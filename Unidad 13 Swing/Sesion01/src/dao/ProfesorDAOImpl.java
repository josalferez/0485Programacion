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
        String sql = "INSERT INTO profesores (usuario_id, departamento, especialidad) VALUES (?, ?, ?)";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, profesor.getId());
            pstmt.setString(2, profesor.getDepartamento());
            pstmt.setString(3, profesor.getEspecialidad());
            pstmt.executeUpdate();
            return profesor.getId();
        }
    }

    @Override
    public void actualizar(Profesor profesor) throws SQLException {
        String sqlUsuario = "UPDATE usuarios SET nombre = ?, apellidos = ?, email = ?, dni = ? WHERE id = ?";
        String sqlProfesor = "UPDATE profesores SET departamento = ?, especialidad = ? WHERE usuario_id = ?";
        
        try (Connection conn = ConexionDB.conectar()) {
            conn.setAutoCommit(false);
            try {
                try (PreparedStatement ptstU = conn.prepareStatement(sqlUsuario)) {
                    ptstU.setString(1, profesor.getNombre());
                    ptstU.setString(2, profesor.getApellidos());
                    ptstU.setString(3, profesor.getEmail());
                    ptstU.setString(4, profesor.getDni());
                    ptstU.setInt(5, profesor.getId());
                    ptstU.executeUpdate();
                }
                try (PreparedStatement ptstP = conn.prepareStatement(sqlProfesor)) {
                    ptstP.setString(1, profesor.getDepartamento());
                    ptstP.setString(2, profesor.getEspecialidad());
                    ptstP.setInt(3, profesor.getId());
                    ptstP.executeUpdate();
                }
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }
        }
    }

    @Override
    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }

    @Override
    public Profesor obtenerPorId(int id) throws SQLException {
        String sql = "SELECT u.*, p.departamento, p.especialidad FROM usuarios u " +
                     "JOIN profesores p ON u.id = p.usuario_id WHERE u.id = ?";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToProfesor(rs);
                }
            }
        }
        return null;
    }

    @Override
    public List<Profesor> listarTodos() throws SQLException {
        String sql = "SELECT u.*, p.departamento, p.especialidad FROM usuarios u " +
                     "JOIN profesores p ON u.id = p.usuario_id";
        List<Profesor> profesores = new ArrayList<>();
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                profesores.add(mapResultSetToProfesor(rs));
            }
        }
        return profesores;
    }

    private Profesor mapResultSetToProfesor(ResultSet rs) throws SQLException {
        Profesor p = new Profesor();
        p.setId(rs.getInt("id"));
        p.setUsername(rs.getString("username"));
        p.setPassword(rs.getString("password"));
        p.setEmail(rs.getString("email"));
        p.setNombre(rs.getString("nombre"));
        p.setApellidos(rs.getString("apellidos"));
        p.setDni(rs.getString("dni"));
        p.setRol(rs.getString("rol"));
        p.setDepartamento(rs.getString("departamento"));
        p.setEspecialidad(rs.getString("especialidad"));
        return p;
    }
}
