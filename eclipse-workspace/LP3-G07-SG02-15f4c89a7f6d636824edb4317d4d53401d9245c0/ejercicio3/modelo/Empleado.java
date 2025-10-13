package ejercicio3.modelo;

public class Empleado {
    private String dni;
    private String nombre;
    private String cargo;
    private double sueldo;

    public Empleado(String dni, String nombre, String cargo, double sueldo) {
        this.dni = dni;
        this.nombre = nombre;
        this.cargo = cargo;
        this.sueldo = sueldo;
    }

    public String getDni() { return dni; }
    public String getNombre() { return nombre; }
    public String getCargo() { return cargo; }
    public double getSueldo() { return sueldo; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCargo(String cargo) { this.cargo = cargo; }
    public void setSueldo(double sueldo) { this.sueldo = sueldo; }

    @Override
    public String toString() {
        return String.format("%-10s %-15s %-10s S/. %.2f", dni, nombre, cargo, sueldo);
    }

    public String toCSV() {
        return dni + "," + nombre + "," + cargo + "," + sueldo;
    }

    public static Empleado fromCSV(String linea) {
        String[] p = linea.split(",");
        if (p.length != 4) throw new IllegalArgumentException("Línea inválida: " + linea);
        return new Empleado(p[0], p[1], p[2], Double.parseDouble(p[3]));
    }
}
