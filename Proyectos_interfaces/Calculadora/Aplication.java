package Calculadora;

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

import gui.VentanaEleccion;
import gui.VentanaOperaciones;


public class Aplication {
Operaciones misOperaciones;
	
	public Aplication() {
		misOperaciones = new Operaciones();
		presentarVentana();
	}
	
	private void presentarVentana() {
		VentanaEleccion miVentana = new VentanaEleccion(misOperaciones);
		
		miVentana.setVisible(true);
	}

	
}
