import CRUD.CRUD;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
         CRUD test = new CRUD("prueba");    //Se especifica el nombre de la base de datos

        //------CREAR TABLAS------
        //Especificar columnas
        Object[][] columnas = {
                //nombre, naturaleza, NOT NULL?, AUTOINCREMENT?
                {"ID", "INTEGER", false, true},
                {"nombre", "TEXT", true},
                {"edad", "INTEGER", false}
        };

         test.crearTabla("personas", columnas);
        //----Almacenar filas----
        //Especificar filas
        Object[][] filas = {
            {"NULL", "\"John\"", 22},
            {"NULL", "\"Juan\"", 14}
        };
         test.guardarFila("personas", filas);

         //---Lectura de TODA la tabla---
         //ArrayList<ArrayList<Object>> personas = test.leerTodo("personas");

         //---Lectura filtrada---
        String[][] condiciones = {
                {"nombre", "\"John\"", "AND"},
                {"nombre", "\"Juan\"", "OR"},
                {"edad", "14"}
        };
        //ArrayList<ArrayList<Object>> people = test.leerFiltrado("personas", condiciones);
        //System.out.println(personas);
    }
}
