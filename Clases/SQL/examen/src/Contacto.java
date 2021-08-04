import java.io.File;
import java.sql.*;
import java.util.Arrays;

public class Contacto {
    //Objetivo: crear, leer, almacenar y eliminar información en bases de datos.
    String refURL = "jdbc:sqlite:";
    String dbName = "misiontic.db";

    private Connection connect() {
        String url = this.refURL + this.dbName;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public String[][] SQLReturn(String sql, String[][] componentes){
        //componentes = [["nombre", "str"], ["id", "num"]]
        String [][] res = {};
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            // loop through the result set
            while (rs.next()) {
                res = Arrays.copyOf(res, res.length+1);
                String [] subres = {};
                int cont = 0;
                for (String[] c : componentes) {
                    subres = Arrays.copyOf(subres, subres.length + 1);
                    if (c[1].equals("str")) {
                        subres[subres.length - 1] = String.valueOf(rs.getString(c[0]));
                    } else if (c[1].equals("int")) {
                        subres[subres.length - 1] = String.valueOf(rs.getInt(c[0]));
                    }
                }
                //String [] subres = {String.valueOf(rs.getInt("id")), rs.getString("name")};
                res[res.length-1] = subres;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return res;
    }

    public void SQLExec(String sql) {
        //Ejecuta código SQL para crear tablas, registros, eliminar información, etc.
        String url = this.refURL + this.dbName;

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void CreateDB(String nombre) {
        String url = this.refURL + nombre;

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("Creando base de datos...");
                System.out.println("El nombre del driver es: " + meta.getDriverName());
                System.out.println("Se ha creado la base de datos " + nombre);
                System.out.println(".................................................");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void dbConnect() {
        String url = this.refURL + this.dbName;
        File file = new File(dbName);

        if (!file.exists()) //Si no existe base de datos, créela
        {
            CreateDB(dbName);
        } else {
            try {
                Connection connection = DriverManager.getConnection(url);
            } catch (SQLException e) {
                System.out.println("Error al acceder a la base de datos");
                e.printStackTrace();
            }
        }
    }

}