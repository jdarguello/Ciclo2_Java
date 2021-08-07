package CRUD;

import java.util.*;
import java.util.stream.Collectors;

public class CRUD extends CRUDBase {
    private HashMap<String, ArrayList<ArrayList<Object>>> tablas = new HashMap<String, ArrayList<ArrayList<Object>>>(); //Almacena toda la información de las tablas creadas
    private boolean inicio = true;

    public CRUD(String nombre) {
        super(nombre);
        //Crear tabla de referencias
        this.crearTabla("refTablas", new Object[][]{
                {"nombreTabla", "TEXT", true},
                {"Contenido", "TEXT", true}
        });
        this.inicio = false;

        //Leer tabla de referencias
        ArrayList<ArrayList<Object>> contTablas = this.leerTodo("refTablas");
        for (ArrayList<Object> tabla: contTablas) {
            String cont = (String)(tabla.get(1));
            cont = cont.substring(1, cont.length() - 1);

            String[] columnas = (cont.split("=")[0]).split(",");

            ArrayList<ArrayList<Object>> columns = new ArrayList<ArrayList<Object>>();
            columns.add(new ArrayList<Object>());
            for (int i=0; i< columnas.length;i++) {
                Character ultLetra = columnas[i].charAt(columnas[i].length()-1);
                //Agregar contenido
                columns.get(columns.size()-1).add(columnas[i].replace("[", "").replace("]", "").replace(" ", ""));
                if (ultLetra.equals(']')) {
                    columns.add(new ArrayList<Object>());
                }
            }
            columns.remove(new ArrayList<Object>());

            //---Convertir booleanos---
            for (int i=0; i<columns.size();i++) {
                for (int j=0; j<columns.get(i).size();j++) {
                    if ((columns.get(i).get(j)).equals("true")) {
                        columns.get(i).set(j, true);
                    } else if((columns.get(i).get(j)).equals("false")) {
                        columns.get(i).set(j, false);
                    }
                }
            }
            tablas.put((String)(tabla.get(0)), columns);
        }
    }

    private ArrayList<ArrayList<Object>> arrayToArrayList(Object[][] array) {
        ArrayList<ArrayList<Object>> nuevo = new ArrayList<ArrayList<Object>>();
        for (Object[] contenidos: array) {
            nuevo.add(new ArrayList<Object>(Arrays.asList(contenidos)));
        }
        return nuevo;
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
        this.tablas.put(nombre, arrayToArrayList(columnas));

        //Anadir contenido general a 'refTablas'
        if (!this.inicio) {
            this.guardarFila("refTablas", new Object[][] {
                    {"\"" + nombre + "\"", "\"" + tablas.get(nombre).toString() + "\""}
            });
        }
    }

    public void eliminarTabla(String nombre) {
        String query = "DROP TABLE " + nombre + ";";
        this.SQLExec(query);
    }

    private Object[][] arraylistToArray (ArrayList<ArrayList<Object>> arrayL) {
        Object[][] array = new Object[arrayL.size()][];
        for (int i=0; i<arrayL.size();i++) {
            array[i] = new Object[arrayL.get(i).size()];
            for (int j=0; j<arrayL.get(i).size();j++) {
                array[i][j] = arrayL.get(i).get(j);
            }
        }
        return array;
    }

    public ArrayList<ArrayList<Object>> leerTodo (String nombre) {
        String query = "SELECT * FROM " + nombre;
        Object[][] filas = this.SQLReturn(query, arraylistToArray(this.tablas.get(nombre)));

        //Convertir a ArrayList
        ArrayList<ArrayList<Object>> datos = new ArrayList<ArrayList<Object>>();
        for (Object[] fila: filas) {
            ArrayList<Object> data = new ArrayList<Object>(Arrays.asList(fila));
            datos.add(data);
        }
        return datos;
    }

    public ArrayList<ArrayList<Object>> leerFiltrado (String nombre, String[][] condiciones) {
        //--Condicion de filtrado--
        String query = "SELECT * FROM " + nombre + " WHERE ";
        for (String[] items: condiciones) {
            for (String item: items) {
                if (!(item.equals("AND")) && !(item.equals("OR"))) {
                    query += item + " IS ";
                } else {
                    query = query.substring(0,query.length()-3);
                    query += item + " ";
                }
            }
        }
        query = query.substring(0, query.length()-4);
        query += ";";
        //System.out.println(query);

        //--
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
        //System.out.println(query);
        this.SQLExec(query);
    }

    public void eliminarFila (String nombre, String condicion) {
        String query = "DELETE FROM " + nombre + "WHERE " + condicion;
        System.out.println(query);
    }

}
