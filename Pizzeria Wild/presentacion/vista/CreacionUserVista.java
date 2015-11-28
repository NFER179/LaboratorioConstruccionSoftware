package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.ImageIcon;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(CreacionUserVista.class.getResource("/Iconos/pizza_1.PNG")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 463, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnGuardar = new JButton(" Guardar");
		btnGuardar.setIcon(new ImageIcon(CreacionUserVista.class.getResource("/Iconos/Guardar.png")));
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGuardar.setBounds(297, 237, 140, 40);
		contentPane.add(btnGuardar);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(176, 96, 148, 25);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		txtContra1 = new JPasswordField();
		txtContra1.setBounds(176, 132, 148, 25);
		contentPane.add(txtContra1);

		txtContra2 = new JPasswordField();
		txtContra2.setBounds(176, 168, 148, 25);
		contentPane.add(txtContra2);
		
		JLabel lblBienvenidoAPizzeria = new JLabel("Bienvenido a Pizzeria Wild");
		lblBienvenidoAPizzeria.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBienvenidoAPizzeria.setBounds(112, 11, 274, 35);
		contentPane.add(lblBienvenidoAPizzeria);
		
		JLabel lblPorFavorIngrese = new JLabel("Por favor ingrese su usuario y contrase\u00F1a para la base de datos:");
		lblPorFavorIngrese.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPorFavorIngrese.setBounds(10, 57, 427, 35);
		contentPane.add(lblPorFavorIngrese);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsuario.setBounds(112, 99, 55, 25);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContrasea.setBounds(87, 132, 79, 25);
		contentPane.add(lblContrasea);
		
		JLabel lblRepitaLaContrasea = new JLabel("Repita la contrase\u00F1a:");
		lblRepitaLaContrasea.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRepitaLaContrasea.setBounds(44, 166, 130, 25);
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
