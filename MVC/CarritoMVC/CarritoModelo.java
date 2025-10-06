import java.util.ArrayList;
import java.util.List;

public class CarritoModelo {
    private List<ItemCarrito> carrito = new ArrayList<>();
    private List<Pedido> historial = new ArrayList<>();
    private double descuento = 0;
    private boolean envioGratis = false;

    public void agregarAlCarrito(Producto p, int cantidad) {
        for (ItemCarrito item : carrito) {
            if (item.getProducto().getId() == p.getId()) {
                item.setCantidad(item.getCantidad() + cantidad);
                return;
            }
        }
        carrito.add(new ItemCarrito(p, cantidad));
    }

    public void eliminarDelCarrito(int idProducto) {
        carrito.removeIf(i -> i.getProducto().getId() == idProducto);
    }

    public List<ItemCarrito> getCarrito() { return carrito; }

    public double calcularSubtotal() {
        double s = 0;
        for (ItemCarrito i : carrito) s += i.getSubtotal();
        return s;
    }

    public double calcularEnvio() {
        if (envioGratis) return 0.0;
        if (calcularSubtotal() >= 100) return 0.0;
        return 10.0;
    }

    public void aplicarCodigo(String codigo) {
        switch (codigo.toUpperCase()) {
            case "DESC10":
                descuento = 10;
                break;
            case "DESC20":
                descuento = 20;
                break;
            case "ENVIOGRATIS":
                envioGratis = true;
                break;
            default:
                descuento = 0;
        }
    }

    public double getDescuento() { return descuento; }

    public void comprar(CatalogoModelo catalogo) {
        double subtotal = calcularSubtotal();
        double envio = calcularEnvio();
        Pedido pedido = new Pedido(new ArrayList<>(carrito), subtotal, descuento, envio);
        historial.add(pedido);
        for (ItemCarrito i : carrito) {
            Producto p = catalogo.buscarPorId(i.getProducto().getId());
            if (p != null) p.setStock(p.getStock() - i.getCantidad());
        }
        carrito.clear();
        descuento = 0;
        envioGratis = false;
    }

    public List<Pedido> getHistorial() { return historial; }
}
