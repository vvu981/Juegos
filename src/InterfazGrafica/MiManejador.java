package InterfazGrafica;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.event.ActionListener;

//Clase que implementa la interfaz ActionListener
public class MiManejador implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		MiManejador manejador = new MiManejador();
		JButton boton1 = InterfazGrafica.Prueba_InterfazGrafica.boton1;
		JButton boton2 = InterfazGrafica.Prueba_InterfazGrafica.boton2;
		JTextField cajaNombre = InterfazGrafica.Prueba_InterfazGrafica.cajaNombre;
		JTextField primero =  InterfazGrafica.Prueba_InterfazGrafica.primero;
		JTextField segundo = InterfazGrafica.Prueba_InterfazGrafica.segundo;

		
		String cadena = "";
		JButton boton = (JButton) e.getSource();
		double x;
		if (boton == boton1) {
			
			cadena += "Suma: \n " + primero ;
			
		} else if (boton == boton2) {
			cadena += "Resta\n";
		}
		JOptionPane.showMessageDialog(null, cadena);
		
	}
	
}

