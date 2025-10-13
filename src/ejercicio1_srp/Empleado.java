package ejercicio1_srp;


public class Empleado {
    private String nombre;
    private double salarioAnual;

    public Empleado(String nombre, double salarioAnual) {
        this.nombre = nombre;
        this.salarioAnual = salarioAnual;
    }

    public String getNombre() { return nombre; }
    public double getSalarioAnual() { return salarioAnual; }
}

