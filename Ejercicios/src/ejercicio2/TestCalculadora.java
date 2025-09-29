package ejercicio2;

public class TestCalculadora {
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();

        try {
            System.out.println("Suma: " + calc.sumar(5, 3));
            System.out.println("Resta: " + calc.restar(5, 3));
            System.out.println("Multiplicación: " + calc.multiplicar(5, 3));
            System.out.println("División: " + calc.dividir(10, 2));

            // División por cero (genera la excepción)
            System.out.println("División: " + calc.dividir(10, 0));

        } catch (DivisionPorCeroException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.out.println("Error aritmético: " + e.getMessage());
        }
    }
}
