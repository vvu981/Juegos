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

public class VentanaEc extends JFrame implements ActionListener {
	Operaciones oper;
	JButton btnSumar;
	private JTextField txtValor1;
	private JLabel lblValor1;
	private JLabel lblPot;
	private JLabel lblNewLabel;
	private JTextField txtValorx;
	private JLabel lblValor1_1;
	private JLabel lblNewLabel_1;
	private JTextField txtValorconst;

	public VentanaEc() {
		asignaOperaciones(oper);

		btnSumar = new JButton("Ecuacion");
		btnSumar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSumar.addActionListener(this);

		txtValor1 = new JTextField();
		txtValor1.setColumns(10);

		lblValor1 = new JLabel("x");
		lblValor1.setFont(new Font("Tahoma", Font.PLAIN, 17));

		lblPot = new JLabel("2");

		lblNewLabel = new JLabel("+");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));

		txtValorx = new JTextField();
		txtValorx.setColumns(10);

		lblValor1_1 = new JLabel("x");
		lblValor1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));

		lblNewLabel_1 = new JLabel("+");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));

		txtValorconst = new JTextField();
		txtValorconst.setColumns(10);

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(115)
				.addComponent(txtValor1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblValor1)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSumar, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup().addComponent(lblPot)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblNewLabel)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(txtValorx, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblValor1_1, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
								.addGap(18).addComponent(txtValorconst, GroupLayout.PREFERRED_SIZE, 23,
										GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(135, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
						.createSequentialGroup().addGap(51)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
								.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblValor1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtValor1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel).addComponent(txtValorx, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblValor1_1, GroupLayout.PREFERRED_SIZE, 49,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 21,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(txtValorconst, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup().addGap(63).addComponent(lblPot)))
				.addGap(18).addComponent(btnSumar, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(100, Short.MAX_VALUE)));
		getContentPane().setLayout(groupLayout);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (btnSumar == e.getSource()) {

			String resultado = oper.Ec(Double.parseDouble(txtValor1.getText()), Double.parseDouble(txtValorx.getText()),
					Double.parseDouble(txtValorconst.getText()));
			JOptionPane.showMessageDialog(null, resultado);

		}

	}

	public void asignaOperaciones(Operaciones misOperaciones) {

		this.oper = misOperaciones;

	}
}
