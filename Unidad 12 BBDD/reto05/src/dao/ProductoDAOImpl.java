package src.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import src.model.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import src.db.ConexionDB;
import src.model.Producto;

public class ProductoDAOImpl implements ProductoDAO {
    @Override
     public void crear(Producto producto) throws SQLException{
        String sql = "INSERT INTO productos (nombre, cantidad, precio) VALUES (?, ?, ?)";
        try (Connection conn = ConexionDB.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1,producto.getNombre());
                stmt.setInt(2,producto.getCantidad());
                stmt.setDouble(3,producto.getPrecio());
                stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    @Override
    public List<Producto> obtenerTodos() throws SQLException{
        String sql = "SELECT * FROM productos";
        List<Producto> producto = new ArrayList<>();

        try (Connection conn = ConexionDB.conectar();
              PreparedStatement stmt = conn.prepareStatement(sql);
              ResultSet rs = stmt.executeQuery()) {
                while (rs.next()){
                    producto.add(new Producto(rs.getString("nombre"), rs.getInt("cantidad"), rs.getDouble("precio")));
                }
                return producto;
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }


//    public Producto obtenerPorId(int id) throws SQLException{}
 ///  public void actualizar(Producto producto) throws SQLException{}
   // public void eliminar(int id) throws SQLException{}
}
