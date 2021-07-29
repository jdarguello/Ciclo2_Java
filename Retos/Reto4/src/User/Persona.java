package User;

public class Persona {
    protected String nombre;
    protected byte edad;
    protected String nivelEducativo;
    protected String correo;

    public Persona(String nombre, byte edad, String correo) {
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
    }

    public Persona (String nombre, byte edad, String correo, String nivelEducativo) {
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
        this.nivelEducativo = nivelEducativo;
    }

    public Persona (String correo) {
        this.correo = correo;
    }

    public void nivelEducativo (String nivel) {
        this.nivelEducativo = nivel;
    }
}
