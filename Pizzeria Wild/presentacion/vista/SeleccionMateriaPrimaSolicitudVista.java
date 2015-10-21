package vista;

import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import objetosVistaCustom.WDefaultTableModel;
import objetosVistaCustom.WTable;

public class SeleccionMateriaPrimaSolicitudVista extends JDialog {
	private DefaultTableModel modelTable;
	private String[] nombreColumnas = {"Materia Prima", "Unidad"};
	private JTable table;
	private JTextField textField;
	private JButton btnAceptar;
	private JButton btnCancelar;

	public SeleccionMateriaPrimaSolicitudVista(CreacionSolicitudVista arg0) {
		super(arg0, true);
		
		setTitle("Seleccion Materi Prima");
		setBounds(100, 100, 287, 300);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 256, 182);
		getContentPane().add(scrollPane);
		
		this.modelTable = new WDefaultTableModel(null, this.nombreColumnas);
		table = new WTable(this.modelTable);
		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JLabel lblCantidad = new JLabel("Cantidad: ");
		lblCantidad.setBounds(10, 204, 69, 14);
		getContentPane().add(lblCantidad);
		
		textField = new JTextField();
		textField.setBounds(78, 201, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(78, 232, 89, 23);
		getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(177, 232, 89, 23);
		getContentPane().add(btnCancelar);
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

	public JTextField getTextField() {
		return textField;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}
}