package dao;

import model.Curso;
import java.sql.SQLException;
import java.util.List;


public interface CursoDAO {
    void insertar(Curso curso) throws SQLException;
    void actualizar(Curso curso) throws SQLException;
    void eliminar(int id) throws SQLException;
    Curso obtenerPorId(int id) throws SQLException;
    List<Curso> listarTodos() throws SQLException;
}
