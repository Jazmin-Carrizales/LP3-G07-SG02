package ejercicio3.app;

import ejercicio3.controlador.EmpleadoController;
import ejercicio3.dao.EmpleadoDAO;
import ejercicio3.vista.EmpleadoView;

public class MainEmpleados {
    public static void main(String[] args) {
        EmpleadoDAO dao = new EmpleadoDAO();
        EmpleadoView vista = new EmpleadoView();
        EmpleadoController controlador = new EmpleadoController(dao, vista);
        controlador.iniciar();
    }
}
