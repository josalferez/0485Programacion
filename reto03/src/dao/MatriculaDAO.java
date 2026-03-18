package src.dao;

import src.model.MatriculaDTO;
import java.sql.SQLException;
import java.util.List;
import java.time.LocalDate;

public interface MatriculaDAO {
    // Método principal para matricular (usar transacciones)
    void matricular(int alumnoId, int cursoId, LocalDate fecha) throws SQLException;
    
    // Listado con JOIN
    List<MatriculaDTO> listarMatriculasDetalladas() throws SQLException;

    void cancelarMatricula(int id) throws SQLException;
}