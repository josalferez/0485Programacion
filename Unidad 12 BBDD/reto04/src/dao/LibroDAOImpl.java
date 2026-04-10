package src.dao;

import java.sql.SQLException;
import java.util.List;
import src.model.Libro;
import src.db.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LibroDAOImpl implements LibroDAO {
    @Override
    public void insertar(Libro libro) throws SQLException{
        String sql = "INSERT INTO libros (titulo, autor) VALUES (?, ?)";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, libro.getTitulo());
            stmt.setString(2, libro.getAutor());
            stmt.executeUpdate();
        }
    }

    @Override
    public void actualizar(Libro libro) throws SQLException{
        String sql = "UPDATE libros SET titulo = ?, autor = ? WHERE id = ?";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, libro.getTitulo());
            stmt.setString(2, libro.getAutor());
            stmt.setInt(3, libro.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM libros WHERE id = ?";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public Libro obtenerPorId(int id) throws SQLException {
        String sql = "SELECT * FROM libros WHERE id = ?";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Libro(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("autor")
                    );
                }
            }
        }
        return null; // Si no se encuentra el libro
    }
    @Override
    public List<Libro> listarTodos() throws SQLException {
        String sql = "SELECT * FROM libros";
        List<Libro> libros = new ArrayList<>();
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                libros.add(new Libro(
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getString("autor")
                ));
            }
        }
        return libros;
    }
}
