package vista;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import objetosVistaCustom.WDefaultTableModel;
import objetosVistaCustom.WTable;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Color;

public class CreacionSolicitudVista extends JDialog {
	private JTextField txtFecha;
	private JTextField txtNumpedido;
	private JTextField txtIdproveedor;
	private JTextField txtDescrproveedor;
	private JLabel lblDescripcin;
	private JButton btnBuscar;
	private DefaultTableModel modelTable;
	private String[] nombreColumnas = { "Materia Prima", "Cantidad" };
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnAgregar;
	private JButton btnQuitar;
	private JButton btnEnviar;
	private JButton btnGuardar;
	private JButton btnVolver;
	private JButton btnImprimir;
	private JLabel lblNewLabel;

	public CreacionSolicitudVista(SolicitudCompraVista arg0) {
		super(arg0, true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CreacionSolicitudVista.class.getResource("/Iconos/pizza_1.PNG")));

		setTitle(" Creaci\u00F3n Solicitud");
		setResizable(false);
		setBounds(100, 100, 512, 473);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);

		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFecha.setBounds(228, 17, 99, 14);
		getContentPane().add(lblFecha);

		txtFecha = new JTextField();
		txtFecha.setEnabled(false);
		txtFecha.setEditable(false);
		txtFecha.setBounds(289, 12, 86, 25);
		getContentPane().add(txtFecha);
		txtFecha.setColumns(10);

		JLabel lblNumeroPedido = new JLabel("N\u00AA Pedido:");
		lblNumeroPedido.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumeroPedido.setBounds(10, 17, 99, 14);
		getContentPane().add(lblNumeroPedido);

		txtNumpedido = new JTextField();
		txtNumpedido.setText("NEXT");
		txtNumpedido.setEnabled(false);
		txtNumpedido.setEditable(false);
		txtNumpedido.setBounds(105, 14, 86, 25);
		getContentPane().add(txtNumpedido);
		txtNumpedido.setColumns(10);

		JLabel lblProveedorId = new JLabel("Proveedor ID:");
		lblProveedorId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblProveedorId.setBounds(10, 58, 99, 14);
		getContentPane().add(lblProveedorId);

		txtIdproveedor = new JTextField();
		txtIdproveedor.setEnabled(false);
		txtIdproveedor.setEditable(false);
		txtIdproveedor.setBounds(105, 55, 134, 25);
		getContentPane().add(txtIdproveedor);
		txtIdproveedor.setColumns(10);

		btnBuscar = new JButton("   Buscar");
		btnBuscar.setIcon(new ImageIcon(CreacionSolicitudVista.class.getResource("/Iconos/Buscar.png")));
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBuscar.setBounds(249, 48, 126, 35);
		getContentPane().add(btnBuscar);

		lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDescripcin.setBounds(10, 94, 99, 14);
		getContentPane().add(lblDescripcin);

		txtDescrproveedor = new JTextField();
		txtDescrproveedor.setEnabled(false);
		txtDescrproveedor.setEditable(false);
		txtDescrproveedor.setBounds(105, 96, 272, 25);
		getContentPane().add(txtDescrproveedor);
		txtDescrproveedor.setColumns(10);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 132, 365, 236);
		getContentPane().add(scrollPane);

		this.modelTable = new WDefaultTableModel(null, this.nombreColumnas);
		table = new WTable(this.modelTable);
		scrollPane.setViewportView(table);

		btnAgregar = new JButton("Agregar");
		btnAgregar.setBackground(new Color(253, 245, 230));
		btnAgregar.setIcon(new ImageIcon(CreacionSolicitudVista.class.getResource("/Iconos/Agregar.png")));
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAgregar.setBounds(385, 127, 110, 60);
		getContentPane().add(btnAgregar);

		btnQuitar = new JButton("Quitar");
		btnQuitar.setBackground(new Color(253, 245, 230));
		btnQuitar.setIcon(new ImageIcon(CreacionSolicitudVista.class.getResource("/Iconos/Quitar.png")));
		btnQuitar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnQuitar.setBounds(385, 198, 110, 60);
		getContentPane().add(btnQuitar);

		btnEnviar = new JButton(" Enviar");
		btnEnviar.setIcon(new ImageIcon(CreacionSolicitudVista.class.getResource("/Iconos/enviar.png")));
		btnEnviar.setBackground(new Color(152, 251, 152));
		btnEnviar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEnviar.setBounds(10, 390, 140, 40);
		getContentPane().add(btnEnviar);

		btnGuardar = new JButton("");
		btnGuardar.setIcon(new ImageIcon(CreacionSolicitudVista.class.getResource("/Iconos/Guardar.png")));
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGuardar.setBounds(385, 380, 50, 50);
		getContentPane().add(btnGuardar);

		btnVolver = new JButton("");
		btnVolver.setIcon(new ImageIcon(CreacionSolicitudVista.class.getResource("/Iconos/Volver.png")));
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVolver.setBounds(445, 380, 50, 50);
		getContentPane().add(btnVolver);

		btnImprimir = new JButton(" Imprimir");
		btnImprimir.setIcon(new ImageIcon(CreacionSolicitudVista.class.getResource("/Iconos/print.png")));
		btnImprimir.setBackground(new Color(152, 251, 152));
		btnImprimir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnImprimir.setBounds(160, 390, 140, 40);
		getContentPane().add(btnImprimir);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CreacionSolicitudVista.class.getResource("/Iconos/Logo Pizzeria Wild 96x96.png")));
		lblNewLabel.setBounds(396, 11, 99, 97);
		getContentPane().add(lblNewLabel);
	}

	public void Open() {
		this.setVisible(true);
	}

	public void Close() {
		this.setVisible(false);
	}

	public JTextField getTxtFecha() {
		return txtFecha;
	}

	public JTextField getTxtNumpedido() {
		return txtNumpedido;
	}

	public JTextField getTxtIdproveedor() {
		return txtIdproveedor;
	}

	public JTextField getTxtDescrproveedor() {
		return txtDescrproveedor;
	}

	public JLabel getLblDescripcin() {
		return lblDescripcin;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public DefaultTableModel getModelTable() {
		return modelTable;
	}

	public String[] getNombreColumnas() {
		return nombreColumnas;
	}

	public JTable getTable() {
		return table;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public JButton getBtnQuitar() {
		return btnQuitar;
	}

	public JButton getBtnEnviar() {
		return btnEnviar;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public JButton getBtnImprimir() {
		return btnImprimir;
	}

	public void setBtnImprimir(JButton btnImprimir) {
		this.btnImprimir = btnImprimir;
	}

}
