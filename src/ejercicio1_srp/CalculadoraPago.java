package ejercicio1_srp;

public class CalculadoraPago {
    // Ejemplo simple: pago mensual = salario anual / 12
    public double calcularPagoMensual(Empleado e) {
        return e.getSalarioAnual() / 12.0;
    }
}

