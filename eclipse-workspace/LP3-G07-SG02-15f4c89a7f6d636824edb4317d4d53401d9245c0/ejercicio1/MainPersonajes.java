package ejercicio1;

import java.util.Scanner;

public class MainPersonajes {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        GestorPersonajes gestor = new GestorPersonajes();
        int op;
        do {
            System.out.println("\n=== GESTIÓN DE PERSONAJES ===");
            System.out.println("1. Listar personajes");
            System.out.println("2. Agregar personaje");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            try { op = Integer.parseInt(sc.nextLine().trim()); } catch (Exception e) { op = -1; }

            switch (op) {
                case 1:
                    System.out.println("\n--- LISTA ---");
                    for (Personaje p : gestor.listar()) {
                        System.out.println(p);
                    }
                    break;
                case 2:
                    System.out.print("Nombre: ");
                    String n = sc.nextLine().trim();
                    System.out.print("Vida: ");
                    int v = Integer.parseInt(sc.nextLine());
                    System.out.print("Ataque: ");
                    int a = Integer.parseInt(sc.nextLine());
                    System.out.print("Defensa: ");
                    int d = Integer.parseInt(sc.nextLine());
                    System.out.print("Alcance: ");
                    int al = Integer.parseInt(sc.nextLine());
                    System.out.print("Nivel: ");
                    int ni = Integer.parseInt(sc.nextLine());
                    gestor.agregar(new Personaje(n, v, a, d, al, ni));
                    System.out.println("Personaje agregado y guardado.");
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (op != 0);
    }
}
