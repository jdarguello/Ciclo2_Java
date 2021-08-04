import java.sql.*;

public class CRUD {
    private String jdbc = "jdbc:sqlite:prueba.db";

    public void SQLExec(String sql) {
        //Ejecuta código SQL para crear tablas, registros, eliminar información, etc.
        try (Connection conn = DriverManager.getConnection(jdbc);
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void CreateDB(String nombre) {
        try (Connection conn = DriverManager.getConnection(jdbc)) {
            if (conn != null) {
                System.out.println("Base de datos creada...");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
