import java.util.List;
import java.util.Scanner;

public class InventarioVista {
    private Scanner sc = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("\n=== SISTEMA DE INVENTARIO ===");
        System.out.println("1. Agregar artículo");
        System.out.println("2. Actualizar artículo");
        System.out.println("3. Eliminar artículo");
        System.out.println("4. Mostrar todos los artículos");
        System.out.println("5. Buscar artículo");
        System.out.println("6. Contar artículos por tipo");
        System.out.println("7. Salir");
        System.out.print("Opción: ");
    }

    public String leerTexto(String msg) {
        System.out.print(msg);
        return sc.nextLine();
    }

    public int leerEntero(String msg) {
        System.out.print(msg);
        return Integer.parseInt(sc.nextLine());
    }

    public double leerDecimal(String msg) {
        System.out.print(msg);
        return Double.parseDouble(sc.nextLine());
    }

    public void mostrarMensaje(String msg) {
        System.out.println(msg);
    }

    public void mostrarArticulos(List<Articulo> articulos) {
        System.out.println("\n--- LISTA DE ARTÍCULOS ---");
        if (articulos.isEmpty()) System.out.println("No hay artículos registrados.");
        else articulos.forEach(System.out::println);
    }
}
