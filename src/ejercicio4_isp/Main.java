package ejercicio4_isp;

public class Main {
    public static void main(String[] args) {
        Imprimible impresoraSimple = new Impresora();
        Imprimible impresoraMultiAsImpresora = new ImpresoraMultifuncional();
        Escaneable escaner = new ImpresoraMultifuncional();

        impresoraSimple.imprimir();
        impresoraMultiAsImpresora.imprimir();
        escaner.escanear();
    }
}
