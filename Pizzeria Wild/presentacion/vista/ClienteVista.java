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

public class ClienteVista extends JFrame {

	private JPanel contentPane;
	private String[] nombreColumna = {"Id", "Nombre"};
	private DefaultTableModel modelTable;
	private JTable table;
	private JButton btnCrear;
	private JButton btnModificar;
	private JButton btnVolver;

	public ClienteVista() {
		setTitle("Cliente");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblClientes = new JLabel("Clientes:");
		lblClientes.setBounds(10, 11, 96, 14);
		contentPane.add(lblClientes);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 38, 325, 222);
		contentPane.add(scrollPane);
		
		this.modelTable = new WDefaultTableModel(null, this.nombreColumna);
		table = new WTable(this.modelTable);
		scrollPane.setViewportView(table);
		
		btnCrear = new JButton("Crear");
		btnCrear.setBounds(345, 35, 89, 23);
		contentPane.add(btnCrear);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(345, 69, 89, 23);
		contentPane.add(btnModificar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(345, 237, 89, 23);
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

	public String[] getNombreColumna() {
		return nombreColumna;
	}

	public DefaultTableModel getModelTable() {
		return modelTable;
	}

	public JTable getTable() {
		return table;
	}

	public JButton getBtnCrear() {
		return btnCrear;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}
}
