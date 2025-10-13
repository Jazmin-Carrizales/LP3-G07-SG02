package ejercicio1;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class GestorPersonajes {
    private final Path archivo = Paths.get("personajes.txt");
    private final List<Personaje> personajes = new ArrayList<>();

    public GestorPersonajes() {
        cargar();
    }

    // Cargar personajes desde el archivo
    public void cargar() {
        personajes.clear();
        if (!Files.exists(archivo)) return;
        try {
            List<String> lineas = Files.readAllLines(archivo);
            for (String l : lineas) {
                if (l.isBlank()) continue;
                try {
                    personajes.add(Personaje.fromCSV(l));
                } catch (Exception e) {
                    System.err.println("Línea inválida: " + l);
                }
            }
        } catch (IOException e) {
            System.err.println("Error leyendo archivo: " + e.getMessage());
        }
    }

    // Guardar lista de personajes en el archivo
    public void guardar() {
        try {
            List<String> lineas = personajes.stream()
                    .map(Personaje::toCSV)
                    .collect(Collectors.toList());
            Files.write(archivo, lineas, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            System.err.println("Error guardando archivo: " + e.getMessage());
        }
    }

    // Agregar nuevo personaje
    public void agregar(Personaje p) {
        personajes.add(p);
        guardar();
    }

    // Listar todos
    public List<Personaje> listar() {
        return new ArrayList<>(personajes);
    }
}
