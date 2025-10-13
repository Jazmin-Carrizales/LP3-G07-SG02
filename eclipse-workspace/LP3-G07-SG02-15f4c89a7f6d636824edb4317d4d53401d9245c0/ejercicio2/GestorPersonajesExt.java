package ejercicio2;

import ejercicio1.Personaje;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class GestorPersonajesExt {
    private final Path archivo = Paths.get("personajes.txt");
    private final List<Personaje> lista = new ArrayList<>();
    private final Random random = new Random();

    public GestorPersonajesExt() {
        cargar();
        cargarAleatorios(3); // añade algunos aleatorios al iniciar
    }

    // === 1. Cargar desde personajes.txt ===
    public final void cargar() {
        lista.clear();
        if (!Files.exists(archivo)) return;
        try {
            for (String l : Files.readAllLines(archivo)) {
                if (l.isBlank()) continue;
                try { lista.add(Personaje.fromCSV(l)); }
                catch (Exception e) { System.err.println("Línea inválida: " + l); }
            }
        } catch (IOException e) {
            System.err.println("Error leyendo archivo: " + e.getMessage());
        }
    }

    // === 2. Guardar en archivo ===
    public void guardar() {
        try {
            Files.write(archivo,
                lista.stream().map(Personaje::toCSV).collect(Collectors.toList()),
                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            System.err.println("Error guardando archivo: " + e.getMessage());
        }
    }

    // === 3. Cargar personajes aleatorios ===
    public void cargarAleatorios(int n) {
        String[] nombres = {"Ares","Loki","Tara","Nilo","Fay","Rex","Cira","Gus","Vian","Eko"};
        for (int i=0; i<n; i++) {
            String nombre = nombres[random.nextInt(nombres.length)] + random.nextInt(100);
            Personaje p = new Personaje(
                    nombre,
                    80 + random.nextInt(220),  // vida 80–300
                    50 + random.nextInt(100),  // ataque 50–150
                    30 + random.nextInt(90),   // defensa 30–120
                    80 + random.nextInt(200),  // alcance 80–280
                    1 + random.nextInt(6)      // nivel 1–6
            );
            lista.add(p);
        }
        guardar();
    }

    // === 4. Importar personajes desde archivo externo ===
    public void importarDesdeArchivo(String ruta) {
        Path externo = Paths.get(ruta);
        if (!Files.exists(externo)) {
            System.out.println("El archivo " + ruta + " no existe.");
            return;
        }
        try {
            for (String l : Files.readAllLines(externo)) {
                if (l.isBlank()) continue;
                try { lista.add(Personaje.fromCSV(l)); }
                catch (Exception e) { System.err.println("Línea inválida en archivo externo: " + l); }
            }
            guardar();
            System.out.println("Personajes importados correctamente.");
        } catch (IOException e) {
            System.err.println("Error al importar: " + e.getMessage());
        }
    }

    // === 5. Listar personajes ===
    public List<Personaje> listar() { return new ArrayList<>(lista); }

    // === 6. Buscar por nombre ===
    public Personaje buscar(String nombre) {
        return lista.stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }

    // === 7. Eliminar ===
    public boolean eliminar(String nombre) {
        Personaje p = buscar(nombre);
        if (p == null) return false;
        lista.remove(p);
        guardar();
        return true;
    }

    // === 8. Ordenar / filtrar por atributo ===
    public List<Personaje> ordenarPor(String atributo, boolean asc) {
        Comparator<Personaje> comp;
        switch (atributo.toLowerCase()) {
            case "vida": comp = Comparator.comparingInt(Personaje::getVida); break;
            case "ataque": comp = Comparator.comparingInt(Personaje::getAtaque); break;
            case "defensa": comp = Comparator.comparingInt(Personaje::getDefensa); break;
            case "alcance": comp = Comparator.comparingInt(Personaje::getAlcance); break;
            case "nivel": comp = Comparator.comparingInt(Personaje::getNivel); break;
            default: comp = Comparator.comparing(Personaje::getNombre); break;
        }
        if (!asc) comp = comp.reversed();
        return lista.stream().sorted(comp).collect(Collectors.toList());
    }

    // === 9. Actualizar un atributo individual ===
    public boolean actualizarAtributo(String nombre, String atributo, int nuevoValor) {
        Personaje p = buscar(nombre);
        if (p == null) return false;
        switch (atributo.toLowerCase()) {
            case "vida": p.setVida(nuevoValor); break;
            case "ataque": p.setAtaque(nuevoValor); break;
            case "defensa": p.setDefensa(nuevoValor); break;
            case "alcance": p.setAlcance(nuevoValor); break;
            case "nivel": p.setNivel(nuevoValor); break;
            default: return false;
        }
        mejorarAtributosPorNivel(p); // recalcula atributos si sube nivel
        guardar();
        return true;
    }

    // === 10. Mejorar atributos cuando sube nivel ===
    private void mejorarAtributosPorNivel(Personaje p) {
        // regla simple: +5 % por cada nivel por encima de 1
        double factor = 1.0 + (p.getNivel() - 1) * 0.05;
        p.setVida((int)(p.getVida() * factor));
        p.setAtaque((int)(p.getAtaque() * factor));
        p.setDefensa((int)(p.getDefensa() * factor));
        p.setAlcance((int)(p.getAlcance() * factor));
    }

    // === 11. Estadísticas promedios ===
    public Map<String, Double> estadisticasPromedio() {
        Map<String, Double> stats = new LinkedHashMap<>();
        if (lista.isEmpty()) return stats;
        stats.put("TotalPersonajes", (double) lista.size());
        stats.put("PromedioVida", lista.stream().mapToInt(Personaje::getVida).average().orElse(0));
        stats.put("PromedioAtaque", lista.stream().mapToInt(Personaje::getAtaque).average().orElse(0));
        stats.put("PromedioDefensa", lista.stream().mapToInt(Personaje::getDefensa).average().orElse(0));
        stats.put("PromedioAlcance", lista.stream().mapToInt(Personaje::getAlcance).average().orElse(0));
        stats.put("PromedioNivel", lista.stream().mapToInt(Personaje::getNivel).average().orElse(0));
        return stats;
    }
}
