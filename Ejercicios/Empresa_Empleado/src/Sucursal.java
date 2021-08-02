import java.util.*;

public class Sucursal {
    private double capital;
    private HashMap<Trabajo, Empleado[]> empleos;

    public Sucursal (double capital) {
        super();                    //es opcional
        this.capital = capital;     //Capital de la sucursal
        Empresa.capital -= capital;   //Capital de la empresa
    }
}