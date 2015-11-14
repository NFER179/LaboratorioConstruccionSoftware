package vista;

import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import objetosVistaCustom.WDefaultTableModel;
import objetosVistaCustom.WTable;

public class BusquedaMPProveedorVista extends JDialog {
	
	private String[] nombreColumnas = {"Materia Prima"};
	private DefaultTableModel modelTable;
	private JTable tblMT;
	private JButton btnAsignar;
	private JButton btnCancelar;

	public BusquedaMPProveedorVista(ABMProveedorVista Vista) {
		super(Vista, true);
		setResizable(false);
		setTitle("Busqueda de Materia Prima");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 422, 211);
		getContentPane().add(scrollPane);
		
		this.modelTable = new WDefaultTableModel(null, this.nombreColumnas);
		tblMT = new WTable(this.modelTable);
		scrollPane.setViewportView(tblMT);
		
		btnAsignar = new JButton("Asignar");
		btnAsignar.setBounds(244, 232, 89, 23);
		getContentPane().add(btnAsignar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(343, 232, 89, 23);
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

	public JTable getTblMT() {
		return tblMT;
	}

	public JButton getBtnAsignar() {
		return btnAsignar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}
}
