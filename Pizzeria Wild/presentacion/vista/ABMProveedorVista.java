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
import java.awt.Font;
import java.awt.Panel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;

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
	private JLabel lblNewLabel;


	public ABMProveedorVista(ProveedorVista Vista) {
		super(Vista, true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ABMProveedorVista.class.getResource("/Iconos/pizza_1.PNG")));
		
		setResizable(false);
		setTitle(" Proveedor");
		setBounds(100, 145, 550, 483);
		//this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblProveedorId = new JLabel("Proveedor ID: ");
		lblProveedorId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblProveedorId.setBounds(10, 11, 98, 14);
		getContentPane().add(lblProveedorId);
		
		txtProveedorid = new JTextField();
		txtProveedorid.setBounds(105, 8, 98, 20);
		getContentPane().add(txtProveedorid);
		txtProveedorid.setColumns(10);
		
		chckbxActivo = new JCheckBox("Activo");
		chckbxActivo.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxActivo.setBounds(306, 7, 84, 23);
		getContentPane().add(chckbxActivo);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setBounds(10, 36, 98, 14);
		getContentPane().add(lblNombre);
		
		txtNombreproveedor = new JTextField();
		txtNombreproveedor.setBounds(105, 33, 285, 20);
		getContentPane().add(txtNombreproveedor);
		txtNombreproveedor.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono: ");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTelefono.setBounds(10, 61, 98, 14);
		getContentPane().add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(105, 58, 123, 20);
		getContentPane().add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblMail = new JLabel("Mail: ");
		lblMail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMail.setBounds(10, 86, 98, 14);
		getContentPane().add(lblMail);
		
		txtMail = new JTextField();
		txtMail.setBounds(105, 83, 285, 20);
		getContentPane().add(txtMail);
		txtMail.setColumns(10);
		
		lblCategorias = new JLabel("Categorias: ");
		lblCategorias.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCategorias.setBounds(10, 111, 98, 14);
		getContentPane().add(lblCategorias);
		
		scrpCategoria = new JScrollPane();
		scrpCategoria.setBounds(10, 136, 406, 95);
		getContentPane().add(scrpCategoria);
		
		this.modelCategoria = new WDefaultTableModel(null, this.nombreColumnasCategoria);
		tblCategoria = new WTable(this.modelCategoria);
		scrpCategoria.setViewportView(tblCategoria);
		
		lblMateriaPrima = new JLabel("Materias Primas: ");
		lblMateriaPrima.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMateriaPrima.setBounds(10, 247, 98, 14);
		getContentPane().add(lblMateriaPrima);
		
		scrpMateriaPrima = new JScrollPane();
		scrpMateriaPrima.setBounds(10, 272, 406, 96);
		getContentPane().add(scrpMateriaPrima);
		
		this.modelMT = new WDefaultTableModel(null, this.nombreColumnasMT);
		tblMateriaPrima = new WTable(this.modelMT);
		scrpMateriaPrima.setViewportView(tblMateriaPrima);
		
		btnAgregarMT = new JButton("Agregar");
		btnAgregarMT.setBackground(new Color(240, 255, 240));
		btnAgregarMT.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAgregarMT.setBounds(426, 273, 100, 40);
		getContentPane().add(btnAgregarMT);
		
		btnQuitarMT = new JButton("Quitar");
		btnQuitarMT.setBackground(new Color(255, 240, 245));
		btnQuitarMT.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnQuitarMT.setBounds(426, 328, 100, 40);
		getContentPane().add(btnQuitarMT);
		
		btnGuardar = new JButton(" Guardar");
		btnGuardar.setIcon(new ImageIcon(ABMProveedorVista.class.getResource("/Iconos/Guardar.png")));
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGuardar.setBounds(224, 400, 140, 40);
		getContentPane().add(btnGuardar);
		
		btnCancelar = new JButton(" Cancelar");
		btnCancelar.setIcon(new ImageIcon(ABMProveedorVista.class.getResource("/Iconos/salir.png")));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setBounds(386, 400, 140, 40);
		getContentPane().add(btnCancelar);
		
		btnAgregarCategoria = new JButton("Agregar");
		btnAgregarCategoria.setBackground(new Color(240, 255, 240));
		btnAgregarCategoria.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAgregarCategoria.setBounds(426, 136, 100, 40);
		getContentPane().add(btnAgregarCategoria);
		
		btnQuitarCategoria = new JButton("Quitar");
		btnQuitarCategoria.setBackground(new Color(255, 240, 245));
		btnQuitarCategoria.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnQuitarCategoria.setBounds(426, 191, 100, 40);
		getContentPane().add(btnQuitarCategoria);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ABMProveedorVista.class.getResource("/Iconos/Logo Pizzeria Wild 96x96.png")));
		lblNewLabel.setBounds(426, 11, 100, 102);
		getContentPane().add(lblNewLabel);
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
