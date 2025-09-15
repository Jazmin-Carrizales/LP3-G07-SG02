package ejercicio4;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class RegistroEstudiantes {
    private List<String> estudiantes = new ArrayList<>();

    public void agregarEstudiante(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío.");
        }
        estudiantes.add(nombre);
    }

    public String buscarEstudiante(String nombre) {
        return estudiantes.stream()
                .filter(e -> e.equalsIgnoreCase(nombre))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Estudiante no encontrado: " + nombre));
    }

    public static void main(String[] args) {
        RegistroEstudiantes registro = new RegistroEstudiantes();

        try {
            registro.agregarEstudiante(" Emilia");
            registro.agregarEstudiante(" Lana");

            registro.agregarEstudiante(""); // lanzará IllegalArgumentException

        } catch (IllegalArgumentException e) {
            System.out.println("Error al agregar estudiante: " + e.getMessage());
        }

        try {
            System.out.println("Encontrado: " + registro.buscarEstudiante(" Emilia"));

            System.out.println("Encontrado: " + registro.buscarEstudiante(" karina"));

        } catch (NoSuchElementException e) {
            System.out.println("Error en búsqueda: " + e.getMessage());
        }
    }
}
