public class PlatoComida {
    private String nombre;
    private Object[][] ingredientes = {};
    private int precioVenta;
    private int costoVenta;     //Se debe calcular

    /**
     * Constructor for objects of class PlatoComida
     */
    public PlatoComida(String nombre, int precioVenta, Object[][] ingredientes)
    {
        // Inicializar las variables
        this.nombre = nombre;
        this.precioVenta = precioVenta;
        this.ingredientes = ingredientes;

        System.out.println("Se creó el plato " + nombre);

    }

    public void ajustarPrecio(int nuevo_precio) {
        precioVenta = nuevo_precio;
    }

    public int calculoCosto () {


        return 0;
    }
}
