//package prueba;

/***
*Programa: P4JGabrielaAbilgailEscamillaFloresOaxaca.java
*Autor: Escamilla Flores Gabriela Abigail
* Ulage Parias Jorge Adan
*Fecha: 21/11/2025 (Actualizado)
*Descripcion: Aplicación para restaurante de Oaxaca,
* control de platillos, facturación, IVA y métodos de pago.
***/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

public class P4GabrielaAbigailEscamillaFloresOaxaca extends JFrame implements ActionListener {
    
    // Definición de Colores temáticos Oaxaqueños
    private static final Color COLOR_FONDO = new Color(255, 250, 235); 
    private static final Color COLOR_MENU = new Color(250, 235, 215); 
    private static final Color COLOR_BOTON = new Color(169, 169, 122);
    private static final Color COLOR_TEXTO = Color.BLACK;

    JTextArea ticket; 

    // Labels para mostrar los totales
    JLabel lblSubtotal, lblIVA, lblTotal; 

    // Campos de texto para las cantidades
    JTextField cantTlayDes, cantMemelas, cantEnchiladas; 
    JTextField cantMole, cantTasajo, cantPiedra;
    JTextField cantTlayGran, cantEmpanadas, cantQuesa;

    JRadioButton rbEfectivo, rbTarjeta, rbTransferencia;
    JTextField campoPago; 

    double subtotal = 0; // Se utiliza para almacenar el TOTAL con IVA (Suma de productos)
    double iva = 0;
    double totalSinIVA = 0; // Variable para el subtotal sin IVA
    final double TASA_IVA_DIVISOR = 1.16; // Constante para dividir por la tasa de IVA

    // Variables para almacenar datos de pago con tarjeta y facturación
    private String tipoTarjeta = "";
    private String numTarjeta = "";
    private String fechaVenc = "";
    private String cvv = "";
    
    private String nombreFactura = "";
    private String rfcFactura = "";
    private String direccionFactura = "";

    // --- NUEVO MÉTODO PARA ESCALAR IMAGENES ---
    private ImageIcon getScaledIcon(String path) {
        try {
            // Se asume que las imágenes están en la misma carpeta o en el classpath
            ImageIcon originalIcon = new ImageIcon(getClass().getResource(path)); 
            Image originalImage = originalIcon.getImage();
            Image scaledImage = originalImage.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            return new ImageIcon(scaledImage);
        } catch (Exception e) {
            System.err.println("Error al cargar o escalar la imagen: " + path);
            // e.printStackTrace(); // Descomentar para debug
            return null; // Devuelve null si hay un error
        }
    }
    // ------------------------------------------

