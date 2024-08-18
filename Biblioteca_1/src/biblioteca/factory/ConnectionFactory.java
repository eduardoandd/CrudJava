import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/biblioteca";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Edu10peixe@";
    
    private Connection conn;
    
    public Connection getConnection() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                System.out.println("Conexão estabelecida com sucesso!");
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return conn;
    }

    public void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Conexão encerrada com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
