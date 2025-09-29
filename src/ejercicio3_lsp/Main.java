package ejercicio3_lsp;

public class Main {
    public static void main(String[] args) {
        Vehiculo[] vehiculos = { new Coche(), new Bicicleta() };
        for (Vehiculo v : vehiculos) v.acelerar();
    }
}
