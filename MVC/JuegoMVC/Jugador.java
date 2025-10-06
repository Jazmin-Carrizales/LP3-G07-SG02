import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private String nombre;
    private int salud;
    private int nivel;
    private List<ObjetoJuego> inventario = new ArrayList<>();
    private ObjetoJuego armaEquipada = null;

    public Jugador(String nombre, int salud, int nivel) {
        this.nombre = nombre;
        this.salud = salud;
        this.nivel = nivel;
    }

    public String getNombre() { return nombre; }
    public int getSalud() { return salud; }
    public boolean estaVivo() { return salud > 0; }

    public void agregarObjeto(ObjetoJuego obj) { inventario.add(obj); }
    public List<ObjetoJuego> getInventario() { return inventario; }

    public void equiparArma(String nombreArma) {
        for (ObjetoJuego o : inventario) {
            if (o.getTipo().equalsIgnoreCase("Arma") && o.getNombre().equalsIgnoreCase(nombreArma)) {
                armaEquipada = o;
                System.out.println("Arma equipada: " + o.getNombre());
                return;
            }
        }
        System.out.println("No se encontró esa arma.");
    }

    public void usarObjeto(String nombreObj) {
        for (ObjetoJuego o : inventario) {
            if (o.getNombre().equalsIgnoreCase(nombreObj) && o.getCantidad() > 0) {
                if (o.getTipo().equalsIgnoreCase("Poción")) {
                    salud += o.getPoder();
                    o.setCantidad(o.getCantidad() - 1);
                    System.out.println(nombre + " usó " + o.getNombre() + " y recuperó " + o.getPoder() + " de salud. Salud actual: " + salud);
                    return;
                }
            }
        }
        System.out.println("No tienes ese objeto o ya no queda.");
    }

    public void atacar(Enemigo e) {
        int dañoBase = 5 + nivel;
        int dañoArma = (armaEquipada != null) ? armaEquipada.getPoder() : 0;
        int dañoTotal = dañoBase + dañoArma;
        System.out.println(nombre + " ataca a " + e.getNombre() + " con " + dañoTotal + " de daño.");
        e.recibirDaño(dañoTotal);
    }

    public void recibirDaño(int daño) {
        salud -= daño;
        System.out.println(nombre + " recibió " + daño + " de daño. Salud: " + salud);
    }
}

