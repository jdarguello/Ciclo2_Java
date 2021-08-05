package Corporaciones;

import User.Usuario;

public class Empresa extends Usuario {
    //---ATRIBUTOS---
    private double dineroPublicidad;
    private String ofertaEmpleos;

    //---METODOS---
    //Constructor
    public Empresa(String correo, String nombre_user) {
        super(correo, nombre_user);
    }

    public void actualizarOferta(String nueva) {
        this.ofertaEmpleos = nueva;
    }

    public void capitalPublicitario () {
        //Seria similar al de 'actualizarOferta'
    }

    public String ofertaEmpleos() {
        return ofertaEmpleos;
    }
    
}
