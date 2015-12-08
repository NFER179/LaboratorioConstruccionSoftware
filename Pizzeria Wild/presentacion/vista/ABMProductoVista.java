package vista;
 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import objetosVistaCustom.WDefaultTableModel;
import objetosVistaCustom.WTable;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Dialog.ModalExclusionType;

public class ABMProductoVista extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField txtIdproducto;
	private JTextField txtDescipcion;
	private JCheckBox chckbxEleboraCocina;
	private String[] nombreColumnas = { "Sabor", "Precio" };
	private DefaultTableModel modelTable;
	private JTable table;
	private JButton btnAgregar;
	private JButton btnEliminar;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JLabel lblNewLabel;

	public ABMProductoVista(ProductoVista Vista) {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				ABMProductoVista.class.getResource("/Iconos/pizza_1.PNG")));
		setTitle(" Informacion Producto");
		setResizable(false);
		setBounds(100, 100, 450, 404);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);

		JLabel lblIdProducto = new JLabel("Id Producto:");
		lblIdProducto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdProducto.setBounds(10, 11, 93, 25);
		getContentPane().add(lblIdProducto);

		txtIdproducto = new JTextField();
		txtIdproducto.setBounds(100, 8, 86, 25);
		getContentPane().add(txtIdproducto);
		txtIdproducto.setColumns(10);

		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDescripcion.setBounds(10, 47, 93, 25);
		getContentPane().add(lblDescripcion);

		txtDescipcion = new JTextField();
		txtDescipcion.setBounds(100, 47, 196, 25);
		getContentPane().add(txtDescipcion);
		txtDescipcion.setColumns(10);

		chckbxEleboraCocina = new JCheckBox("Elebora Cocina");
		chckbxEleboraCocina.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxEleboraCocina.setBounds(10, 79, 137, 25);
		getContentPane().add(chckbxEleboraCocina);

		JLabel lblSabores = new JLabel("Sabores:");
		lblSabores.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSabores.setBounds(10, 111, 93, 25);
		getContentPane().add(lblSabores);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 136, 255, 174);
		getContentPane().add(scrollPane);

		this.modelTable = new WDefaultTableModel(null, this.nombreColumnas);
		table = new WTable(this.modelTable);
		scrollPane.setViewportView(table);

		btnAgregar = new JButton(" Agregar");
		btnAgregar.setIcon(new ImageIcon(ABMProductoVista.class
				.getResource("/Iconos/Agregar.png")));
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAgregar.setBounds(294, 136, 140, 40);
		getContentPane().add(btnAgregar);

		btnEliminar = new JButton(" Eliminar");
		btnEliminar.setIcon(new ImageIcon(ABMProductoVista.class
				.getResource("/Iconos/Quitar.png")));
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEliminar.setBounds(294, 187, 140, 40);
		getContentPane().add(btnEliminar);

		btnGuardar = new JButton(" Guardar");
		btnGuardar.setIcon(new ImageIcon(ABMProductoVista.class
				.getResource("/Iconos/Guardar.png")));
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGuardar.setBounds(144, 321, 140, 40);
		getContentPane().add(btnGuardar);

		btnCancelar = new JButton(" Cancelar");
		btnCancelar.setIcon(new ImageIcon(ABMProductoVista.class
				.getResource("/Iconos/salir.png")));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setBounds(294, 321, 140, 40);
		getContentPane().add(btnCancelar);

		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ABMProductoVista.class
				.getResource("/Iconos/Logo Pizzeria Wild 96x96.png")));
		lblNewLabel.setBounds(332, 11, 102, 99);
		getContentPane().add(lblNewLabel);

	}

	public void Open() {
		this.setVisible(true);
	}

	public void Close() {
		this.setVisible(false);
	}

	public JTextField getTxtIdproducto() {
		return txtIdproducto;
	}

	public JTextField getTxtDescipcion() {
		return txtDescipcion;
	}

	public JCheckBox getChckbxEleboraCocina() {
		return chckbxEleboraCocina;
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

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}
}
