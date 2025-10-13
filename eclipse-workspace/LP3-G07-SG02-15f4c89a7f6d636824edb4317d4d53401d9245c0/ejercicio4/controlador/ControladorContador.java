package ejercicio4.controlador;

import ejercicio4.modelo.ContadorPalabras;
import ejercicio4.vista.VistaContador;

import java.io.IOException;

public class ControladorContador {
    private final ContadorPalabras modelo;
    private final VistaContador vista;
    private String rutaArchivo;

    public ControladorContador(ContadorPalabras modelo, VistaContador vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        int opcion;
        do {
            opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1 -> seleccionarYAnalizar();
                case 2 -> mostrarResultados();
                case 0 -> vista.mostrarMensaje("Saliendo...");
                default -> vista.mostrarMensaje("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private void seleccionarYAnalizar() {
        boolean analizado = false;
        while (!analizado) {
            rutaArchivo = vista.seleccionarArchivo();
            if (rutaArchivo == null) {
                vista.mostrarMensaje("No se seleccionó ningún archivo.");
                return;
            }
            try {
                modelo.analizarArchivo(rutaArchivo);
                vista.mostrarMensaje("Archivo analizado correctamente.");
                analizado = true;
            } catch (IOException e) {
                vista.mostrarMensaje("Error: " + e.getMessage());
            }
        }
    }

    private void mostrarResultados() {
        if (rutaArchivo == null) {
            vista.mostrarMensaje("Primero debe analizar un archivo.");
        } else {
            vista.mostrarResultados(modelo);
        }
    }
}
