package vista;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import objetosVistaCustom.WDefaultTableModel;
import objetosVistaCustom.WTable;
import javax.swing.ListSelectionModel;

public class SeleccionadorCombosVista extends JDialog {
	
	private String[] nombreColumnas = {"Id Combo","Descripcion","Precio"};
	private DefaultTableModel modelTable;
	private JTable table;
	private JButton btnAgregar;
	private JButton btnCancelar;
	private JLabel lblCantidad;
	private JTextField textField;

	public SeleccionadorCombosVista(ArmadoVentaVista Vista) {
		super(Vista, true);
		setResizable(false);
		setTitle("Seleccion Combo");
		setBounds(100, 100, 491, 321);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel lblCombos = new JLabel("Combos:");
		lblCombos.setBounds(10, 11, 80, 14);
		getContentPane().add(lblCombos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 32, 463, 161);
		getContentPane().add(scrollPane);
		
		this.modelTable = new WDefaultTableModel(null, this.nombreColumnas);
		table = new WTable(this.modelTable);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(10, 207, 80, 14);
		getContentPane().add(lblCantidad);
		
		textField = new JTextField();
		textField.setBounds(74, 204, 116, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(285, 253, 89, 23);
		getContentPane().add(btnAgregar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(384, 253, 89, 23);
		getContentPane().add(btnCancelar);
	}
	public void Open() {
		this.setVisible(true);
	}
	
	public void Close() {
		this.setVisible(false);
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

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public JLabel getLblCantidad() {
		return lblCantidad;
	}

	public JTextField getTextField() {
		return textField;
	}
}