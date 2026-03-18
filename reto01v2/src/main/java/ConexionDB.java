import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static final String URL = "jdbc:mysql://localhost:3307/reto01v2";
    private static final String USER = "root";
    private static final String PASS = "admin";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS); // Necesita el jar en referenced libraries
    }
}
