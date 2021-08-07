import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
	    String nombreBD = "personas.db";

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + nombreBD);
             Statement st = conn.createStatement()) {

            String sql = "CREATE TABLE IF NOT EXISTS personas(" +
                    "cedula INTEGER PRIMARY KEY NOT NULL," +
                    "nombre TEXT NOT NULL," +
                    "apellido TEXT NOT NULL" +
                    ");";
            st.execute(sql);

            conn.close();


        } catch (SQLException e) {
            e.printStackTrace();    //Conocer errores de comunicación con la base de datos
        }
    }
}
