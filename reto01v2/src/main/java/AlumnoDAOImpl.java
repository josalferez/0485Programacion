import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDAOImpl implements AlumnoDAO {

    @Override
    public void insertar(Alumno u) throws SQLException{
        String sql = "INSERT INTO alumnos (nombre, edad, email) VALUES (?,?,?)";

        try (Connection conn = ConexionDB.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, u.getNombre());
                    stmt.setInt(2, u.getEdad());
                    stmt.setString(3, u.getEmail());

                    stmt.executeUpdate(); // Lanzamos la escritura
            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public List<Alumno> listar() throws SQLException{
        String sql = "SELECT * from alumnos";
        List<Alumno> lista = new ArrayList<>();

        try (Connection conn = new ConexionDB().conectar();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
        
        while (rs.next()) {
            Alumno a = new Alumno(rs.getInt("id"), rs.getString("nombre"), rs.getInt("edad"), rs.getString("email"));
            lista.add(a);

        }
            
        } catch (Exception e) {
            // TODO: handle exception
        }

        return lista;
    }
    
}