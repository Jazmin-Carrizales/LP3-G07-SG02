import javax.swing.*;
import java.awt.*;

public class Ejercicio2 extends JFrame {

    private JTextField[] camposTemp = new JTextField[7];
    private int[] temperaturas = new int[7];
    private String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
    private PanelGrafico panelGrafico;

    public Ejercicio2() {
        setTitle("Gráfico de Temperaturas Semanales");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelEntrada = new JPanel(new GridLayout(7, 2));
        for (int i = 0; i < 7; i++) {
            panelEntrada.add(new JLabel(dias[i] + ":"));
            camposTemp[i] = new JTextField();
            panelEntrada.add(camposTemp[i]);
        }

        JButton btnMostrar = new JButton("Mostrar Gráfico");
        btnMostrar.addActionListener(e -> actualizarGrafico());

        panelGrafico = new PanelGrafico();

        add(panelEntrada, BorderLayout.WEST);
        add(panelGrafico, BorderLayout.CENTER);
        add(btnMostrar, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void actualizarGrafico() {
        for (int i = 0; i < 7; i++) {
            try {
                temperaturas[i] = Integer.parseInt(camposTemp[i].getText());
            } catch (NumberFormatException ex) {
                temperaturas[i] = 0;
            }
        }
        panelGrafico.setTemperaturas(temperaturas);
        panelGrafico.repaint();
    }

    public static void main(String[] args) {
        new Ejercicio2();
    }
}

class PanelGrafico extends JPanel {
    private int[] temps = new int[7];
    private String[] dias = {"L", "M", "Mi", "J", "V", "S", "D"};

    public void setTemperaturas(int[] temps) {
        this.temps = temps.clone();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int margen = 50;
        int ancho = getWidth() - 2 * margen;
        int alto = getHeight() - 2 * margen;

        g.setColor(Color.WHITE);
        g.fillRect(margen, margen, ancho, alto);

        g.setColor(Color.BLACK);
        g.drawRect(margen, margen, ancho, alto);

        int espacioX = ancho / 6;
        int maxTemp = 0;
        for (int t : temps) if (t > maxTemp) maxTemp = t;
        maxTemp = Math.max(maxTemp, 1);

        int[] puntosX = new int[7];
        int[] puntosY = new int[7];

        for (int i = 0; i < 7; i++) {
            puntosX[i] = margen + i * espacioX;
            puntosY[i] = margen + alto - (temps[i] * alto / maxTemp);
        }

        g.setColor(Color.BLUE);
        for (int i = 0; i < 6; i++) {
            g.drawLine(puntosX[i], puntosY[i], puntosX[i + 1], puntosY[i + 1]);
        }

        g.setColor(Color.RED);
        for (int i = 0; i < 7; i++) {
            g.fillOval(puntosX[i] - 5, puntosY[i] - 5, 10, 10);
        }

        g.setColor(Color.BLACK);
        for (int i = 0; i < 7; i++) {
            g.drawString(dias[i], puntosX[i] - 5, margen + alto + 20);
        }
    }
}
