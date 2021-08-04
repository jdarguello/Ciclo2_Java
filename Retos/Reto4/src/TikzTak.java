import Publicaciones.Historia;
import Publicaciones.Pub;
import Publicaciones.Reel;
import User.Usuario;
import Corporaciones.Empresa;

import java.util.Arrays;
import java.util.Scanner;

public class TikzTak {
    static Scanner input = new Scanner(System.in);
    static Usuario[] users;
    static Usuario usuarioRef;

    public static void main(String[] args) {
        //---Creacion de usuarios---
        Usuario delta = new Usuario("Joaquim Low", (byte)22, "jolow@gmail.com", "jolow");
        Usuario omega = new Usuario("Moise Low", (byte)28, "molow@gmail.com", "Ingeniero" ,"molow");
        Usuario alpha = new Usuario("Juan", (byte)17, "juan@gmail.com", "juan");

        //---Acceder como un usuario---
        users = new Usuario[] {delta, omega, alpha};    //Usuarios iniciales...

        usuarioRef = cambioUsuario();
        //---Opciones---
        boolean condicion = true;
        while (condicion) {
            System.out.println("\n");
            byte opcion = opciones(usuarioRef.nombreUsuario());
            System.out.println("Usuario: " + usuarioRef.nombreUsuario());
            switch (opcion) {
                case 1:
                    seguirUser();
                    break;
                case 2:
                    Object[] selecciones = selecPerfilUsuario();
                    Usuario user =  (Usuario) selecciones[0];
                    byte option = (byte)selecciones[1];
                    while (option != -1) {
                        switch (option) {
                            //Opcion <= 3 -> ver pubs
                            case 1:
                                verPubs("Publicacion", user);
                                break;
                            case 2:
                                verPubs("Historia", user);
                                break;
                            case 3:
                                verPubs("Reel", user);
                                break;
                            case 4:
                                meSiguen(user);
                                break;
                            case 5:
                                crearPub("sencilla");
                                break;
                            case 6:
                                crearPub("historia");
                                break;
                            case 7:
                                crearPub("reel");
                                break;
                        }
                        option = opcionesPerfil(user);
                    }
                    break;
                case 3:
                    usuarioRef = cambioUsuario();
                    break;
                case 4:
                    condicion = false;
                    break;
            }
        }
        System.out.println("Cierre de sesion...");
    }

    public static void crearPub (String tipo) {
        String[] contenido = contenidoPublicacion(tipo);
        usuarioRef.publicar(contenido, tipo);
        System.out.println("Se creo una nueva publicacion!");
    }

    public static byte opciones (String nombre) {
        System.out.println("Eres el usuario '" + nombre + "'");
        System.out.println("Que opcion deseas elegir?");
        System.out.println("1. Seguir a otro usuario.");
        System.out.println("2. Entrar al perfil de un usuario.");
        System.out.println("3. Cambiar de usuario.");
        System.out.println("4. Salir.");
        return input.nextByte();
    }

    public static Object[] selecPerfilUsuario() {
        System.out.println("Perfiles a acceder:");
        System.out.println(pickUser(false));
        Usuario user = users[input.nextByte()-1];

        //Opciones en perfil
        byte opcion = opcionesPerfil(user);

        return new Object[]{user, opcion};
    }

    public static byte opcionesPerfil(Usuario user) {
        String msg = "\nAccediste al perfil de " + user.nombre_user;
        if (user.equals(usuarioRef)) {
            msg = "\nAccediste a tu perfil";
        }
        System.out.println(msg);
        System.out.println("Que deseas hacer?");
        System.out.println("1. Ver publicaciones");
        System.out.println("2. Ver historias");
        System.out.println("3. Ver reels");
        System.out.println("4. Ver seguidores");
        byte ultOpcion = 5;
        if (user.equals(usuarioRef)) {
            System.out.println("5. Crear publicacion");
            System.out.println("6. Crear historia");
            System.out.println("7. Crear reel");
            ultOpcion = 8;
        }
        System.out.println(ultOpcion + ". Volver a inicio");
        byte opcion = input.nextByte();
        if (opcion <0 || opcion > ultOpcion) {
            System.out.println("No existe la opcion " + opcion);
            opcion = -1;
        } else if (opcion == ultOpcion) {
            opcion = -1;
        }
        return opcion;
    }


    public static String[] contenidoPublicacion(String tipo) {
        byte numCont = 2;
        if (tipo.equals("historia")){
            numCont = 5;
        } else if (tipo.equals("reel")) {
            numCont = 4;
        }
        String[] contenido = new String[numCont];
        System.out.println("Titulo:");
        contenido[0] = input.nextLine();
        contenido[0] = input.nextLine();
        System.out.println("Contenido:");
        contenido[1] = input.nextLine();

        if (tipo.equals("historia")){
            System.out.println("Longitud video:");
            contenido[2] = input.nextLine();
            System.out.println("Calidad:");
            contenido[3] = input.nextLine();
            System.out.println("Duracion:");
            contenido[4] = input.nextLine();
        } else if (tipo.equals("reel")) {
            System.out.println("Efectos (true/false):");
            contenido[2] = input.nextLine();
            System.out.println("Calidad:");
            contenido[3] = input.nextLine();
        }
        return contenido;
    }

