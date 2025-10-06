import java.util.List;
import java.util.Scanner;

public class CombateVista {
    private Scanner sc = new Scanner(System.in);

    public void mostrarEstado(Jugador j, List<Enemigo> enemigos) {
        System.out.println("\n=== ESTADO DEL COMBATE ===");
        System.out.println("Jugador: " + j.getNombre() + " | Salud: " + j.getSalud());
        System.out.println("Inventario:");
        j.getInventario().forEach(o -> System.out.println(" - " + o));
        System.out.println("\nEnemigos:");
        for (int i = 0; i < enemigos.size(); i++) {
            System.out.println(i + ". " + enemigos.get(i));
        }
    }

    public int leerEntero(String msg) {
        System.out.print(msg);
        try { return Integer.parseInt(sc.nextLine()); }
        catch (Exception e) { return -1; }
    }

    public String leerTexto(String msg) {
        System.out.print(msg);
        return sc.nextLine();
    }

    public void mostrarMensaje(String msg) {
        System.out.println(msg);
    }
}

