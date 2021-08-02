import java.util.ArrayList;

public class Empresa {
    //---ATRIBUTOS---
    //Se deben inicializar una sola vez
    protected static String nombre;
    protected static double capital;
    protected static Persona[] socios = {};
    protected static ArrayList<Producto> productos = new ArrayList();
    protected static Empleado[] empleados = {};

    //---MÉTODOS---
    public double getCapital() {
        return this.capital;
    }
    //Constructores -> polimorfismo estático

    public Empresa () {
        //Se va a ejecutar cuando se cree una sucursal nueva

        //No es necesario instanciar en la clase hija el constructor de la clase padre
    }

    public Empresa (String nombre, double capital, Persona[] socios) {
        //Objetivo: inicializar los atributos LA PRIMERA VEZ que se cree una sucursal
        this.nombre = nombre;
        this.capital = capital;
        this.socios = socios;
    }

    public void inyeccionCapital(int dinero) {
        capital += dinero;
    }

    public void pagoDividendos(int dinero) {
        capital -= dinero;
    }

    public void enviarEmailEmpleados(String titulo, String contenido) {
        for (Empleado trabajador: empleados) {
            //Se crea un email personalizado para cada empleado
            System.out.println(trabajador.emailCorp + "\n" + titulo + "\n" + contenido);
        }
    }
}