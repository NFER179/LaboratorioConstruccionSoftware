package vista;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import objetosVistaCustom.WDefaultTableModel;
import objetosVistaCustom.WTable;

public class ABMProductoVista extends JDialog {
	
	private JTextField txtIdproducto;
	private JTextField txtDescipcion;
	private JCheckBox chckbxEleboraCocina;
	private String[] nombreColumnas = {"Sabor", "Precio"};
	private DefaultTableModel modelTable;
	private JTable table;
	private JButton btnAgregar;
	private JButton btnEliminar;
	private JButton btnGuardar;
	private JButton btnCancelar;

	public ABMProductoVista(ProductoVista Vista) {
		super(Vista, true);
		setTitle("Informacion Producto");
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel lblIdProducto = new JLabel("Id Producto:");
		lblIdProducto.setBounds(10, 11, 93, 14);
		getContentPane().add(lblIdProducto);
		
		txtIdproducto = new JTextField();
		txtIdproducto.setBounds(100, 8, 86, 20);
		getContentPane().add(txtIdproducto);
		txtIdproducto.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(10, 36, 93, 14);
		getContentPane().add(lblDescripcion);
		
		txtDescipcion = new JTextField();
		txtDescipcion.setBounds(100, 33, 220, 20);
		getContentPane().add(txtDescipcion);
		txtDescipcion.setColumns(10);
		
		chckbxEleboraCocina = new JCheckBox("Elebora Cocina");
		chckbxEleboraCocina.setBounds(10, 57, 137, 23);
		getContentPane().add(chckbxEleboraCocina);
		
		JLabel lblSabores = new JLabel("Sabores:");
		lblSabores.setBounds(10, 87, 93, 14);
		getContentPane().add(lblSabores);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 112, 325, 114);
		getContentPane().add(scrollPane);
		
		this.modelTable = new WDefaultTableModel(null, this.nombreColumnas);
		table = new WTable(this.modelTable);
		scrollPane.setViewportView(table);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(345, 108, 89, 23);
		getContentPane().add(btnAgregar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(345, 142, 89, 23);
		getContentPane().add(btnEliminar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(246, 237, 89, 23);
		getContentPane().add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(345, 237, 89, 23);
		getContentPane().add(btnCancelar);

	}
	public void Open() {
		this.setVisible(true);
	}
	
	public void Close() {
		this.setVisible(false);
	}
	public JTextField getTxtIdproducto() {
		return txtIdproducto;
	}
	public JTextField getTxtDescipcion() {
		return txtDescipcion;
	}
	public JCheckBox getChckbxEleboraCocina() {
		return chckbxEleboraCocina;
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
	public JButton getBtnAgregar() {
		return btnAgregar;
	}
	public JButton getBtnEliminar() {
		return btnEliminar;
	}
	public JButton getBtnGuardar() {
		return btnGuardar;
	}
	public JButton getBtnCancelar() {
		return btnCancelar;
	}
}
