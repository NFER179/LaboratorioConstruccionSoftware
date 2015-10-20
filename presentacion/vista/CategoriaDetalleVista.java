package vista;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import objetosVistaCustom.WDefaultTableModel;
import objetosVistaCustom.WTable;

public class CategoriaDetalleVista extends JDialog {
	
	private JTextField txtIdcategoria;
	private JTextField txtDescr;
	private DefaultTableModel modelTable;
	private String[] nombreColumnas = {"Materias Primas Asociadas"};
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnAgregar;
	private JButton btnQuitar;
	private JButton btnGuardar;
	private JButton btnCancelar;

	public CategoriaDetalleVista(CategoriaVista vtCategoria) {
		super(vtCategoria, true);
		
		setTitle("Detalle Categoria");
		setBounds(100, 100, 420, 298);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel lblIdCategoria = new JLabel("Id Categoria:");
		lblIdCategoria.setBounds(10, 11, 91, 14);
		getContentPane().add(lblIdCategoria);
		
		txtIdcategoria = new JTextField();
		txtIdcategoria.setBounds(93, 8, 86, 20);
		getContentPane().add(txtIdcategoria);
		txtIdcategoria.setColumns(10);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setBounds(10, 39, 91, 14);
		getContentPane().add(lblDescripcin);
		
		txtDescr = new JTextField();
		txtDescr.setBounds(93, 36, 208, 20);
		getContentPane().add(txtDescr);
		txtDescr.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(93, 64, 210, 155);
		getContentPane().add(scrollPane);
		
		this.modelTable = new WDefaultTableModel(null, this.nombreColumnas);
		table = new WTable(this.modelTable);
		scrollPane.setViewportView(table);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(313, 67, 89, 23);
		getContentPane().add(btnAgregar);
		
		btnQuitar = new JButton("Quitar");
		btnQuitar.setBounds(313, 101, 89, 23);
		getContentPane().add(btnQuitar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(212, 230, 89, 23);
		getContentPane().add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(313, 230, 89, 23);
		getContentPane().add(btnCancelar);
	}
	
	public void Open() {
		this.setVisible(true);
	}
	
	public void Close() {
		this.setVisible(false);
	}

	public JTextField getTxtIdcategoria() {
		return txtIdcategoria;
	}

	public JTextField getTxtDescr() {
		return txtDescr;
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

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public JButton getBtnQuitar() {
		return btnQuitar;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}
}