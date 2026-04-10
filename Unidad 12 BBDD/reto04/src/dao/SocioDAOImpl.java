package src.dao;

import java.sql.SQLException;
import java.util.List;
import src.model.Socio;
import src.db.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SocioDAOImpl implements SocioDAO {
     @Override
    public void insertar(Socio socio) throws SQLException {
        String sql = "INSERT INTO socios (nombre, email) VALUES (?, ?)";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, socio.getNombre());
            stmt.setString(2, socio.getEmail());
            stmt.executeUpdate();
        }
     }

    @Override
    public void actualizar(Socio socio) throws SQLException {
        String sql = "UPDATE socios SET nombre = ?, email = ? WHERE id = ?";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, socio.getNombre());
            stmt.setString(2, socio.getEmail());
            stmt.setInt(3, socio.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM socios WHERE id = ?";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public Socio obtenerPorId(int id) throws SQLException {
        String sql = "SELECT * FROM socios WHERE id = ?";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Socio(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("email")
                    );
                }
            }
        }
        return null; // Si no se encuentra el socio
    }
    
    @Override
    public List<Socio> listarTodos() throws SQLException {
        List<Socio> socios = new ArrayList<>();
        String sql = "SELECT * FROM socios";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                socios.add(new Socio(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("email")
                ));
            }
        }
        return socios;
    }
}
