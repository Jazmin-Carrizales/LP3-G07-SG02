import java.util.Scanner;

public class Estacionamiento {
    public static double calcularPago(int horas) {
        if (horas <= 1) {
            return 3.0;
        } else {
            double pago = 3.0 + (horas - 1) * 0.5;
            return Math.min(pago, 12.0); // máximo 12
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el número de horas: ");
        int horas = sc.nextInt();

        System.out.println("El pago es: S/" + calcularPago(horas));
    }
}
