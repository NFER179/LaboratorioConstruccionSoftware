package vista;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class ABMRepartidorVista extends JDialog {
	private JTextField txtRepartidorid;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTel;
	private JTextField txtDireccion;
	private JTextField txtPatente;
	private JTextField txtModelo;
	private JTextField txtTipo;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JCheckBox chckbxActivo;
	
	public ABMRepartidorVista(RepartidorVista Vista) {
		super(Vista, true);
		
		setTitle("Repartidor");
		setResizable(false);
		setBounds(100, 100, 406, 340);
		getContentPane().setLayout(null);
		
		JLabel lblIdRepartidor = new JLabel("Id Repartidor: ");
		lblIdRepartidor.setBounds(10, 11, 118, 14);
		getContentPane().add(lblIdRepartidor);
		this.setLocationRelativeTo(null);
		
		txtRepartidorid = new JTextField();
		txtRepartidorid.setEnabled(false);
		txtRepartidorid.setEditable(false);
		txtRepartidorid.setBounds(111, 8, 86, 20);
		getContentPane().add(txtRepartidorid);
		txtRepartidorid.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 36, 118, 14);
		getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(111, 33, 230, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(10, 61, 118, 14);
		getContentPane().add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(111, 58, 230, 20);
		getContentPane().add(txtApellido);
		txtApellido.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(10, 86, 118, 14);
		getContentPane().add(lblTelefono);
		
		txtTel = new JTextField();
		txtTel.setBounds(111, 83, 146, 20);
		getContentPane().add(txtTel);
		txtTel.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(10, 111, 118, 14);
		getContentPane().add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(111, 108, 180, 20);
		getContentPane().add(txtDireccion);
		txtDireccion.setColumns(10);
		
		JLabel lblDatosVehiculo = new JLabel("Datos Vehiculo ");
		lblDatosVehiculo.setBounds(10, 140, 118, 14);
		getContentPane().add(lblDatosVehiculo);
		
		JLabel lblPatente = new JLabel("Patente: ");
		lblPatente.setBounds(20, 165, 46, 14);
		getContentPane().add(lblPatente);
		
		txtPatente = new JTextField();
		txtPatente.setBounds(111, 162, 86, 20);
		getContentPane().add(txtPatente);
		txtPatente.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(20, 218, 46, 14);
		getContentPane().add(lblTipo);
		
		txtTipo = new JTextField();
		txtTipo.setBounds(111, 190, 146, 20);
		getContentPane().add(txtTipo);
		txtTipo.setColumns(10);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(20, 193, 86, 14);
		getContentPane().add(lblModelo);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(111, 215, 230, 20);
		getContentPane().add(txtModelo);
		txtModelo.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(84, 147, 294, 20);
		getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(10, 153, 10, 96);
		getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 248, 368, 14);
		getContentPane().add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(377, 147, 22, 102);
		getContentPane().add(separator_3);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(202, 273, 89, 23);
		getContentPane().add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(301, 273, 89, 23);
		getContentPane().add(btnCancelar);
		
		chckbxActivo = new JCheckBox("Activo");
		chckbxActivo.setBounds(301, 7, 97, 23);
		getContentPane().add(chckbxActivo);

	}
	
	public void Open() {
		this.setVisible(true);
	}
	
	public void Close() {
		this.setVisible(false);
	}

	public JTextField getTxtRepartidorid() {
		return txtRepartidorid;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public JTextField getTxtApellido() {
		return txtApellido;
	}

	public JTextField getTxtTel() {
		return txtTel;
	}

	public JTextField getTxtDireccion() {
		return txtDireccion;
	}

	public JTextField getTxtPatente() {
		return txtPatente;
	}

	public JTextField getTxtModelo() {
		return txtModelo;
	}

	public JTextField getTxtTipo() {
		return txtTipo;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public JCheckBox getChckbxActivo() {
		return chckbxActivo;
	}
}
