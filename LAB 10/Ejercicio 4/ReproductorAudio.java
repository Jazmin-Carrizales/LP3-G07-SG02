import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class ReproductorAudio extends JFrame {

    private Clip clip;
    private Long currentFrame; // para guardar la posición al pausar
    private String archivoAudio = "Musica.wav"; // tu archivo WAV

    public ReproductorAudio() {
        setTitle("Reproductor de Música");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JButton btnReproducir = new JButton("Reproducir");
        JButton btnPausar = new JButton("Pausar");
        JButton btnReanudar = new JButton("Reanudar");

        add(btnReproducir);
        add(btnPausar);
        add(btnReanudar);

        btnReproducir.addActionListener(e -> reproducir());
        btnPausar.addActionListener(e -> pausar());
        btnReanudar.addActionListener(e -> reanudar());

        setVisible(true);
    }

    private void reproducir() {
        try {
            if (clip != null && clip.isOpen()) {
                clip.stop();
                clip.close();
            }

            File archivo = new File(archivoAudio);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(archivo);

            clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();

            currentFrame = 0L; // resetear la posición
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            JOptionPane.showMessageDialog(this, "Error al reproducir el audio: " + archivoAudio);
            e.printStackTrace();
        }
    }

    private void pausar() {
        if (clip != null && clip.isRunning()) {
            currentFrame = clip.getMicrosecondPosition();
            clip.stop();
        }
    }

    private void reanudar() {
        if (clip != null && !clip.isRunning()) {
            clip.setMicrosecondPosition(currentFrame);
            clip.start();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ReproductorAudio());
    }
}
