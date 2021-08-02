public class Trabajo {
    private String nombre_cargo;
    private int salario;
    private String horario;

    public Trabajo (String cargo, int salary, String horario) {
        this.nombre_cargo = cargo;
        this.salario = salary;
        this.horario = horario;
    }

    public void ajusteSalarial (int salario) {
        this.salario = salario;
    }
}