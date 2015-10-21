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

import objetosVistaCustom.WDefaultTableModel;
import objetosVistaCustom.WTable;

@SuppressWarnings("serial")
public class ArmadoVentaVista extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private JTextField txtNumVenta;
	private JTextField txtHora;
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
	private JTextArea txtrObservacionDelivery;
	private JScrollPane scrollPane_1;
	private JLabel lblTelefono;
	private JTextField txtTel;
	private JTextArea txtrObservacion;
	private JScrollPane scrollPane_2;
	private JButton btnArmar;
	private JButton btnCancelar;
	private JScrollPane scrollPane;
	private JTextField txtFecha;
	
	public ArmadoVentaVista(JFrame frame) {
		super(frame, true);
		this.setTitle("Armado Venta");
		
		this.setBounds(100, 100, 550, 578);
		this.getContentPane().setLayout(new BorderLayout());
		this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.getContentPane().add(contentPanel, BorderLayout.CENTER);
		this.contentPanel.setLayout(null);
		this.contentPanel.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel lblNVenta = new JLabel("Num Pedido:");
		lblNVenta.setBounds(10, 8, 90, 14);
		this.contentPanel.add(lblNVenta);
		
		this.txtNumVenta = new JTextField();
		this.txtNumVenta.setEditable(false);
		this.txtNumVenta.setBounds(103, 5, 86, 20);
		this.contentPanel.add(txtNumVenta);
		this.txtNumVenta.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(249, 8, 46, 14);
		this.contentPanel.add(lblFecha);
		
		this.txtFecha = new JTextField();
		this.txtFecha.setEnabled(false);
		this.txtFecha.setEditable(false);
		this.txtFecha.setBounds(305, 5, 86, 20);
		this.contentPanel.add(txtFecha);
		this.txtFecha.setColumns(10);
		
		JLabel lblHora = new JLabel("Hora:");
		lblHora.setBounds(401, 8, 46, 14);
		this.contentPanel.add(lblHora);
		
		this.txtHora = new JTextField();
		this.txtHora.setEditable(false);
		this.txtHora.setBounds(457, 5, 75, 20);
		this.contentPanel.add(txtHora);
		this.txtHora.setColumns(10);
		
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
		
		this.scrollPane = new JScrollPane();
		this.scrollPane.setBounds(10, 61, 412, 164);
		this.contentPanel.add(scrollPane);
		
		this.modelProductos = new WDefaultTableModel(null, this.nombreColumnas);
		this.tblProductos = new WTable(this.modelProductos);
		this.scrollPane.setViewportView(tblProductos);
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
		this.chckbxDelivery.setBounds(6, 257, 97, 23);
		this.contentPanel.add(chckbxDelivery);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(10, 287, 90, 14);
		this.contentPanel.add(lblDireccion);
		
		this.txtDireccion = new JTextField();
		this.txtDireccion.setBounds(103, 284, 279, 20);
		this.contentPanel.add(txtDireccion);
		this.txtDireccion.setColumns(10);
		
		JLabel lblObservacionDelivery = new JLabel("Observaciones Delivery:");
		lblObservacionDelivery.setBounds(10, 312, 152, 14);
		this.contentPanel.add(lblObservacionDelivery);
		
		this.scrollPane_1 = new JScrollPane();
		this.scrollPane_1.setBounds(10, 337, 522, 44);
		this.contentPanel.add(scrollPane_1);
		
		this.txtrObservacionDelivery = new JTextArea();
		this.txtrObservacionDelivery.setEditable(false);
		this.txtrObservacionDelivery.setEnabled(false);
		this.scrollPane_1.setViewportView(txtrObservacionDelivery);
		this.txtrObservacionDelivery.setLineWrap(true);
		
		this.lblTelefono = new JLabel("Telefono:");
		this.lblTelefono.setBounds(10, 392, 90, 14);
		this.contentPanel.add(lblTelefono);
		
		this.txtTel = new JTextField();
		this.txtTel.setBounds(103, 389, 169, 20);
		this.contentPanel.add(txtTel);
		this.txtTel.setColumns(10);
		
		JLabel lblObservaciones = new JLabel("Observaciones:");
		lblObservaciones.setBounds(10, 417, 90, 14);
		this.contentPanel.add(lblObservaciones);
		
		this.scrollPane_2 = new JScrollPane();
		this.scrollPane_2.setBounds(10, 442, 522, 57);
		this.contentPanel.add(scrollPane_2);
		
		this.txtrObservacion = new JTextArea();
		this.scrollPane_2.setViewportView(txtrObservacion);
		this.txtrObservacion.setLineWrap(true);
		
		this.btnArmar = new JButton("Armar");
		this.btnArmar.setBounds(344, 510, 89, 23);
		this.contentPanel.add(btnArmar);
		
		this.btnCancelar = new JButton("Cancelar");
		this.btnCancelar.setBounds(443, 510, 89, 23);
		this.contentPanel.add(btnCancelar);
	}
	
	public void Open() {
		this.setVisible(true);
	}
	
	public void Close() {
		this.setVisible(false);
	}

	public JTextField getTxtNumVenta() {
		return txtNumVenta;
	}

	public JTextField getTxtHora() {
		return txtHora;
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

	public JTextArea getTxtrObservacionDelivery() {
		return txtrObservacionDelivery;
	}

	public JScrollPane getScrollPane_1() {
		return scrollPane_1;
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

	public JScrollPane getScrollPane_2() {
		return scrollPane_2;
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

	public JTextField getTxtFecha() {
		return txtFecha;
	}
}