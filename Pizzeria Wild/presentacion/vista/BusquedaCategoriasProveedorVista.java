package vista;

import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import objetosVistaCustom.WDefaultTableModel;
import objetosVistaCustom.WTable;

public class BusquedaCategoriasProveedorVista extends JDialog {
	
	private String[] nombrecolumnas = {"ID Categoria", "Descripción"};
	private DefaultTableModel modelTable;
	private JTable tblCategorias;
	private JButton btnAsignar;
	private JButton btnCancelar;

	public BusquedaCategoriasProveedorVista(ABMProveedorVista Vista) {
		super(Vista, true);
		setTitle("Busqueda de Categorias");
		setResizable(false);	
		this.setLocationRelativeTo(null);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 424, 213);
		getContentPane().add(scrollPane);
		
		this.modelTable = new WDefaultTableModel(null, this.nombrecolumnas);
		tblCategorias = new WTable(this.modelTable);
		scrollPane.setViewportView(tblCategorias);
		
		btnAsignar = new JButton("Asignar");
		btnAsignar.setBounds(246, 234, 89, 23);
		getContentPane().add(btnAsignar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(345, 234, 89, 23);
		getContentPane().add(btnCancelar);
	}
	
	public void Open() {
		this.setVisible(true);
	}
	
	public void Close() {
		this.setVisible(false);
	}

	public String[] getNombrecolumnas() {
		return nombrecolumnas;
	}

	public DefaultTableModel getModelTable() {
		return modelTable;
	}

	public JTable getTblCategorias() {
		return tblCategorias;
	}

	public JButton getBtnAsignar() {
		return btnAsignar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}
}
