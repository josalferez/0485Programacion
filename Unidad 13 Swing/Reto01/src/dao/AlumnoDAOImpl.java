package dao;

import model.Alumno;
import db.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDAOImpl implements AlumnoDAO {

    @Override
    public int insertar(Alumno alumno) throws SQLException {
        String sql = "INSERT INTO alumnos (nombre, email) VALUES (?, ?)";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS)) {
            
            pstmt.setString(1, alumno.getNombre());
            pstmt.setString(2, alumno.getEmail());
            pstmt.executeUpdate();

            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        }
        return -1;
    }

    @Override
    public void actualizar(Alumno alumno) throws SQLException {
        String sql = "UPDATE alumnos SET nombre = ?, email = ? WHERE alumno_id = ?";
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
        String sql = "DELETE FROM alumnos WHERE alumno_id = ?";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }

    @Override
    public Alumno obtenerPorId(int id) throws SQLException {
        String sql = "SELECT * FROM alumnos WHERE alumno_id = ?";
        Alumno alumno = null;
        
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    alumno = new Alumno(
                            rs.getInt("alumno_id"),
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
                        rs.getInt("alumno_id"),
                        rs.getString("nombre"),
                        rs.getString("email")
                ));
            }
        }
        return alumnos;
    }
}
