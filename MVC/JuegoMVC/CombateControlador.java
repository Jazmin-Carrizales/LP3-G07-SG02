import java.util.ArrayList;
import java.util.List;

public class CombateControlador {
    private Jugador jugador;
    private List<Enemigo> enemigos;
    private CombateVista vista;

    public CombateControlador(Jugador jugador, List<Enemigo> enemigos, CombateVista vista) {
        this.jugador = jugador;
        this.enemigos = enemigos;
        this.vista = vista;
    }

    public void iniciarCombate() {
        vista.mostrarMensaje("¡Comienza el combate!");
        while (jugador.estaVivo() && enemigos.stream().anyMatch(Enemigo::estaVivo)) {
            vista.mostrarEstado(jugador, enemigos);
            turnoJugador();
            enemigos.removeIf(e -> !e.estaVivo());
            for (Enemigo e : new ArrayList<>(enemigos)) {
                if (e.estaVivo() && jugador.estaVivo()) {
                    e.atacar(jugador);
                }
            }
        }
        if (jugador.estaVivo())
            vista.mostrarMensaje("🏆 ¡Victoria! Has derrotado a todos los enemigos.");
        else
            vista.mostrarMensaje("💀 Has sido derrotado...");
    }

    private void turnoJugador() {
        vista.mostrarMensaje("\nTu turno: 1) Atacar  2) Usar objeto  3) Equipar arma");
        int op = vista.leerEntero("Opción: ");
        switch (op) {
            case 1:
                int idx = vista.leerEntero("Elige enemigo (índice): ");
                if (idx < 0 || idx >= enemigos.size() || !enemigos.get(idx).estaVivo()) {
                    vista.mostrarMensaje("Enemigo inválido.");
                } else {
                    jugador.atacar(enemigos.get(idx));
                }
                break;
            case 2:
                String obj = vista.leerTexto("Nombre del objeto a usar: ");
                jugador.usarObjeto(obj);
                break;
            case 3:
                String arma = vista.leerTexto("Nombre del arma a equipar: ");
                jugador.equiparArma(arma);
                break;
            default:
                vista.mostrarMensaje("Opción no válida.");
        }
    }
}
