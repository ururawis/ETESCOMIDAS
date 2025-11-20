//package prueba;

/***
*Programa: P4JGabrielaAbilgailEscamillaFloresOaxaca.java
*Autor: Escamilla Flores Gabriela Abigail
* Ulage Parias Jorge Adan
*Fecha: 17/11/2025
*Descripcion: Aplicación para restaurante de Oaxaca,
* control de platillos, facturación, IVA y métodos de pago.
***/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

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

    double subtotal = 0;
    double iva = 0;
    double total = 0;
    final double TASA_IVA = 0.16; // Constante para la tasa de IVA (16%)

    public P4GabrielaAbigailEscamillaFloresOaxaca() {

        super("Restaurante Oaxaca");
        setLayout(null); 
        getContentPane().setBackground(COLOR_FONDO); // Fondo principal

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

        //TLAYUDA DESAYUNO
        JLabel img1 = new JLabel(new ImageIcon(getClass().getResource("tlayuda.jpg")));
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

        //MEMELAS
        JLabel img2 = new JLabel(new ImageIcon(getClass().getResource("memelas.jpg")));
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

        //ENCHILADAS
        JLabel img3 = new JLabel(new ImageIcon(getClass().getResource("enchiladas.jpg")));
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

        //MOLE NEGRO
        JLabel img4 = new JLabel(new ImageIcon(getClass().getResource("mole.jpg")));
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

        //TASAJO
        JLabel img5 = new JLabel(new ImageIcon(getClass().getResource("tasajo.jfif")));
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

        //CALDO DE PIEDRA
        JLabel img6 = new JLabel(new ImageIcon(getClass().getResource("piedra.jfif")));
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

        //TLAYUDA GRANDE
        JLabel img7 = new JLabel(new ImageIcon(getClass().getResource("tlayuda_grande.jpg")));
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

        //EMPANADAS
        JLabel img8 = new JLabel(new ImageIcon(getClass().getResource("empanadas.jpeg")));
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

        //QUESADILLAS
        JLabel img9 = new JLabel(new ImageIcon(getClass().getResource("quesadilla.jfif")));
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
        iva = subtotal * TASA_IVA;
        total = subtotal + iva;
        
        // Escriben las cantidades y usa String.format para que solo escriba dos decimales
        lblSubtotal.setText("SUBTOTAL: $" + String.format("%.2f", subtotal));
        lblIVA.setText("IVA (16%): $" + String.format("%.2f", iva));
        lblTotal.setText("TOTAL: $" + String.format("%.2f", total));
    }
    
    // Método para limpiar el carrito y reiniciar variables
    private void limpiarCarrito() {
        subtotal = 0;
        iva = 0;
        total = 0;
        
        ticket.setText("");
        
        //Resetea los campos de cantidad -- les pone vacío
        cantTlayDes.setText("");
        cantMemelas.setText("");
        cantEnchiladas.setText("");
        cantMole.setText("");
        cantTasajo.setText("");
        cantPiedra.setText("");
        cantTlayGran.setText("");
        cantEmpanadas.setText("");
        cantQuesa.setText("");
        
        campoPago.setText("");
        
        // Deseleccionar RadioButtons
        if (rbEfectivo.isSelected() || rbTarjeta.isSelected() || rbTransferencia.isSelected()) {
            rbEfectivo.setSelected(false);
            rbTarjeta.setSelected(false);
            rbTransferencia.setSelected(false);
        }
        
        actualizarTotales();
    }

    //Bloque que permite la funcionalidad de facturar
    public void actionPerformed(ActionEvent e) {
        
        if (e.getActionCommand().equals("Generar factura")) {
            if (subtotal == 0) {
                JOptionPane.showMessageDialog(this, "No añadiste nada al carrito. Agrega productos para facturar.");
                return;
            }
            
            iva = subtotal * TASA_IVA;
            total = subtotal + iva;

            String metodo = "";
            double cambio = 0;

            if (rbEfectivo.isSelected()) {
                metodo = "EFECTIVO";
                try {
                    double pago = Double.parseDouble(campoPago.getText());
                    if (pago < total) {
                        JOptionPane.showMessageDialog(this, "Pago insuficiente: Faltan $" + String.format("%.2f", total - pago));
                        return;
                    }
                    cambio = pago - total;
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Ingresa un monto de pago válido para efectivo.");
                    return;
                }
            } 
            else if (rbTarjeta.isSelected()) {
                metodo = "TARJETA";
            }
            else if (rbTransferencia.isSelected()) {
                metodo = "TRANSFERENCIA";
            }
            else {
                JOptionPane.showMessageDialog(this, "Selecciona un método de pago.");
                return;
            }

            JTextArea factura = new JTextArea();
            factura.setEditable(false);

            factura.append("        FACTURA GENERADA\n");
            factura.append("=================================\n");
            factura.append("RESTAURANTE OAXACA\n\n");
            factura.append(ticket.getText()); 
            factura.append("\nSUBTOTAL: $" + String.format("%.2f", subtotal) +
                           "\nIVA (16%): $" + String.format("%.2f", iva) +
                           "\nTOTAL: $" + String.format("%.2f", total) + "\n\n");

            factura.append("MÉTODO DE PAGO: " + metodo + "\n");

            if (metodo.equals("EFECTIVO")) {
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

    public static void main(String[] args) {
        new P4GabrielaAbigailEscamillaFloresOaxaca();
    }
}