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
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.ImageIcon;

public class CategoriaDetalleVista extends JDialog {

	private JTextField txtIdcategoria;
	private JTextField txtDescr;
	private DefaultTableModel modelTable;
	private String[] nombreColumnas = { "Materias Primas Asociadas", "Unidad" };
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnAgregar;
	private JButton btnModificarMt;
	private JButton btnQuitar;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JLabel lblNewLabel;

	public CategoriaDetalleVista(CategoriaVista vtCategoria) {
		super(vtCategoria, true);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				CategoriaDetalleVista.class.getResource("/Iconos/pizza_1.PNG")));

		setTitle(" Detalle Categoria");
		setBounds(100, 100, 479, 514);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);

		JLabel lblIdCategoria = new JLabel("Id Categoria:");
		lblIdCategoria.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdCategoria.setBounds(10, 8, 91, 25);
		getContentPane().add(lblIdCategoria);

		txtIdcategoria = new JTextField();
		txtIdcategoria.setBounds(93, 8, 86, 25);
		getContentPane().add(txtIdcategoria);
		txtIdcategoria.setColumns(10);

		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDescripcin.setBounds(10, 50, 91, 25);
		getContentPane().add(lblDescripcin);

		txtDescr = new JTextField();
		txtDescr.setBounds(93, 50, 208, 25);
		getContentPane().add(txtDescr);
		txtDescr.setColumns(10);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 86, 293, 294);
		getContentPane().add(scrollPane);

		this.modelTable = new WDefaultTableModel(null, this.nombreColumnas);
		table = new WTable(this.modelTable);
		scrollPane.setViewportView(table);

		btnAgregar = new JButton("Agregar MT");
		btnAgregar.setIcon(new ImageIcon(CategoriaDetalleVista.class
				.getResource("/Iconos/Agregar.png")));
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAgregar.setBounds(313, 204, 140, 40);
		getContentPane().add(btnAgregar);

		btnModificarMt = new JButton("Modificar MT");
		btnModificarMt.setIcon(new ImageIcon(CategoriaDetalleVista.class
				.getResource("/Iconos/modificar.png")));
		btnModificarMt.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModificarMt.setBounds(313, 277, 140, 40);
		getContentPane().add(btnModificarMt);

		btnQuitar = new JButton("Quitar MT");
		btnQuitar.setIcon(new ImageIcon(CategoriaDetalleVista.class
				.getResource("/Iconos/Quitar.png")));
		btnQuitar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnQuitar.setBounds(313, 340, 140, 40);
		getContentPane().add(btnQuitar);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setIcon(new ImageIcon(CategoriaDetalleVista.class
				.getResource("/Iconos/Guardar.png")));
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGuardar.setBounds(161, 425, 140, 40);
		getContentPane().add(btnGuardar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(CategoriaDetalleVista.class
				.getResource("/Iconos/salir.png")));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setBounds(313, 425, 140, 40);
		getContentPane().add(btnCancelar);

		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CategoriaDetalleVista.class
				.getResource("/Iconos/Logo Pizzeria Wild .png")));
		lblNewLabel.setBounds(290, 8, 163, 169);
		getContentPane().add(lblNewLabel);
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

	public JButton getBtnModificarMt() {
		return btnModificarMt;
	}

	// public JButton getBtnCambiarMt() {
	// return btnCambiarMt;
	// }
}