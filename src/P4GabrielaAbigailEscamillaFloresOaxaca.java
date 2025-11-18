/***
*Programa: P4JGabrielaAbilgailEscamillaFloresOaxaca.java
*Autor: Escamilla Flores Gabriela Abigail
        Ulage Parias Jorge Adan
*Fecha: 17/11/2025
*Descripcion: Se debe de realizar una aplicación para un restaurante de comida típica mexicana que pueda llevar el control y 
facturacion de los platillos que se sirven. 


***/
/*Bibliotecas*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class P4GabrielaAbigailEscamillaFloresOaxaca extends JFrame 
    implements ActionListener {

    //Paneles a ocupar
    private JPanel panel1,panel2;
    //Botones a ocupar
    private JButton añadir, eliminar, listo, salir;

    public static void main(String[] args) {
    	P4GabrielaAbigailEscamillaFloresOaxaca marco = new P4GabrielaAbigailEscamillaFloresOaxaca();
        marco.setSize(1100, 900);
        marco.setTitle("Ejemplo Clase con dos Panels");
        marco.crearGUI();
        marco.setVisible(true);
    }
    
    private void crearGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container ventana = getContentPane();
        ventana.setLayout(new FlowLayout() );

		//PanelIzquierdo
		panel1 = new JPanel();
		panel1.setPreferredSize(new Dimension(450, 480));
		panel1.setBackground(Color.CYAN);
		ventana.add(panel1);
		
		//PanelDerecho
		panel2 = new JPanel();
    	panel2.setPreferredSize(new Dimension(450, 480));
    	panel2.setBackground(Color.lightGray);
    	ventana.add(panel2);
    			
	}
    

    public void actionPerformed(ActionEvent event) {

    }
}
