package ejercicio2;

import ejercicio1.Personaje;
import java.util.*;

public class MainEstadisticas {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        GestorPersonajesExt gestor = new GestorPersonajesExt();
        int op;
        do {
            System.out.println("\n=== NUEVAS FUNCIONALIDADES ===");
            System.out.println("1. Listar personajes");
            System.out.println("2. Ordenar / Filtrar por atributo");
            System.out.println("3. Actualizar atributo individual");
            System.out.println("4. Eliminar personaje");
            System.out.println("5. Mostrar estadísticas");
            System.out.println("6. Importar personajes desde archivo externo");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            try { op = Integer.parseInt(sc.nextLine().trim()); } catch (Exception e) { op = -1; }

            switch (op) {
                case 1:
                    gestor.listar().forEach(System.out::println);
                    break;

                case 2:
                    System.out.print("Atributo (vida, ataque, defensa, alcance, nivel): ");
                    String atr = sc.nextLine();
                    System.out.print("Ascendente (s/n): ");
                    boolean asc = sc.nextLine().trim().equalsIgnoreCase("s");
                    gestor.ordenarPor(atr, asc).forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Atributo: ");
                    String atributo = sc.nextLine();
                    System.out.print("Nuevo valor: ");
                    int val;
                    try { val = Integer.parseInt(sc.nextLine()); }
                    catch (Exception e) { System.out.println("Valor inválido."); break; }
                    if (gestor.actualizarAtributo(nombre, atributo, val))
                        System.out.println("Atributo actualizado correctamente.");
                    else
                        System.out.println("Error al actualizar.");
                    break;

                case 4:
                    System.out.print("Nombre a eliminar: ");
                    String n = sc.nextLine();
                    if (gestor.eliminar(n))
                        System.out.println("Personaje eliminado.");
                    else
                        System.out.println("No se encontró el personaje.");
                    break;

                case 5:
                    Map<String, Double> stats = gestor.estadisticasPromedio();
                    if (stats.isEmpty()) System.out.println("No hay personajes.");
                    else stats.forEach((k,v)-> System.out.println(k + ": " + v));
                    break;

                case 6:
                    System.out.print("Nombre del archivo a importar (por defecto importar.txt): ");
                    String ruta = sc.nextLine().trim();
                    if (ruta.isEmpty()) ruta = "importar.txt";
                    gestor.importarDesdeArchivo(ruta);
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
