package dao;

import java.sql.SQLException;
import model.Usuario;

public interface UsuarioDAO {
    boolean validar(String user, String pass) throws SQLException;
    void registrar(Usuario usuario) throws SQLException;
}
