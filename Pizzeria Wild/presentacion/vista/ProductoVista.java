package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import objetosVistaCustom.WDefaultTableModel;
import objetosVistaCustom.WTable;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Dialog.ModalExclusionType;

public class ProductoVista extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String[] nombreColumnas = { "Id", "Descripcion" };
	private DefaultTableModel modelTable;
	private JTable table;
	private JButton btnAgregar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnVolver;
	private JLabel lblNewLabel;

	public ProductoVista() {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				ProductoVista.class.getResource("/Iconos/pizza_1.PNG")));
		setTitle(" Productos");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 493, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);

		JLabel lblProductos = new JLabel("Productos: ");
		lblProductos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblProductos.setBounds(10, 11, 106, 25);
		contentPane.add(lblProductos);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 34, 315, 348);
		contentPane.add(scrollPane);

		this.modelTable = new WDefaultTableModel(null, this.nombreColumnas);
		table = new WTable(this.modelTable);
		scrollPane.setViewportView(table);

		btnAgregar = new JButton(" Agregar");
		btnAgregar.setIcon(new ImageIcon(ProductoVista.class
				.getResource("/Iconos/Agregar.png")));
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAgregar.setBounds(335, 32, 140, 40);
		contentPane.add(btnAgregar);

		btnModificar = new JButton(" Modificar");
		btnModificar.setIcon(new ImageIcon(ProductoVista.class
				.getResource("/Iconos/modificar.png")));
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModificar.setBounds(335, 83, 140, 40);
		contentPane.add(btnModificar);

		btnEliminar = new JButton(" Eliminar");
		btnEliminar.setIcon(new ImageIcon(ProductoVista.class
				.getResource("/Iconos/Quitar.png")));
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEliminar.setBounds(335, 134, 140, 40);
		contentPane.add(btnEliminar);

		btnVolver = new JButton(" Volver");
		btnVolver.setIcon(new ImageIcon(ProductoVista.class
				.getResource("/Iconos/Volver.png")));
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVolver.setBounds(335, 342, 140, 40);
		contentPane.add(btnVolver);

		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ProductoVista.class
				.getResource("/Iconos/Logo Pizzeria Wild 96x96.png")));
		lblNewLabel.setBounds(356, 203, 106, 103);
		contentPane.add(lblNewLabel);
	}

	public void Open() {
		this.setVisible(true);
	}

	public void Close() {
		this.setVisible(false);
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JTable getTable() {
		return table;
	}

	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public String[] getNombreColumnas() {
		return nombreColumnas;
	}

	public DefaultTableModel getModelTable() {
		return modelTable;
	}

}