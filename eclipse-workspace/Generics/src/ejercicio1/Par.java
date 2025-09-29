package ejercicio1;


public class Par<F, S> {
    private F primero;
    private S segundo;

    public Par(F primero, S segundo) {
        this.primero = primero;
        this.segundo = segundo;
    }

    public F getPrimero() {
        return primero;
    }

    public void setPrimero(F primero) {
        this.primero = primero;
    }

    public S getSegundo() {
        return segundo;
    }

    public void setSegundo(S segundo) {
        this.segundo = segundo;
    }

    @Override
    public String toString() {
        return "(Primero: " + primero + ", Segundo: " + segundo + ")";
    }

    // Para probar el funcionamiento
    public static void main(String[] args) {
        Par<String, Integer> par1 = new Par<>("Edad", 19);
        System.out.println(par1);

        Par<Double, String> par2 = new Par<>(15.6, "Peso");
        System.out.println(par2);

        par1.setSegundo(20);
        System.out.println("Después de modificar: " + par1);
    }
}
