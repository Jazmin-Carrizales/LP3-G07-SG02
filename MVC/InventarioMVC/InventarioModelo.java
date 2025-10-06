import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InventarioModelo {
    private List<Articulo> articulos = new ArrayList<>();
    private int siguienteId = 1;

    public Articulo agregarArticulo(String nombre, String tipo, int cantidad, double precio) {
        Articulo art = new Articulo(siguienteId++, nombre, tipo, cantidad, precio);
        articulos.add(art);
        return art;
    }

    public boolean actualizarArticulo(int id, String nombre, String tipo, int cantidad, double precio) {
        Articulo art = buscarPorId(id);
        if (art == null) return false;
        art.setNombre(nombre);
        art.setTipo(tipo);
        art.setCantidad(cantidad);
        art.setPrecio(precio);
        return true;
    }

    public boolean eliminarArticulo(int id) {
        return articulos.removeIf(a -> a.getId() == id);
    }

    public Articulo buscarPorId(int id) {
        for (Articulo a : articulos) {
            if (a.getId() == id) return a;
        }
        return null;
    }

    public List<Articulo> buscar(String termino) {
        String t = termino.toLowerCase();
        return articulos.stream()
                .filter(a -> a.getNombre().toLowerCase().contains(t) || a.getTipo().toLowerCase().contains(t))
                .collect(Collectors.toList());
    }

    public List<Articulo> obtenerTodos() {
        return articulos;
    }

    public long contarPorTipo(String tipo) {
        return articulos.stream().filter(a -> a.getTipo().equalsIgnoreCase(tipo)).count();
    }
}
