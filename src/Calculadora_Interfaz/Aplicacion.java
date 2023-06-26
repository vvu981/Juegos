package Calculadora_Interfaz;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import gui.VentanaOperaciones;


public class Aplicacion {
OperacionesMatematicas misOperaciones;
	
	public Aplicacion() {
		misOperaciones = new OperacionesMatematicas();
		presentarVentana();
	}
	
	private void presentarVentana() {
		VentanaOperaciones miVentana = new VentanaOperaciones();
		miVentana.asignaOperaciones(misOperaciones);
		miVentana.setVisible(true);
	}

	
}
