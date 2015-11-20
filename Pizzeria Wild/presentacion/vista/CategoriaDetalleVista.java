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
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

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
	private JLabel lblNewLabel;

	public CategoriaDetalleVista(CategoriaVista vtCategoria) {
		super(vtCategoria, true);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CategoriaDetalleVista.class.getResource("/Iconos/pizza_1.PNG")));
		
		setTitle(" Detalle Categoria");
		setBounds(100, 100, 420, 338);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel lblIdCategoria = new JLabel("Id Categoria:");
		lblIdCategoria.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdCategoria.setBounds(10, 11, 91, 14);
		getContentPane().add(lblIdCategoria);
		
		txtIdcategoria = new JTextField();
		txtIdcategoria.setBounds(93, 8, 86, 20);
		getContentPane().add(txtIdcategoria);
		txtIdcategoria.setColumns(10);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDescripcin.setBounds(10, 39, 91, 14);
		getContentPane().add(lblDescripcin);
		
		txtDescr = new JTextField();
		txtDescr.setBounds(93, 36, 208, 20);
		getContentPane().add(txtDescr);
		txtDescr.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 64, 227, 178);
		getContentPane().add(scrollPane);
		
		this.modelTable = new WDefaultTableModel(null, this.nombreColumnas);
		table = new WTable(this.modelTable);
		scrollPane.setViewportView(table);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setIcon(new ImageIcon(CategoriaDetalleVista.class.getResource("/Iconos/Agregar.png")));
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAgregar.setBounds(262, 97, 140, 40);
		getContentPane().add(btnAgregar);
		
		btnQuitar = new JButton("Quitar");
		btnQuitar.setIcon(new ImageIcon(CategoriaDetalleVista.class.getResource("/Iconos/Quitar.png")));
		btnQuitar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnQuitar.setBounds(262, 148, 140, 40);
		getContentPane().add(btnQuitar);
		
		btnGuardar = new JButton(" Guardar");
		btnGuardar.setIcon(new ImageIcon(CategoriaDetalleVista.class.getResource("/Iconos/Guardar.png")));
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGuardar.setBounds(93, 253, 140, 40);
		getContentPane().add(btnGuardar);
		
		btnCancelar = new JButton(" Cancelar");
		btnCancelar.setIcon(new ImageIcon(CategoriaDetalleVista.class.getResource("/Iconos/salir.png")));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setBounds(262, 253, 140, 40);
		getContentPane().add(btnCancelar);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CategoriaDetalleVista.class.getResource("/Iconos/Logo Pizzeria Wild 2.png")));
		lblNewLabel.setBounds(330, 7, 72, 67);
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
}