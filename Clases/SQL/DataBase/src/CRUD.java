import java.sql.*;

public class CRUD {
    String jdbc = "jdbc:sqlite:prueba.db";

    public Connection connect() {
        String url = jdbc;
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;

    }
}
