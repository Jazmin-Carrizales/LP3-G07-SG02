public class Articulo {
    private int id;
    private String nombre;
    private String tipo;
    private int cantidad;
    private double precio;

    public Articulo(int id, String nombre, String tipo, int cantidad, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public int getCantidad() { return cantidad; }
    public double getPrecio() { return precio; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public void setPrecio(double precio) { this.precio = precio; }

    @Override
    public String toString() {
        return id + " | " + nombre + " | Tipo: " + tipo + " | Cantidad: " + cantidad + " | Precio: $" + String.format("%.2f", precio);
    }
}
