package CRUD;

import java.util.*;
import java.util.stream.Collectors;

public class CRUD extends CRUDBase {
    private HashMap<String, Object[][]> tablas = new HashMap<String, Object[][]>(); //Almacena toda la información de las tablas creadas

    public CRUD(String nombre) {
        super(nombre);
    }
    public void crearTabla(String nombre, Object[][] columnas) {
        //Ej: columnas = [["ID", "integer", true, true], ["nombre", "text", false], ["costo", "integer"]]
        //               nombre, tipo, not null, autoincrement
        String query = "CREATE TABLE IF NOT EXISTS " + nombre + "(\n";
        for (Object[] col: columnas) {
            query += col[0] + " " + col[1];
            if (col.length > 3) {
                //Se trata del componente principal
                query += " PRIMARY KEY";
                if ((boolean)col[3] && !((boolean) col[2])) {
                    query += " AUTOINCREMENT";
                }
            }
            if ((boolean) col[2]) {
                query += " NOT NULL";
            }
            query += ",\n";
        }
        query = query.substring(0,query.length()-2);
        query += "\n);";
        //System.out.println(query);
        this.SQLExec(query);

        //Almacenar información de la tabla
        this.tablas.put(nombre, columnas);
    }

    public void eliminarTabla(String nombre) {
        String query = "DROP TABLE " + nombre + ";";
        this.SQLExec(query);
    }

    public ArrayList<ArrayList<Object>> leerTodo (String nombre) {
        String query = "SELECT * FROM " + nombre;
        Object[][] filas = this.SQLReturn(query, this.tablas.get(nombre));

        //Convertir a ArrayList
        ArrayList<ArrayList<Object>> datos = new ArrayList<ArrayList<Object>>();
        for (Object[] fila: filas) {
            ArrayList<Object> data = new ArrayList<Object>(Arrays.asList(fila));
            datos.add(data);
        }
        return datos;
    }

    public ArrayList<ArrayList<Object>> leerFiltrado (String nombre, String condicion) {

        return new ArrayList<>();
    }

    public void guardarFila (String nomTabla, Object[][] filas) {
        String query = "INSERT INTO " + nomTabla + "\nVALUES ";
        for (Object[] fila: filas) {
            query += "(";
            for (Object comp:fila) {
                query += comp + ", ";
            }
            query = query.substring(0,query.length()-2);
            query += "),\n";
        }
        query = query.substring(0, query.length()-2) + ";";
        this.SQLExec(query);
    }

    public void eliminarFila (String nombre, String condicion) {
        String query = "DELETE FROM " + nombre + "WHERE " + condicion;
        System.out.println(query);
    }

}
