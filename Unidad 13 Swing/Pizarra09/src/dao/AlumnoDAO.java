package dao;

import model.Alumno;
import java.sql.SQLException;
import java.util.List;

public interface AlumnoDAO {
    int insertar(Alumno alumno) throws SQLException;

    void actualizar(Alumno alumno) throws SQLException;

    void eliminar(int id) throws SQLException;

    Alumno obtenerPorId(int id) throws SQLException;

    List<Alumno> listarTodos() throws SQLException;

}
