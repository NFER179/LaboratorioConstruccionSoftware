package vista;

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
import javax.swing.ListSelectionModel;

public class RepartidorVista extends JFrame {

	private JPanel contentPane;
	private JLabel lblReoartidoresActivos;
	private String[] nombreColumnas = {"Id", "Nombre", "Activo"};
	private DefaultTableModel modelTable;
	private JTable table;
	private JButton btnAgregar;
	private JButton btnModificar;
	private JButton btnTodos;
	private JButton btnVolver;

	public RepartidorVista() {
		setResizable(false);
		setTitle("Repartidores");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblReoartidoresActivos = new JLabel("Repartidores Activos:");
		lblReoartidoresActivos.setBounds(10, 11, 196, 14);
		contentPane.add(lblReoartidoresActivos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 317, 187);
		contentPane.add(scrollPane);
		
		this.modelTable = new WDefaultTableModel(null, this.nombreColumnas);
		table = new WTable(this.modelTable);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(349, 36, 89, 23);
		contentPane.add(btnAgregar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(349, 70, 89, 23);
		contentPane.add(btnModificar);
		
		btnTodos = new JButton("Todos");
		btnTodos.setBounds(349, 104, 89, 23);
		contentPane.add(btnTodos);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(349, 234, 89, 23);
		contentPane.add(btnVolver);
		this.setLocationRelativeTo(null);
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

	public JLabel getLblReoartidoresActivos() {
		return lblReoartidoresActivos;
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

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public JButton getBtnTodos() {
		return btnTodos;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}
}