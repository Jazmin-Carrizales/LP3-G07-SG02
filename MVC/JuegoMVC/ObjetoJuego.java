public class ObjetoJuego {
    private String nombre;
    private String tipo;
    private int poder;
    private int cantidad;

    public ObjetoJuego(String nombre, String tipo, int poder, int cantidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.poder = poder;
        this.cantidad = cantidad;
    }

    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public int getPoder() { return poder; }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    @Override
    public String toString() {
        return nombre + " (" + tipo + ") Poder: " + poder + " x" + cantidad;
    }
}
