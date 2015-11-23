package vista;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import objetosVistaCustom.WDefaultTableModel;
import objetosVistaCustom.WTable;

public class BusquedaProductosCombosVista extends JDialog {
	
	private String[] cbx = {"Ninguno"};
	private DefaultComboBoxModel modelCbx;
	private JComboBox comboBox;
	private String[] nombreColumna = {"Sabor"};
	private DefaultTableModel modelTable;
	private JTable table;
	private JTextField txtCantidad;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JLabel lblDescripcion;
	private JTextField txtDescripcion;

	public BusquedaProductosCombosVista(ABMComboVista Vista) {
		super(Vista, true);
		
		setTitle("Busueda Producto");
		setBounds(100, 100, 515, 413);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		
		this.modelCbx = new DefaultComboBoxModel<>(this.cbx);
		comboBox = new JComboBox(this.modelCbx);
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(15, 16, 210, 26);
		getContentPane().add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 100, 452, 157);
		getContentPane().add(scrollPane);
		
		this.modelTable = new WDefaultTableModel(null, this.nombreColumna);
		table = new WTable(this.modelTable);
		scrollPane.setViewportView(table);
		
		JLabel lblCantidad = new JLabel("Cantidad: ");
		lblCantidad.setBounds(15, 273, 99, 20);
		getContentPane().add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(124, 270, 146, 26);
		getContentPane().add(txtCantidad);
		txtCantidad.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(233, 312, 115, 29);
		getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(363, 312, 115, 29);
		getContentPane().add(btnCancelar);
		
		lblDescripcion = new JLabel("Descripcion: ");
		lblDescripcion.setBounds(15, 58, 109, 20);
		getContentPane().add(lblDescripcion);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(124, 58, 354, 26);
		getContentPane().add(txtDescripcion);
		txtDescripcion.setColumns(10);

	}
	public void Open(){
		this.setVisible(true);
	}
	public void Close(){
		this.setVisible(false);
	}
	public DefaultComboBoxModel getModelCbx() {
		return modelCbx;
	}
	public JComboBox getComboBox() {
		return comboBox;
	}
	public String[] getNombreColumna() {
		return nombreColumna;
	}
	public DefaultTableModel getModelTable() {
		return modelTable;
	}
	public JTable getTable() {
		return table;
	}
	public JTextField getTxtCantidad() {
		return txtCantidad;
	}
	public JButton getBtnAceptar() {
		return btnAceptar;
	}
	public JButton getBtnCancelar() {
		return btnCancelar;
	}
	public JLabel getLblDescripcion() {
		return lblDescripcion;
	}
	public JTextField getTxtDescripcion() {
		return txtDescripcion;
	}	
}