package vista;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import objetosVistaCustom.WDefaultTableModel;
import objetosVistaCustom.WTable;

public class ABMComboVista extends JDialog {
	private JTextField txtIdcombo;
	private JTextField txtDescripcion;
	private JTextField txtFechaInicio;
	private JTextField txtFechaHasta;
	private String[] nombreColumnas = {"Producto","Sabor","Cantidad","Precio"};
	private DefaultTableModel modelTable; 
	private JTable table;
	private JTextField txtPrecio;
	private JButton btnAgregar;
	private JButton btnQuitar;
	private JButton btnGuardar;
	private JButton btnCancelar;

	public ABMComboVista(ComboVista Vista) {
		super(Vista, true);
		
		setTitle("Combo");
		setResizable(false);
		setBounds(100, 100, 649, 452);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel lblIdCombo = new JLabel("Id Combo: ");
		lblIdCombo.setBounds(10, 11, 94, 14);
		getContentPane().add(lblIdCombo);
		
		txtIdcombo = new JTextField();
		txtIdcombo.setBounds(89, 8, 86, 20);
		getContentPane().add(txtIdcombo);
		txtIdcombo.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion: ");
		lblDescripcion.setBounds(10, 39, 94, 14);
		getContentPane().add(lblDescripcion);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(89, 36, 253, 20);
		getContentPane().add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		JLabel lblDesde = new JLabel("Desde:");
		lblDesde.setBounds(10, 67, 46, 14);
		getContentPane().add(lblDesde);
		
		txtFechaInicio = new JTextField();
		txtFechaInicio.setBounds(89, 64, 86, 20);
		getContentPane().add(txtFechaInicio);
		txtFechaInicio.setColumns(10);
		
		JLabel lblHasta = new JLabel("Hasta");
		lblHasta.setBounds(223, 67, 68, 14);
		getContentPane().add(lblHasta);
		
		txtFechaHasta = new JTextField();
		txtFechaHasta.setBounds(280, 64, 86, 20);
		getContentPane().add(txtFechaHasta);
		txtFechaHasta.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 92, 524, 255);
		getContentPane().add(scrollPane);
		
		this.modelTable = new WDefaultTableModel(null, this.nombreColumnas);
		table = new WTable(this.modelTable);
		scrollPane.setViewportView(table);
		
		JLabel lblPrecio = new JLabel("Precio: ");
		lblPrecio.setBounds(10, 361, 94, 14);
		getContentPane().add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(89, 358, 86, 20);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(544, 94, 89, 23);
		getContentPane().add(btnAgregar);
		
		btnQuitar = new JButton("Quitar");
		btnQuitar.setBounds(544, 128, 89, 23);
		getContentPane().add(btnQuitar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(445, 389, 89, 23);
		getContentPane().add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(544, 389, 89, 23);
		getContentPane().add(btnCancelar);

	}
	public void Open() {
		this.setVisible(true);
	}
	
	public void Close() {
		this.setVisible(false);
	}
	public JTextField getTxtIdcombo() {
		return txtIdcombo;
	}
	public JTextField getTxtDescripcion() {
		return txtDescripcion;
	}
	public JTextField getTxtFechaInicio() {
		return txtFechaInicio;
	}
	public JTextField getTxtFechaHasta() {
		return txtFechaHasta;
	}
	public String[] getNombreColumnas() {
		return nombreColumnas;
	}
	public DefaultTableModel getModelTable() {
		return modelTable;
	}
	public JTable getTable() {
		return table;
	}
	public JTextField getTxtPrecio() {
		return txtPrecio;
	}
	public JButton getBtnAgregar() {
		return btnAgregar;
	}
	public JButton getBtnQuitar() {
		return btnQuitar;
	}
	public JButton getBtnGuardar() {
		return btnGuardar;
	}
	public JButton getBtnCancelar() {
		return btnCancelar;
	}
}
