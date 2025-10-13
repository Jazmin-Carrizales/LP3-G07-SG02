package ejercicio2;

public class PruebaPar {
    public static void main(String[] args) {
        Par<String, Integer> p1 = new Par<>("Edad", 19);
        Par<String, Integer> p2 = new Par<>("Edad", 19);
        Par<String, Integer> p3 = new Par<>("Peso", 19);

        System.out.println("p1: " + p1);
        System.out.println("p2: " + p2);
        System.out.println("p3: " + p3);

        System.out.println("¿p1 es igual a p2? " + p1.esIgual(p2));
        System.out.println("¿p1 es igual a p3? " + p1.esIgual(p3));
    }
}
