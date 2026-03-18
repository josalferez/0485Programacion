import java.sql.SQLException;
import java.util.List;

public interface UsuarioDAO {

    void insertar(Usuario u) throws SQLException;

    void actualizar(Usuario u) throws SQLException;

    void eliminar(int id) throws SQLException;

    List<Usuario> listar() throws SQLException;
}