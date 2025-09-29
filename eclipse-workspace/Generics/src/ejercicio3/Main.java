package ejercicio3;

public class Main {
    // Método genérico imprimirPar
    public static <F, S> void imprimirPar(Par<F, S> par) {
        System.out.println(par);
    }

    public static void main(String[] args) {
        Par<String, Integer> par1 = new Par<>("Edad", 19);
        Par<Double, Boolean> par2 = new Par<>(15.6, true);
        Par<Persona, Integer> par3 = new Par<>(new Persona("Jazmín"), 123);

        imprimirPar(par1);
        imprimirPar(par2);
        imprimirPar(par3);
    }
}
