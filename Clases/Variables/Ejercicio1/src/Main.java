import java.util.Scanner;

public class Main {
    /*Ejercicio:
        Elabora un algoritmo interactivo que pregunte por:
            - Nombre.
            - Año de nacimiento.
        Con estos datos se busca calcular la posible edad de la persona.

        Por ejemplo:
            - Nombre -> Juan.
            - Año de nacimiento -> 1992.
            - Respuesta: "Juan nació en 1992 y posiblemente tenga 29 años".
     */
    public static void main(String[] args) {
        //Para la parte interactiva, requerimos usar la librería Scanner
        Scanner scanner = new Scanner(System.in);   //Iniciamos con la creación de la variable
        System.out.println("Ejemplo de impresión...");
        /*
            A continuación, el usuario podrá definir el valor de la variable 'x'.
            Toda variable definida por usuario es de tipo 'String'.
         */
        String x = scanner.nextLine();
        System.out.println("Escribiste que 'x' es igual a " + x);
    }
}
