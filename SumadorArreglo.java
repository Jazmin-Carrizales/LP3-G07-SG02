public class SumadorArreglo {
    public static int sumarArreglo(int[] arr) {
        int suma = 0;
        for (int elemento : arr) {
            suma += elemento;
        }
        return suma;
    }

    public static void main(String[] args) {
        int[] numeros = {10, 20, 30, 40, 50};
        System.out.println("La suma de los elementos es: " + sumarArreglo(numeros));
    }
}
