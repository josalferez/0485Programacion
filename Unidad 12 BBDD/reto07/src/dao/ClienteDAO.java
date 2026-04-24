package src.dao;

import java.sql.SQLException;
import java.util.List;

import src.model.Cliente;

public interface ClienteDAO {
    void crear(Cliente cliente) throws SQLException;
  //  List<Cliente> obtenerTodos() throws SQLException;
 //   Cliente obtenerPorId(int id) throws SQLException;
  //  void actualizar(Cliente cliente) throws SQLException;
 //   void eliminar(int id) throws SQLException;
}
