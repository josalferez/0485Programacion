package src.dao;

import src.model.*;
import java.sql.SQLException;
import java.util.List;


public interface ProductoDAO {
    void crear(Producto producto) throws SQLException;
    List<Producto> obtenerTodos() throws SQLException;
    Producto obtenerPorId(int id) throws SQLException;
 //   void actualizar(Producto producto) throws SQLException;
  //  void eliminar(int id) throws SQLException;
} 
