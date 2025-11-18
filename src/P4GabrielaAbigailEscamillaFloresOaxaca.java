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

    double subtotal = 0;

    //Fuentes más vistosas
    Font titulo = new Font("Serif", Font.BOLD, 22);
    Font normal = new Font("Serif", Font.PLAIN, 16);

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

        // ======================================
        // PALETA OAXAQUEÑA
        // ======================================
        Color rosaMex = new Color(230, 30, 120);
        Color amarilloMaiz = new Color(250, 210, 90);
        Color verdeJade = new Color(60, 130, 90);
        Color azulAnil = new Color(40, 60, 140);
        Color terracota = new Color(180, 80, 50);

        //-----------------------------------------
        // PANEL IZQUIERDO – MENÚ
        //-----------------------------------------
        panelMenu = new JPanel(null);
        panelMenu.setBounds(20, 20, 500, 560);
        panelMenu.setBackground(new Color(255, 235, 240));
        panelMenu.setBorder(new LineBorder(rosaMex, 4));
        cp.add(panelMenu);

        JLabel lblTituloMenu = new JLabel("MENÚ OAXACA");
        lblTituloMenu.setFont(titulo);
        lblTituloMenu.setForeground(rosaMex);
        lblTituloMenu.setBounds(170, 10, 250, 35);
        panelMenu.add(lblTituloMenu);

        //-----------------------------------------
        // DESAYUNOS
        //-----------------------------------------
        agregarCategoria("DESAYUNOS", 60);

        crearPlatillo("Tlayuda desayuno", 80, 100, amarilloMaiz,
            "tlayDes.jpg"); 

        crearPlatillo("Memelas", 40, 140, terracota,
            "memelas.jpg");

        crearPlatillo("Enchiladas verdes", 70, 180, verdeJade,
            "enchVerd.jpg"); 

        //-----------------------------------------
        // COMIDAS
        //-----------------------------------------
        agregarCategoria("COMIDAS", 230);

        crearPlatillo("Mole negro", 120, 270, azulAnil,
            "moleNegro.jpg"); // Imagen Mole negro

        crearPlatillo("Tasajo con frijoles", 150, 310, rosaMex,
            "Tasajo.jpg"); // Imagen Tasajo con frijoles

        crearPlatillo("Caldo de piedra", 110, 350, amarilloMaiz,
            "piedra.jpg"); // Imagen Caldo de piedra

        //-----------------------------------------
        // CENAS
        //-----------------------------------------
        agregarCategoria("CENAS", 400);

        crearPlatillo("Tlayuda grande", 100, 440, verdeJade,
            "tlayGran.jpg"); // Imagen Tlayuda grande

        crearPlatillo("Empanadas de amarillo", 60, 480, terracota,
            "empanadas.jpg"); // Imagen Empanadas de amarillo

        crearPlatillo("Quesadillas de flor", 50, 520, azulAnil,
            "quesadillas.jpg"); // Imagen Quesadillas de flor

        //-----------------------------------------
        // PANEL FACTURA
        //-----------------------------------------
        panelFactura = new JPanel(null);
        panelFactura.setBounds(540, 20, 540, 560);
        panelFactura.setBackground(new Color(240, 250, 255));
        panelFactura.setBorder(new LineBorder(azulAnil, 4));
        cp.add(panelFactura);

        JLabel lblFact = new JLabel("FACTURA");
        lblFact.setFont(titulo);
        lblFact.setForeground(azulAnil);
        lblFact.setBounds(220, 10, 200, 35);
        panelFactura.add(lblFact);


        //-----------------------------------------
        // LISTA
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

        lblSub.setBounds(40, 280, 250, 30);
        lblSub.setForeground(terracota);
        lblIVA.setBounds(40, 310, 250, 30);
        lblIVA.setForeground(terracota);
        lblTotal.setBounds(40, 340, 250, 30);
        lblTotal.setForeground(terracota);

        panelFactura.add(lblSub);
        panelFactura.add(lblIVA);
        panelFactura.add(lblTotal);

        //-----------------------------------------
        // MÉTODOS DE PAGO
        //-----------------------------------------
        JLabel lblPago = new JLabel("Método de pago:");
        lblPago.setBounds(300, 280, 200, 25);
        lblPago.setForeground(azulAnil);
        panelFactura.add(lblPago);

        rbEfectivo = new JRadioButton("Efectivo");
        rbTarjeta = new JRadioButton("Tarjeta");
        rbTransferencia = new JRadioButton("Transferencia");

        agregarPago(rbEfectivo, 300, 310);
        agregarPago(rbTarjeta, 300, 340);
        agregarPago(rbTransferencia, 300, 370);

        //-----------------------------------------
        // CÓDIGO DE BARRAS EN PANEL FACTURA
        //-----------------------------------------
        ImageIcon iconCB = new ImageIcon("codigo.png"); 
        Image imgCB = iconCB.getImage().getScaledInstance(250, 100, Image.SCALE_SMOOTH);
        JLabel lblCodigo = new JLabel(new ImageIcon(imgCB));
        lblCodigo.setBounds(150, 395, 250, 100);
        panelFactura.add(lblCodigo);

        //-----------------------------------------
        // BOTONES
        //-----------------------------------------
        btnEliminar = new JButton("Eliminar último");
        btnEliminar.setBounds(260, 420, 150, 35);
        btnEliminar.setBackground(rosaMex);
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.addActionListener(this);
        panelFactura.add(btnEliminar);

        btnFactura = new JButton("Generar factura");
        btnFactura.setBounds(260, 465, 150, 35);
        btnFactura.setBackground(verdeJade);
        btnFactura.setForeground(Color.WHITE);
        btnFactura.addActionListener(this);
        panelFactura.add(btnFactura);

        btnSalir = new JButton("Salir");
        btnSalir.setBounds(430, 465, 80, 35);
        btnSalir.setBackground(terracota);
        btnSalir.setForeground(Color.WHITE);
        btnSalir.addActionListener(this);
        panelFactura.add(btnSalir);
    }

    //-------------------------------------------------------
    // CATEGORÍAS
    //-------------------------------------------------------
    private void agregarCategoria(String nombre, int y) {
        JLabel lbl = new JLabel(nombre);
        lbl.setFont(titulo);
        lbl.setForeground(new Color(180, 50, 100)); // rosa oscuro
        lbl.setBounds(30, y, 300, 30);
        panelMenu.add(lbl);
    }

    //-------------------------------------------------------
    // CREAR PLATILLO CON IMAGEN
    //-------------------------------------------------------
    private void crearPlatillo(String nombre, double precio, int y, Color color, String imgRuta) {

        JButton btn = new JButton(nombre + "  $" + precio);
        btn.setBounds(30, y, 260, 30);
        btn.setFont(normal);
        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        panelMenu.add(btn);

        // Imagen — aquí se pone "x.jpg"
        JLabel img = new JLabel(new ImageIcon(imgRuta));
        img.setBounds(320, y, 120, 30);
        panelMenu.add(img);

        btn.addActionListener(evt -> {
            modeloCarrito.addElement(nombre + "   $ " + precio);
            subtotal += precio;
            actualizarTotales();
        });
    }

    //-------------------------------------------------------
    private void agregarPago(JRadioButton rb, int x, int y) {
        rb.setBounds(x, y, 150, 25);
        rb.setFont(normal);
        rb.setBackground(panelFactura.getBackground());
        grupoPago.add(rb);
        panelFactura.add(rb);
    }

    //-------------------------------------------------------
    private void actualizarTotales() {
        double iva = subtotal * 0.16;
        double total = subtotal + iva;

        lblSub.setText("Subtotal: $" + String.format("%.2f", subtotal));
        lblIVA.setText("IVA (16%): $" + String.format("%.2f", iva));
        lblTotal.setText("TOTAL: $" + String.format("%.2f", total));
    }

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

            JPanel facturaPanel = new JPanel();
            facturaPanel.setLayout(new BoxLayout(facturaPanel, BoxLayout.Y_AXIS));

            JLabel t = new JLabel("FACTURA DE CONSUMO");
            t.setFont(new Font("Serif", Font.BOLD, 18));
            t.setAlignmentX(Component.CENTER_ALIGNMENT);
            facturaPanel.add(t);

            facturaPanel.add(Box.createVerticalStrut(10));

            JTextArea textoProductos = new JTextArea(10, 25);
            textoProductos.setEditable(false);

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < modeloCarrito.size(); i++) {
                sb.append(modeloCarrito.get(i)).append("\n");
            }

            textoProductos.setText(sb.toString());
            facturaPanel.add(new JScrollPane(textoProductos));

            facturaPanel.add(Box.createVerticalStrut(10));

            facturaPanel.add(new JLabel("Subtotal: $" + String.format("%.2f", subtotal)));
            facturaPanel.add(new JLabel("IVA (16%): $" + String.format("%.2f", subtotal * 0.16)));
            facturaPanel.add(new JLabel("TOTAL: $" + String.format("%.2f", subtotal * 1.16)));

            //-----------------------------------------
            // CÓDIGO DE BARRAS EN FACTURA EMERGENTE
            //-----------------------------------------
            ImageIcon iconCB2 = new ImageIcon("codigo.png"); // ← Ruta aquí también
            Image imgCB2 = iconCB2.getImage().getScaledInstance(220, 80, Image.SCALE_SMOOTH);
            JLabel lblCodigo2 = new JLabel(new ImageIcon(imgCB2));
            lblCodigo2.setAlignmentX(Component.CENTER_ALIGNMENT);
            facturaPanel.add(Box.createVerticalStrut(10));
            facturaPanel.add(lblCodigo2);

            JOptionPane.showMessageDialog(this, facturaPanel,
                    "Factura", JOptionPane.PLAIN_MESSAGE);
        }

        if (e.getSource() == btnSalir) System.exit(0);
    }
}
