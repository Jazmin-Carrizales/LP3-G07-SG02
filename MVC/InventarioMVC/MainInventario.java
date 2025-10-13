public class MainInventario {
    public static void main(String[] args) {
        InventarioModelo modelo = new InventarioModelo();
        InventarioVista vista = new InventarioVista();
        InventarioControlador controlador = new InventarioControlador(modelo, vista);

        modelo.agregarArticulo("Tornillo", "Ferretería", 100, 0.2);
        modelo.agregarArticulo("Monitor 24 pulgadas", "Electrónica", 10, 120.0);

        controlador.iniciar();
        System.out.println("Fin del sistema de inventario.");
    }
}
