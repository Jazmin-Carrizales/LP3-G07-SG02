import java.time.LocalDateTime;
import java.util.List;

public class Pedido {
    private double subtotal;
    private double descuento;
    private double envio;
    private LocalDateTime fecha;

    public Pedido(List<ItemCarrito> items, double subtotal, double descuento, double envio) {
        this.subtotal = subtotal;
        this.descuento = descuento;
        this.envio = envio;
        this.fecha = LocalDateTime.now();
    }

    public double getTotal() {
        double conDescuento = subtotal - (subtotal * (descuento / 100.0));
        return conDescuento + envio;
    }

    @Override
    public String toString() {
        return "Pedido (" + fecha + "): Subtotal $" + String.format("%.2f", subtotal)
                + ", Descuento " + descuento + "%, Envío $" + envio
                + " → Total $" + String.format("%.2f", getTotal());
    }
}
