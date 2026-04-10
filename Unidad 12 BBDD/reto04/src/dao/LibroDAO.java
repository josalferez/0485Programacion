package src.dao;

import java.sql.SQLException;
import java.util.List;
import src.model.Libro;

public interface LibroDAO {
    void insertar(Libro libro) throws SQLException;
    void actualizar(Libro libro) throws SQLException;
    void eliminar(int id) throws SQLException;
    Libro obtenerPorId(int id) throws SQLException;
    List<Libro> listarTodos() throws SQLException;
}