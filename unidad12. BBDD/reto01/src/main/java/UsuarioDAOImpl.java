import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.PreparableStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAOImpl implements UsuarioDAO {

    // Implemento el método para insertar usuarios en la BD
    @Override
    public void insertar(Usuario u) throws SQLException {
        String sql = "INSERT INTO usuarios(nombre,email) VALUES (?,?)";
        try (Connection conn = ConexionDB.conectar()) {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, u.getNombre());
            pstmt.setString(2, u.getEmail());

            pstmt.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Listo todos los usuarios de la base de datos
    @Override
    public List<Usuario> listar() throws SQLException {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";

        try (Connection conn = ConexionDB.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery() ) {
            while (rs.next()){
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");
                // Añado a mi ArrayList los datos que devuelve la consulta
                lista.add(new Usuario(id, nombre, email));
//                System.out.println("Usuario añadido al ArrayList con exito");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        // Devuelvo la lista
        return lista;
    }

    // Borro un usuario de la base de datsos 
    @Override
    public void delete(int id) throws SQLException{
        String sql = "DELETE FROM usuarios WHERE id = ?";

        try (Connection conn = ConexionDB.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setInt(1, id);
                    stmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Update de usuarios en la base de datos
    @Override
    public void update(Usuario u) throws SQLException{
        String sql = "UPDATE usuarios SET nombre = ?, email = ? WHERE id = ?";
        try (Connection conn = ConexionDB.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, u.getNombre());
                    stmt.setString(2, u.getEmail());
                    stmt.setInt(3, u.getId());
                    stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
