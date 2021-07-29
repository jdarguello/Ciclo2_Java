public class Main {

    public static void main(String[] args) {
        //Crear ingredientes
        Ingrediente cebolla_larga = new Ingrediente("Cebolla larga", "08/2021", 800, "Lb", 1);

        Ingrediente tomate = new Ingrediente("Tomate", "08/2021", 1000, "Lb", 1);

        Ingrediente lomito_res = new Ingrediente("Lomito", "08/2021", 8000, "Lb", 1);

        Ingrediente tocineta = new Ingrediente("Tocineta", "09/2021", 600, "g", 250);

        //Crear plato - filet mignon
        Object[][] ingredientes = {
                {cebolla_larga, 0.01},
                {tomate, 0.05},
                {lomito_res, 2},
                {tocineta, 250}
        };
        PlatoComida filet_mignon = new PlatoComida("Filet mignon", 45_000, ingredientes);
    }
}
