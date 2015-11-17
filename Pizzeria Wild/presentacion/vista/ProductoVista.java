package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import objetosVistaCustom.WDefaultTableModel;
import objetosVistaCustom.WTable;

public class ProductoVista extends JFrame {

	private JPanel contentPane;
	private String[] nombreColumnas = {"Id", "Descripcion"};
	private DefaultTableModel modelTable;
	private JTable table;
	private JButton btnAgregar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnVolver;

	public ProductoVista() {
		setTitle("Productos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 274);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProductos = new JLabel("Productos: ");
		lblProductos.setBounds(10, 11, 106, 14);
		contentPane.add(lblProductos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 34, 315, 190);
		contentPane.add(scrollPane);
		
		this.modelTable = new WDefaultTableModel(null, this.nombreColumnas);
		table = new WTable(this.modelTable);
		scrollPane.setViewportView(table);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(335, 32, 89, 23);
		contentPane.add(btnAgregar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(335, 66, 89, 23);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(335, 100, 89, 23);
		contentPane.add(btnEliminar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(335, 201, 89, 23);
		contentPane.add(btnVolver);
	}
	
	public void Open() {
		this.setVisible(true);
	}
	
	public void Close() {
		this.setVisible(false);
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JTable getTable() {
		return table;
	}

	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public String[] getNombreColumnas() {
		return nombreColumnas;
	}

	public DefaultTableModel getModelTable() {
		return modelTable;
	}
	
}