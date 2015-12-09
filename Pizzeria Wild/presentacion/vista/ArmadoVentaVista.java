package vista;

import java.awt.BorderLayout;
import java.awt.Component;

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
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.ListSelectionModel;

@SuppressWarnings("serial")
public class ArmadoVentaVista extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private JTextField txtNumVenta;
	private JTextField txtHora;
	private JTextField txtCliente;
	private JButton btnBusquedaCliente;
	private JTable tblProductos;
	private DefaultTableModel modelProductos;
	private String[] nombreColumnas = { "Producto", "Sabor", "Cantidad",
			"Precio Unidad", "Precio" };
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
	private String[] nombreColumnasCombos = { "Nombre Combo", "Descripcion",
			"Cantidad", "Precio", "Fecha" };
	private DefaultTableModel modelTableCombo;
	private JTable tblCombo;
	private JScrollPane scrollPaneCombo;
	private JButton btnAgregarCombo;
	private JButton btnQuitarCombo;
	private JLabel lblCombo;

	public ArmadoVentaVista(JFrame frame) {
		super(frame, true);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				ArmadoVentaVista.class.getResource("/Iconos/pizza_1.PNG")));
		this.setTitle(" Armado Venta");

		this.setBounds(50, 50, 1108, 619);
		this.getContentPane().setLayout(new BorderLayout());
		this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.getContentPane().add(contentPanel, BorderLayout.CENTER);
		this.contentPanel.setLayout(null);
		this.contentPanel.setLayout(null);
		// this.setLocationRelativeTo(null);

		JLabel lblNVenta = new JLabel("Num Pedido:");
		lblNVenta.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNVenta.setBounds(10, 14, 90, 14);
		this.contentPanel.add(lblNVenta);

		this.txtNumVenta = new JTextField();
		txtNumVenta.setText("NEXT");
		txtNumVenta.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.txtNumVenta.setEditable(false);
		this.txtNumVenta.setEnabled(false);
		this.txtNumVenta.setBounds(103, 11, 86, 20);
		this.contentPanel.add(txtNumVenta);
		this.txtNumVenta.setColumns(10);

		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFecha.setBounds(249, 14, 46, 14);
		this.contentPanel.add(lblFecha);

		this.txtFecha = new JTextField();
		txtFecha.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.txtFecha.setEnabled(false);
		this.txtFecha.setEditable(false);
		this.txtFecha.setBounds(305, 11, 86, 20);
		this.contentPanel.add(txtFecha);
		this.txtFecha.setColumns(10);

		JLabel lblHora = new JLabel("Hora:");
		lblHora.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHora.setBounds(401, 14, 46, 14);
		this.contentPanel.add(lblHora);

		this.txtHora = new JTextField();
		txtHora.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.txtHora.setEditable(false);
		this.txtHora.setEnabled(false);
		this.txtHora.setBounds(457, 11, 75, 20);
		this.contentPanel.add(txtHora);
		this.txtHora.setColumns(10);

		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCliente.setBounds(10, 50, 90, 20);
		this.contentPanel.add(lblCliente);

		this.txtCliente = new JTextField();
		this.txtCliente.setBounds(103, 47, 279, 25);
		this.contentPanel.add(txtCliente);
		this.txtCliente.setColumns(10);

		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDireccion.setBounds(10, 86, 90, 20);
		this.contentPanel.add(lblDireccion);

		this.txtDireccion = new JTextField();
		this.txtDireccion.setBounds(103, 83, 279, 25);
		this.contentPanel.add(txtDireccion);
		this.txtDireccion.setColumns(10);

		this.lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.lblTelefono.setBounds(10, 120, 90, 20);
		this.contentPanel.add(lblTelefono);

		this.txtTel = new JTextField();
		this.txtTel.setBounds(103, 117, 169, 25);
		this.contentPanel.add(txtTel);
		this.txtTel.setColumns(10);

		this.btnBusquedaCliente = new JButton("Cliente");
		btnBusquedaCliente.setIcon(new ImageIcon(ArmadoVentaVista.class
				.getResource("/Iconos/Buscar.png")));
		btnBusquedaCliente.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.btnBusquedaCliente.setBounds(401, 50, 140, 60);
		this.contentPanel.add(btnBusquedaCliente);

		this.scrollPane = new JScrollPane();
		this.scrollPane.setBounds(20, 159, 353, 407);
		this.contentPanel.add(scrollPane);

		this.modelProductos = new WDefaultTableModel(null, this.nombreColumnas);
		this.tblProductos = new WTable(this.modelProductos);
		this.scrollPane.setViewportView(tblProductos);
		this.tblProductos.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				null, null));

		this.btnAgregar = new JButton("Agregar");
		btnAgregar.setIcon(new ImageIcon(ArmadoVentaVista.class
				.getResource("/Iconos/Agregar.png")));
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.btnAgregar.setBounds(401, 200, 140, 60);
		this.contentPanel.add(btnAgregar);

		this.btnQuitar = new JButton("Quitar");
		btnQuitar.setIcon(new ImageIcon(ArmadoVentaVista.class
				.getResource("/Iconos/Quitar.png")));
		btnQuitar.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.btnQuitar.setBounds(401, 303, 140, 60);
		this.contentPanel.add(btnQuitar);

		this.chckbxDelivery = new JCheckBox("Delivery");
		chckbxDelivery.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.chckbxDelivery.setBounds(569, 364, 97, 23);
		this.contentPanel.add(chckbxDelivery);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrecio.setBounds(791, 367, 54, 20);
		this.contentPanel.add(lblPrecio);

		this.txtPrecio = new JTextField();
		this.txtPrecio.setEditable(false);
		this.txtPrecio.setEnabled(false);
		this.txtPrecio.setBounds(855, 367, 86, 20);
		this.contentPanel.add(txtPrecio);
		this.txtPrecio.setColumns(10);

		JLabel lblObservacionDelivery = new JLabel("Observaciones Delivery:");
		lblObservacionDelivery.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblObservacionDelivery.setBounds(569, 394, 152, 20);
		this.contentPanel.add(lblObservacionDelivery);

		this.scrollPane_1 = new JScrollPane();
		this.scrollPane_1.setBounds(569, 415, 522, 25);
		this.contentPanel.add(scrollPane_1);

		this.txtrObservacionDelivery = new JTextArea();
		scrollPane_1.setViewportView(txtrObservacionDelivery);
		this.txtrObservacionDelivery.setEditable(false);
		this.txtrObservacionDelivery.setEnabled(false);
		this.txtrObservacionDelivery.setLineWrap(true);

		JLabel lblObservaciones = new JLabel("Observaciones:");
		lblObservaciones.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblObservaciones.setBounds(569, 461, 90, 20);
		this.contentPanel.add(lblObservaciones);

		this.scrollPane_2 = new JScrollPane();
		this.scrollPane_2.setBounds(569, 482, 522, 25);
		this.contentPanel.add(scrollPane_2);

		scrollPaneCombo = new JScrollPane();
		scrollPaneCombo.setBounds(569, 39, 353, 293);
		contentPanel.add(scrollPaneCombo);

		this.modelTableCombo = new WDefaultTableModel(null,
				this.nombreColumnasCombos);
		tblCombo = new WTable(this.modelTableCombo);
		tblCombo.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scrollPaneCombo.setViewportView(tblCombo);

		btnAgregarCombo = new JButton("Agregar Combo");
		btnAgregarCombo.setIcon(new ImageIcon(ArmadoVentaVista.class.getResource("/Iconos/Agregar.png")));		
		btnAgregarCombo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAgregarCombo.setBounds(951, 66, 140, 60);
		contentPanel.add(btnAgregarCombo);

		btnQuitarCombo = new JButton("Quitar Combo");
		btnQuitarCombo.setIcon(new ImageIcon(ArmadoVentaVista.class.getResource("/Iconos/Quitar.png")));
		btnQuitarCombo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnQuitarCombo.setBounds(951, 171, 140, 60);
		contentPanel.add(btnQuitarCombo);

		lblCombo = new JLabel("Combos:");
		lblCombo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCombo.setBounds(569, 11, 152, 20);
		contentPanel.add(lblCombo);

		this.txtrObservacion = new JTextArea();
		scrollPane_2.setViewportView(txtrObservacion);
		this.txtrObservacion.setLineWrap(true);

		this.btnArmar = new JButton("Armar");
		btnArmar.setIcon(new ImageIcon(ArmadoVentaVista.class
				.getResource("/Iconos/OK.png")));
		btnArmar.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.btnArmar.setBounds(801, 540, 140, 40);
		this.contentPanel.add(btnArmar);

		this.btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(ArmadoVentaVista.class
				.getResource("/Iconos/salir.png")));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.btnCancelar.setBounds(951, 540, 140, 40);
		this.contentPanel.add(btnCancelar);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ArmadoVentaVista.class
				.getResource("/Iconos/Logo Pizzeria Wild .png")));
		lblNewLabel.setBounds(393, 402, 166, 178);
		contentPanel.add(lblNewLabel);
	}

	public void Open() {
		this.setVisible(true);
	}

	public void Close() {
		this.setVisible(false);
	}

	public void Quitar(Component Componente) {
		this.contentPanel.remove(Componente);
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

	public String[] getNombreColumnasCombos() {
		return nombreColumnasCombos;
	}

	public DefaultTableModel getModelTableCombo() {
		return modelTableCombo;
	}

	public JTable getTblCombo() {
		return tblCombo;
	}

	public JScrollPane getScrollPaneCombo() {
		return scrollPaneCombo;
	}

	public JButton getBtnAgregarCombo() {
		return btnAgregarCombo;
	}

	public JButton getBtnQuitarCombo() {
		return btnQuitarCombo;
	}

	public JLabel getLblCombo() {
		return lblCombo;
	}
}