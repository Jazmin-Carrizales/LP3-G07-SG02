package ejercicio4;

public class Main {
    public static void main(String[] args) {
        Contenedor<String, Integer> cont = new Contenedor<>();

        cont.agregarPar("Edad", 19);
        cont.agregarPar("Peso", 55);
        cont.agregarPar("Altura", 156);

        System.out.println("Todos los pares:");
        cont.mostrarPares();

        System.out.println("Par en posición 1: " + cont.obtenerPar(1));
    }
}
