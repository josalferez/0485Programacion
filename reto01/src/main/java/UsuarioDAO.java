import java.sql.SQLException;
import java.util.List;

public interface UsuarioDAO {

    // 1. Insertamos Usuarios en la base de datos
    void insertar(Usuario u) throws SQLException;

    // 2. Listo los usuarios de la base de datos;
    List<Usuario> listar() throws SQLException;

    // 3. Borro un usuario de la lista;
    void delete(int id) throws SQLException;

    // 4. Actualizo un usurio
    void update(Usuario u) throws SQLException;
} 
