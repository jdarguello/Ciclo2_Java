import CRUD.CRUD;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
         CRUD test = new CRUD("prueba");

         test.crearTabla("personas", new Object[][] {
                 {"ID", "INTEGER", false, true},
                 {"nombre", "TEXT", true},
                 {"edad", "INTEGER", false}
         });

         /*
         test.guardarFila("personas", new Object[][]{
                 {"NULL", "\"John\"", 22},
                 {"NULL", "\"Juan\"", 14}
         });
          */

         ArrayList<ArrayList<Object>> personas = test.leerTodo("personas");

        System.out.println(personas);


    }
}
