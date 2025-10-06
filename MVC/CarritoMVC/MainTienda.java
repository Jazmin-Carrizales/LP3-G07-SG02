public class MainTienda {
    public static void main(String[] args) {
        CatalogoModelo catalogo = new CatalogoModelo();
        catalogo.agregarProducto(new Producto(1, "Camiseta", 25.0, 10));
        catalogo.agregarProducto(new Producto(2, "Pantalón", 40.0, 5));
        catalogo.agregarProducto(new Producto(3, "Zapatillas", 70.0, 4));
        catalogo.agregarProducto(new Producto(4, "Gorra", 15.0, 8));

        CarritoModelo carrito = new CarritoModelo();
        TiendaVista vista = new TiendaVista();
        TiendaControlador controlador = new TiendaControlador(catalogo, carrito, vista);

        controlador.iniciar();
        System.out.println("Gracias por usar la tienda.");
    }
}
