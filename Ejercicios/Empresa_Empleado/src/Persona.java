public class Persona {
    protected String nombre;
    protected byte edad;
    protected String numCelular;
    protected String email;

    public Persona (String nombre, byte edad, String numCelular, String email) {
        this.nombre = nombre;
        this.edad = edad;
        this.numCelular = numCelular;
        this.email = email;

        System.out.println("Se creó una persona");
    }

    public void actualizarCelular (String nuevoNum) {
        this.numCelular = nuevoNum;
    }
}