    public P4GabrielaAbigailEscamillaFloresOaxaca() {

        super("Restaurante Oaxaca");
        setLayout(null); 
        getContentPane().setBackground(COLOR_FONDO);

        // ... [Configuración de paneles, títulos, JTextArea, etc. - CÓDIGO SIN CAMBIOS] ...

        JPanel menu = new JPanel(null);
        menu.setBounds(20, 20, 520, 600);
        menu.setBackground(COLOR_MENU);
        menu.setBorder(null);
        add(menu);

        JLabel titulo = new JLabel("MENÚ OAXACA");
        titulo.setFont(new Font("Arial", Font.BOLD, 26));
        titulo.setBounds(150, 10, 300, 40);
        titulo.setForeground(COLOR_TEXTO);
        menu.add(titulo);

        ticket = new JTextArea();
        ticket.setEditable(false);
        ticket.setBackground(Color.WHITE);
        JScrollPane scroll = new JScrollPane(ticket); 
        scroll.setBounds(560, 200, 200, 250);
        add(scroll);

        JLabel lblTicket = new JLabel("CARRITO:");
        lblTicket.setFont(new Font("Arial", Font.BOLD, 16));
        lblTicket.setBounds(560, 170, 200, 25);
        lblTicket.setForeground(COLOR_TEXTO);
        add(lblTicket);
        
        //para mostrar Subtotal, IVA y Total en el carrito
        lblSubtotal = new JLabel("SUBTOTAL: $0.00");
        lblSubtotal.setBounds(560, 460, 200, 20);
        lblSubtotal.setForeground(COLOR_TEXTO);
        add(lblSubtotal);
        
        lblIVA = new JLabel("IVA (16%): $0.00");
        lblIVA.setBounds(560, 485, 200, 20);
        lblIVA.setForeground(COLOR_TEXTO);
        add(lblIVA);
        
        lblTotal = new JLabel("TOTAL: $0.00");
        lblTotal.setFont(new Font("Arial", Font.BOLD, 14));
        lblTotal.setBounds(560, 510, 200, 25);
        lblTotal.setForeground(COLOR_BOTON.darker()); 
        add(lblTotal);
        
        // Estilos para los botones de agregar
        ActionListener agregarListener = this::handleAgregar; 
        Color btnForeground = Color.WHITE;
        
        //SECCIONES DEL MENÚ
        
        JLabel d = new JLabel("DESAYUNOS");
        d.setFont(new Font("Arial", Font.BOLD, 18));
        d.setBounds(20, 60, 200, 25);
        d.setForeground(COLOR_BOTON.darker());
        menu.add(d);
        
        JLabel c = new JLabel("COMIDAS");
        c.setFont(new Font("Arial", Font.BOLD, 18));
        c.setBounds(20, 230, 200, 25);
        c.setForeground(COLOR_BOTON.darker());
        menu.add(c);
        
        JLabel e = new JLabel("CENAS");
        e.setFont(new Font("Arial", Font.BOLD, 18));
        e.setBounds(20, 400, 200, 25);
        e.setForeground(COLOR_BOTON.darker());
        menu.add(e);

    //CONTENIDO DEL MENÚ:
        // (El código de los botones y campos de cantidad es el mismo que el original, omitido aquí por brevedad)
        
        // TLAYUDA DESAYUNO
        JLabel img1 = new JLabel(getScaledIcon("tlayuda.jpg")); 
        img1.setBounds(20, 100, 40, 40);
        menu.add(img1);
        JLabel l1 = new JLabel("Tlayuda desayuno $80");
        l1.setBounds(70, 100, 200, 25);
        menu.add(l1);
        cantTlayDes = new JTextField("0");
        cantTlayDes.setBounds(280, 100, 50, 25);
        cantTlayDes.setBackground(Color.WHITE);
        menu.add(cantTlayDes);
        JButton btnTlayDes = new JButton("Agregar");
        btnTlayDes.setBounds(350, 100, 100, 25);
        btnTlayDes.setBackground(COLOR_BOTON);
        btnTlayDes.setForeground(btnForeground);
        btnTlayDes.setFocusPainted(false);
        btnTlayDes.putClientProperty("precio", 80);
        btnTlayDes.putClientProperty("nombre", "Tlayuda desayuno");
        btnTlayDes.putClientProperty("cantidad", cantTlayDes);
        btnTlayDes.addActionListener(agregarListener);
        menu.add(btnTlayDes);

        // MEMELAS 
        JLabel img2 = new JLabel(getScaledIcon("memelas.jpg")); 
        img2.setBounds(20, 140, 40, 40);
        menu.add(img2);
        JLabel l2 = new JLabel("Memelas $40");
        l2.setBounds(70, 140, 200, 25);
        menu.add(l2);
        cantMemelas = new JTextField("0");
        cantMemelas.setBounds(280, 140, 50, 25);
        cantMemelas.setBackground(Color.WHITE);
        menu.add(cantMemelas);
        JButton btnMemelas = new JButton("Agregar");
        btnMemelas.setBounds(350, 140, 100, 25);
        btnMemelas.setBackground(COLOR_BOTON);
        btnMemelas.setForeground(btnForeground);
        btnMemelas.setFocusPainted(false);
        btnMemelas.putClientProperty("precio", 40);
        btnMemelas.putClientProperty("nombre", "Memelas");
        btnMemelas.putClientProperty("cantidad", cantMemelas);
        btnMemelas.addActionListener(agregarListener);
        menu.add(btnMemelas);

        // ENCHILADAS 
        JLabel img3 = new JLabel(getScaledIcon("enchiladas.jpg")); 
        img3.setBounds(20, 180, 40, 40);
        menu.add(img3);
        JLabel l3 = new JLabel("Enchiladas verdes $70");
        l3.setBounds(70, 180, 200, 25);
        menu.add(l3);
        cantEnchiladas = new JTextField("0");
        cantEnchiladas.setBounds(280, 180, 50, 25);
        cantEnchiladas.setBackground(Color.WHITE);
        menu.add(cantEnchiladas);
        JButton btnEnchiladas = new JButton("Agregar");
        btnEnchiladas.setBounds(350, 180, 100, 25);
        btnEnchiladas.setBackground(COLOR_BOTON);
        btnEnchiladas.setForeground(btnForeground);
        btnEnchiladas.setFocusPainted(false);
        btnEnchiladas.putClientProperty("precio", 70);
        btnEnchiladas.putClientProperty("nombre", "Enchiladas verdes");
        btnEnchiladas.putClientProperty("cantidad", cantEnchiladas);
        btnEnchiladas.addActionListener(agregarListener);
        menu.add(btnEnchiladas);

        // MOLE NEGRO 
        JLabel img4 = new JLabel(getScaledIcon("mole.jpg")); 
        img4.setBounds(20, 270, 40, 40);
        menu.add(img4);
        JLabel l4 = new JLabel("Mole negro $120");
        l4.setBounds(70, 270, 200, 25);
        menu.add(l4);
        cantMole = new JTextField("0");
        cantMole.setBounds(280, 270, 50, 25);
        cantMole.setBackground(Color.WHITE);
        menu.add(cantMole);
        JButton btnMole = new JButton("Agregar");
        btnMole.setBounds(350, 270, 100, 25);
        btnMole.setBackground(COLOR_BOTON);
        btnMole.setForeground(btnForeground);
        btnMole.setFocusPainted(false);
        btnMole.putClientProperty("precio", 120);
        btnMole.putClientProperty("nombre", "Mole negro");
        btnMole.putClientProperty("cantidad", cantMole);
        btnMole.addActionListener(agregarListener);
        menu.add(btnMole);

        // TASAJO
        JLabel img5 = new JLabel(getScaledIcon("tasajo.jfif")); 
        img5.setBounds(20, 310, 40, 40);
        menu.add(img5);
        JLabel l5 = new JLabel("Tasajo con frijoles $150");
        l5.setBounds(70, 310, 200, 25);
        menu.add(l5);
        cantTasajo = new JTextField("0");
        cantTasajo.setBounds(280, 310, 50, 25);
        cantTasajo.setBackground(Color.WHITE);
        menu.add(cantTasajo);
        JButton btnTasajo = new JButton("Agregar");
        btnTasajo.setBounds(350, 310, 100, 25);
        btnTasajo.setBackground(COLOR_BOTON);
        btnTasajo.setForeground(btnForeground);
        btnTasajo.setFocusPainted(false);
        btnTasajo.putClientProperty("precio", 150);
        btnTasajo.putClientProperty("nombre", "Tasajo con frijoles");
        btnTasajo.putClientProperty("cantidad", cantTasajo);
        btnTasajo.addActionListener(agregarListener);
        menu.add(btnTasajo);

        // CALDO DE PIEDRA 
        JLabel img6 = new JLabel(getScaledIcon("piedra.jfif")); 
        img6.setBounds(20, 350, 40, 40);
        menu.add(img6);
        JLabel l6 = new JLabel("Caldo de piedra $110");
        l6.setBounds(70, 350, 200, 25);
        menu.add(l6);
        cantPiedra = new JTextField("0");
        cantPiedra.setBounds(280, 350, 50, 25);
        cantPiedra.setBackground(Color.WHITE);
        menu.add(cantPiedra);
        JButton btnPiedra = new JButton("Agregar");
        btnPiedra.setBounds(350, 350, 100, 25);
        btnPiedra.setBackground(COLOR_BOTON);
        btnPiedra.setForeground(btnForeground);
        btnPiedra.setFocusPainted(false);
        btnPiedra.putClientProperty("precio", 110);
        btnPiedra.putClientProperty("nombre", "Caldo de piedra");
        btnPiedra.putClientProperty("cantidad", cantPiedra);
        btnPiedra.addActionListener(agregarListener);
        menu.add(btnPiedra);

        // TLAYUDA GRANDE 
        JLabel img7 = new JLabel(getScaledIcon("tlayuda_grande.jpg")); 
        img7.setBounds(20, 440, 40, 40);
        menu.add(img7);
        JLabel l7 = new JLabel("Tlayuda grande $100");
        l7.setBounds(70, 440, 200, 25);
        menu.add(l7);
        cantTlayGran = new JTextField("0");
        cantTlayGran.setBounds(280, 440, 50, 25);
        cantTlayGran.setBackground(Color.WHITE);
        menu.add(cantTlayGran);
        JButton btnTlayGran = new JButton("Agregar");
        btnTlayGran.setBounds(350, 440, 100, 25);
        btnTlayGran.setBackground(COLOR_BOTON);
        btnTlayGran.setForeground(btnForeground);
        btnTlayGran.setFocusPainted(false);
        btnTlayGran.putClientProperty("precio", 100);
        btnTlayGran.putClientProperty("nombre", "Tlayuda grande");
        btnTlayGran.putClientProperty("cantidad", cantTlayGran);
        btnTlayGran.addActionListener(agregarListener);
        menu.add(btnTlayGran);

        // EMPANADAS 
        JLabel img8 = new JLabel(getScaledIcon("empanadas.jpeg")); 
        img8.setBounds(20, 480, 40, 40);
        menu.add(img8);
        JLabel l8 = new JLabel("Empanadas amarillo $60");
        l8.setBounds(70, 480, 200, 25);
        menu.add(l8);
        cantEmpanadas = new JTextField("0");
        cantEmpanadas.setBounds(280, 480, 50, 25);
        cantEmpanadas.setBackground(Color.WHITE);
        menu.add(cantEmpanadas);
        JButton btnEmpanadas = new JButton("Agregar");
        btnEmpanadas.setBounds(350, 480, 100, 25);
        btnEmpanadas.setBackground(COLOR_BOTON);
        btnEmpanadas.setForeground(btnForeground);
        btnEmpanadas.setFocusPainted(false);
        btnEmpanadas.putClientProperty("precio", 60);
        btnEmpanadas.putClientProperty("nombre", "Empanadas amarillo");
        btnEmpanadas.putClientProperty("cantidad", cantEmpanadas);
        btnEmpanadas.addActionListener(agregarListener);
        menu.add(btnEmpanadas);

        // QUESADILLAS
        JLabel img9 = new JLabel(getScaledIcon("quesadilla.jfif")); 
        img9.setBounds(20, 520, 40, 40);
        menu.add(img9);
        JLabel l9 = new JLabel("Quesadillas flor $50");
        l9.setBounds(70, 520, 200, 25);
        menu.add(l9);
        cantQuesa = new JTextField("0");
        cantQuesa.setBounds(280, 520, 50, 25);
        cantQuesa.setBackground(Color.WHITE);
        menu.add(cantQuesa);
        JButton btnQuesadillas = new JButton("Agregar");
        btnQuesadillas.setBounds(350, 520, 100, 25);
        btnQuesadillas.setBackground(COLOR_BOTON);
        btnQuesadillas.setForeground(btnForeground);
        btnQuesadillas.setFocusPainted(false);
        btnQuesadillas.putClientProperty("precio", 50);
        btnQuesadillas.putClientProperty("nombre", "Quesadillas flor");
        btnQuesadillas.putClientProperty("cantidad", cantQuesa);
        btnQuesadillas.addActionListener(agregarListener);
        menu.add(btnQuesadillas);


        //Método de pAgo
        rbEfectivo = new JRadioButton("Efectivo");
        rbTarjeta = new JRadioButton("Tarjeta");
        rbTransferencia = new JRadioButton("Transferencia");
        
        rbEfectivo.setBackground(COLOR_FONDO);
        rbTarjeta.setBackground(COLOR_FONDO);
        rbTransferencia.setBackground(COLOR_FONDO);

        ButtonGroup g = new ButtonGroup();
        g.add(rbEfectivo);
        g.add(rbTarjeta);
        g.add(rbTransferencia);
        
        // *** CAMBIO CLAVE 3: Listener para la tarjeta que abre la ventana ***
        rbTarjeta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rbTarjeta.isSelected()) {
                    mostrarDialogoTarjeta();
                }
            }
        });
        // *******************************************************************

        rbEfectivo.setBounds(560, 60, 100, 25);
        rbTarjeta.setBounds(660, 60, 100, 25);
        rbTransferencia.setBounds(560, 85, 150, 25);

        add(rbEfectivo);
        add(rbTarjeta);
        add(rbTransferencia);

        JLabel lp = new JLabel("Paga con:");
        lp.setBounds(560, 120, 80, 25);
        lp.setForeground(COLOR_TEXTO);
        add(lp);

        campoPago = new JTextField();
        campoPago.setBounds(630, 120, 100, 25);
        campoPago.setBackground(Color.WHITE);
        add(campoPago);
        
        //BOTÓN LIMPIAR CARRO
        JButton btnLimpiar = new JButton("Limpiar Carrito");
        btnLimpiar.setBounds(560, 540, 200, 20);
        btnLimpiar.setBackground(COLOR_BOTON.darker().darker()); 
        btnLimpiar.setForeground(btnForeground);
        btnLimpiar.setFocusPainted(false);
        btnLimpiar.setBorderPainted(false);
        btnLimpiar.addActionListener(_ -> limpiarCarrito());
        add(btnLimpiar);

        JButton btnGenerar = new JButton("Generar factura");
        btnGenerar.setBounds(560, 565, 200, 30);
        btnGenerar.setBackground(COLOR_BOTON);
        btnGenerar.setForeground(btnForeground);
        btnGenerar.setFocusPainted(false);
        btnGenerar.setBorderPainted(false);
        btnGenerar.addActionListener(this); 
        add(btnGenerar);

        JButton btnSalir = new JButton("Salir");
        btnSalir.setBounds(560, 600, 200, 30);
        btnSalir.setBackground(Color.RED.darker());
        btnSalir.setForeground(btnForeground);
        btnSalir.setFocusPainted(false);
        btnSalir.addActionListener(_ -> System.exit(0));
        add(btnSalir);

        setSize(800, 680);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        //Vacía la lista del carrito
        limpiarCarrito(); 
    }
    
    // ---------------------- CLASES DE VALIDACIÓN ----------------------
    
    // Clase DocumentFilter para validar solo números
    class NumberOnlyFilter extends DocumentFilter {
        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            if (string.matches("\\d+")) { // Acepta solo dígitos
                super.insertString(fb, offset, string, attr);
            } else {
                 Toolkit.getDefaultToolkit().beep();
            }
        }
        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            if (text.matches("\\d*")) { // Acepta solo dígitos, incluyendo cadena vacía
                super.replace(fb, offset, length, text, attrs);
            } else {
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }
    
    // Clase DocumentFilter para validar solo letras y espacios
    class LetterOnlyFilter extends DocumentFilter {
        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            if (string.matches("[a-zA-Z\\sñÑáÁéÉíÍóÓúÚüÜ]+")) { // Acepta letras, espacios y caracteres especiales en español
                super.insertString(fb, offset, string, attr);
            } else {
                 Toolkit.getDefaultToolkit().beep();
            }
        }
        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            if (text.matches("[a-zA-Z\\sñÑáÁéÉíÍóÓúÚüÜ]*")) { // Acepta letras, espacios y caracteres especiales en español
                super.replace(fb, offset, length, text, attrs);
            } else {
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }

    // ---------------------- DIÁLOGO DE PAGO CON TARJETA ----------------------
    private void mostrarDialogoTarjeta() {
        JDialog dialog = new JDialog(this, "Datos de Tarjeta", true); // true para modal
        dialog.setLayout(new GridLayout(6, 2, 10, 10));
        dialog.setSize(350, 300);
        dialog.setLocationRelativeTo(this);
        dialog.getContentPane().setBackground(COLOR_FONDO.brighter());

        // Tipo de Tarjeta (Crédito/Débito)
        JRadioButton rbCredito = new JRadioButton("Crédito");
        JRadioButton rbDebito = new JRadioButton("Débito");
        ButtonGroup g = new ButtonGroup();
        g.add(rbCredito);
        g.add(rbDebito);
        
        rbCredito.setBackground(COLOR_FONDO.brighter());
        rbDebito.setBackground(COLOR_FONDO.brighter());
        
        JPanel pTipo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pTipo.setBackground(COLOR_FONDO.brighter());
        pTipo.add(rbCredito);
        pTipo.add(rbDebito);
        
        dialog.add(new JLabel("Tipo de Tarjeta:"));
        dialog.add(pTipo);

        // Número de Tarjeta (Solo números)
        JTextField txtNumTarjeta = new JTextField(numTarjeta);
        ((AbstractDocument) txtNumTarjeta.getDocument()).setDocumentFilter(new NumberOnlyFilter());
        dialog.add(new JLabel("Número de Tarjeta:"));
        dialog.add(txtNumTarjeta);

        // Fecha de Vencimiento
        JTextField txtFechaVenc = new JTextField(fechaVenc);
        dialog.add(new JLabel("Fecha de Vencimiento:"));
        dialog.add(txtFechaVenc);

        // CVV (Solo números)
        JTextField txtCVV = new JTextField(cvv);
        ((AbstractDocument) txtCVV.getDocument()).setDocumentFilter(new NumberOnlyFilter());
        dialog.add(new JLabel("CVV:"));
        dialog.add(txtCVV);
        
        // Botones de Acción
        JButton btnAceptar = new JButton("Aceptar");
        JButton btnCancelar = new JButton("Cancelar");

        btnAceptar.addActionListener(e -> {
            if (!rbCredito.isSelected() && !rbDebito.isSelected()) {
                JOptionPane.showMessageDialog(dialog, "Debes seleccionar Crédito o Débito.", "Error de Selección", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (txtNumTarjeta.getText().trim().isEmpty() || txtFechaVenc.getText().trim().isEmpty() || txtCVV.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(dialog, "Todos los campos son obligatorios.", "Error de Campos", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            // Guardar datos
            tipoTarjeta = rbCredito.isSelected() ? "Crédito" : "Débito";
            numTarjeta = txtNumTarjeta.getText().trim();
            fechaVenc = txtFechaVenc.getText().trim();
            cvv = txtCVV.getText().trim();
            
            rbTarjeta.setText("Tarjeta (" + tipoTarjeta + ")"); // Actualizar el texto del radio button
            dialog.dispose();
        });

        btnCancelar.addActionListener(e -> {
            rbTarjeta.setSelected(false); // Deseleccionar Tarjeta si cancela
            g.clearSelection();
            rbTarjeta.setText("Tarjeta"); 
            dialog.dispose();
        });
        
        dialog.add(btnAceptar);
        dialog.add(btnCancelar);

        dialog.setVisible(true);
    }
    
    // ---------------------- DIÁLOGO DE DATOS DE FACTURACIÓN ----------------------
    private boolean mostrarDialogoFacturacion() {
        JDialog dialog = new JDialog(this, "Datos de Facturación", true); // true para modal
        dialog.setLayout(new GridLayout(4, 2, 10, 10));
        dialog.setSize(400, 250);
        dialog.setLocationRelativeTo(this);
        dialog.getContentPane().setBackground(COLOR_FONDO.brighter());

        // Nombre (Solo letras y espacios)
        JTextField txtNombre = new JTextField(nombreFactura);
        ((AbstractDocument) txtNombre.getDocument()).setDocumentFilter(new LetterOnlyFilter());
        dialog.add(new JLabel("Nombre o Razón Social:"));
        dialog.add(txtNombre);

        // RFC (Acepta ambos: letras y números)
        JTextField txtRFC = new JTextField(rfcFactura);
        dialog.add(new JLabel("RFC:"));
        dialog.add(txtRFC);

        // Dirección (Acepta ambos: letras, números, y otros caracteres)
        JTextField txtDireccion = new JTextField(direccionFactura);
        dialog.add(new JLabel("Dirección (Calle, No, Col.):"));
        dialog.add(txtDireccion);
        
        // Botones de Acción
        JButton btnAceptar = new JButton("Generar Factura");
        JButton btnCancelar = new JButton("Cancelar");
        
        final boolean[] result = {false};

        btnAceptar.addActionListener(e -> {
            if (txtNombre.getText().trim().isEmpty() || txtRFC.getText().trim().isEmpty() || txtDireccion.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(dialog, "Todos los campos de facturación son obligatorios.", "Campos Faltantes", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            // Guardar datos
            nombreFactura = txtNombre.getText().trim();
            rfcFactura = txtRFC.getText().trim();
            direccionFactura = txtDireccion.getText().trim();
            
            result[0] = true; // Indicar que se debe continuar con la facturación
            dialog.dispose();
        });
        
        btnCancelar.addActionListener(e -> {
            dialog.dispose();
        });
        
        dialog.add(btnAceptar);
        dialog.add(btnCancelar);

        dialog.setVisible(true);
        return result[0];
    }
    
    //Listener para botones de agregar
    private void handleAgregar(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        try {
            JTextField cantField = (JTextField) source.getClientProperty("cantidad");
            int precio = (int) source.getClientProperty("precio");
            String nombre = (String) source.getClientProperty("nombre");
            
            int cant = Integer.parseInt(cantField.getText());
            if (cant > 0) {
                double s = cant * precio; 
                // El subtotal es la suma de todos los productos (Total con IVA incluido)
                subtotal += s; 
                ticket.append(nombre + " x" + cant + " = $" + String.format("%.2f", s) + "\n");
                actualizarTotales(); 
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingresa un número válido en la cantidad.");
        } catch (Exception ex) {
             // Manejar otras excepciones
        }
    }
    
    //Método para calcular y actualizar los labels de totales
    private void actualizarTotales() {
        // Cálculo según la solicitud: Total = suma de productos (variable 'subtotal')
        // Subtotal (sin IVA) = Total / 1.16
        totalSinIVA = subtotal / TASA_IVA_DIVISOR;
        // IVA = Total - Subtotal
        iva = subtotal - totalSinIVA;
        
        // Escriben las cantidades y usa String.format para que solo escriba dos decimales
        lblSubtotal.setText("SUBTOTAL: $" + String.format("%.2f", totalSinIVA));
        lblIVA.setText("IVA (16%): $" + String.format("%.2f", iva));
        lblTotal.setText("TOTAL: $" + String.format("%.2f", subtotal)); // Muestra 'subtotal' como el total
    }
    
    // Método para limpiar el carrito y reiniciar variables
    private void limpiarCarrito() {
        subtotal = 0;
        iva = 0;
        totalSinIVA = 0;
        
        ticket.setText("");
        
        //Resetea los campos de cantidad
        cantTlayDes.setText("0"); 
        cantMemelas.setText("0");
        cantEnchiladas.setText("0");
        cantMole.setText("0");
        cantTasajo.setText("0");
        cantPiedra.setText("0");
        cantTlayGran.setText("0");
        cantEmpanadas.setText("0");
        cantQuesa.setText("0");
        
        campoPago.setText("");
        
        // Deseleccionar RadioButtons y restablecer texto de Tarjeta
        if (rbEfectivo.isSelected() || rbTarjeta.isSelected() || rbTransferencia.isSelected()) {
            rbEfectivo.setSelected(false);
            rbTarjeta.setSelected(false);
            rbTransferencia.setSelected(false);
        }
        rbTarjeta.setText("Tarjeta"); 
        
        // Limpiar datos de tarjeta y facturación
        tipoTarjeta = "";
        numTarjeta = "";
        fechaVenc = "";
        cvv = "";
        nombreFactura = "";
        rfcFactura = "";
        direccionFactura = "";
        
        actualizarTotales();
    }

    //Bloque que permite la funcionalidad de facturar
    public void actionPerformed(ActionEvent e) {
        
        if (e.getActionCommand().equals("Generar factura")) {
            
            if (subtotal == 0) { // 'subtotal' ahora es el Total con IVA
                JOptionPane.showMessageDialog(this, "No añadiste nada al carrito. Agrega productos para facturar.");
                return;
            }
            
            String metodo = "";
            double cambio = 0;
            boolean pagoValido = false;

            if (rbEfectivo.isSelected()) {
                metodo = "EFECTIVO";
                try {
                    double pago = Double.parseDouble(campoPago.getText());
                    if (pago < subtotal) { // subtotal es el TOTAL a pagar
                        JOptionPane.showMessageDialog(this, "Pago insuficiente: Faltan $" + String.format("%.2f", subtotal - pago));
                        return;
                    }
                    cambio = pago - subtotal;
                    pagoValido = true;
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Ingresa un monto de pago válido para efectivo.");
                    return;
                }
            } 
            else if (rbTarjeta.isSelected()) {
                if (numTarjeta.isEmpty() || tipoTarjeta.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Completa los datos de la tarjeta para continuar.", "Datos de Tarjeta Faltantes", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                metodo = "TARJETA (" + tipoTarjeta + ")";
                pagoValido = true;
            }
            else if (rbTransferencia.isSelected()) {
                metodo = "TRANSFERENCIA";
                pagoValido = true;
            }
            else {
                JOptionPane.showMessageDialog(this, "Selecciona un método de pago.");
                return;
            }
            
            // Si el pago es válido, abrir el diálogo de facturación
            if (pagoValido) {
                if (mostrarDialogoFacturacion()) {
                    
                    // Facturación con los datos capturados y validados
                    JTextArea factura = new JTextArea();
                    factura.setEditable(false);

                    factura.append("       FACTURA GENERADA\n");
                    factura.append("=================================\n");
                    factura.append("RESTAURANTE OAXACA\n\n");
                    
                    // Datos de Facturación
                    factura.append("CLIENTE:\n");
                    factura.append("Nombre: " + nombreFactura + "\n");
                    factura.append("RFC: " + rfcFactura + "\n");
                    factura.append("Dirección: " + direccionFactura + "\n\n");
                    
                    // Detalle del Consumo
                    factura.append(ticket.getText()); 
                    
                    // Totales
                    factura.append("\nSUBTOTAL: $" + String.format("%.2f", totalSinIVA) +
                                   "\nIVA (16%): $" + String.format("%.2f", iva) +
                                   "\nTOTAL: $" + String.format("%.2f", subtotal) + "\n\n"); // subtotal es el TOTAL
        
                    factura.append("MÉTODO DE PAGO: " + metodo + "\n");
                    
                    if (metodo.contains("TARJETA")) {
                        factura.append("Tipo: " + tipoTarjeta + " | Terminación: **" + numTarjeta.substring(numTarjeta.length() - 4) + "\n");
                    }

                    if (metodo.equals("EFECTIVO")) {
                        factura.append("PAGO RECIBIDO: $" + String.format("%.2f", subtotal + cambio) + "\n");
                        factura.append("CAMBIO: $" + String.format("%.2f", cambio) + "\n");
                    }
                    factura.append("\nCÓDIGO DE BARRAS:\n");
                    factura.append("|| ||| ||||| || ||||| |\n\n");

                    factura.append("¡GRACIAS POR SU VISITA!\nVUELVA PRONTO\n");

                    JScrollPane sp = new JScrollPane(factura);
                    sp.setPreferredSize(new Dimension(400, 450));

                    JOptionPane.showMessageDialog(this, sp,
                        "FACTURA RESTAURANTE OAXACA",
                        JOptionPane.PLAIN_MESSAGE);
                        
                    // Limpia el carrito después de generar la factura
                    limpiarCarrito(); 
                }
            }
        }
    }

    public static void main(String[] args) {
        // Asegúrate de que el path de las imágenes sea correcto o coméntalas si no las tienes.
        new P4GabrielaAbigailEscamillaFloresOaxaca();
    }
}