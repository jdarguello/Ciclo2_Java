import java.util.HashMap;
import java.util.Scanner;

public class FinanzasP {
    //Propiedades
    HashMap<String, Integer> carteraAhorros = new HashMap<String, Integer>();
    HashMap<String, Integer> gastosFijos = new HashMap<String, Integer>();
    HashMap<String, Integer> gastos = new HashMap<String, Integer>();

    public void utilidades () {
        int utilidad = 0;
        //Calcula el dinero disponible para inversion


        System.out.println("Dispones de $" + utilidad + " para invertir en bolsa o criptomoneda.\n");
    }

    public void movimientosF() {
        //Resumen de movimientos financieros
        int ingresos = 0;
        int egresos = 0;
        //---calculo de ingresos y egresos---

        System.out.println("Resumen de movimientos: $" + ingresos + " de ingresos y $" + egresos + " de egresos.");
    }

    public void ConsultarCartera() {
        int efectivo = 0;
        int electronico = 0;
        //---Tu desarrollo---


        System.out.println("Dispones de $" + efectivo + " en efectivo y de $" + electronico + " en banco.\n");
    }

    public void gasto(Scanner input) {
        System.out.print("Nombre del gasto: ");
        String nombre = input.next();
        System.out.print("Indica el valor: ");
        int valor = input.nextInt();
        gastos.put(nombre, valor);
    }

    public void registrarFijos(Scanner input) {
        System.out.print("Ingresa el nombre del gasto fijo: ");
        String nombre = input.next();
        System.out.print("Indica el valor: ");
        int valor = input.nextInt();

        gastosFijos.put(nombre, valor);
    }

    public void Efectivo(Scanner input) {
        System.out.print("Cuanto dinero tienes en efectivo?");
        int efectivo = input.nextInt();
        carteraAhorros.put("Efectivo", efectivo);
        System.out.println("Has registrado: $" + efectivo + " de dinero en efectivo.\n");
    }

    public void EfElectronico(Scanner input) {
        System.out.print("Cuanto dinero tienes en banco?");
        int efectivo = input.nextInt();
        carteraAhorros.put("Electronico", efectivo);
        System.out.println("Has registrado: $" + efectivo + " de dinero en banco.\n");
    }
}
