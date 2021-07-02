import java.util.Arrays;

public class Main {
    /*
        Ejercicio:
            1. Elabora un algoritmo que identifique el procentaje de hombres y mujeres
               en una compañía. <-
            2. Calcula el total de egresos de la empresa en salarios.
            3. Discretiza los salarios por género.
            4. Discretiza los salarios por cargo.
     */
    public static void main(String[] args) {
        //Estructura: nombre, género, cargo, salario
        Object[][] nomina = {                           //nomina ->[Object[], Object[],...]
                {"Alfredo", "M", "Operador 1", 200000}, //persona -> [Object, Object, Object]
                //    String, String, String,       int
                {"Álvaro", "M", "Operador 3", 1500000},
                {"Alejandra", "F", "Operador 2", 400000},
                {"Mauro", "M", "Operador 1", 200000},
                {"Luisa", "F", "Operador 2", 1500000},
                {"Alicia", "F", "Operador 1", 200000}
        };

        /*OBJETIVO:
            1. Contar cuántas personas hay en total, cuántas son mujeres y cuántas personas son hombres.
            2. %Hombres = cant_hombres/cant_total*100; %Mujeres = cant_mujeres/cant_total*100;
        */

        /*FOR
            //Enfoque numérico
            for (int i=0; i<limite;i++) {

            }

            //Enfoque directo
            for (<tipo_variable> componente: array) {

            }
        */

        //System.out.println(nomina[3][0]);

        //Conversión -> (<tipo_var>)(var_a_convertir)
        int num_personas = 0;
        int num_mujeres = 0;
        int num_hombres = 0;
        for (Object[] c: nomina) {
            String nombre = (String)(c[0]);
            String genero = (String)(c[1]);
            String cargo = (String)(c[2]);
            int salario = (int)(c[3]);

            //Comparación numérica: ==, !=, <=,...
            //Comparación texto: ==, != (Python) -> (Java) genero.equals("M")
            //

            //System.out.println(Arrays.toString(c)); //Convierte un vector en string
            //System.out.println(nombre);
        }
    }
}
