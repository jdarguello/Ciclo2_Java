import java.util.HashMap;
import java.util.Scanner;

public class FinanzasP {
    //Propiedades
    HashMap<String, Integer> carteraAhorros = new HashMap<String, Integer>();
    HashMap<String, Integer> gastosFijos = new HashMap<String, Integer>();
    HashMap<String, Integer> gastos = new HashMap<String, Integer>();

    public int utilidades () {
        int utilidad = 0;
        //Calcula el dinero disponible para inversion

        return utilidad;
    }

    public HashMap<String, Integer> movimientosF() {
        //Resumen de movimientos financieros
        HashMap<String, Integer> mov = new HashMap<String, Integer>(){{
            put("Ingresos", 0);
            put("Egresos", 0);
        }};
        //---calculo de ingresos y egresos---

        return mov;
    }

    public int[] ConsultarCartera() {
        int[] dinero = {0,0};   //[Efectivo, electronico]
        //---Tu desarrollo---

        return dinero;
    }

    public void gasto(String nombre, int valor) {
        gastos.put(nombre, valor);
    }

    public void registrarFijos(String nombre, int valor) {
        gastosFijos.put(nombre, valor);
    }

    public void Efectivo(int efectivo) {
        carteraAhorros.put("Efectivo", efectivo);
    }

    public void EfElectronico(int efectivo) {
        carteraAhorros.put("Electronico", efectivo);
    }
}
