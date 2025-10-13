package ejercicio4.modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class ContadorPalabras {
    private int totalLineas;
    private int totalPalabras;
    private int totalCaracteres;
    private double promedioPalabrasPorLinea;
    private Map<String, Integer> frecuenciaPalabras = new HashMap<>();

    public void analizarArchivo(String rutaArchivo) throws IOException {
        Path archivo = Paths.get(rutaArchivo);
        if (!Files.exists(archivo)) {
            throw new IOException("El archivo no existe: " + rutaArchivo);
        }

        totalLineas = 0;
        totalPalabras = 0;
        totalCaracteres = 0;
        frecuenciaPalabras.clear();

        try (BufferedReader br = Files.newBufferedReader(archivo)) {
            String linea;
            while ((linea = br.readLine()) != null) {
                totalLineas++;
                totalCaracteres += linea.length();

                StringBuilder palabraActual = new StringBuilder();
                for (char c : linea.toCharArray()) {
                    if (Character.isLetterOrDigit(c)) {
                        palabraActual.append(c);
                    } else if (palabraActual.length() > 0) {
                        procesarPalabra(palabraActual.toString());
                        palabraActual.setLength(0);
                    }
                }
                if (palabraActual.length() > 0) {
                    procesarPalabra(palabraActual.toString());
                }
            }
        }

        promedioPalabrasPorLinea = (totalLineas > 0) ? (double) totalPalabras / totalLineas : 0;
    }

    private void procesarPalabra(String palabra) {
        palabra = palabra.toLowerCase();
        totalPalabras++;
        frecuenciaPalabras.put(palabra, frecuenciaPalabras.getOrDefault(palabra, 0) + 1);
    }

    public int getTotalLineas() { return totalLineas; }
    public int getTotalPalabras() { return totalPalabras; }
    public int getTotalCaracteres() { return totalCaracteres; }
    public double getPromedioPalabrasPorLinea() { return promedioPalabrasPorLinea; }

    public Map<String, Integer> getPalabrasFrecuentes() {
        if (frecuenciaPalabras.isEmpty()) return Collections.emptyMap();
        int max = Collections.max(frecuenciaPalabras.values());
        Map<String, Integer> resultado = new LinkedHashMap<>();
        frecuenciaPalabras.entrySet().stream()
            .filter(e -> e.getValue() == max)
            .forEach(e -> resultado.put(e.getKey(), e.getValue()));
        return resultado;
    }
}
