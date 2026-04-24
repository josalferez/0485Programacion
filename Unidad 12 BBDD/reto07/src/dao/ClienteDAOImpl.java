package src.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import src.db.ConexionDB;
import src.model.Cliente;

public class ClienteDAOImpl implements ClienteDAO {
    @Override
    public void crear(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO clientes (nombre, email, telefono) VALUES (?, ?, ?)";

        try (Connection conn = ConexionDB.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

                    stmt.setString(1, cliente.getNombreCliente());
                    stmt.setString(2, cliente.getEmailCliente());
                    stmt.setInt(3,cliente.getTelefonoCliente());

                    stmt.executeUpdate();
                    
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error: " + e.getMessage());
        }
    }

    // List<Cliente> obtenerTodos() throws SQLException;

    // Cliente obtenerPorId(int id) throws SQLException;

    // void actualizar(Cliente cliente) throws SQLException;

    // void eliminar(int id) throws SQLException;
}
