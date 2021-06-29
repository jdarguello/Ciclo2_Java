import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    // Inicialización de herramientas
        POS sistema = new POS();                        //Métodos a desarrollar
        Scanner scanner = new Scanner((System.in));     //Interacción de usuario

        // Desarrollo interactivo
        boolean nuevaCompra = true;
        do {
            while (true) {
                System.out.println("¿Qué artículo deseas adquirir?");
                String articulo = scanner.nextLine();
                System.out.println("¿Qué cantidad deseas comprar?");
                String cantidad = scanner.nextLine();
                sistema.nuevoProducto(articulo, Integer.parseInt(cantidad));    //Almacenamiento del artículo de interés
                System.out.println("¿Deseas seguir comprando? (si/no)");
                if (scanner.nextLine().equals("no")) {
                    break;
                }
            }
            sistema.Factura();      //Impresión de factura
            System.out.println("¿Deseas hacer una nueva compra? (si/no)");
            if (scanner.nextLine().equals("no")) {
                nuevaCompra = false;
            } else {
                sistema.articulos = new Object[][] {};          //Reinicio de la variable artículos para nueva factura
            }
        } while (nuevaCompra);
        sistema.ResumenVentas();
    }
}
