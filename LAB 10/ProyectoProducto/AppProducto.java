import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AppProducto extends JFrame {

    private Producto producto;

    private JTextField txtNombre;
    private JTextField txtPrecio;
    private JTextField txtCantidad;
    private JTextField txtCategoria;
    private JLabel lblResultado;

    public AppProducto() {
        setTitle("Gestión de Producto");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 5, 5));

        producto = new Producto("Sin nombre", 0.0, 0, "Sin categoría");

        add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        add(txtNombre);

        add(new JLabel("Precio:"));
        txtPrecio = new JTextField();
        add(txtPrecio);

        add(new JLabel("Cantidad Stock:"));
        txtCantidad = new JTextField();
        add(txtCantidad);

        add(new JLabel("Categoría:"));
        txtCategoria = new JTextField();
        add(txtCategoria);

        JButton btnActualizar = new JButton("Actualizar Producto");
        add(btnActualizar);

        lblResultado = new JLabel("Información del producto aparecerá aquí");
        add(lblResultado);

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                producto.setNombre(txtNombre.getText());
                producto.setPrecio(Double.parseDouble(txtPrecio.getText()));
                producto.setCantidadStock(Integer.parseInt(txtCantidad.getText()));
                producto.setCategoria(txtCategoria.getText());

                lblResultado.setText(producto.toString());
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new AppProducto();
    }
}
