package Publicaciones;

public class Historia extends Pub {
    //---ATRIBUTOS---
    private int longVideo;
    private int calidad;
    private int duracion;
    //---METODOS---

    //---Constructor general---
    public Historia(String nombre, String contenido, int longVideo, int calidad, int duracion) {
        super(nombre, contenido);
        this.longVideo = longVideo;
        this.calidad = calidad;
        this.duracion = duracion;
    }
    //---Constructor base---
    public Historia(String nombre, String contenido) {
        super(nombre, contenido);
    }
}