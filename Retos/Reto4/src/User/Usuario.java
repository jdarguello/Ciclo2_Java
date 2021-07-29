package User;

import Publicaciones.Pub;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Usuario extends Persona {
    //---Atributos---
    public String nombre_user;
    private String contra;
    private ArrayList<Usuario> sigueA = new ArrayList();
    private ArrayList<Usuario> seguidores = new ArrayList();
    private HashMap<Usuario, Pub[]> gustos = new HashMap();
    private Pub[] publicaciones = {};

    //---Métodos---
    public void gustaPublicacion (Usuario usuario, int id_pub) {
        Pub[] gustos = this.gustos.get(usuario);                    //Obtener publicaciones de gustos provenientes de otro usuario
        gustos = Arrays.copyOf(gustos, gustos.length+1);    //Se crea una copia y se incrementa en uno su longitud
        //Añadir publicación que gustó
        gustos[gustos.length-1] = usuario.obtenerPublicacion(id_pub);
        this.gustos.put(usuario, gustos);

    }
    public Pub obtenerPublicacion (int id_pub) {
        return this.publicaciones[id_pub];
    }
    public void publicar(Pub publi) {
        //Añadir nueva publicación
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
    public String nombreUsuario() {
        return this.nombre_user;
    }
    public void serSeguido(Usuario user) {
        this.seguidores.add(user);
    }
    public void seguir(Usuario user) {
        this.sigueA.add(user);          //Añadir usuario a lista de genta a quienes sigue
        user.serSeguido(this);      //Añadir usuario actual a la lista de seguidores del otro usuario
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
