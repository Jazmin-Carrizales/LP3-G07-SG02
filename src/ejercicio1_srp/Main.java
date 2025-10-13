package ejercicio1_srp;

public class Main {
    public static void main(String[] args) {
        Empleado emp = new Empleado("Jazmín", 12000.0);
        CalculadoraPago calc = new CalculadoraPago();
        double pagoMensual = calc.calcularPagoMensual(emp);
        System.out.println("Empleado: " + emp.getNombre());
        System.out.println("Pago mensual: S/ " + pagoMensual);
    }
}
