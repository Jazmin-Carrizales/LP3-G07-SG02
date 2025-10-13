import java.util.Random;

public class Enemigo {
    private String nombre;
    private int salud;
    private int nivel;
    private int dañoMin;
    private int dañoMax;
    private Random aleatorio = new Random();

    public Enemigo(String nombre, int salud, int nivel, int dañoMin, int dañoMax) {
        this.nombre = nombre;
        this.salud = salud;
        this.nivel = nivel;
        this.dañoMin = dañoMin;
        this.dañoMax = dañoMax;
    }

    public String getNombre() { return nombre; }
    public int getSalud() { return salud; }
    public boolean estaVivo() { return salud > 0; }

    public void atacar(Jugador j) {
        int daño = aleatorio.nextInt(dañoMax - dañoMin + 1) + dañoMin + nivel;
        System.out.println(nombre + " ataca a " + j.getNombre() + " causando " + daño + " de daño.");
        j.recibirDaño(daño);
    }

    public void recibirDaño(int daño) {
        salud -= daño;
        System.out.println(nombre + " recibió " + daño + " de daño. Salud: " + salud);
    }

    @Override
    public String toString() {
        return nombre + " (Salud: " + salud + ", Nivel: " + nivel + ")";
    }
}


