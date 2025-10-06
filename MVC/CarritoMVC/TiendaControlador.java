public class TiendaControlador {
    private CatalogoModelo catalogo;
    private CarritoModelo carrito;
    private TiendaVista vista;

    public TiendaControlador(CatalogoModelo c, CarritoModelo ca, TiendaVista v) {
        catalogo = c;
        carrito = ca;
        vista = v;
    }

    public void iniciar() {
        boolean activo = true;
        while (activo) {
            vista.mostrarMenu();
            int op = vista.leerEntero();
            switch (op) {
                case 1:
                    vista.mostrarProductos(catalogo.getProductos());
                    break;
                case 2:
                    int id = Integer.parseInt(vista.leerTexto("ID del producto: "));
                    int cant = Integer.parseInt(vista.leerTexto("Cantidad: "));
                    Producto p = catalogo.buscarPorId(id);
                    if (p == null) vista.mensaje("Producto no encontrado.");
                    else carrito.agregarAlCarrito(p, cant);
                    break;
                case 3:
                    vista.mostrarCarrito(carrito.getCarrito());
                    break;
                case 4:
                    int idElim = Integer.parseInt(vista.leerTexto("ID del producto a eliminar: "));
                    carrito.eliminarDelCarrito(idElim);
                    break;
                case 5:
                    String cod = vista.leerTexto("Código (DESC10, DESC20, ENVIOGRATIS): ");
                    carrito.aplicarCodigo(cod);
                    vista.mensaje("Código aplicado.");
                    break;
                case 6:
                    double subtotal = carrito.calcularSubtotal();
                    double desc = carrito.getDescuento();
                    double envio = carrito.calcularEnvio();
                    double total = subtotal - subtotal * (desc / 100.0) + envio;
                    vista.mensaje("Subtotal $" + subtotal + " | Desc " + desc + "% | Envío $" + envio + " | Total $" + total);
                    break;
                case 7:
                    carrito.comprar(catalogo);
                    vista.mensaje("Compra realizada.");
                    break;
                case 8:
                    vista.mostrarPedidos(carrito.getHistorial());
                    break;
                case 9:
                    activo = false;
                    break;
                default:
                    vista.mensaje("Opción inválida.");
            }
        }
    }
}
