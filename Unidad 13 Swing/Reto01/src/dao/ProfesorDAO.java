package dao;

import model.Profesor;
import java.sql.SQLException;
import java.util.List;

public interface ProfesorDAO {
    int insertar(Profesor profesor) throws SQLException;
    void actualizar(Profesor profesor) throws SQLException;
    void eliminar(int id) throws SQLException;
    Profesor obtenerPorId(int id) throws SQLException;
    List<Profesor> listarTodos() throws SQLException;
}
