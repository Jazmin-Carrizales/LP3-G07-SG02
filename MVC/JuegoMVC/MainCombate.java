import java.util.ArrayList;
import java.util.List;

public class MainCombate {
    public static void main(String[] args) {
        Jugador j = new Jugador("Héroe", 100, 1);
        j.agregarObjeto(new ObjetoJuego("Espada corta", "Arma", 8, 1));
        j.agregarObjeto(new ObjetoJuego("Poción pequeña", "Poción", 20, 2));
        j.agregarObjeto(new ObjetoJuego("Hacha de batalla", "Arma", 12, 1));

        List<Enemigo> enemigos = new ArrayList<>();
        enemigos.add(new Enemigo("Goblin", 30, 1, 3, 6));
        enemigos.add(new Enemigo("Orco", 50, 2, 5, 10));

        CombateVista vista = new CombateVista();
        CombateControlador controlador = new CombateControlador(j, enemigos, vista);
        controlador.iniciarCombate();
    }
}
