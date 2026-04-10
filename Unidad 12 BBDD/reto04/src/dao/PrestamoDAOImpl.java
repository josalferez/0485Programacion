package src.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import src.db.ConexionDB;
import src.model.PrestamoDTO;

public class PrestamoDAOImpl implements PrestamoDAO {
    // Método principal para registrar un préstamo (Debe usarse con transacciones en la implementación)
    @Override
    public void registrarPrestamo(int socioId, int libroId, LocalDate fecha) throws SQLException{
        String sqlInsertPrestamo = "INSERT INTO prestamos (socio_id, libro_id, fecha) VALUES (?, ?, ?)";
        String sqlActualizarLibro = "UPDATE libros SET disponible = false WHERE id = ?";
        try (Connection conn = ConexionDB.conectar()) {
            conn.setAutoCommit(false); // Iniciar transacción
            try (PreparedStatement stmtPrestamo = conn.prepareStatement(sqlInsertPrestamo);
                 PreparedStatement stmtActualizarLibro = conn.prepareStatement(sqlActualizarLibro)) {
                // Insertar el préstamo
                stmtPrestamo.setInt(1, socioId);
                stmtPrestamo.setInt(2, libroId);
                stmtPrestamo.setDate(3, java.sql.Date.valueOf(fecha));
                stmtPrestamo.executeUpdate();

                // Actualizar el estado del libro a no disponible
                stmtActualizarLibro.setInt(1, libroId);
                stmtActualizarLibro.executeUpdate();

                conn.commit(); // Confirmar transacción
            } catch (SQLException e) {
                conn.rollback(); // Revertir transacción en caso de error
                throw e; // Volver a lanzar la excepción para manejarla en el nivel superior
            }
        }
    }

    // Método para el listado con JOIN (usando un DTO o String para la consola)
    // El objetivo es mostrar: Nombre Socio - Título Libro - Fecha
    @Override
    public List<PrestamoDTO> listarPrestamosDetallados() throws SQLException{
        String sql = "SELECT s.nombre AS socio_nombre, l.titulo AS libro_titulo, p.fecha " +
                     "FROM prestamos p " +
                     "JOIN socios s ON p.socio_id = s.id " +
                     "JOIN libros l ON p.libro_id = l.id";
        List<PrestamoDTO> prestamos = new ArrayList<>();
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                PrestamoDTO dto = new PrestamoDTO(
                    rs.getString("socio_nombre"),
                    rs.getString("libro_titulo"),
                    rs.getDate("fecha").toLocalDate()
                );
                prestamos.add(dto);
            }
        }
        return prestamos;
    }

    @Override
    public void cancelarPrestamo(int id) throws SQLException{
        String sqlEliminarPrestamo = "DELETE FROM prestamos WHERE id = ?";
        String sqlActualizarLibro = "UPDATE libros SET disponible = true WHERE id = (SELECT libro_id FROM prestamos WHERE id = ?)";
        try (Connection conn = ConexionDB.conectar()) {
            conn.setAutoCommit(false); // Iniciar transacción
            try (PreparedStatement stmtEliminarPrestamo = conn.prepareStatement(sqlEliminarPrestamo);
                 PreparedStatement stmtActualizarLibro = conn.prepareStatement(sqlActualizarLibro)) {
                // Actualizar el estado del libro a disponible
                stmtActualizarLibro.setInt(1, id);
                stmtActualizarLibro.executeUpdate();

                // Eliminar el préstamo
                stmtEliminarPrestamo.setInt(1, id);
                stmtEliminarPrestamo.executeUpdate();

                conn.commit(); // Confirmar transacción
            } catch (SQLException e) {
                conn.rollback(); // Revertir transacción en caso de error
                throw e; // Volver a lanzar la excepción para manejarla en el nivel superior
            }
        }
    }
}
