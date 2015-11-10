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
import javax.swing.JCheckBox;

public class ABMProveedorVista extends JDialog {
	
	private JTextField txtProveedorid;
	private JCheckBox chckbxActivo;
	private JTextField txtNombreproveedor;
	private JTextField txtTelefono;
	private JTextField txtMail;
	private JLabel lblCategorias;
	private String[] nombreColumnasCategoria = {"ID","Descripcion"};
	private DefaultTableModel modelCategoria;
	private JTable tblCategoria;
	private JScrollPane scrpCategoria;
	private JButton btnAgregarCategoria;
	private JButton btnQuitarCategoria;
	private JLabel lblMateriaPrima;
	private String[] nombreColumnasMT = {"Materia Prima"};
	private DefaultTableModel modelMT;
	private JTable tblMateriaPrima;
	private JScrollPane scrpMateriaPrima;
	private JButton btnAgregarMT;
	private JButton btnQuitarMT;
	private JButton btnGuardar;
	private JButton btnCancelar;


	public ABMProveedorVista(ProveedorVista Vista) {
		super(Vista, true);
		
		setResizable(false);
		setTitle("Proveedor");
		setBounds(100, 100, 581, 446);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblProveedorId = new JLabel("Proveedor ID: ");
		lblProveedorId.setBounds(10, 11, 98, 14);
		getContentPane().add(lblProveedorId);
		
		txtProveedorid = new JTextField();
		txtProveedorid.setBounds(105, 8, 98, 20);
		getContentPane().add(txtProveedorid);
		txtProveedorid.setColumns(10);
		
		chckbxActivo = new JCheckBox("Activo");
		chckbxActivo.setBounds(396, 7, 97, 23);
		getContentPane().add(chckbxActivo);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(10, 36, 98, 14);
		getContentPane().add(lblNombre);
		
		txtNombreproveedor = new JTextField();
		txtNombreproveedor.setBounds(105, 33, 285, 20);
		getContentPane().add(txtNombreproveedor);
		txtNombreproveedor.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono: ");
		lblTelefono.setBounds(10, 61, 98, 14);
		getContentPane().add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(105, 58, 123, 20);
		getContentPane().add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblMail = new JLabel("Mail: ");
		lblMail.setBounds(10, 86, 98, 14);
		getContentPane().add(lblMail);
		
		txtMail = new JTextField();
		txtMail.setBounds(105, 83, 86, 20);
		getContentPane().add(txtMail);
		txtMail.setColumns(10);
		
		lblCategorias = new JLabel("Categorias: ");
		lblCategorias.setBounds(10, 111, 98, 14);
		getContentPane().add(lblCategorias);
		
		scrpCategoria = new JScrollPane();
		scrpCategoria.setBounds(10, 136, 380, 95);
		getContentPane().add(scrpCategoria);
		
		this.modelCategoria = new WDefaultTableModel(null, this.nombreColumnasCategoria);
		tblCategoria = new WTable(this.modelCategoria);
		scrpCategoria.setViewportView(tblCategoria);
		
		btnAgregarCategoria = new JButton("Agregar Categoria");
		btnAgregarCategoria.setBounds(444, 137, 121, 23);
		getContentPane().add(btnAgregarCategoria);
		
		btnQuitarCategoria = new JButton("Quitar Categoria");
		btnQuitarCategoria.setBounds(444, 171, 121, 23);
		getContentPane().add(btnQuitarCategoria);
		
		lblMateriaPrima = new JLabel("Materias Primas: ");
		lblMateriaPrima.setBounds(10, 247, 98, 14);
		getContentPane().add(lblMateriaPrima);
		
		scrpMateriaPrima = new JScrollPane();
		scrpMateriaPrima.setBounds(10, 272, 380, 96);
		getContentPane().add(scrpMateriaPrima);
		
		this.modelMT = new WDefaultTableModel(null, this.nombreColumnasMT);
		tblMateriaPrima = new WTable(this.modelMT);
		scrpMateriaPrima.setViewportView(tblMateriaPrima);
		
		btnAgregarMT = new JButton("Agregar Materia Prima");
		btnAgregarMT.setBounds(426, 273, 139, 23);
		getContentPane().add(btnAgregarMT);
		
		btnQuitarMT = new JButton("Quitar Materia Prima");
		btnQuitarMT.setBounds(426, 307, 139, 23);
		getContentPane().add(btnQuitarMT);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(377, 383, 89, 23);
		getContentPane().add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(476, 383, 89, 23);
		getContentPane().add(btnCancelar);
	}
	
	public void Open() {
		this.setVisible(true);
	}
	
	public void Close() {
		this.setVisible(false);
	}

	public JTextField getTxtProveedorid() {
		return txtProveedorid;
	}

	public JTextField getTxtNombreproveedor() {
		return txtNombreproveedor;
	}

	public JTextField getTxtTelefono() {
		return txtTelefono;
	}

	public JTextField getTxtMail() {
		return txtMail;
	}

	public JLabel getLblCategorias() {
		return lblCategorias;
	}

	public String[] getNombreColumnasCategoria() {
		return nombreColumnasCategoria;
	}

	public DefaultTableModel getModelCategoria() {
		return modelCategoria;
	}

	public JTable getTblCategoria() {
		return tblCategoria;
	}

	public JScrollPane getScrpCategoria() {
		return scrpCategoria;
	}

	public JButton getBtnAgregarCategoria() {
		return btnAgregarCategoria;
	}

	public JButton getBtnQuitarCategoria() {
		return btnQuitarCategoria;
	}

	public JLabel getLblMateriaPrima() {
		return lblMateriaPrima;
	}

	public String[] getNombreColumnasMT() {
		return nombreColumnasMT;
	}

	public DefaultTableModel getModelMT() {
		return modelMT;
	}

	public JTable getTblMateriaPrima() {
		return tblMateriaPrima;
	}

	public JScrollPane getScrpMateriaPrima() {
		return scrpMateriaPrima;
	}

	public JButton getBtnAgregarMT() {
		return btnAgregarMT;
	}

	public JButton getBtnQuitarMT() {
		return btnQuitarMT;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public JCheckBox getChckbxActivo() {
		return chckbxActivo;
	}
}
