package vista;

import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import objetosVistaCustom.WDefaultTableModel;
import objetosVistaCustom.WTable;

public class SeleccionMateriaPrimaVista extends JDialog {

	private DefaultTableModel modelTable;
	private String[] nombreColumnas = {"Materias Primas"};
	private JTable table;
	private JButton btnAsignar;
	private JButton btnCancelar;

	public SeleccionMateriaPrimaVista(CategoriaDetalleVista CategoriaDetalle) {
		super(CategoriaDetalle, true);
		
		setTitle("Seleccion Materias Primas");
		setBounds(100, 100, 270, 287);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 242, 197);
		getContentPane().add(scrollPane);
		
		this.modelTable = new WDefaultTableModel(null, this.nombreColumnas);
		table = new WTable(this.modelTable);
		scrollPane.setViewportView(table);
		
		btnAsignar = new JButton("Asignar");
		btnAsignar.setBounds(64, 219, 89, 23);
		getContentPane().add(btnAsignar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(163, 219, 89, 23);
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

	public JButton getBtnAsignar() {
		return btnAsignar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}
}