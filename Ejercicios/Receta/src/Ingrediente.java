import java.util.HashMap;

public class Ingrediente {
    private String nombre;
    private String fechaVencimiento;
    private HashMap<String, Object> presentacion = new HashMap();
    private int costo;

    /**
     * Constructor for objects of class Ingrediente
     */
    public Ingrediente(String name, String fecha, int costo, String sistema_unidades, int cantidad)
    {
        // initialise instance variables
        this.nombre = name;
        this.fechaVencimiento = fecha;
        this.costo = costo;

        //Construcción del mapa
        this.presentacion.put("Cantidad", cantidad);
        this.presentacion.put("Unidades", sistema_unidades);

        System.out.println("Se creó el ingrediente " + nombre);
    }
}
