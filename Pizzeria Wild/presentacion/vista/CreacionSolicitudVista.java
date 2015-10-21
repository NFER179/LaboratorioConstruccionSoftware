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

public class CreacionSolicitudVista extends JDialog {
	private JTextField txtFecha;
	private JTextField txtNumpedido;
	private JTextField txtIdproveedor;
	private JTextField txtDescrproveedor;
	private JLabel lblDescripcin;
	private JButton btnBuscar;
	private DefaultTableModel modelTable;
	private String[] nombreColumnas = {"Materia Prima", "Cantidad"};
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnAgregar;
	private JButton btnQuitar;
	private JButton btnVolver;

	public CreacionSolicitudVista(SolicitudCompraVista arg0) {
		super(arg0, true);
		
		setTitle("Creaci\u00F3n Solicitud");
		setResizable(false);
		setBounds(100, 100, 490, 330);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(10, 11, 99, 14);
		getContentPane().add(lblFecha);
		
		txtFecha = new JTextField();
		txtFecha.setText("CURRENT");
		txtFecha.setEnabled(false);
		txtFecha.setEditable(false);
		txtFecha.setBounds(105, 8, 86, 20);
		getContentPane().add(txtFecha);
		txtFecha.setColumns(10);
		
		JLabel lblNumeroPedido = new JLabel("Numero Pedido:");
		lblNumeroPedido.setBounds(10, 42, 99, 14);
		getContentPane().add(lblNumeroPedido);
		
		txtNumpedido = new JTextField();
		txtNumpedido.setText("NEXT");
		txtNumpedido.setEnabled(false);
		txtNumpedido.setEditable(false);
		txtNumpedido.setBounds(105, 39, 86, 20);
		getContentPane().add(txtNumpedido);
		txtNumpedido.setColumns(10);
		
		JLabel lblProveedorId = new JLabel("Proveedor ID:");
		lblProveedorId.setBounds(10, 73, 99, 14);
		getContentPane().add(lblProveedorId);
		
		txtIdproveedor = new JTextField();
		txtIdproveedor.setEnabled(false);
		txtIdproveedor.setEditable(false);
		txtIdproveedor.setBounds(105, 70, 86, 20);
		getContentPane().add(txtIdproveedor);
		txtIdproveedor.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(201, 69, 89, 23);
		getContentPane().add(btnBuscar);
		
		lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setBounds(10, 101, 99, 14);
		getContentPane().add(lblDescripcin);
		
		txtDescrproveedor = new JTextField();
		txtDescrproveedor.setEnabled(false);
		txtDescrproveedor.setEditable(false);
		txtDescrproveedor.setBounds(105, 98, 272, 20);
		getContentPane().add(txtDescrproveedor);
		txtDescrproveedor.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 129, 365, 124);
		getContentPane().add(scrollPane);
		
		this.modelTable = new WDefaultTableModel(null, this.nombreColumnas);
		table = new WTable(this.modelTable);
		scrollPane.setViewportView(table);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(385, 127, 89, 23);
		getContentPane().add(btnAgregar);
		
		btnQuitar = new JButton("Quitar");
		btnQuitar.setBounds(385, 161, 89, 23);
		getContentPane().add(btnQuitar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(385, 264, 89, 23);
		getContentPane().add(btnVolver);
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

	public JButton getBtnVolver() {
		return btnVolver;
	}
	
}
