public class Main {
    /*
        Ejercicio: en el mercado del ganado bovino, es común vender las reces machos para la
                   producción de carne de res. Las hembras se venden para este fin cuando culmina
                   su etapa reproductiva. Suponiendo ciertos los siguientes hechos:
                        1. El kilo de ganado se vende en $4.000.
                        2. La etapa reproductiva de una hembra culmina a los 10 años.
                        3. Es viable vender una res cuando su peso sea mayor a los 600 kg.

                   Elabora un algoritmo que:
                        1. Identifique la cantidad de reces listas para la venta en una finca.
                        2. Calcule el total de ingresos que supondría vender este ganado.
                        3. Calcule el porcentaje que representa el ganado listo para vender
                           respecto del total disponible.
     */
    public static void main(String[] args) {
        //Estructura: id de la res, peso, edad, género: hembra (0) - macho (1)
	    short [][] ganado = {
                {602, 300, 3, 1},
                {506, 700, 6, 1},
                {811, 500, 9, 0},
                {602, 300, 8, 1},
                {343, 600, 2, 1},
                {299, 350, 2, 0},
                {568, 500, 11, 0}
        };
    }
}
