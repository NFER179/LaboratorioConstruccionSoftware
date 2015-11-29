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
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JButton btnGuardar;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JPasswordField txtContra1;
	private JPasswordField txtContra2;

	/**
	 * Create the frame.
	 */
	public CreacionUserVista() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				CreacionUserVista.class.getResource("/Iconos/pizza_1.PNG")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 463, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnGuardar = new JButton(" Guardar");
		btnGuardar.setIcon(new ImageIcon(CreacionUserVista.class
				.getResource("/Iconos/Guardar.png")));
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGuardar.setBounds(297, 280, 140, 40);
		contentPane.add(btnGuardar);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(176, 96, 148, 25);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		JLabel lblBienvenidoAPizzeria = new JLabel("Bienvenido a Pizzeria Wild");
		lblBienvenidoAPizzeria.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBienvenidoAPizzeria.setBounds(112, 11, 274, 35);
		contentPane.add(lblBienvenidoAPizzeria);

		JLabel lblPorFavorIngrese = new JLabel(
				"Por favor ingrese su usuario y contrase\u00F1a para la base de datos:");
		lblPorFavorIngrese.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPorFavorIngrese.setBounds(10, 57, 427, 35);
		contentPane.add(lblPorFavorIngrese);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsuario.setBounds(112, 99, 55, 25);
		contentPane.add(lblUsuario);

		JLabel label_2 = new JLabel("Telefono:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setBounds(112, 172, 55, 25);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("Direccion:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_3.setBounds(112, 136, 55, 25);
		contentPane.add(label_3);

		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(176, 133, 148, 25);
		contentPane.add(txtDireccion);

		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(176, 169, 148, 25);
		contentPane.add(txtTelefono);

		JLabel label = new JLabel("Contrase\u00F1a:");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(87, 208, 79, 25);
		contentPane.add(label);

		txtContra1 = new JPasswordField();
		txtContra1.setBounds(176, 208, 148, 25);
		contentPane.add(txtContra1);

		txtContra2 = new JPasswordField();
		txtContra2.setBounds(176, 244, 148, 25);
		contentPane.add(txtContra2);

		JLabel label_1 = new JLabel("Repita la contrase\u00F1a:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(44, 242, 130, 25);
		contentPane.add(label_1);
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

	public JTextField getTxtDireccion() {
		return txtDireccion;
	}

	public void setTxtDireccion(JTextField txtDireccion) {
		this.txtDireccion = txtDireccion;
	}

	public JTextField getTxtTelefono() {
		return txtTelefono;
	}

	public void setTxtTelefono(JTextField txtTelefono) {
		this.txtTelefono = txtTelefono;
	}

	public void Open() {
		this.setVisible(true);
	}

	public void Close() {
		this.setVisible(false);

	}
}
