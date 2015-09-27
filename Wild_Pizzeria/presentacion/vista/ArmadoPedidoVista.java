package vista;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.border.EtchedBorder;
import javax.swing.JCheckBox;


public class ArmadoPedidoVista extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private JTextField txtNumpedido;
	private JTextField txtFecha;
	private JTextField txtCliente;
	private JButton btnBusquedaCliente;
	private JTable tblProductos;
	private DefaultTableModel modelProductos;
	private String[] nombreColumnas = {"Producto","Sabor","Cantidad","Precio Unidad","Precio"};
	private JButton btnAgregar;
	private JButton btnQuitar;
	private JTextField txtPrecio;
	private JCheckBox chckbxDelivery;
	private JTextField txtDireccion;
	private JLabel lblTelefono;
	private JTextField txtTel;
	private JTextArea txtrObservacion;
	private JScrollPane scrollPane_1;
	private JButton btnArmar;
	private JButton btnCancelar;
	private JScrollPane scrollPane;
	
	public ArmadoPedidoVista(JFrame frame) {
		super(frame, true);
		
		setBounds(100, 100, 550, 497);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		this.contentPanel.setLayout(null);
		contentPanel.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel lblNPedido = new JLabel("Num Pedido:");
		lblNPedido.setBounds(10, 11, 90, 14);
		this.contentPanel.add(lblNPedido);
		
		this.txtNumpedido = new JTextField();
		this.txtNumpedido.setEditable(false);
		this.txtNumpedido.setBounds(103, 5, 86, 20);
		this.contentPanel.add(txtNumpedido);
		this.txtNumpedido.setColumns(10);
		
		this.txtFecha = new JTextField();
		this.txtFecha.setEditable(false);
		this.txtFecha.setBounds(397, 8, 135, 20);
		this.contentPanel.add(txtFecha);
		this.txtFecha.setColumns(10);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(10, 36, 90, 14);
		this.contentPanel.add(lblCliente);
		
		this.txtCliente = new JTextField();
		this.txtCliente.setBounds(103, 33, 279, 20);
		this.contentPanel.add(txtCliente);
		this.txtCliente.setColumns(10);
		
		this.btnBusquedaCliente = new JButton("Busqueda Cliente");
		this.btnBusquedaCliente.setBounds(392, 32, 140, 23);
		this.contentPanel.add(btnBusquedaCliente);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 61, 412, 164);
		contentPanel.add(scrollPane);
		
		this.modelProductos = new DefaultTableModel(null, this.nombreColumnas);
		this.tblProductos = new JTable(this.modelProductos);
		scrollPane.setViewportView(tblProductos);
		this.tblProductos.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null)); 
		
		this.btnAgregar = new JButton("Agregar");
		this.btnAgregar.setBounds(443, 61, 89, 23);
		this.contentPanel.add(btnAgregar);
		
		this.btnQuitar = new JButton("quitar");
		this.btnQuitar.setBounds(443, 95, 89, 23);
		this.contentPanel.add(btnQuitar);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(10, 236, 90, 14);
		this.contentPanel.add(lblPrecio);
		
		this.txtPrecio = new JTextField();
		this.txtPrecio.setEditable(false);
		this.txtPrecio.setBounds(103, 233, 86, 20);
		this.contentPanel.add(txtPrecio);
		this.txtPrecio.setColumns(10);
		
		this.chckbxDelivery = new JCheckBox("Delivery");
		this.chckbxDelivery.setBounds(10, 257, 97, 23);
		this.contentPanel.add(chckbxDelivery);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(10, 287, 90, 14);
		contentPanel.add(lblDireccion);
		
		this.txtDireccion = new JTextField();
		this.txtDireccion.setBounds(103, 282, 279, 20);
		this.contentPanel.add(txtDireccion);
		this.txtDireccion.setColumns(10);
		
		this.lblTelefono = new JLabel("Telefono:");
		this.lblTelefono.setBounds(10, 312, 90, 14);
		this.contentPanel.add(lblTelefono);
		
		this.txtTel = new JTextField();
		this.txtTel.setBounds(103, 309, 169, 20);
		this.contentPanel.add(txtTel);
		this.txtTel.setColumns(10);
		
		JLabel lblObservaciones = new JLabel("Observaciones:");
		lblObservaciones.setBounds(10, 337, 90, 14);
		this.contentPanel.add(lblObservaciones);
		
		this.scrollPane_1 = new JScrollPane();
		this.scrollPane_1.setBounds(10, 362, 522, 57);
		this.contentPanel.add(scrollPane_1);
		
		this.txtrObservacion = new JTextArea();
		this.scrollPane_1.setViewportView(txtrObservacion);
		this.txtrObservacion.setLineWrap(true);
		
		this.btnArmar = new JButton("Armar");
		this.btnArmar.setBounds(344, 430, 89, 23);
		this.contentPanel.add(btnArmar);
		
		this.btnCancelar = new JButton("Cancelar");
		this.btnCancelar.setBounds(443, 430, 89, 23);
		this.contentPanel.add(btnCancelar);
	}
	
	public void Open() {
		this.setVisible(true);
	}
	
	public void Close() {
		this.setVisible(false);
	}

	public JTextField getTxtNumpedido() {
		return txtNumpedido;
	}

	public JTextField getTxtFecha() {
		return txtFecha;
	}

	public JTextField getTxtCliente() {
		return txtCliente;
	}

	public JButton getBtnBusquedaCliente() {
		return btnBusquedaCliente;
	}

	public JTable getTblProductos() {
		return tblProductos;
	}

	public DefaultTableModel getModelProductos() {
		return modelProductos;
	}

	public String[] getNombreColumnas() {
		return nombreColumnas;
	}

	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public JButton getBtnQuitar() {
		return btnQuitar;
	}

	public JTextField getTxtPrecio() {
		return txtPrecio;
	}

	public JCheckBox getChckbxDelivery() {
		return chckbxDelivery;
	}

	public JTextField getTxtDireccion() {
		return txtDireccion;
	}

	public JLabel getLblTelefono() {
		return lblTelefono;
	}

	public JTextField getTxtTel() {
		return txtTel;
	}

	public JTextArea getTxtrObservacion() {
		return txtrObservacion;
	}

	public JScrollPane getScrollPane_1() {
		return scrollPane_1;
	}

	public JButton getBtnArmar() {
		return btnArmar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}
}