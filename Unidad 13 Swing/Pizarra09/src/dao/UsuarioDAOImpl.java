package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import db.ConexionDB;
import model.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO {

    @Override
    public boolean validar(String user, String pass) throws SQLException {
        String sql = "SELECT * FROM usuarios WHERE username = ? AND password = ?";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, user);
            pstmt.setString(2, pass);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next(); // Retorna true si existe el usuario
            }
        }
    }

    @Override
    public void registrar(Usuario usuario) throws SQLException {
        // Aseguramos que los nombres de las columnas sean 'alumno_id' y 'profesor_id'
        String sql = "INSERT INTO usuarios (username, password, email, alumno_id, profesor_id, rol) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, usuario.getUsername());
            pstmt.setString(2, usuario.getPassword());
            pstmt.setString(3, usuario.getEmail());
            
            // Vincular ID de Alumno (si existe)
            if (usuario.getAlumnoId() != null) {
                pstmt.setInt(4, usuario.getAlumnoId());
            } else {
                pstmt.setNull(4, java.sql.Types.INTEGER);
            }

            // Vincular ID de Profesor (si existe)
            if (usuario.getProfesorId() != null) {
                pstmt.setInt(5, usuario.getProfesorId());
            } else {
                pstmt.setNull(5, java.sql.Types.INTEGER);
            }

            pstmt.setString(6, usuario.getRol());
            
            pstmt.executeUpdate();
        }
    }
}
