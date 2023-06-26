package gui;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Calculadora.Operaciones;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class VentanaEleccion extends JFrame{
	
	public VentanaEleccion(Operaciones misOperaciones) {
		
		JButton btnSuma = new JButton("SUMAR");
		btnSuma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaSuma ventanaSuma = new VentanaSuma();
				ventanaSuma.asignaOperaciones(misOperaciones);
				ventanaSuma.setVisible(true);
			}
		});
		
		JButton btnRestar = new JButton("RESTAR");
		btnRestar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaResta ventanaResta = new VentanaResta();
				ventanaResta.asignaOperaciones(misOperaciones);
				ventanaResta.setVisible(true);
			}
		});
		
		JButton btnMultiplicar = new JButton("MULTIPLICAR");
		btnMultiplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaMult VentanaMult = new VentanaMult();
				VentanaMult.asignaOperaciones(misOperaciones);
				VentanaMult.setVisible(true);
			}
		});
		
		JButton btnDividir = new JButton("DIVIDIR");
		btnDividir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaDiv VentanaDiv = new VentanaDiv();
				VentanaDiv.asignaOperaciones(misOperaciones);
				VentanaDiv.setVisible(true);
			}
		});
		
		JButton btnEcuaciongrado = new JButton("ECUACION 2\u00BAGRADO");
		btnEcuaciongrado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaEc VentanaEc = new VentanaEc();
				VentanaEc.asignaOperaciones(misOperaciones);
				VentanaEc.setVisible(true);
			}
		});
		
		
		JButton btnPotencia = new JButton("POTENCIA");
		
		JLabel lblOperaciones = new JLabel("OPERACIONES MATEMATICAS");
		lblOperaciones.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOperaciones.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnSuma, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnMultiplicar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 176, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnDividir, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRestar, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
					.addGap(23))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(172, Short.MAX_VALUE)
					.addComponent(btnPotencia, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addGap(156))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(159, Short.MAX_VALUE)
					.addComponent(btnEcuaciongrado)
					.addGap(140))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(118, Short.MAX_VALUE)
					.addComponent(lblOperaciones)
					.addGap(112))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(lblOperaciones)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSuma)
						.addComponent(btnRestar))
					.addGap(18)
					.addComponent(btnEcuaciongrado, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnMultiplicar)
						.addComponent(btnDividir))
					.addGap(32)
					.addComponent(btnPotencia)
					.addContainerGap(51, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
}
