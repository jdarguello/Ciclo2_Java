import java.util.HashMap;

public class FinanzasP {
    //Propiedades
    HashMap<String, Integer> carteraAhorros = new HashMap<String, Integer>();   //Contiene: Efectivo, Electronico
    HashMap<String, Integer> gastosFijos = new HashMap<String, Integer>();      //Por ejemplo: servicios, alimentacion,...
    HashMap<String, Integer> gastos = new HashMap<String, Integer>();           //Por ejemplo: ropa, salidas, etc.

    public int utilidades () {  //6. Consulta de capital de inversion
        int utilidad = 0;
        //Calcula el dinero disponible para inversion

        return utilidad;
    }

    public HashMap<String, Integer> movimientosF() {    //7. Movimientos financieros
        //Resumen de movimientos financieros
        HashMap<String, Integer> mov = new HashMap<String, Integer>(){{
            put("Ingresos", 0);
            put("Egresos", 0);
        }};
        //---calculo de ingresos y egresos---

        return mov;
    }

    public int[] ConsultarCartera() {   //5. Consulta de liquidez
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

