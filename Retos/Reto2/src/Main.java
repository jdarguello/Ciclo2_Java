import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
        public static void main(String[] args) {
            //Herramientas
            HashMap<String, Integer> num = new HashMap<>();
            FinanzasP finanzas = new FinanzasP();

            //Variables repetitivas
            String nombre;
            int valor, efectivo;

            while (true) {
                byte opcion = opcionesG();
                switch (opcion) {
                    case 1:
                        System.out.print("Ingresa el nombre del gasto fijo: ");
                        nombre = input.next();
                        System.out.print("Indica el valor: ");
                        valor = input.nextInt();
                        finanzas.registrarFijos(nombre, valor);
                        break;
                    case 2:
                        System.out.print("Nombre del gasto: ");
                        nombre = input.next();
                        System.out.print("Indica el valor: ");
                        valor = input.nextInt();
                        finanzas.gasto(nombre, valor);
                        break;
                    case 3:
                        System.out.print("Cuanto dinero tienes en efectivo?");
                        efectivo = input.nextInt();
                        System.out.println("Has registrado: $" + efectivo + " de dinero en efectivo.\n");
                        finanzas.Efectivo(efectivo);
                        break;
                    case 4:
                        System.out.print("Cuanto dinero tienes en banco?");
                        efectivo = input.nextInt();
                        System.out.println("Has registrado: $" + efectivo + " de dinero en banco.\n");
                        finanzas.EfElectronico(efectivo);
                        break;
                    case 5:
                        int[] dinero = finanzas.ConsultarCartera();
                        System.out.println("Dispones de $" + dinero[0] + " en efectivo y de $" + dinero[1] + " en banco.\n");
                        break;
                    case 6:
                        int utilidad = finanzas.utilidades();
                        System.out.println("Dispones de $" + utilidad + " para invertir en bolsa o criptomoneda.\n");
                        break;
                    case 7:
                        HashMap<String, Integer> movimientos = finanzas.movimientosF();
                        System.out.println("Resumen de movimientos: $" + movimientos.get("Ingresos") + " de ingresos y $" + movimientos.get("Egresos") + " de egresos.");
                        break;
                }
            }
    }

    public static byte opcionesG() {
        byte opcion = 0;
        while (opcion == 0) {
            System.out.println("Menu de opciones:");
            System.out.println("1. Registrar gasto fijo.");
            System.out.println("2. Registrar gasto.");
            System.out.println("3. Modificar dinero en efectivo.");
            System.out.println("4. Modificar dinero en banco.");
            System.out.println("5. Consulta de liquidez.");
            System.out.println("6. Consulta de capital de inversion.");
            System.out.println("7. Movimientos financieros.");
            opcion = input.nextByte();
            if (opcion > 7 || opcion < 0) {
                opcion = (byte)0;
            }
        }
        return opcion;
    }
}
