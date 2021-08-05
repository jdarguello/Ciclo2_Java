package Publicaciones;

import User.Usuario;

import java.util.*;

public class Pub {
    //---Atributos---
    protected String nombre;
    protected String contenido;
    public Usuario[] likes = {};
    public ArrayList<Usuario> meEncanta = new ArrayList<Usuario>();

    //---Metodos---
    public Pub(String nombre, String contenido) {
        this.nombre = nombre;
        this.contenido = contenido;
    }

    public Pub() {
        //No hay que hacerle nada.

        //Esta estipulado para crear 'borradores'
    }

    public int[] likesMeEncanta () {
        //Retorna el numero de likes y corazones (me encanta)
        int[] meGusta = {likes.length,meEncanta.size()};  //[num_likes, num_me_encanta]
        return meGusta;
    }


    public void meGusta(Usuario user) {
        //Objetivo: Anadir un nuevo 'like' a una publicacion
        //1. Se creo la copia del array original con un comp. adicional
        likes = Arrays.copyOf(likes, likes.length+1);
        //2. Modificamos el ultimo componente
        likes[likes.length-1] = user;
    }

    public void noMeGusta(Usuario user) {
        //likes = [John, Monica, Luis]
        //Eliminemos a Monica -> likes = [John, Luis]

        //1.Creamos un array "vacio" con la misma longitud de 'likes' -1
        Usuario[] nuevos_likes = new Usuario[likes.length-1];

        //2. Llenar la informacion sin el Usuario que ya no gusta de la publicacion
        int contador = 0;   //Toma la posicion del array 'nuevos_likes'
        for (int i=0; i<likes.length;i++) {
            if (!(likes[i]).equals(user)) {    //Si el 'usuario' es diferente al 'user'...
                nuevos_likes[contador] = likes[i];
                contador++;
            }
        }

        //3. Reemplazar el array de 'likes'
        likes = nuevos_likes;

    }

    public void editarContenido (String nuevo) {
        this.contenido = nuevo;
    }

    public void meEncanta(Usuario user) {
        meEncanta.add(user);
    }

    public void noMeEncanta(Usuario user) {
        meEncanta.remove(user);
    }

    public String obtenerNombre() {
        return nombre;
    }

    public String obtenerContenido() {
        return contenido;
    }
}

