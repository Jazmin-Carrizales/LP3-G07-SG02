import java.util.Random;

public class LanzarDado {

    public static void main(String[] args) {
        int[] frecuencia = new int[6];

        Random random = new Random();

        int numeroLanzamientos = 20000;
        
        for (int i = 0; i < numeroLanzamientos; i++) {
            int resultado = random.nextInt(6);

            frecuencia[resultado]++;
        }
        
        System.out.println("Resultados de " + numeroLanzamientos + " lanzamientos:");
        System.out.println("------------------------------------");
        
        for (int i = 0; i < frecuencia.length; i++) {
            System.out.println("Cara " + (i + 1) + ": " + frecuencia[i] + " veces");
        }
    }
}
