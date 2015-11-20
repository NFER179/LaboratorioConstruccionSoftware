package vista;

import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import objetosVistaCustom.WDefaultTableModel;
import objetosVistaCustom.WTable;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class BusquedaCategoriasProveedorVista extends JDialog {
	
	private String[] nombrecolumnas = {"ID Categoria", "Descripción"};
	private DefaultTableModel modelTable;
	private JTable tblCategorias;
	private JButton btnAsignar;
	private JButton btnCancelar;
	private JLabel lblNewLabel;

	public BusquedaCategoriasProveedorVista(ABMProveedorVista Vista) {
		super(Vista, true);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(BusquedaCategoriasProveedorVista.class.getResource("/Iconos/pizza_1.PNG")));
		setTitle(" Busqueda de Categorias");
		setResizable(false);	
		this.setLocationRelativeTo(null);
		setBounds(100, 100, 450, 329);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 424, 201);
		getContentPane().add(scrollPane);
		
		this.modelTable = new WDefaultTableModel(null, this.nombrecolumnas);
		tblCategorias = new WTable(this.modelTable);
		scrollPane.setViewportView(tblCategorias);
		
		btnAsignar = new JButton(" Asignar");
		btnAsignar.setIcon(new ImageIcon(BusquedaCategoriasProveedorVista.class.getResource("/Iconos/Agregar.png")));
		btnAsignar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAsignar.setBounds(144, 246, 140, 40);
		getContentPane().add(btnAsignar);
		
		btnCancelar = new JButton(" Cancelar");
		btnCancelar.setIcon(new ImageIcon(BusquedaCategoriasProveedorVista.class.getResource("/Iconos/salir.png")));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setBounds(294, 246, 140, 40);
		getContentPane().add(btnCancelar);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(BusquedaCategoriasProveedorVista.class.getResource("/Iconos/Logo Pizzeria Wild 2.png")));
		lblNewLabel.setBounds(36, 222, 71, 64);
		getContentPane().add(lblNewLabel);
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
