import java.sql.SQLException;
import java.util.List;

public interface AlumnoDAO {

    // 1. Insertamos Usuarios en la base de datos
    void insertar(Alumno u) throws SQLException;

    // 2. Listo los usuarios de la base de datos;
    List<Alumno> listar() throws SQLException;

    // 3. Borro un usuario de la lista;
 //   void delete(int id) throws SQLException;

    // 4. Actualizo un usurio
  //  void update(Usuario u) throws SQLException;
} 
