package gui;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Calculadora.Operaciones;
import Calculadora_Interfaz.OperacionesMatematicas;

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

public class VentanaResta extends JFrame implements ActionListener{
	private JTextField txtNum1;
	private JTextField txtNum2;
	Operaciones oper;
	JButton btnSumar;
	
	public VentanaResta() {
		asignaOperaciones(oper);
		txtNum1 = new JTextField();
		txtNum1.setColumns(10);
		
		txtNum2 = new JTextField();
		txtNum2.setColumns(10);
		
		JLabel lblNum1Suma = new JLabel("Numero 1");
		
		JLabel lblNum2Suma = new JLabel("Numero 2");
		
		btnSumar = new JButton("RESTAR");
		btnSumar.addActionListener(this);

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(60, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNum1Suma, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNum2Suma, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
							.addGap(30)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtNum2, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtNum1, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
							.addGap(147))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnSumar)
							.addGap(175))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(79)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNum1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNum1Suma))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNum2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNum2Suma))
					.addGap(27)
					.addComponent(btnSumar)
					.addContainerGap(44, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	
		if (btnSumar == e.getSource()) {
			
			double resultado = oper.Restar(Double.parseDouble(txtNum1.getText()),
					Double.parseDouble(txtNum2.getText()));
			if (resultado % 1 == 0)
				JOptionPane.showMessageDialog(null, (int) resultado);
			else
				JOptionPane.showMessageDialog(null, resultado);
			
		}
		
		
	}
	
	public void asignaOperaciones(Operaciones misOperaciones) {

		this.oper = misOperaciones;

	}
}
