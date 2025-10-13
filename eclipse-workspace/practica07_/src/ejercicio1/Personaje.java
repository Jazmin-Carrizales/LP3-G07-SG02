package ejercicio1;

public class Personaje {
    private String nombre;
    private int vida;
    private int ataque;
    private int defensa;
    private int alcance;
    private int nivel;

    public Personaje(String nombre, int vida, int ataque, int defensa, int alcance, int nivel) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.alcance = alcance;
        this.nivel = nivel;
    }

    public String getNombre() { return nombre; }
    public int getVida() { return vida; }
    public int getAtaque() { return ataque; }
    public int getDefensa() { return defensa; }
    public int getAlcance() { return alcance; }
    public int getNivel() { return nivel; }

    public void setVida(int vida) { this.vida = vida; }
    public void setAtaque(int ataque) { this.ataque = ataque; }
    public void setDefensa(int defensa) { this.defensa = defensa; }
    public void setAlcance(int alcance) { this.alcance = alcance; }
    public void setNivel(int nivel) { this.nivel = nivel; }

    @Override
    public String toString() {
        return String.format("%-10s Vida:%3d  Atk:%3d  Def:%3d  Alc:%3d  Niv:%2d",
                nombre, vida, ataque, defensa, alcance, nivel);
    }

    // Convierte el objeto en formato CSV (para guardar en archivo)
    public String toCSV() {
        return nombre + "," + vida + "," + ataque + "," + defensa + "," + alcance + "," + nivel;
    }

    public static Personaje fromCSV(String linea) {
        String[] p = linea.split(",");
        if (p.length != 6) throw new IllegalArgumentException("Línea inválida: " + linea);
        return new Personaje(p[0],
                Integer.parseInt(p[1]),
                Integer.parseInt(p[2]),
                Integer.parseInt(p[3]),
                Integer.parseInt(p[4]),
                Integer.parseInt(p[5]));
    }
}
