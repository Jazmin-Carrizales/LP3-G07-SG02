import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[10];
        
        System.out.println("Por favor, ingrese 10 números, cada uno mayor que el anterior.");
        for (int i = 0; i < numeros.length; i++) {
            boolean entradaValida = false;
            while (!entradaValida) {
                System.out.print("Ingrese el número " + (i + 1) + ": ");
                int numeroActual = scanner.nextInt();
                if (i > 0 && numeroActual <= numeros[i - 1]) {
                    System.out.println("Error: El número debe ser mayor que el anterior (" + numeros[i - 1] + "). Intente de nuevo.");
                } else {
                    numeros[i] = numeroActual;
                    entradaValida = true;
                }
            }
        }
        
        System.out.println("\nNúmeros guardados en el arreglo:");
        for (int numero : numeros) {
            System.out.print(numero + " ");
        }

        scanner.close();
    }
}

