import java.util.Arrays;
import java.util.Scanner;

public class Interactividad {
    //Objetivo general: Interactividad de usuario ->
    //                                    conexión con las clases: MisionTIC, ciclo, grupo y tripulante.
    String [] objetos = {"sede", "ciclo", "grupo", "tripulante"};
    String[][][] estructuras = {{{"id", "int"}, {"Nombre", "str"}}, {{"id", "int"}, {"Nombre" , "str"}, {"Sede", "str"}}, {{"id", "int"}, {"Nombre" , "str"}, {"Sede", "str"}, {"Ciclo", "str"}},  {{"id", "int"}, {"Nombre", "str"}, {"Celular", "str"}, {"Email", "str"} ,{"Sede", "str"} , {"Ciclo", "str"}, {"Grupo", "str"}}};


    public void EliminarItem(MisionTIC mision, Scanner scanner) {
        int tipoTab = Integer.parseInt(opcionesActEl(scanner));
        tipoTab--;
        //Imprimir tabla para selección de usuario
        this.Imprimir(mision, false);
        System.out.println("Indica el id del item que deseas eliminar:");
        int id = Integer.parseInt(scanner.nextLine());
        mision.eliminarItem(tipoTab, id);
        System.out.println("Item eliminado.");
    }

    private String opcionesActEl(Scanner scanner) {
        System.out.println("Selecciona el número que identifica la tabla que deseas modificar:");
        System.out.println("1. sede");
        System.out.println("2. ciclo");
        System.out.println("3. grupo");
        System.out.println("4. tripulante");
        return scanner.nextLine();
    }

    public void ActualizarItem(MisionTIC mision, Scanner scanner) {
         String op = opcionesActEl(scanner);
         int tipoTab = Integer.parseInt(op);
         tipoTab--;
         //Imprimir tabla para selección de usuario
        this.Imprimir(mision, false);
        System.out.println("Indica el id del item que deseas cambiar:");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Indica los nuevos valores:");
        String[][] info = {};
        for (String [] item: this.estructuras[tipoTab]) {
            System.out.println(item[0] + ":");
            info = Arrays.copyOf(info, info.length+1);
            info[info.length-1] = new String[] {item[0], scanner.nextLine()};
        }
        mision.actualizarTabla(tipoTab, id, info);
        System.out.println("¡Elementos actualizados!");
    }

    public void Imprimir (MisionTIC mision, boolean filtrar) {
        /*
            Objetivo: Impresión en orden descendente:
                * sede
                    + ciclos        (sede)
                    + grupos        (sede)
                    + tripulantes   (sede)
                * sede - ciclo
                    + grupos        (sede - ciclo)
                    + tripulantes   (sede - ciclo)
                * sede - ciclo - grupo
                    + tripulantes (sede - ciclo - grupo)
         */
        int ult_pos = 0;
        for (int pos = 0; pos < mision.name.length-1; pos++) {
            if (mision.name[pos] != null) {
                ult_pos = pos;
            }
        }
        if (!filtrar) {
            ult_pos = -1;
        }
        //Lecturas de base de datos
        for (int i = ult_pos+1; i < mision.name.length; i++) {
            //Antes de leer la base de datos, se debe ajustar la estructura
            mision.est_datos = this.estructuras[i];
            String[][] info = mision.leer(this.objetos[i], filtrar);
            //Impresión de la información
            //String [] mensaje = msg_ubicacion(mision);
            if (filtrar) {
                System.out.println("Base de datos de " + this.objetos[i] + ": " + mision.name[ult_pos]);
            } else {
                System.out.println("Base de datos de " + this.objetos[i]);
            }
            //Cabecera
            String msg = "";
            String sep = "\t\t\t\t\t\t\t\t";
            for (String[] dato : this.estructuras[i]) {
                msg += dato[0] + sep;
            }
            System.out.println(msg);
            //Cuerpo
            for (String[] fila : info) {
                msg = "";
                for (String item : fila) {
                    msg += item + sep;
                }
                System.out.println(msg);
            }
            System.out.println("---------------------------------------------------------------------------------------------------|");
        }
    }

    public MisionTIC access (MisionTIC mision, int tipo, Scanner scanner, String name) {
        //Limpieza de nombres
        mision.est_datos = this.estructuras[tipo];
        for (int i = 0; i< mision.name.length-1; i++) {
            if (i > tipo) {
                mision.name[i] = null;
            }
        }
        //Acceso al nombre del objeto
        System.out.println("Escribe el nombre del " + objetos[tipo] + " al que deseas acceder");
        String nombre;
        if (name.equals("")) {
            nombre = scanner.nextLine();
        } else {
            nombre = name;
        }
        if (mision.accederObjeto(nombre, tipo, objetos[tipo])) {
            mision.name[tipo] = nombre;
        } else {
            String mensaje = "El nombre del " + objetos[tipo] + " '" + nombre + "' no existe en la base de datos. Están registrados los nombres: ";
            String[][] infoDB = mision.leer(objetos[tipo], true);
            for (String[] fila : infoDB) {
                mensaje += fila[1] + ", ";
            }
            mensaje = mensaje.substring(0, mensaje.length()-1);
            System.out.println(mensaje);
        }
        return mision;
    }

