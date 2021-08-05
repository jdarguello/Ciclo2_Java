package CRUD;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.Arrays;

public class CRUDBase {
    private String jdbc;
    private File db;

    public CRUDBase (String nombre) {
        this.selecBD(nombre);
    }

    private void selecBD(String nombre) {
        //Permite seleccionar la base de datos con la cual trabajar
        this.db = new File(nombre + ".db");
        this.jdbc = "jdbc:sqlite:" + nombre;

        this.crearBD();
    }

    public void crearBD() {
        try {
            db.createNewFile();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void eliminarBD(String nombre) {
        File dbEliminar = new File(nombre + ".db");
        dbEliminar.delete();
    }

    private Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(jdbc);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    protected void SQLExec(String sql) {
        //Ejecuta código SQL para crear tablas, registros, eliminar información, etc.
        try (Connection conn = DriverManager.getConnection(jdbc);
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Object[][] SQLReturn(String sql, Object[][] componentes){
        //componentes = [["nombre", "str"], ["id", "int"]]
        Object [][] res = {};
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            // loop through the result set
            while (rs.next()) {
                res = Arrays.copyOf(res, res.length+1);
                Object [] subres = {};
                int cont = 0;
                for (Object[] c : componentes) {
                    subres = Arrays.copyOf(subres, subres.length + 1);
                    if (c[1].equals("TEXT")) {
                        subres[subres.length - 1] = rs.getString((String)c[0]);
                    } else if (c[1].equals("INTEGER")) {
                        subres[subres.length - 1] = rs.getInt((String)c[0]);
                    } else if (c[1].equals("REAL")) {
                        subres[subres.length - 1] = rs.getDouble((String)c[0]);
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
}
