package src.dao;

import java.sql.SQLException;
import java.util.List;
import src.model.Socio;


public interface SocioDAO {
    void insertar(Socio socio) throws SQLException;
    void actualizar(Socio socio) throws SQLException;
    void eliminar(int id) throws SQLException;
    Socio obtenerPorId(int id) throws SQLException;
    List<Socio> listarTodos() throws SQLException;
}