    public MisionTIC Registro(Scanner scanner, MisionTIC mision) {
        //Mensaje de entrada
        String [] mensaje = msg_ubicacion(mision);
        String msg = "Registro de " + mensaje[1] + " para: " + mensaje[0];
        while (true) {
            //Reiniciar estructura de datos
            mision.est_datos = new String[][] {{"id","int"}, {"Nombre", "str"}};
            //Mensajes
            System.out.println(msg);
            System.out.println("Digita la siguiente información:");
            String [][] info = {{"Nombre", ""}};
            int ref = 0;
            if (mision.name[mision.name.length -  2] == null) {
                System.out.println("Nombre: ");
                info[0][1] = scanner.nextLine();
                ref = 2;
            } else {
                //Se trata de un tripulante
                info = new String[][]{{"Nombre", ""}, {"Celular", ""}, {"Email", ""}};
                for (int i = 0; i < info.length; i++) {
                    System.out.println(info[i][0] + ":");
                    info[i][1] = scanner.nextLine();
                }
                ref = 4;
            }
            //Preparación de la estructura de datos
            int location = 0;   //¿En dónde está ubicado? (sede, ciclo, etc)
            for (String name : mision.name) {
                if (name == null) {
                    break;
                } else {

                }
                location++;
            }
            for (int i=ref; i < this.estructuras[location].length;i++) {
                info = Arrays.copyOf(info, info.length+1);
                info[info.length-1] = new String[] {this.estructuras[location][i][0], mision.name[i-ref]};
            }
            mision.est_datos = this.estructuras[location];
            mision.crearObjeto(info, mensaje[1]);
            System.out.println("¿Deseas agregar otro " + mensaje[1] + "? (s/n)");
            boolean salir = false;
            switch (scanner.nextLine()) {
                case "s":
                    break;
                case "n":
                    salir = true;
                    break;
            }
            if (salir) {
                break;
            }
        }
        return mision;
    }

    private String[] msg_ubicacion (MisionTIC mision) {
        String msg = "";
        String nom_obj = "";
        for (int i = 0; i < mision.name.length-1; i++) {
            if (mision.name[i] != null) {
                nom_obj = this.objetos[i+1];
                msg += mision.name[i] + " - ";
            }
        }
        msg = msg.substring(0,msg.length()-2);
        String[] mensaje = new String[] {msg, nom_obj};
        return mensaje;
    }

    public void options(MisionTIC mision) {
        System.out.println("Selecciona una de las siguientes opciones escribiendo en consola el número correspondiente:");
        System.out.println("1. Cambiar de sede.");
        System.out.println("2. Registrar ciclo.");
        System.out.println("3. Acceder a un ciclo.");
        System.out.println("4. Registrar un grupo.");
        System.out.println("5. Acceder a un grupo.");
        System.out.println("6. Registrar un tripulante.");
        //Impresión de información interactiva
        String[] mensaje = msg_ubicacion(mision);
        System.out.println("7. Imprimir en pantalla información de: " + mensaje[0]);
        System.out.println("8. Imprimir toda la base de datos.");
        System.out.println("9. Actualizar datos.");
        System.out.println("10. Eliminar datos");
        System.out.println("11. Salir.");
    }

    public MisionTIC Intro(Scanner scanner) {
        String nombreMision = "MisiónTIC 2022";
        MisionTIC mision = new MisionTIC();
        //Reiniciar
        mision.name = new String[4];
        mision.est_datos = new String[][] {{"id","int"}, {"Nombre", "str"}};
        while (true) {
            System.out.println("Bienvenido a la " + nombreMision + ". ¿Deseas acceder (a) o crear (c) una sede MisiónTIC?");

            //MisiónTIC
            String respuesta = this.pregunta("a", "c", "sede");
            if (respuesta.equals("c")) {
                System.out.println("¿Cuál es el nombre de la sede que deseas registrar?");
                String[][] nombreSede = {{"Nombre",scanner.nextLine()}};
                mision.crearObjeto(nombreSede, this.objetos[0]);
            } else {
                System.out.println("¿Cuál es el nombre de la sede a la que deseas acceder?");
                String nom_acceder = scanner.nextLine();
                boolean existe = mision.accederObjeto(nom_acceder, 0, this.objetos[0]);
                if (existe) {
                    this.access (mision, 0, scanner, nom_acceder);
                    break;
                }
                //ciclo = mision.returnCiclo(scanner.nextLine());
            }
        }
        return mision;
    }

    private String pregunta(String op1, String op2, String etapa) {
        Scanner scanner = new Scanner(System.in);
        String respuesta;
        while (true) {
            respuesta = scanner.nextLine();
            if (respuesta.equals(op1) || respuesta.equals(op2)) {
                break;
            } else {
                System.out.println("Respuesta incorrecta. ¿Qué te gustaría hacer?");
                System.out.println(op1 + " -> acceder a " + etapa);
                System.out.println(op2 +" -> crear nueva " + etapa);
            }
        }
        return respuesta;
    }
}
