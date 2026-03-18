package src.dao;

import src.model.Alumno;
// Asegúrate de crear este paquete y clase más adelante para la conexión
import src.db.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDAOImpl implements AlumnoDAO {

    @Override
    public void insertar(Alumno alumno) throws SQLException {
        String sql = "INSERT INTO alumnos (nombre, email) VALUES (?, ?)";
        // Utilizamos try-with-resources para cerrar automáticamente Connection y PreparedStatement
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, alumno.getNombre());
            pstmt.setString(2, alumno.getEmail());
            pstmt.executeUpdate();
        }
    }

    @Override
    public void actualizar(Alumno alumno) throws SQLException {
        String sql = "UPDATE alumnos SET nombre = ?, email = ? WHERE id = ?";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, alumno.getNombre());
            pstmt.setString(2, alumno.getEmail());
            pstmt.setInt(3, alumno.getId());
            pstmt.executeUpdate();
        }
    }

    @Override
    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM alumnos WHERE id = ?";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }

    @Override
    public Alumno obtenerPorId(int id) throws SQLException {
        String sql = "SELECT * FROM alumnos WHERE id = ?";
        Alumno alumno = null;
        
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    alumno = new Alumno(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("email")
                    );
                }
            }
        }
        return alumno;
    }

    @Override
    public List<Alumno> listarTodos() throws SQLException {
        String sql = "SELECT * FROM alumnos";
        List<Alumno> alumnos = new ArrayList<>();
        
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                alumnos.add(new Alumno(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("email")
                ));
            }
        }
        return alumnos;
    }
}
