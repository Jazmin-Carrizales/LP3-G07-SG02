package ejercicio4.vista;

import ejercicio4.modelo.ContadorPalabras;
import javax.swing.JFileChooser;
import java.util.Map;
import java.util.Scanner;

public class VistaContador {
    private final Scanner sc = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n=== CONTADOR DE PALABRAS ===");
        System.out.println("1. Seleccionar y analizar archivo");
        System.out.println("2. Mostrar resultados");
        System.out.println("0. Salir");
        System.out.print("Opción: ");
        try { return Integer.parseInt(sc.nextLine().trim()); } catch (Exception e) { return -1; }
    }

    public String seleccionarArchivo() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Seleccione el archivo a analizar");
        int result = chooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile().getAbsolutePath();
        }
        return null;
    }

    public void mostrarResultados(ContadorPalabras c) {
        System.out.println("\n===== RESULTADOS =====");
        System.out.println("Total de líneas: " + c.getTotalLineas());
        System.out.println("Total de palabras: " + c.getTotalPalabras());
        System.out.println("Total de caracteres: " + c.getTotalCaracteres());
        System.out.printf("Promedio de palabras por línea: %.2f\n", c.getPromedioPalabrasPorLinea());

        Map<String, Integer> frecuentes = c.getPalabrasFrecuentes();
        if (frecuentes.isEmpty()) {
            System.out.println("No hay palabras frecuentes.");
        } else {
            System.out.println("Palabras más frecuentes:");
            frecuentes.forEach((p, f) -> System.out.println(" - " + p + ": " + f + " veces"));
        }
    }

    public void mostrarMensaje(String msg) {
        System.out.println(msg);
    }
}
