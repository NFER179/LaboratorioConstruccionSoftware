package vista;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ABMClienteVista extends JDialog {
	private JTextField txtIdcliente;
	private JTextField txtNombres;
	private JTextField txtApellido;
	private JTextField txtDireccion;
	private JTextField txtTel;
	private JButton btnGuardar;
	private JButton btnCancalar;

	public ABMClienteVista(ClienteVista Vista) {
		super(Vista, true);
		this.Iniciar();
	}
	
	private void Iniciar() {
		setTitle("Cliente");
		setResizable(false);
		setBounds(100, 100, 450, 204);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel lblIdCliente = new JLabel("Id Cliente:");
		lblIdCliente.setBounds(10, 11, 86, 14);
		getContentPane().add(lblIdCliente);
		
		txtIdcliente = new JTextField();
		txtIdcliente.setEditable(false);
		txtIdcliente.setEnabled(false);
		txtIdcliente.setBounds(76, 8, 86, 20);
		getContentPane().add(txtIdcliente);
		txtIdcliente.setColumns(10);
		
		JLabel lblNombres = new JLabel("Nombres: ");
		lblNombres.setBounds(10, 36, 86, 14);
		getContentPane().add(lblNombres);
		
		txtNombres = new JTextField();
		txtNombres.setBounds(76, 33, 198, 20);
		getContentPane().add(txtNombres);
		txtNombres.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido: ");
		lblApellido.setBounds(10, 61, 86, 14);
		getContentPane().add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(76, 58, 141, 20);
		getContentPane().add(txtApellido);
		txtApellido.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direccion: ");
		lblDireccion.setBounds(10, 86, 86, 14);
		getContentPane().add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(76, 83, 255, 20);
		getContentPane().add(txtDireccion);
		txtDireccion.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono: ");
		lblTelefono.setBounds(10, 111, 86, 14);
		getContentPane().add(lblTelefono);
		
		txtTel = new JTextField();
		txtTel.setBounds(76, 108, 107, 20);
		getContentPane().add(txtTel);
		txtTel.setColumns(10);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(242, 139, 89, 23);
		getContentPane().add(btnGuardar);
		
		btnCancalar = new JButton("Cancalar");
		btnCancalar.setBounds(345, 139, 89, 23);
		getContentPane().add(btnCancalar);
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
