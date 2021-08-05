package User;

import Publicaciones.Historia;
import Publicaciones.Pub;
import Publicaciones.Reel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Usuario extends Persona {
    //---Atributos---
    public String nombre_user;
    private String contra;
    private ArrayList<Usuario> sigueA = new ArrayList<Usuario>();
    private ArrayList<Usuario> seguidores = new ArrayList<Usuario>();
    public Pub[] publicaciones = {};

    //---Metodos---
    public Pub obtenerPublicacion (int id_pub) {
        return this.publicaciones[id_pub];
    }

    public void publicar(String[] contenido, String tipo) {
        //Crear la publicacion
        Pub publi = new Pub();
        if (tipo.equals("sencilla")) {
            publi = new Pub(contenido[0], contenido[1]);
        } else if (tipo.equals("historia")) {
            publi = new Historia(contenido[0], contenido[1], Integer.parseInt(contenido[2]), Integer.parseInt(contenido[3]), Integer.parseInt(contenido[4]));
        } else {
            //Es un Reel
            publi = new Reel(contenido[0], contenido[1], Boolean.parseBoolean(contenido[2]), Integer.parseInt(contenido[3]));
        }
        //Anadir nueva publicacion
        publicaciones = Arrays.copyOf(publicaciones, publicaciones.length+1);
        publicaciones[publicaciones.length-1] = publi;
    }
    public void dejarSeguir (Usuario user) {
        for (int i = 0; i < sigueA.size(); i++) { //Identificacion de usuario a dejar de seguir
            Usuario usuario = sigueA.get(i);
            if ((usuario.nombreUsuario()).equals(user.nombreUsuario())) {
                sigueA.remove(i);
                break;
            }
        }
    }

    public ArrayList<Usuario> siguesA() {
        return sigueA;
    }

    public ArrayList<Usuario> verSeguidores() {
        return seguidores;
    }

    public String nombreUsuario() {
        return this.nombre_user;
    }
    public void serSeguido(Usuario user) {
        this.seguidores.add(user);
    }
    public void seguir(Usuario user) {
        this.sigueA.add(user);          //Anadir usuario a lista de genta a quienes sigue
        user.serSeguido(this);      //Anadir usuario actual a la lista de seguidores del otro usuario
    }
    public void cambiarContra(String[] msgs) {
        Scanner input = new Scanner(System.in);

        System.out.println(msgs[0] + this.nombre_user);
        String contra;
        while (true) {
            System.out.println(msgs[1]);
            contra = input.next();
            System.out.println(msgs[2]);
            String repite = input.next();

            if (contra.equals(repite)) {
                break;
            }
        }
        //contra = repite
        this.contra = contra;
    }
    //Constructores
    public Usuario (String nombre, byte edad, String correo, String nombre_user) {
        super(nombre, edad, correo);
        this.nombre_user = nombre_user;
    }
    public Usuario (String nombre, byte edad, String correo, String nivelEducativo,String nombre_user) {
        super(nombre, edad, correo, nivelEducativo);
        this.nombre_user = nombre_user;
    }

    public Usuario (String correo, String nombre_user) {
        //Para usuario corporativo
        super(correo);
        this.nombre_user = nombre_user;
    }
}