package Publicaciones;

import User.Usuario;

import java.util.ArrayList;

public class Pub {
    //---Atributos---
    protected String nombre;
    protected String contenido;
    public Usuario[] likes = {};
    public ArrayList<Usuario> meEncanta = new ArrayList();

    //---Metodos---
    public Pub(String nombre, String contenido) {
        this.nombre = nombre;
        this.contenido = contenido;
    }

    public int[] likesMeEncanta () {
        //Retorna el número de likes y corazones (me encanta)
        int[] meGusta = {0,0};
        //---Desarrolla la lógica---

        return meGusta;
    }

    public Pub() {
        System.out.println("Se creo un borrador");
    }

    public void meGusta(Usuario user) {
        //Contenido a reemplazar...
        System.out.println("Deberia ocurrir algo que todavia no...");
    }

    public void noMeGusta(Usuario user) {
        //Contenido a reemplazar...
        System.out.println("Deberia ocurrir algo que todavia no...");
    }

    public void meEncanta(Usuario user) {
        //Contenido a reemplazar...
        System.out.println("Deberia ocurrir algo que todavia no...");
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
