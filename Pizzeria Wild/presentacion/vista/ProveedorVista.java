package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import objetosVistaCustom.WDefaultTableModel;
import objetosVistaCustom.WTable;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.ImageIcon;

public class ProveedorVista extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultTableModel modelTable;
	private String[] nombreColumnas = { "ID", "Nombre", "Activo" };
	private JTable table;
	private JButton btnNuevoProveedor;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnVolver;

	public ProveedorVista() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				ProveedorVista.class.getResource("/Iconos/pizza_1.PNG")));
		setResizable(false);
		setTitle(" Proveedor");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 677, 297);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 504, 239);
		contentPane.add(scrollPane);

		this.modelTable = new WDefaultTableModel(null, this.nombreColumnas);
		table = new WTable(this.modelTable);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);

		btnNuevoProveedor = new JButton(" Nuevo");
		btnNuevoProveedor.setIcon(new ImageIcon(ProveedorVista.class
				.getResource("/Iconos/Nuevo.png")));
		btnNuevoProveedor.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNuevoProveedor.setBounds(524, 11, 140, 40);
		contentPane.add(btnNuevoProveedor);

		btnModificar = new JButton(" Modificar");
		btnModificar.setIcon(new ImageIcon(ProveedorVista.class
				.getResource("/Iconos/modificar.png")));
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModificar.setBounds(524, 62, 140, 40);
		contentPane.add(btnModificar);

		btnEliminar = new JButton(" Eliminar");
		btnEliminar.setIcon(new ImageIcon(ProveedorVista.class
				.getResource("/Iconos/Quitar.png")));
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEliminar.setBounds(524, 113, 140, 40);
		contentPane.add(btnEliminar);

		btnVolver = new JButton(" Volver");
		btnVolver.setIcon(new ImageIcon(ProveedorVista.class
				.getResource("/Iconos/Volver.png")));
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVolver.setBounds(524, 210, 140, 40);
		contentPane.add(btnVolver);
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

	public JButton getBtnNuevoProveedor() {
		return btnNuevoProveedor;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}
}