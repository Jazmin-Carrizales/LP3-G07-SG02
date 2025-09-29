import java.util.Scanner;

public class TiempoASegundos {
    public static int convertirASegundos(int horas, int minutos, int segundos) {
        return horas * 3600 + minutos * 60 + segundos;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese horas: ");
        int horas = sc.nextInt();
        System.out.print("Ingrese minutos: ");
        int minutos = sc.nextInt();
        System.out.print("Ingrese segundos: ");
        int segundos = sc.nextInt();

        int total = convertirASegundos(horas, minutos, segundos);
        System.out.println("El tiempo total en segundos es: " + total);
    }
}
