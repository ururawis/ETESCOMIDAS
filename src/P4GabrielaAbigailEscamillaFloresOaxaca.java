/***
*Programa: P4JGabrielaAbilgailEscamillaFloresOaxaca.java
*Autor: Escamilla Flores Gabriela Abigail
*       Ulage Parias Jorge Adan
*Fecha: 17/11/2025
*Descripcion: Aplicación para restaurante de Oaxaca,
*             control de platillos, facturación, IVA y métodos de pago.
***/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class P4GabrielaAbigailEscamillaFloresOaxaca extends JFrame implements ActionListener {

    //Paneles
    JPanel panelMenu, panelFactura;

    //Botones
    JButton btnEliminar, btnFactura, btnSalir;

    //Lista visual del carrito
    DefaultListModel<String> modeloCarrito = new DefaultListModel<>();
    JList<String> listaCarrito = new JList<>(modeloCarrito);

    //Totales
    JLabel lblSub, lblIVA, lblTotal;

    //Métodos de pago
    JRadioButton rbEfectivo, rbTarjeta, rbTransferencia;
    ButtonGroup grupoPago = new ButtonGroup();

    //Subtotal total acumulado
    double subtotal = 0;

    //Fuentes
    Font titulo = new Font("Verdana", Font.BOLD, 20);
    Font normal = new Font("Verdana", Font.PLAIN, 14);

    public static void main(String[] args) {
        P4GabrielaAbigailEscamillaFloresOaxaca v = new P4GabrielaAbigailEscamillaFloresOaxaca();
        v.crearGUI();
        v.setSize(1110, 700);
        v.setVisible(true);
        v.setLocationRelativeTo(null);
        v.setResizable(false);
    }

    public void crearGUI() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container cp = getContentPane();
        cp.setLayout(null);

        //-----------------------------------------
        // PANEL IZQUIERDO – MENÚ
        //-----------------------------------------
        panelMenu = new JPanel(null);
        panelMenu.setBounds(20, 20, 500, 560);
        panelMenu.setBackground(new Color(255, 240, 230));
        panelMenu.setBorder(new LineBorder(Color.GRAY, 2));
        cp.add(panelMenu);

        JLabel lblTituloMenu = new JLabel("MENÚ OAXACA");
        lblTituloMenu.setFont(titulo);
        lblTituloMenu.setBounds(170, 10, 250, 35);
        panelMenu.add(lblTituloMenu);

        //-----------------------------------------
        // DESAYUNOS
        //-----------------------------------------
        agregarCategoria("DESAYUNOS", 60);

        crearPlatillo("Tlayuda desayuno", 80, 100, Color.PINK);
        crearPlatillo("Memelas", 40, 140, Color.ORANGE);
        crearPlatillo("Enchiladas verdes", 70, 180, Color.CYAN);

        //-----------------------------------------
        // COMIDAS
        //-----------------------------------------
        agregarCategoria("COMIDAS", 230);

        crearPlatillo("Mole negro", 120, 270, Color.YELLOW);
        crearPlatillo("Tasajo con frijoles", 150, 310, Color.GREEN);
        crearPlatillo("Caldo de piedra", 110, 350, Color.MAGENTA);

        //-----------------------------------------
        // CENAS
        //-----------------------------------------
        agregarCategoria("CENAS", 400);

        crearPlatillo("Tlayuda grande", 100, 440, Color.LIGHT_GRAY);
        crearPlatillo("Empanadas de amarillo", 60, 480, Color.BLUE);
        crearPlatillo("Quesadillas de flor", 50, 520, Color.RED);

        //-----------------------------------------
        // PANEL DERECHO – FACTURA
        //-----------------------------------------
        panelFactura = new JPanel(null);
        panelFactura.setBounds(540, 20, 540, 560);
        panelFactura.setBackground(new Color(230, 240, 255));
        panelFactura.setBorder(new LineBorder(Color.GRAY, 2));
        cp.add(panelFactura);

        JLabel lblFact = new JLabel("FACTURA");
        lblFact.setFont(titulo);
        lblFact.setBounds(220, 10, 200, 35);
        panelFactura.add(lblFact);

        //-----------------------------------------
        // LISTA DE LO QUE SE AGREGA
        //-----------------------------------------
        listaCarrito.setFont(normal);
        JScrollPane scroll = new JScrollPane(listaCarrito);
        scroll.setBounds(30, 60, 470, 200);
        panelFactura.add(scroll);

        //-----------------------------------------
        // TOTALES
        //-----------------------------------------
        lblSub = new JLabel("Subtotal: $0");
        lblIVA = new JLabel("IVA (16%): $0");
        lblTotal = new JLabel("TOTAL: $0");

        lblSub.setBounds(40, 280, 200, 30);
        lblIVA.setBounds(40, 310, 200, 30);
        lblTotal.setBounds(40, 340, 200, 30);

        panelFactura.add(lblSub);
        panelFactura.add(lblIVA);
        panelFactura.add(lblTotal);

        //-----------------------------------------
        // MÉTODOS DE PAGO
        //-----------------------------------------
        JLabel lblPago = new JLabel("Método de pago:");
        lblPago.setBounds(300, 280, 200, 25);
        panelFactura.add(lblPago);

        rbEfectivo = new JRadioButton("Efectivo");
        rbTarjeta = new JRadioButton("Tarjeta");
        rbTransferencia = new JRadioButton("Transferencia");

        agregarPago(rbEfectivo, 300, 310);
        agregarPago(rbTarjeta, 300, 340);
        agregarPago(rbTransferencia, 300, 370);

        //-----------------------------------------
        // RECTÁNGULO DEL CÓDIGO EN PANEL
        //-----------------------------------------
        JPanel code = new JPanel();
        code.setBackground(Color.DARK_GRAY);
        code.setBounds(30, 390, 200, 90);
        panelFactura.add(code);

        //-----------------------------------------
        // BOTONES
        //-----------------------------------------
        btnEliminar = new JButton("Eliminar último");
        btnEliminar.setBounds(260, 420, 150, 35);
        btnEliminar.addActionListener(this);
        panelFactura.add(btnEliminar);

        btnFactura = new JButton("Generar factura");
        btnFactura.setBounds(260, 465, 150, 35);
        btnFactura.addActionListener(this);
        panelFactura.add(btnFactura);

        btnSalir = new JButton("Salir");
        btnSalir.setBounds(430, 465, 80, 35);
        btnSalir.addActionListener(this);
        panelFactura.add(btnSalir);
    }

    //-------------------------------------------------------
    // CATEGORÍAS
    //-------------------------------------------------------
    private void agregarCategoria(String nombre, int y) {
        JLabel lbl = new JLabel(nombre);
        lbl.setFont(titulo);
        lbl.setBounds(30, y, 200, 30);
        panelMenu.add(lbl);
    }

    //-------------------------------------------------------
    // CREAR PLATILLO SIN ARREGLOS
    //-------------------------------------------------------
    private void crearPlatillo(String nombre, double precio, int y, Color color) {

        JButton btn = new JButton(nombre + "  $" + precio);
        btn.setBounds(30, y, 260, 30);
        btn.setFont(normal);
        panelMenu.add(btn);

        JPanel rect = new JPanel();
        rect.setBounds(320, y, 120, 30);
        rect.setBackground(color);
        rect.setBorder(new LineBorder(Color.BLACK));
        panelMenu.add(rect);

        btn.addActionListener(evt -> {
            modeloCarrito.addElement(nombre + "   $ " + precio);
            subtotal += precio;
            actualizarTotales();
        });
    }

    //-------------------------------------------------------
    // MÉTODOS DE PAGO
    //-------------------------------------------------------
    private void agregarPago(JRadioButton rb, int x, int y) {
        rb.setBounds(x, y, 150, 25);
        rb.setFont(normal);
        grupoPago.add(rb);
        panelFactura.add(rb);
    }

    //-------------------------------------------------------
    // ACTUALIZAR TOTALES
    //-------------------------------------------------------
    private void actualizarTotales() {
        double iva = subtotal * 0.16;
        double total = subtotal + iva;

        lblSub.setText("Subtotal: $" + String.format("%.2f", subtotal));
        lblIVA.setText("IVA (16%): $" + String.format("%.2f", iva));
        lblTotal.setText("TOTAL: $" + String.format("%.2f", total));
    }

    //-------------------------------------------------------
    // BOTONES DE ACCIÓN
    //-------------------------------------------------------
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnEliminar) {
            if (modeloCarrito.size() > 0) {

                String ultimo = modeloCarrito.get(modeloCarrito.size() - 1);

                double precio = Double.parseDouble(ultimo.substring(ultimo.lastIndexOf("$") + 1).trim());
                subtotal -= precio;

                modeloCarrito.remove(modeloCarrito.size() - 1);
                actualizarTotales();
            }
        }

        if (e.getSource() == btnFactura) {

            if (grupoPago.getSelection() == null) {
                JOptionPane.showMessageDialog(this, "Seleccione forma de pago");
                return;
            }

            // ==============================
            //   PANEL PERSONALIZADO FACTURA
            // ==============================
            JPanel facturaPanel = new JPanel();
            facturaPanel.setLayout(new BoxLayout(facturaPanel, BoxLayout.Y_AXIS));

            JLabel titulo = new JLabel("FACTURA DE CONSUMO");
            titulo.setFont(new Font("Arial", Font.BOLD, 18));
            titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
            facturaPanel.add(titulo);

            facturaPanel.add(Box.createVerticalStrut(10));

            // LISTA DE PRODUCTOS
            JTextArea textoProductos = new JTextArea(10, 25);
            textoProductos.setEditable(false);

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < modeloCarrito.size(); i++) {
                sb.append(modeloCarrito.get(i)).append("\n");
            }

            textoProductos.setText(sb.toString());
            facturaPanel.add(new JScrollPane(textoProductos));

            facturaPanel.add(Box.createVerticalStrut(10));

            // TOTALES
            JLabel l1 = new JLabel("Subtotal: $" + String.format("%.2f", subtotal));
            JLabel l2 = new JLabel("IVA (16%): $" + String.format("%.2f",subtotal * 0.16));
            JLabel l3 = new JLabel("TOTAL: $" + String.format("%.2f", subtotal * 1.16));

            facturaPanel.add(l1);
            facturaPanel.add(l2);
            facturaPanel.add(l3);

            facturaPanel.add(Box.createVerticalStrut(15));

            // RECTÁNGULO COMO CÓDIGO DE BARRAS
            JPanel codigo = new JPanel();
            codigo.setPreferredSize(new Dimension(200, 60));
            codigo.setMaximumSize(new Dimension(200, 60));
            codigo.setBackground(Color.BLACK);
            facturaPanel.add(codigo);

            // MOSTRAR PANEL EN JOPTIONPANE
            JOptionPane.showMessageDialog(this, facturaPanel, "Factura", JOptionPane.PLAIN_MESSAGE);
        }

        if (e.getSource() == btnSalir) {
            System.exit(0);
        }
    }
}
