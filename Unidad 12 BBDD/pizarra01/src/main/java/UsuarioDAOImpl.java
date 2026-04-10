
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImpl implements UsuarioDAO {

    @Override
    public void insertar(Usuario u) throws SQLException {
        String sql = "INSERT INTO usuarios (nombre, email) VALUES (?, ?)";

        try (Connection conn = ConexionDB.conectar();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, u.getNombre());
            pstmt.setString(2, u.getEmail());
            pstmt.executeUpdate(); //executeUpdate -> Escritura/Modificación
        }
    }

    @Override
    public void actualizar(Usuario u) throws SQLException {
        String sql = "UPDATE usuarios SET nombre = ?, email = ? WHERE id = ?";

        try (Connection conn = ConexionDB.conectar();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, u.getNombre());
            pstmt.setString(2, u.getEmail());
            pstmt.setInt(3, u.getId());

            pstmt.executeUpdate();
        }
    }

    @Override
    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM usuarios WHERE id = ?";

        try (Connection conn = ConexionDB.conectar();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate(); 
        }
    }

    @Override
    public List<Usuario> listar() throws SQLException {

        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";

        try (Connection conn = ConexionDB.conectar();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) { //executeQuery -> Lectura

            while (rs.next()) {
                Usuario u = new Usuario(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("email"));
                lista.add(u);
            }
        }

        return lista;
    }

}
