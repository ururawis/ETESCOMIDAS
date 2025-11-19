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
import javax.swing.border.*;

public class P4GabrielaAbigailEscamillaFloresOaxaca extends JFrame implements ActionListener {

    JTextArea ticket;

    // Cantidades
    JTextField cantTlayDes, cantMemelas, cantEnchiladas;
    JTextField cantMole, cantTasajo, cantPiedra;
    JTextField cantTlayGran, cantEmpanadas, cantQuesa;

    // Pago
    JRadioButton rbEfectivo, rbTarjeta, rbTransferencia;
    JTextField campoPago;

    // Totales
    double subtotal = 0;
    double iva = 0;
    double total = 0;

    public P4GabrielaAbigailEscamillaFloresOaxaca() {

        super("Restaurante Oaxaca");
        setLayout(null);

        // PANEL MENÚ
        JPanel menu = new JPanel(null);
        menu.setBounds(20, 20, 520, 600);
        menu.setBackground(new Color(255, 240, 240));
        menu.setBorder(new LineBorder(Color.RED, 3));
        add(menu);

        JLabel titulo = new JLabel("MENÚ OAXACA");
        titulo.setFont(new Font("Arial", Font.BOLD, 26));
        titulo.setBounds(150, 10, 300, 40);
        menu.add(titulo);

        // CARRITO
        ticket = new JTextArea();
        ticket.setEditable(false);
        JScrollPane scroll = new JScrollPane(ticket);
        scroll.setBounds(560, 200, 200, 350);
        add(scroll);

        JLabel lblTicket = new JLabel("CARRITO:");
        lblTicket.setFont(new Font("Arial", Font.BOLD, 16));
        lblTicket.setBounds(560, 170, 200, 25);
        add(lblTicket);

        // ---------------------- DESAYUNOS ----------------------

        JLabel d = new JLabel("DESAYUNOS");
        d.setFont(new Font("Arial", Font.BOLD, 18));
        d.setBounds(20, 60, 200, 25);
        menu.add(d);

        // TLAYUDA DESAYUNO
        JLabel img1 = new JLabel(new ImageIcon("tlayuda.png"));
        img1.setBounds(20, 100, 40, 40);
        menu.add(img1);

        JLabel l1 = new JLabel("Tlayuda desayuno $80");
        l1.setBounds(70, 100, 200, 25);
        menu.add(l1);

        cantTlayDes = new JTextField("0");
        cantTlayDes.setBounds(280, 100, 50, 25);
        menu.add(cantTlayDes);

        JButton b1 = new JButton("Agregar");
        b1.setBounds(350, 100, 100, 25);
        menu.add(b1);

        b1.addActionListener(e -> {
            try {
                int cant = Integer.parseInt(cantTlayDes.getText());
                if (cant > 0) {
                    double s = cant * 80;
                    subtotal += s;
                    ticket.append("Tlayuda desayuno x" + cant + " = $" + s + "\n");
                }
            } catch (Exception ex) {}
        });

        // MEMELAS
        JLabel img2 = new JLabel(new ImageIcon("memelas.png"));
        img2.setBounds(20, 140, 40, 40);
        menu.add(img2);

        JLabel l2 = new JLabel("Memelas $40");
        l2.setBounds(70, 140, 200, 25);
        menu.add(l2);

        cantMemelas = new JTextField("0");
        cantMemelas.setBounds(280, 140, 50, 25);
        menu.add(cantMemelas);

        JButton b2 = new JButton("Agregar");
        b2.setBounds(350, 140, 100, 25);
        menu.add(b2);

        b2.addActionListener(e -> {
            try {
                int cant = Integer.parseInt(cantMemelas.getText());
                if (cant > 0) {
                    double s = cant * 40;
                    subtotal += s;
                    ticket.append("Memelas x" + cant + " = $" + s + "\n");
                }
            } catch (Exception ex) {}
        });

        // ENCHILADAS
        JLabel img3 = new JLabel(new ImageIcon("enchiladas.png"));
        img3.setBounds(20, 180, 40, 40);
        menu.add(img3);

        JLabel l3 = new JLabel("Enchiladas verdes $70");
        l3.setBounds(70, 180, 200, 25);
        menu.add(l3);

        cantEnchiladas = new JTextField("0");
        cantEnchiladas.setBounds(280, 180, 50, 25);
        menu.add(cantEnchiladas);

        JButton b3 = new JButton("Agregar");
        b3.setBounds(350, 180, 100, 25);
        menu.add(b3);

        b3.addActionListener(e -> {
            try {
                int cant = Integer.parseInt(cantEnchiladas.getText());
                if (cant > 0) {
                    double s = cant * 70;
                    subtotal += s;
                    ticket.append("Enchiladas verdes x" + cant + " = $" + s + "\n");
                }
            } catch (Exception ex) {}
        });

        // ---------------------- COMIDAS ----------------------

        JLabel c = new JLabel("COMIDAS");
        c.setFont(new Font("Arial", Font.BOLD, 18));
        c.setBounds(20, 230, 200, 25);
        menu.add(c);

        // MOLE NEGRO
        JLabel img4 = new JLabel(new ImageIcon("mole.png"));
        img4.setBounds(20, 270, 40, 40);
        menu.add(img4);

        JLabel l4 = new JLabel("Mole negro $120");
        l4.setBounds(70, 270, 200, 25);
        menu.add(l4);

        cantMole = new JTextField("0");
        cantMole.setBounds(280, 270, 50, 25);
        menu.add(cantMole);

        JButton b4 = new JButton("Agregar");
        b4.setBounds(350, 270, 100, 25);
        menu.add(b4);

        b4.addActionListener(e -> {
            try {
                int cant = Integer.parseInt(cantMole.getText());
                if (cant > 0) {
                    double s = cant * 120;
                    subtotal += s;
                    ticket.append("Mole negro x" + cant + " = $" + s + "\n");
                }
            } catch (Exception ex) {}
        });

        // TASAJO
        JLabel img5 = new JLabel(new ImageIcon("tasajo.png"));
        img5.setBounds(20, 310, 40, 40);
        menu.add(img5);

        JLabel l5 = new JLabel("Tasajo con frijoles $150");
        l5.setBounds(70, 310, 200, 25);
        menu.add(l5);

        cantTasajo = new JTextField("0");
        cantTasajo.setBounds(280, 310, 50, 25);
        menu.add(cantTasajo);

        JButton b5 = new JButton("Agregar");
        b5.setBounds(350, 310, 100, 25);
        menu.add(b5);

        b5.addActionListener(e -> {
            try {
                int cant = Integer.parseInt(cantTasajo.getText());
                if (cant > 0) {
                    double s = cant * 150;
                    subtotal += s;
                    ticket.append("Tasajo con frijoles x" + cant + " = $" + s + "\n");
                }
            } catch (Exception ex) {}
        });

        // CALDO DE PIEDRA
        JLabel img6 = new JLabel(new ImageIcon("piedra.png"));
        img6.setBounds(20, 350, 40, 40);
        menu.add(img6);

        JLabel l6 = new JLabel("Caldo de piedra $110");
        l6.setBounds(70, 350, 200, 25);
        menu.add(l6);

        cantPiedra = new JTextField("0");
        cantPiedra.setBounds(280, 350, 50, 25);
        menu.add(cantPiedra);

        JButton b6 = new JButton("Agregar");
        b6.setBounds(350, 350, 100, 25);
        menu.add(b6);

        b6.addActionListener(e -> {
            try {
                int cant = Integer.parseInt(cantPiedra.getText());
                if (cant > 0) {
                    double s = cant * 110;
                    subtotal += s;
                    ticket.append("Caldo de piedra x" + cant + " = $" + s + "\n");
                }
            } catch (Exception ex) {}
        });

        // ---------------------- CENAS ----------------------

        JLabel e = new JLabel("CENAS");
        e.setFont(new Font("Arial", Font.BOLD, 18));
        e.setBounds(20, 400, 200, 25);
        menu.add(e);

        // TLAYUDA GRANDE
        JLabel img7 = new JLabel(new ImageIcon("tlayuda_grande.png"));
        img7.setBounds(20, 440, 40, 40);
        menu.add(img7);

        JLabel l7 = new JLabel("Tlayuda grande $100");
        l7.setBounds(70, 440, 200, 25);
        menu.add(l7);

        cantTlayGran = new JTextField("0");
        cantTlayGran.setBounds(280, 440, 50, 25);
        menu.add(cantTlayGran);

        JButton b7 = new JButton("Agregar");
        b7.setBounds(350, 440, 100, 25);
        menu.add(b7);

        b7.addActionListener(e2 -> {
            try {
                int cant = Integer.parseInt(cantTlayGran.getText());
                if (cant > 0) {
                    double s = cant * 100;
                    subtotal += s;
                    ticket.append("Tlayuda grande x" + cant + " = $" + s + "\n");
                }
            } catch (Exception ex) {}
        });

        // EMPANADAS
        JLabel img8 = new JLabel(new ImageIcon("empanadas.png"));
        img8.setBounds(20, 480, 40, 40);
        menu.add(img8);

        JLabel l8 = new JLabel("Empanadas amarillo $60");
        l8.setBounds(70, 480, 200, 25);
        menu.add(l8);

        cantEmpanadas = new JTextField("0");
        cantEmpanadas.setBounds(280, 480, 50, 25);
        menu.add(cantEmpanadas);

        JButton b8 = new JButton("Agregar");
        b8.setBounds(350, 480, 100, 25);
        menu.add(b8);

        b8.addActionListener(e2 -> {
            try {
                int cant = Integer.parseInt(cantEmpanadas.getText());
                if (cant > 0) {
                    double s = cant * 60;
                    subtotal += s;
                    ticket.append("Empanadas amarillo x" + cant + " = $" + s + "\n");
                }
            } catch (Exception ex) {}
        });

        // QUESADILLAS
        JLabel img9 = new JLabel(new ImageIcon("quesadilla.png"));
        img9.setBounds(20, 520, 40, 40);
        menu.add(img9);

        JLabel l9 = new JLabel("Quesadillas flor $50");
        l9.setBounds(70, 520, 200, 25);
        menu.add(l9);

        cantQuesa = new JTextField("0");
        cantQuesa.setBounds(280, 520, 50, 25);
        menu.add(cantQuesa);

        JButton b9 = new JButton("Agregar");
        b9.setBounds(350, 520, 100, 25);
        menu.add(b9);

        b9.addActionListener(e2 -> {
            try {
                int cant = Integer.parseInt(cantQuesa.getText());
                if (cant > 0) {
                    double s = cant * 50;
                    subtotal += s;
                    ticket.append("Quesadillas flor x" + cant + " = $" + s + "\n");
                }
            } catch (Exception ex) {}
        });

        // ---------------------- MÉTODO DE PAGO ----------------------

        rbEfectivo = new JRadioButton("Efectivo");
        rbTarjeta = new JRadioButton("Tarjeta");
        rbTransferencia = new JRadioButton("Transferencia");

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
        add(lp);

        campoPago = new JTextField();
        campoPago.setBounds(630, 120, 100, 25);
        add(campoPago);

        JButton generar = new JButton("Generar factura");
        generar.setBounds(560, 150, 200, 30);
        generar.addActionListener(this);
        add(generar);

        JButton salir = new JButton("Salir");
        salir.setBounds(560, 560, 200, 30);
        salir.addActionListener(e3 -> System.exit(0));
        add(salir);

        // Ventana
        setSize(800, 680);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    // ---------------------- FACTURA ----------------------

    public void actionPerformed(ActionEvent e) {

        iva = subtotal * 0.16;
        total = subtotal + iva;

        String metodo = "";
        double cambio = 0;

        if (rbEfectivo.isSelected()) {
            metodo = "EFECTIVO";
            try {
                double pago = Double.parseDouble(campoPago.getText());
                if (pago < total) {
                    JOptionPane.showMessageDialog(this, "Pago insuficiente");
                    return;
                }
                cambio = pago - total;
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Ingresa pago válido");
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
            JOptionPane.showMessageDialog(this, "Selecciona método de pago");
            return;
        }

        JTextArea factura = new JTextArea();
        factura.setEditable(false);

        factura.append("        FACTURA GENERADA\n");
        factura.append("=================================\n");
        factura.append("RESTAURANTE OAXACA\n\n");
        factura.append(ticket.getText());
        factura.append("\nSUBTOTAL: $" + subtotal +
                       "\nIVA (16%): $" + iva +
                       "\nTOTAL: $" + total + "\n\n");

        factura.append("MÉTODO DE PAGO: " + metodo + "\n");

        if (metodo.equals("EFECTIVO")) {
            factura.append("CAMBIO: $" + cambio + "\n");
        }
        factura.append("\nCÓDIGO DE BARRAS:\n");
        factura.append("|| ||| ||||| || ||||| |\n\n");

        factura.append("¡GRACIAS POR SU VISITA!\nVUELVA PRONTO\n");

        JScrollPane sp = new JScrollPane(factura);
        sp.setPreferredSize(new Dimension(400, 450));

        JOptionPane.showMessageDialog(this, sp,
            "FACTURA RESTAURANTE OAXACA",
            JOptionPane.PLAIN_MESSAGE);
    }

    public static void main(String[] args) {
        new P4GabrielaAbigailEscamillaFloresOaxaca();
    }
}
