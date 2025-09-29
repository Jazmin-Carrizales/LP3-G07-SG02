package ejercicio4_isp;

public class ImpresoraMultifuncional implements Imprimible, Escaneable {
    @Override
    public void imprimir() {
        System.out.println("Imprimiendo documento (multifuncional).");
    }

    @Override
    public void escanear() {
        System.out.println("Escaneando documento (multifuncional).");
    }
}
