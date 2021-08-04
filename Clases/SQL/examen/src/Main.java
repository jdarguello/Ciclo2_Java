import java.util.Arrays;
import java.util.Scanner;

//Hecho por: Juan  David Argüello Plata

public class Main {
    //Script a ejecutar
    //Objetivo: Conectar todos los algoritmos desarrollados.
    public static void main(String[] args) {
        //Inicialización de objetos generales
        Scanner scanner = new Scanner(System.in);
        Interactividad interac = new Interactividad();

        //Introducción
        MisionTIC mision = interac.Intro(scanner);

        //Menú de opciones
        boolean exito = true;       //Impresión interactiva de opciones
        while (true) {
            if (exito) {
                interac.options(mision);
            }
            boolean salir = false;
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1:
                    mision = interac.Intro(scanner);
                    exito = true;
                    break;
                case 2:
                    if (mision.name[0] != null) {
                        mision = interac.Registro(scanner, mision);
                        exito=true;
                    }
                    System.out.println(Arrays.toString(mision.name));
                    break;
                case 3:
                    if (mision.name[0] != null) {
                        mision = interac.access(mision, 1, scanner, "");
                        if (mision.existe) {
                            exito = true;
                        } else {
                            System.out.println("El nombre del ciclo usado no está registrado. Selecciona una nueva opción...");
                        }
                    } else {
                        System.out.println("Debes acceder primero a la sede. Selecciona una nueva opción...");
                        exito = false;
                    }
                    break;
                case 4:
                    if (mision.name[1] != null) {
                        mision = interac.Registro(scanner, mision);
                        exito = true;
                    }
                    break;
                case 5:
                    if (mision.name[1] != null) {
                        mision = interac.access(mision, 2, scanner, "");
                        if (mision.existe) {
                            exito = true;
                        } else {
                            System.out.println("El nombre del grupo usado no está registrado. Selecciona una nueva opción...");
                        }
                    } else {
                        System.out.println("Debes acceder primero al ciclo. Selecciona una nueva opción...");
                        exito = false;
                    }
                    break;
                case 6:
                    if (mision.name[2] != null) {
                        mision = interac.Registro(scanner, mision);
                        exito = true;
                    }
                    break;
                case 7:
                    interac.Imprimir(mision, true);
                    System.out.println("Selecciona otra opción...");
                    exito = false;
                    break;
                case 8:
                    interac.Imprimir(mision, false);
                    exito = true;
                    break;
                case 9:
                    interac.ActualizarItem(mision, scanner);
                    break;
                case 10:
                    interac.EliminarItem(mision, scanner);
                    break;
                case 11:
                    System.out.println("Se ha finalizado el proceso.");
                    salir = true;
                    break;
            }
            if (salir) {
                break;
            }
        }
    }
}


