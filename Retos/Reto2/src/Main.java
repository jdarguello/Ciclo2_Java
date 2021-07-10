import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
        public static void main(String[] args) {
            //Herramientas
            FinanzasP finanzas = new FinanzasP();

            while (true) {
                byte opcion = opcionesG();
                switch (opcion) {
                    case 1:
                        finanzas.registrarFijos(input);
                        break;
                    case 2:
                        finanzas.gasto(input);
                        break;
                    case 3:
                        finanzas.Efectivo(input);
                        break;
                    case 4:
                        finanzas.EfElectronico(input);
                        break;
                    case 5:
                        finanzas.ConsultarCartera();
                        break;
                    case 6:
                        finanzas.utilidades();
                        break;
                    case 7:
                        finanzas.movimientosF();
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
