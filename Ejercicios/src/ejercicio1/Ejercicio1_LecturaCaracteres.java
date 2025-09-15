package ejercicio1;

import java.io.IOException;

public class Ejercicio1_LecturaCaracteres {

    private final LeerEntrada entrada = new LeerEntrada();

    public void procesar() throws IOException, ExcepcionVocal, ExcepcionNumero, ExcepcionBlanco, ExcepcionSalida {
        char c = entrada.getChar();

        if (Character.isWhitespace(c)) {
            throw new ExcepcionBlanco("Se ingresó un espacio en blanco.");
        } else if (Character.isDigit(c)) {
            throw new ExcepcionNumero("Se ingresó un número.");
        } else if ("aeiouAEIOU".indexOf(c) != -1) {
            throw new ExcepcionVocal("Se ingresó una vocal.");
        } else if (c == 'x' || c == 'X') {
            throw new ExcepcionSalida("Se ingresó carácter de salida.");
        } else {
            System.out.println("Se ingresó: " + c);
        }
    }

    public static void main(String[] args) {
        Ejercicio1_LecturaCaracteres app = new Ejercicio1_LecturaCaracteres();

        while (true) {
            try {
                System.out.print("Ingrese un carácter (Enter para enviar): ");
                app.procesar();
            } catch (ExcepcionVocal | ExcepcionNumero | ExcepcionBlanco e) {
                System.out.println(e.getMessage());
            } catch (ExcepcionSalida e) {
                System.out.println(e.getMessage() + " Fin del programa.");
                break;
            } catch (IOException e) {
                System.out.println("Error de entrada: " + e.getMessage());
                break;
            }
        }
    }
}
