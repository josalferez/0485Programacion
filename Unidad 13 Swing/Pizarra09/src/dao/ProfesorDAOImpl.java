package dao;

import model.Profesor;
import db.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfesorDAOImpl implements ProfesorDAO {

    @Override
    public int insertar(Profesor profesor) throws SQLException {
        String sql = "INSERT INTO profesores (nombre, email) VALUES (?, ?)";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS)) {
            
            pstmt.setString(1, profesor.getNombre());
            pstmt.setString(2, profesor.getEmail());
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
    public void actualizar(Profesor profesor) throws SQLException {
        String sql = "UPDATE profesores SET nombre = ?, email = ? WHERE id = ?";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, profesor.getNombre());
            pstmt.setString(2, profesor.getEmail());
            pstmt.setInt(3, profesor.getId());
            pstmt.executeUpdate();
        }
    }

    @Override
    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM profesores WHERE id = ?";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }

    @Override
    public Profesor obtenerPorId(int id) throws SQLException {
        String sql = "SELECT * FROM profesores WHERE id = ?";
        Profesor profesor = null;
        
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    profesor = new Profesor(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("email")
                    );
                }
            }
        }
        return profesor;
    }

    @Override
    public List<Profesor> listarTodos() throws SQLException {
        String sql = "SELECT * FROM profesores";
        List<Profesor> profesores = new ArrayList<>();
        
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                profesores.add(new Profesor(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("email")
                ));
            }
        }
        return profesores;
    }
}
