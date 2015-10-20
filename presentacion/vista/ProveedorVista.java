package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import objetosVistaCustom.WDefaultTableModel;
import objetosVistaCustom.WTable;

public class ProveedorVista extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel modelTable;
	private String[] nombreColumnas = {"ID","Nombre","Telefono","Mail"};
	private JTable table;
	private JButton btnNuevoProveedor;
	private JButton btnModificar;
	private JButton btnVolver;

	public ProveedorVista() {
		setTitle("Proveedor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 422, 210);
		contentPane.add(scrollPane);
		
		this.modelTable = new WDefaultTableModel(null, this.nombreColumnas);
		table = new WTable(this.modelTable);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		btnNuevoProveedor = new JButton("Nuevo Proveedor");
		btnNuevoProveedor.setBounds(52, 232, 120, 23);
		contentPane.add(btnNuevoProveedor);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(182, 232, 120, 23);
		contentPane.add(btnModificar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(312, 232, 120, 23);
		contentPane.add(btnVolver);
	}
	
	public void Open() {
		this.setVisible(true);
	}
	
	public void Close() {
		this.setVisible(false);
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

	public JButton getBtnNuevoProveedor() {
		return btnNuevoProveedor;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}
}