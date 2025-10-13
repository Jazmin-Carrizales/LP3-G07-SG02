package ejercicio4.app;

import ejercicio4.controlador.ControladorContador;
import ejercicio4.modelo.ContadorPalabras;
import ejercicio4.vista.VistaContador;

public class MainContador {
    public static void main(String[] args) {
        ContadorPalabras modelo = new ContadorPalabras();
        VistaContador vista = new VistaContador();
        ControladorContador controlador = new ControladorContador(modelo, vista);
        controlador.iniciar();
    }
}
