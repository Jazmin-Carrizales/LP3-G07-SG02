package ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeerEntrada {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public char getChar() throws IOException {
        String line = br.readLine();
        if (line == null || line.length() == 0) {
            return '\n';
        }
        return line.charAt(0);
    }
}
