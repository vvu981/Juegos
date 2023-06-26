package gui;


import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

public class VentanaOperaciones extends JFrame implements ActionListener {

	private JPanel mainPanel;
	private JTextField txtNum1;
	private JTextField txtNum2;

	JButton btnSuma = new JButton("SUMA");

	JButton btnResta = new JButton("RESTA");

	JButton btnMul = new JButton("MUL");

	JButton btnDiv = new JButton("DIV");

	OperacionesMatematicas misOperaciones;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { VentanaOperaciones frame = new
	 * VentanaOperaciones(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */
	/**
	 * Create the frame.
	 */
	public VentanaOperaciones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		iniciarComponentes();

		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Ventana Operaciones");

	}

	private void iniciarComponentes() {

		setBounds(100, 100, 483, 397);
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(mainPanel);

		JLabel Label1 = new JLabel("Operaciones matematicas");
		Label1.setHorizontalAlignment(SwingConstants.CENTER);
		Label1.setFont(new Font("Tahoma", Font.PLAIN, 15));

		txtNum1 = new JTextField();
		txtNum1.setColumns(10);

		txtNum2 = new JTextField();
		txtNum2.setColumns(10);

		JLabel lblNum1 = new JLabel("Num1");
		lblNum1.setFont(new Font("Times New Roman", Font.PLAIN, 17));

		JLabel lblNum2 = new JLabel("Num2");
		lblNum2.setFont(new Font("Times New Roman", Font.PLAIN, 17));

		btnSuma.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSuma.addActionListener(this);

		btnResta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnResta.addActionListener(this);

		btnMul.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnMul.addActionListener(this);

		btnDiv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDiv.addActionListener(this);

		GroupLayout gl_mainPanel = new GroupLayout(mainPanel);
		gl_mainPanel.setHorizontalGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_mainPanel
				.createSequentialGroup().addGap(76)
				.addGroup(gl_mainPanel.createParallelGroup(Alignment.TRAILING).addGroup(gl_mainPanel
						.createSequentialGroup()
						.addGroup(gl_mainPanel.createParallelGroup(Alignment.TRAILING).addComponent(lblNum1)
								.addComponent(lblNum2, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(txtNum2, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 200,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(txtNum1, GroupLayout.PREFERRED_SIZE, 200,
												GroupLayout.PREFERRED_SIZE))
								.addComponent(Label1, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(131, Short.MAX_VALUE))
						.addGroup(gl_mainPanel.createSequentialGroup()
								.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING).addComponent(btnSuma)
										.addComponent(btnMul, GroupLayout.PREFERRED_SIZE, 75,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
								.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(btnDiv, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btnResta, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE))
								.addGap(104)))));
		gl_mainPanel
				.setVerticalGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_mainPanel.createSequentialGroup().addContainerGap()
								.addComponent(Label1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addGap(25)
								.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(txtNum1, GroupLayout.PREFERRED_SIZE, 42,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNum1))
								.addGap(39)
								.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(txtNum2, GroupLayout.PREFERRED_SIZE, 42,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNum2, GroupLayout.PREFERRED_SIZE, 21,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE).addComponent(btnSuma)
										.addComponent(btnResta))
								.addGap(33)
								.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnMul, GroupLayout.PREFERRED_SIZE, 29,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnDiv, GroupLayout.PREFERRED_SIZE, 29,
												GroupLayout.PREFERRED_SIZE))
								.addContainerGap(58, Short.MAX_VALUE)));
		mainPanel.setLayout(gl_mainPanel);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (btnSuma == e.getSource()) {
			double resultado = misOperaciones.Suma(Double.parseDouble(txtNum1.getText()),
					Double.parseDouble(txtNum2.getText()));
			if (resultado % 1 == 0)
				JOptionPane.showMessageDialog(null, (int) resultado);
			else
				JOptionPane.showMessageDialog(null, resultado);

		}
		if (btnResta == e.getSource()) {
			double resultado = misOperaciones.Resta(Double.parseDouble(txtNum1.getText()),
					Double.parseDouble(txtNum2.getText()));
			if (resultado % 1 == 0)
				JOptionPane.showMessageDialog(null, (int) resultado);
			else
				JOptionPane.showMessageDialog(null, resultado);
		}
		if (btnMul == e.getSource()) {
			double resultado = misOperaciones.Mult(Double.parseDouble(txtNum1.getText()),
					Double.parseDouble(txtNum2.getText()));
			if (resultado % 1 == 0)
				JOptionPane.showMessageDialog(null, (int) resultado);
			else
				JOptionPane.showMessageDialog(null, resultado);
		}
		if (btnDiv == e.getSource()) {

			String resultado = misOperaciones.Div(Double.parseDouble(txtNum1.getText()),
					Double.parseDouble(txtNum2.getText()));
			if (Double.parseDouble(txtNum2.getText()) != 0)
				JOptionPane.showMessageDialog(null, resultado + "\nResto: "
						+ (int) (Double.parseDouble(txtNum1.getText()) % Double.parseDouble(txtNum2.getText())));
			else
				JOptionPane.showMessageDialog(null, "No se puede dividir entre 0");

		}
	}

	public void asignaOperaciones(OperacionesMatematicas misOperaciones) {

		this.misOperaciones = misOperaciones;

	}
}
