import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class ReproductorSonido extends JFrame {

    public ReproductorSonido() {
        setTitle("Reproductor de Efectos de Sonido");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Crear botones
        JButton btnAplausos = new JButton("Aplausos");
        JButton btnCampana = new JButton("Campana");
        JButton btnExplosion = new JButton("Explosión");

        add(btnAplausos);
        add(btnCampana);
        add(btnExplosion);

        // Asociar eventos
        btnAplausos.addActionListener(e -> reproducirSonido("Aplausos.wav"));
        btnCampana.addActionListener(e -> reproducirSonido("Campana.wav"));
        btnExplosion.addActionListener(e -> reproducirSonido("Explosion.wav"));

        setVisible(true);
    }

    private void reproducirSonido(String archivoWav) {
        try {
            // Cargar archivo de sonido
            File archivo = new File(archivoWav);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(archivo);

            // Obtener un Clip y reproducirlo
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            JOptionPane.showMessageDialog(this, "Error al reproducir el sonido: " + archivoWav);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Ejecutar en el hilo de Swing
        SwingUtilities.invokeLater(() -> new ReproductorSonido());
    }
}
