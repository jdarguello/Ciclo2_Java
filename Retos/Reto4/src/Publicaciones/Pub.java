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
        //Contenido a reemplazar...
        System.out.println("Deberia ocurrir algo que todavia no...");
    }

    public void meEncanta(Usuario user) {
        meEncanta.add(user);
    }

    public void noMeEncanta(Usuario user) {
        //Contenido a reemplazar...
        System.out.println("Deberia ocurrir algo que todavia no...");
    }

    public String obtenerNombre() {
        return nombre;
    }

    public String obtenerContenido() {
        return contenido;
    }
}

