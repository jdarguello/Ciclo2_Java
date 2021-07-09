import java.util.HashMap;

public class FinanzasP {
    //Propiedades
    HashMap<String, Integer> carteraAhorros = new HashMap<String, Integer>();
    HashMap<String, Integer> gastosFijos = new HashMap<String, Integer>();

    public void registrarFijos(String nombre, int valor) {

    }

    public void crearEfectivo(int efectivo) {
        carteraAhorros.put("Efectivo", efectivo);
    }

    public void crearEfElectronico(int dinero) {
        carteraAhorros.put("Electronico", dinero);
    }
}
