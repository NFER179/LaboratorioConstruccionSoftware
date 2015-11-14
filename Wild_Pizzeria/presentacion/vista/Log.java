package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controlador.LogControlador;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Log extends JFrame {

	private LogControlador controlador;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JButton btnAceptar;
	private JButton btnCancelar;

	public Log() {
				
		this.controlador = new LogControlador(this);
		
		this.setTitle("Log");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 340, 107);
		
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		this.contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(10, 14, 89, 14);
		this.contentPane.add(lblContrasea);
		
		this.passwordField = new JPasswordField();
		this.passwordField.setBounds(97, 8, 193, 20);
		this.contentPane.add(passwordField);
		
		this.btnAceptar = new JButton("Aceptar");
		this.btnAceptar.addActionListener(controlador);
		this.btnAceptar.setBounds(58, 39, 89, 23);
		this.contentPane.add(btnAceptar);
		
		this.btnCancelar = new JButton("Cancelar");
		this.btnCancelar.addActionListener(controlador);
		this.btnCancelar.setBounds(178, 39, 89, 23);
		this.contentPane.add(btnCancelar);
	}

	public void Open() {
		this.setVisible(true);
	}
	
	public void Close() {
		this.dispose();
	}
	
	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}	
}