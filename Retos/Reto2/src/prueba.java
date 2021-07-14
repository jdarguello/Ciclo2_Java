import java.util.Arrays;

public class prueba {
    public static void main(String[] args) {
        FinanzasP fin = new FinanzasP();
        //Capital
        fin.Efectivo(550_000);
        fin.EfElectronico(3_800_000);
        //Gastos
        fin.registrarFijos("Servicios", 400_000);
        fin.registrarFijos("Alimentacion", 300_000);
        fin.gasto("Zapatos", 500_000);

        System.out.println(fin.utilidades());
        System.out.println(fin.movimientosF());
        System.out.println(Arrays.toString(fin.ConsultarCartera()));
    }
}
