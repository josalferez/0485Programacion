package dao;

import model.Curso;
import db.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursoDAOImpl implements CursoDAO {

    @Override
    public void insertar(Curso curso) throws SQLException {
        String sql = "INSERT INTO cursos (titulo, creditos) VALUES (?, ?)";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, curso.getTitulo());
            pstmt.setInt(2, curso.getCreditos());
            pstmt.executeUpdate();
        }
    }

    @Override
    public void actualizar(Curso curso) throws SQLException {
        String sql = "UPDATE cursos SET titulo = ?, creditos = ? WHERE id = ?";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, curso.getTitulo());
            pstmt.setInt(2, curso.getCreditos());
            pstmt.setInt(3, curso.getId());
            pstmt.executeUpdate();
        }
    }

    @Override
    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM cursos WHERE id = ?";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }

    @Override
    public Curso obtenerPorId(int id) throws SQLException {
        String sql = "SELECT * FROM cursos WHERE id = ?";
        Curso curso = null;

        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    curso = new Curso(
                            rs.getInt("id"),
                            rs.getString("titulo"),
                            rs.getInt("creditos")
                    );
                }
            }
        }
        return curso;
    }

    @Override
    public List<Curso> listarTodos() throws SQLException {
        String sql = "SELECT * FROM cursos";
        List<Curso> cursos = new ArrayList<>();

        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                cursos.add(new Curso(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getInt("creditos")
                ));
            }
        }
        return cursos;
    }
}
