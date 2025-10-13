package ejercicio3.vista;

import ejercicio3.modelo.Empleado;
import java.util.*;

public class EmpleadoView {
    private final Scanner sc = new Scanner(System.in);

    public int menu() {
        System.out.println("\n=== GESTIÓN DE EMPLEADOS ===");
        System.out.println("1. Listar empleados");
        System.out.println("2. Agregar empleado");
        System.out.println("3. Buscar por DNI");
        System.out.println("4. Actualizar sueldo");
        System.out.println("5. Eliminar empleado");
        System.out.println("6. Ver estadísticas");
        System.out.println("0. Salir");
        System.out.print("Opción: ");
        try { return Integer.parseInt(sc.nextLine().trim()); } catch (Exception e) { return -1; }
    }

    public Empleado leerNuevoEmpleado() {
        System.out.print("DNI: ");
        String dni = sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Cargo: ");
        String cargo = sc.nextLine();
        System.out.print("Sueldo: ");
        double sueldo = Double.parseDouble(sc.nextLine());
        return new Empleado(dni, nombre, cargo, sueldo);
    }

    public String leerDni() {
        System.out.print("Ingrese DNI: ");
        return sc.nextLine();
    }

    public double leerSueldo() {
        System.out.print("Nuevo sueldo: ");
        return Double.parseDouble(sc.nextLine());
    }

    public void mostrarEmpleados(List<Empleado> lista) {
        if (lista.isEmpty()) System.out.println("No hay empleados.");
        else lista.forEach(System.out::println);
    }

    public void mostrarMensaje(String msg) {
        System.out.println(msg);
    }

    public void mostrarEstadisticas(Map<String, Double> stats) {
        if (stats.isEmpty()) System.out.println("No hay datos disponibles.");
        else stats.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
