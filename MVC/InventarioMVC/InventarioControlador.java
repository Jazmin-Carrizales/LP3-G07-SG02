public class InventarioControlador {
    private InventarioModelo modelo;
    private InventarioVista vista;

    public InventarioControlador(InventarioModelo modelo, InventarioVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        boolean activo = true;
        while (activo) {
            vista.mostrarMenu();
            int opcion = vista.leerEntero("");
            switch (opcion) {
                case 1:
                    String nombre = vista.leerTexto("Nombre: ");
                    String tipo = vista.leerTexto("Tipo: ");
                    int cantidad = vista.leerEntero("Cantidad: ");
                    double precio = vista.leerDecimal("Precio: ");
                    modelo.agregarArticulo(nombre, tipo, cantidad, precio);
                    vista.mostrarMensaje("Artículo agregado correctamente.");
                    break;
                case 2:
                    int idActualizar = vista.leerEntero("ID del artículo a actualizar: ");
                    Articulo art = modelo.buscarPorId(idActualizar);
                    if (art == null) {
                        vista.mostrarMensaje("No existe un artículo con ese ID.");
                    } else {
                        String nuevoNombre = vista.leerTexto("Nuevo nombre (" + art.getNombre() + "): ");
                        String nuevoTipo = vista.leerTexto("Nuevo tipo (" + art.getTipo() + "): ");
                        int nuevaCantidad = vista.leerEntero("Nueva cantidad (" + art.getCantidad() + "): ");
                        double nuevoPrecio = vista.leerDecimal("Nuevo precio (" + art.getPrecio() + "): ");
                        modelo.actualizarArticulo(idActualizar,
                                nuevoNombre.isEmpty() ? art.getNombre() : nuevoNombre,
                                nuevoTipo.isEmpty() ? art.getTipo() : nuevoTipo,
                                nuevaCantidad, nuevoPrecio);
                        vista.mostrarMensaje("Artículo actualizado correctamente.");
                    }
                    break;
                case 3:
                    int idEliminar = vista.leerEntero("ID del artículo a eliminar: ");
                    if (modelo.eliminarArticulo(idEliminar))
                        vista.mostrarMensaje("Artículo eliminado.");
                    else
                        vista.mostrarMensaje("No existe ese ID.");
                    break;
                case 4:
                    vista.mostrarArticulos(modelo.obtenerTodos());
                    break;
                case 5:
                    String termino = vista.leerTexto("Término de búsqueda: ");
                    vista.mostrarArticulos(modelo.buscar(termino));
                    break;
                case 6:
                    String tipoBuscar = vista.leerTexto("Tipo a contar: ");
                    long total = modelo.contarPorTipo(tipoBuscar);
                    vista.mostrarMensaje("Hay " + total + " artículos del tipo " + tipoBuscar + ".");
                    break;
                case 7:
                    activo = false;
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida.");
            }
        }
    }
}
