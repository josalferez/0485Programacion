package dao;

import java.sql.SQLException;
import java.util.List;
import model.Usuario;

public interface UsuarioDAO {
    boolean validar(String user, String pass) throws SQLException;
    int registrar(Usuario usuario) throws SQLException;
    List<Usuario> listarTodos() throws SQLException;
    void actualizar(Usuario usuario) throws SQLException;
    void eliminar(int id) throws SQLException;
    Usuario obtenerPorId(int id) throws SQLException;
}
