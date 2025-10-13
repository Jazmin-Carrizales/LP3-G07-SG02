import java.util.List;
import java.util.Scanner;

public class TiendaVista {
    private Scanner sc = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("\n=== MENÚ DE TIENDA ===");
        System.out.println("1. Ver catálogo");
        System.out.println("2. Agregar al carrito");
        System.out.println("3. Ver carrito");
        System.out.println("4. Eliminar del carrito");
        System.out.println("5. Aplicar código de descuento");
        System.out.println("6. Calcular total");
        System.out.println("7. Comprar");
        System.out.println("8. Ver historial");
        System.out.println("9. Salir");
        System.out.print("Opción: ");
    }

    public int leerEntero() { return Integer.parseInt(sc.nextLine()); }
    public String leerTexto(String msg) {
        System.out.print(msg);
        return sc.nextLine();
    }

    public void mostrarProductos(List<Producto> productos) {
        System.out.println("\nCatálogo:");
        for (Producto p : productos) System.out.println(p);
    }

    public void mostrarCarrito(List<ItemCarrito> items) {
        System.out.println("\nCarrito:");
        if (items.isEmpty()) System.out.println("Vacío.");
        else for (ItemCarrito i : items) System.out.println(i);
    }

    public void mostrarPedidos(List<Pedido> pedidos) {
        System.out.println("\nHistorial de compras:");
        if (pedidos.isEmpty()) System.out.println("Aún no has comprado.");
        else for (Pedido p : pedidos) System.out.println(p);
    }

    public void mensaje(String msg) { System.out.println(msg); }
}
