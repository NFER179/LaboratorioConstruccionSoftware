package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;

public class CreacionUserVista extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtContra1;
	private JPasswordField txtContra2;
	private JButton btnGuardar;

	/**
	 * Create the frame.
	 */
	public CreacionUserVista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 337, 253);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(117, 185, 89, 23);
		contentPane.add(btnGuardar);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(163, 61, 86, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		txtContra1 = new JPasswordField();
		txtContra1.setBounds(163, 92, 86, 20);
		contentPane.add(txtContra1);

		txtContra2 = new JPasswordField();
		txtContra2.setBounds(163, 123, 86, 20);
		contentPane.add(txtContra2);
		
		JLabel lblBienvenidoAPizzeria = new JLabel("Bienvenido a Pizzeria Wild");
		lblBienvenidoAPizzeria.setBounds(87, 11, 132, 14);
		contentPane.add(lblBienvenidoAPizzeria);
		
		JLabel lblPorFavorIngrese = new JLabel("Por favor ingrese su usuario y contrase\u00F1a para la base de datos:");
		lblPorFavorIngrese.setBounds(10, 36, 319, 14);
		contentPane.add(lblPorFavorIngrese);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(107, 64, 46, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(87, 95, 66, 14);
		contentPane.add(lblContrasea);
		
		JLabel lblRepitaLaContrasea = new JLabel("Repita la contrase\u00F1a:");
		lblRepitaLaContrasea.setBounds(44, 126, 109, 14);
		contentPane.add(lblRepitaLaContrasea);
	}

	public JTextField getTxtUsuario() {
		return txtUsuario;
	}

	public void setTxtUsuario(JTextField txtUsuario) {
		this.txtUsuario = txtUsuario;
	}

	public JPasswordField getTxtContra1() {
		return txtContra1;
	}

	public void setTxtContra1(JPasswordField txtContra1) {
		this.txtContra1 = txtContra1;
	}

	public JPasswordField getTxtContra2() {
		return txtContra2;
	}

	public void setTxtContra2(JPasswordField txtContra2) {
		this.txtContra2 = txtContra2;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}

	public void Open() {
		this.setVisible(true);
	}

	public void Close() {
		this.setVisible(false);

	}
}
