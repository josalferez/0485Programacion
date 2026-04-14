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
        // En el patrón Joined Table, primero se inserta en usuarios (se hace en la vista o servicio)
        // y luego aquí se vincula insertando en alumnos usando el mismo ID.
        String sql = "INSERT INTO alumnos (usuario_id, beca, promocion) VALUES (?, ?, ?)";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, alumno.getId());
            pstmt.setString(2, alumno.getBeca());
            pstmt.setString(3, alumno.getPromocion());
            pstmt.executeUpdate();
            return alumno.getId();
        }
    }

    @Override
    public void actualizar(Alumno alumno) throws SQLException {
        // Actualizamos ambas tablas
        String sqlUsuario = "UPDATE usuarios SET nombre = ?, apellidos = ?, email = ?, dni = ? WHERE id = ?";
        String sqlAlumno = "UPDATE alumnos SET beca = ?, promocion = ? WHERE usuario_id = ?";
        
        try (Connection conn = ConexionDB.conectar()) {
            conn.setAutoCommit(false);
            try {
                try (PreparedStatement ptstU = conn.prepareStatement(sqlUsuario)) {
                    ptstU.setString(1, alumno.getNombre());
                    ptstU.setString(2, alumno.getApellidos());
                    ptstU.setString(3, alumno.getEmail());
                    ptstU.setString(4, alumno.getDni());
                    ptstU.setInt(5, alumno.getId());
                    ptstU.executeUpdate();
                }
                try (PreparedStatement ptstA = conn.prepareStatement(sqlAlumno)) {
                    ptstA.setString(1, alumno.getBeca());
                    ptstA.setString(2, alumno.getPromocion());
                    ptstA.setInt(3, alumno.getId());
                    ptstA.executeUpdate();
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
        // Borrar el usuario borrará el alumno por el ON DELETE CASCADE
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }

    @Override
    public Alumno obtenerPorId(int id) throws SQLException {
        String sql = "SELECT u.*, a.beca, a.promocion FROM usuarios u " +
                     "JOIN alumnos a ON u.id = a.usuario_id WHERE u.id = ?";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToAlumno(rs);
                }
            }
        }
        return null;
    }

    @Override
    public List<Alumno> listarTodos() throws SQLException {
        String sql = "SELECT u.*, a.beca, a.promocion FROM usuarios u " +
                     "JOIN alumnos a ON u.id = a.usuario_id";
        List<Alumno> alumnos = new ArrayList<>();
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                alumnos.add(mapResultSetToAlumno(rs));
            }
        }
        return alumnos;
    }

    private Alumno mapResultSetToAlumno(ResultSet rs) throws SQLException {
        Alumno a = new Alumno();
        a.setId(rs.getInt("id"));
        a.setUsername(rs.getString("username"));
        a.setPassword(rs.getString("password"));
        a.setEmail(rs.getString("email"));
        a.setNombre(rs.getString("nombre"));
        a.setApellidos(rs.getString("apellidos"));
        a.setDni(rs.getString("dni"));
        a.setRol(rs.getString("rol"));
        a.setBeca(rs.getString("beca"));
        a.setPromocion(rs.getString("promocion"));
        return a;
    }
}
