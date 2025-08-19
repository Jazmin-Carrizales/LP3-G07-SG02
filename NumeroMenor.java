import java.util.Scanner;

public class NumeroMenor {
    public static double menor(double a, double b, double c) {
        return Math.min(a, Math.min(b, c));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el primer número: ");
        double n1 = sc.nextDouble();
        System.out.print("Ingrese el segundo número: ");
        double n2 = sc.nextDouble();
        System.out.print("Ingrese el tercer número: ");
        double n3 = sc.nextDouble();

        System.out.println("El menor número es: " + menor(n1, n2, n3));
    }
}
