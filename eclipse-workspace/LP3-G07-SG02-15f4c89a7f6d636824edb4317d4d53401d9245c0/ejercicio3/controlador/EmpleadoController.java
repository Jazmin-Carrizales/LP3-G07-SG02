package ejercicio3.controlador;

import ejercicio3.dao.EmpleadoDAO;
import ejercicio3.modelo.Empleado;
import ejercicio3.vista.EmpleadoView;

import java.util.List;
import java.util.Map;

public class EmpleadoController {
    private final EmpleadoDAO dao;
    private final EmpleadoView vista;

    public EmpleadoController(EmpleadoDAO dao, EmpleadoView vista) {
        this.dao = dao;
        this.vista = vista;
    }

    public void iniciar() {
        int op;
        do {
            op = vista.menu();
            switch (op) {
                case 1 -> listar();
                case 2 -> agregar();
                case 3 -> buscar();
                case 4 -> actualizarSueldo();
                case 5 -> eliminar();
                case 6 -> estadisticas();
                case 0 -> vista.mostrarMensaje("Saliendo...");
                default -> vista.mostrarMensaje("Opción inválida.");
            }
        } while (op != 0);
    }

    private void listar() {
        List<Empleado> lista = dao.listar();
        vista.mostrarEmpleados(lista);
    }

    private void agregar() {
        Empleado e = vista.leerNuevoEmpleado();
        dao.agregar(e);
        vista.mostrarMensaje("Empleado agregado correctamente.");
    }

    private void buscar() {
        String dni = vista.leerDni();
        Empleado e = dao.buscar(dni);
        if (e != null) vista.mostrarMensaje(e.toString());
        else vista.mostrarMensaje("No se encontró el empleado.");
    }

    private void actualizarSueldo() {
        String dni = vista.leerDni();
        double s = vista.leerSueldo();
        if (dao.actualizarSueldo(dni, s))
            vista.mostrarMensaje("Sueldo actualizado.");
        else
            vista.mostrarMensaje("Empleado no encontrado.");
    }

    private void eliminar() {
        String dni = vista.leerDni();
        if (dao.eliminar(dni))
            vista.mostrarMensaje("Empleado eliminado.");
        else
            vista.mostrarMensaje("Empleado no encontrado.");
    }

    private void estadisticas() {
        Map<String, Double> stats = dao.estadisticas();
        vista.mostrarEstadisticas(stats);
    }
}
