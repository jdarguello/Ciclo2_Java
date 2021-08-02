public class Main {

    public static void main(String[] args) {
        //---Crear personas---
        Persona john = new Persona("John", (byte)20, "320910", "john@gmail.com");

        Persona[] socios = {john};
        //---Crear empresa---
        Empresa Bancolombia = new Empresa("Bancolombia", 200_000_000_000.0, socios);

        //Crear sucursales
        Sucursal banc45 = new Sucursal(50_000_000_000.0);

        System.out.println(Bancolombia.getCapital());
        //---Crear empleados---
        //Empleado operador1 = new Empleado();

        //NO debemos crear empleos aquí
    }
}
