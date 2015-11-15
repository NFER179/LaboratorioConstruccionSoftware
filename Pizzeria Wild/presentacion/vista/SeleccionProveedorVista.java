package vista;

import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import objetosVistaCustom.WDefaultTableModel;
import objetosVistaCustom.WTable;

public class SeleccionProveedorVista extends JDialog {
	
	private DefaultTableModel modelTable;
	private String[] nombreColumnas = {"ID Proveedor","Descripcion"};
	private JTable table;
	private JButton btnSeleccionar;
	private JButton btnCancelar;

	public SeleccionProveedorVista(CreacionSolicitudVista Vista) {
		super(Vista, true);
		
		setTitle("Seleccion Proveedor");
		setBounds(100, 100, 297, 300);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 269, 211);
		getContentPane().add(scrollPane);
		
		this.modelTable = new WDefaultTableModel(null, this.nombreColumnas);
		table = new WTable(this.modelTable);
		scrollPane.setViewportView(table);
		
		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setBounds(91, 232, 89, 23);
		getContentPane().add(btnSeleccionar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(190, 232, 89, 23);
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

	public JButton getBtnSeleccionar() {
		return btnSeleccionar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}
}