import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class prueba {
    public static void main(String[] args) {
        HashMap<String, ArrayList<ArrayList<Object>>> algo = new HashMap();

        algo.put("Algo", new ArrayList<ArrayList<Object>>(Arrays.asList(
                new ArrayList<Object>(Arrays.asList("nombre", "TEXT", true, true)),
                new ArrayList<Object>(Arrays.asList("edad", "INTEGER", false))
        )));

        String cont = algo.toString();

        //--Reverse--
        cont = cont.substring(1, cont.length() - 1);

        String[] columnas = (cont.split("=")[1]).split(",");

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
        System.out.println(columns);
    }
}
