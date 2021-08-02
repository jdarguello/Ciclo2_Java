public class Empleado extends Persona {
    public Trabajo empleo;
    public int ID;
    public String emailCorp;

    public Empleado (Trabajo empleo, int ID, String emailCorp, String nombre, byte edad, String numCelular, String email) {
        super(nombre, edad, numCelular, email);
        this.empleo = empleo;
        this.ID = ID;
        this.emailCorp = emailCorp;
    }

    public void actualizarEmpleo (Trabajo nuevo) {
        this.empleo = nuevo;
    }
}
