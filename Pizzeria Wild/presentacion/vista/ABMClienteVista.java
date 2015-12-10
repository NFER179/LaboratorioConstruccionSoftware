package vista;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class ABMClienteVista extends JDialog {
	private static final long serialVersionUID = 1L;
	private JTextField txtIdcliente;
	private JTextField txtNombres;
	private JTextField txtApellido;
	private JTextField txtDireccion;
	private JTextField txtTel;
	private JButton btnGuardar;
	private JButton btnCancalar;
	private JLabel lblNewLabel;

	public ABMClienteVista(ClienteVista Vista) {
		super(Vista, true);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				ABMClienteVista.class.getResource("/Iconos/pizza_1.PNG")));
		this.Iniciar();
	}

	private void Iniciar() {
		setTitle(" Cliente");
		setResizable(false);
		setBounds(0, -21, 476, 297);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);

		JLabel lblIdCliente = new JLabel("Id Cliente:");
		lblIdCliente.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdCliente.setBounds(10, 11, 86, 25);
		getContentPane().add(lblIdCliente);

		txtIdcliente = new JTextField();
		txtIdcliente.setEditable(false);
		txtIdcliente.setEnabled(false);
		txtIdcliente.setBounds(81, 11, 86, 25);
		getContentPane().add(txtIdcliente);
		txtIdcliente.setColumns(10);

		JLabel lblNombres = new JLabel("Nombres: ");
		lblNombres.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombres.setBounds(10, 47, 86, 25);
		getContentPane().add(lblNombres);

		txtNombres = new JTextField();
		txtNombres.setBounds(81, 47, 198, 25);
		getContentPane().add(txtNombres);
		txtNombres.setColumns(10);

		JLabel lblApellido = new JLabel("Apellido: ");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblApellido.setBounds(10, 83, 86, 25);
		getContentPane().add(lblApellido);

		txtApellido = new JTextField();
		txtApellido.setBounds(81, 83, 198, 25);
		getContentPane().add(txtApellido);
		txtApellido.setColumns(10);

		JLabel lblDireccion = new JLabel("Direccion: ");
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDireccion.setBounds(10, 119, 86, 25);
		getContentPane().add(lblDireccion);

		txtDireccion = new JTextField();
		txtDireccion.setBounds(81, 119, 255, 25);
		getContentPane().add(txtDireccion);
		txtDireccion.setColumns(10);

		JLabel lblTelefono = new JLabel("Telefono: ");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTelefono.setBounds(10, 158, 86, 25);
		getContentPane().add(lblTelefono);

		txtTel = new JTextField();
		txtTel.setBounds(81, 158, 107, 25);
		getContentPane().add(txtTel);
		txtTel.setColumns(10);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setIcon(new ImageIcon(ABMClienteVista.class
				.getResource("/Iconos/OK.png")));
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGuardar.setBounds(172, 214, 140, 40);
		getContentPane().add(btnGuardar);

		btnCancalar = new JButton("Cancalar");
		btnCancalar.setIcon(new ImageIcon(ABMClienteVista.class
				.getResource("/Iconos/salir.png")));
		btnCancalar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancalar.setBounds(320, 214, 140, 40);
		getContentPane().add(btnCancalar);

		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ABMClienteVista.class
				.getResource("/Iconos/Logo Pizzeria Wild .png")));
		lblNewLabel.setBounds(289, 11, 181, 158);
		getContentPane().add(lblNewLabel);
	}

	public void Open() {
		this.setVisible(true);
	}

	public void Close() {
		this.setVisible(false);
	}

	public JTextField getTxtIdcliente() {
		return txtIdcliente;
	}

	public JTextField getTxtNombres() {
		return txtNombres;
	}

	public JTextField getTxtApellido() {
		return txtApellido;
	}

	public JTextField getTxtDireccion() {
		return txtDireccion;
	}

	public JTextField getTxtTel() {
		return txtTel;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public JButton getBtnCancalar() {
		return btnCancalar;
	}
}
