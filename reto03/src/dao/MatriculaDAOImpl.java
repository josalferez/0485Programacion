package src.dao;

import src.model.MatriculaDTO;
import src.db.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MatriculaDAOImpl implements MatriculaDAO {

    @Override
    public void matricular(int alumnoId, int cursoId, LocalDate fecha) throws SQLException {

        // Validación previa
        String sqlCheckAlumno = "SELECT id FROM alumnos WHERE id = ?";
        String sqlCheckCurso = "SELECT id FROM cursos WHERE id = ?";
        String sqlInsert = "INSERT INTO matriculas (alumno_id, curso_id, fecha_matricula) VALUES (?, ?, ?)";

        try (Connection conn = ConexionDB.conectar()) {

            conn.setAutoCommit(false); // Inicio de transacción

            try (PreparedStatement checkAlumno = conn.prepareStatement(sqlCheckAlumno);
                    PreparedStatement checkCurso = conn.prepareStatement(sqlCheckCurso);
                    PreparedStatement insert = conn.prepareStatement(sqlInsert)) {

                // Verificar que el alumno existe
                checkAlumno.setInt(1, alumnoId);
                ResultSet rsAlumno = checkAlumno.executeQuery();
                if (!rsAlumno.next()) {
                    throw new SQLException("El alumno con ID " + alumnoId + " no existe.");
                }

                // Verificar que el curso existe
                checkCurso.setInt(1, cursoId);
                ResultSet rsCurso = checkCurso.executeQuery();
                if (!rsCurso.next()) {
                    throw new SQLException("El curso con ID " + cursoId + " no existe.");
                }

                // Insertar matrícula
                insert.setInt(1, alumnoId);
                insert.setInt(2, cursoId);
                insert.setDate(3, java.sql.Date.valueOf(fecha));
                insert.executeUpdate();

                conn.commit(); // Todo OK → confirmar

            } catch (SQLException e) {
                conn.rollback(); // Algo falló → deshacer todo
                throw e; // Re-lanzar para que Main lo muestre
            }
        }
    }

    @Override
    public List<MatriculaDTO> listarMatriculasDetalladas() throws SQLException {
        String sql = "SELECT a.nombre, c.titulo, m.fecha_matricula " +
                "FROM matriculas m " +
                "JOIN alumnos a ON m.alumno_id = a.id " +
                "JOIN cursos c ON m.curso_id = c.id";
        List<MatriculaDTO> matriculas = new ArrayList<>();

        try (Connection conn = ConexionDB.conectar();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                matriculas.add(new MatriculaDTO(
                        rs.getString("nombre"),
                        rs.getString("titulo"),
                        rs.getDate("fecha_matricula").toLocalDate()));
            }
        }
        return matriculas;
    }

    @Override
    public void cancelarMatricula(int id) throws SQLException {
        String sql = "DELETE FROM matriculas WHERE id = ?";
        try (Connection conn = ConexionDB.conectar();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}