    public static void verPubs (String tipo_pub, Usuario usuario) {
        System.out.println(tipo_pub + ":");
        //tipo de publicacion
        if (usuario.publicaciones.length > 0) {
            int cont = 0;
            for (int i=0; i<usuario.publicaciones.length;i++) {
                int[] meGusta = usuario.publicaciones[i].likesMeEncanta();
                if (tipo_pub.equals("Publicacion") && usuario.publicaciones[i] instanceof Pub && !(usuario.publicaciones[i] instanceof Historia) && !(usuario.publicaciones[i] instanceof Reel)) {
                    cont += 1;
                    likes(cont, i, meGusta, usuario);
                } else if (tipo_pub.equals("Historia") && usuario.publicaciones[i] instanceof Historia) {
                    cont += 1;
                    likes(cont, i, meGusta, usuario);
                } else if (tipo_pub.equals("Reel") && usuario.publicaciones[i] instanceof Reel) {
                    cont += 1;
                    likes(cont, i, meGusta, usuario);
                }
            }
        }
    }

    public static void likes(int cont, int i, int[] meGusta, Usuario usuario) {
        System.out.println("Publicacion " + cont + ":");
        System.out.println(usuario.publicaciones[i].obtenerNombre());
        System.out.println(usuario.publicaciones[i].obtenerContenido());
        System.out.println("Likes: " + meGusta[0] + ". Me encanta: " + meGusta[1]);

        //Ya gusta la publicacion?
        boolean yaGusta = false;
        boolean like = true;
        for (Usuario user: usuario.publicaciones[i].likes) {
            if (user.equals(usuarioRef)) {
                yaGusta = true;
            }
        }

        for (Usuario user: usuario.publicaciones[i].meEncanta) {
            if (user.equals(usuarioRef)) {
                yaGusta = true;
                like = false;
            }
        }

        if (yaGusta) {
            if (like) {
                System.out.println("\nDeseas darle 'dislike'? (true/false)");
                if (input.nextBoolean()) {
                    usuario.publicaciones[i].noMeGusta(usuarioRef);
                }
            } else {
                System.out.println("\nDeseas darle 'no me encanta'? (true/false)");
                if (input.nextBoolean()) {
                    usuario.publicaciones[i].noMeEncanta(usuarioRef);
                }
            }

        } else {
            System.out.println("\nDeseas darle 'like' (1), 'me encanta'(2) o 'ninguna' (3)? ");
            switch (input.nextByte()) {
                case 1:
                    usuario.publicaciones[i].meGusta(usuarioRef);
                    break;
                case 2:
                    usuario.publicaciones[i].meEncanta(usuarioRef);
                    break;
            }
        }
    }

    public static void sigo() {
        System.out.println("Sigues a:");
        if ((usuarioRef.siguesA()).size() == 0) {
            System.out.println("No sigues a nadie");
        } else {
            for (Usuario user: usuarioRef.siguesA()) {
                System.out.println(user.nombre_user);
            }
        }
    }

    public static void meSiguen(Usuario usuario) {
        System.out.println("Los seguidores de " + usuario.nombre_user + " son:");
        if ((usuario.verSeguidores()).size() == 0) {
            System.out.println("No tienes seguidores");
        } else {
            for (Usuario user: usuario.verSeguidores()) {
                System.out.println(user.nombre_user);
            }
        }
    }

    public static void seguirUser () {
        System.out.println("Selecciona el usuario a seguir:");
        for (int i=0; i<users.length; i++) {
            if (!users[i].equals(usuarioRef)) {
                System.out.println(i + ". " + users[i].nombre_user);
            }
        }
        usuarioRef.seguir(users[input.nextByte()]);
    }

    public static String pickUser (boolean nuevo) {
        String msg = "Elige un usuario: ";
        for (int i=0; i<users.length; i++) {
            msg += users[i].nombreUsuario() + " (" + (i+1) + ") - ";
        }
        if (nuevo) {
            msg += "crear empresa (" + (users.length+1) + ")";
        }
        return msg;
    }

    public static Usuario cambioUsuario () {
        Usuario user = users[0];
        byte opcion = (byte)(users.length+1);   //Opcion inexistente
        boolean condicion = true;
        while (condicion) {
            System.out.println(pickUser(true));
            opcion = input.nextByte();
            if (opcion == users.length+1) {
                condicion = false;
                //Crear usuario empresarial
                String[] datos = datosEmpresa();
                user = new Empresa(datos[0], datos[1]);
                addUser(user);
            } else {
                //Acceder a usuario corriente
                for (int i=0; i<users.length; i++) {
                    if ((opcion-1) == i) {
                        user = users[i];
                        condicion = false;
                        break;
                    }
                }
            }
        }
        return user;
    }

    public static void addUser (Usuario user) {
        users = Arrays.copyOf(users, users.length+1);
        users[users.length-1] = user;
    }

    public static String[] datosEmpresa () {
        System.out.println("Escribe el nombre de usuario corporativo:");
        String corpo = input.next();
        System.out.println("Escribe el correo electronico corporativo:");
        String email = input.next();
        return new String[] {email, corpo};
    }
}