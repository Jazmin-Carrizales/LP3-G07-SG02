package ejercicio3.dao;

import ejercicio3.modelo.Empleado;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class EmpleadoDAO {
    private final Path archivo = Paths.get("empleados.txt");
    private final List<Empleado> empleados = new ArrayList<>();

    public EmpleadoDAO() {
        cargar();
    }

    public void cargar() {
        empleados.clear();
        if (!Files.exists(archivo)) return;
        try {
            for (String l : Files.readAllLines(archivo)) {
                if (!l.isBlank()) empleados.add(Empleado.fromCSV(l));
            }
        } catch (IOException e) {
            System.err.println("Error leyendo empleados: " + e.getMessage());
        }
    }

    public void guardar() {
        try {
            List<String> out = empleados.stream().map(Empleado::toCSV).collect(Collectors.toList());
            Files.write(archivo, out, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            System.err.println("Error guardando archivo: " + e.getMessage());
        }
    }

    public void agregar(Empleado e) {
        empleados.add(e);
        guardar();
    }

    public List<Empleado> listar() {
        return new ArrayList<>(empleados);
    }

    public Empleado buscar(String dni) {
        return empleados.stream()
                .filter(e -> e.getDni().equalsIgnoreCase(dni))
                .findFirst()
                .orElse(null);
    }

    public boolean eliminar(String dni) {
        Empleado e = buscar(dni);
        if (e == null) return false;
        empleados.remove(e);
        guardar();
        return true;
    }

    public boolean actualizarSueldo(String dni, double nuevoSueldo) {
        Empleado e = buscar(dni);
        if (e == null) return false;
        e.setSueldo(nuevoSueldo);
        guardar();
        return true;
    }

    public Map<String, Double> estadisticas() {
        Map<String, Double> mapa = new LinkedHashMap<>();
        if (empleados.isEmpty()) return mapa;
        mapa.put("Cantidad", (double) empleados.size());
        mapa.put("SueldoPromedio", empleados.stream().mapToDouble(Empleado::getSueldo).average().orElse(0));
        mapa.put("SueldoMáximo", empleados.stream().mapToDouble(Empleado::getSueldo).max().orElse(0));
        mapa.put("SueldoMínimo", empleados.stream().mapToDouble(Empleado::getSueldo).min().orElse(0));
        return mapa;
    }
}
