public class Producto {
    private String nombre;
    private int precioVenta;

    public Producto (String nombre, int precio) {
        this.nombre = nombre;
        this.precioVenta = precio;

        this.descripcion();
    }
    public void ajustarPrecio (int precio) {
        this.precioVenta = precio;
    }
    public void descripcion () {
        //Objetivo: imprimir los atributos del producto
        System.out.println("El producto " + nombre + " tiene un precio de venta de $" + precioVenta);
    }
}