public class Gorila extends Animal {
    public Gorila (double peso, double altura) {
        this.peso = peso;
        this.altura = altura;
    }
    public double getPesoAlims() {
        int suma = 0;
        for (Alimento alim: alimsIngeridos) {
            suma += alim.getGramos();
        }
        return suma;
    }
    public double getIMC() {
        return (peso+(getPesoAlims()/1000))/(altura*altura);
    }
}