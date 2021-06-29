import java.util.Arrays;

public class POS {
    Object [][] articulos = new Object [][] {};
    /*
        (variable "articulos")
        OBJETIVO:   Almacenar los artículos que se desean facturar para un cliente individual.
        FORMATO:
            articulos = [
                [nombre_articulo1, cantidad1],
                [nombre_articulo2, cantidad2],
                .
                .
                .
            ]

        Ejemplo:
            articulos = [
                ["Honey", 3],
                ["Negra", 2]
            ]
     */
    int [] ventas = new int[] {};
    /*
        (variable "ventas")
        OBJETIVO:   Almacenar el total de cada venta individual
        FORMATO:
            ventas = [
                total1,
                total2,
                .
                .
                .
            ]

        Ejemplo:
            ventas = [
                49000,  //Equivalente al total de las 3 Honey y las 2 Negra
                .
                .
                .
            ]
     */
    Object [][] productos = new Object [][] {
        {"Honey", 10000},
        {"Malta", 8000},
        {"Negra", 9500}
    };

    public void Factura() {
        String mensaje = "\t\tFACTURA\n";
        mensaje += "Artículo\t\t\tCantidad\t\t\t\t\tValor unitario\t\t\tValor total\n";
        int total = 0;  //Valor total de la venta individual
        //---Tu desarrollo (debes emplear la variable "articulos")--

        mensaje += "TOTAL = " + total;
        System.out.println(mensaje);
        this.nuevaVenta(total);  //Registro de la venta
    }

    public void ResumenVentas() {
        int total = 0;
        //----Calcula el valor total (debes emplear la variable "ventas")----


        String mensaje = "El resumen de ventas del día de hoy es: $" + total;
        System.out.println(mensaje);
    }

    public void nuevoProducto(String art, int cant) {
        articulos = Arrays.copyOf(articulos, articulos.length+1) ;
        articulos[articulos.length-1] = new Object[] {art, cant};
    }

    public void nuevaVenta(int total) {
        ventas = Arrays.copyOf(ventas, ventas.length+1);
        ventas[ventas.length-1] = total;
    }
}
