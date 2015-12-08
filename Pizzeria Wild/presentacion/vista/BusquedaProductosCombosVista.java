package vista;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import objetosVistaCustom.WDefaultTableModel;
import objetosVistaCustom.WTable;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.ImageIcon;

public class BusquedaProductosCombosVista extends JDialog {
	private static final long serialVersionUID = 1L;
	private String[] cbx = { "Ninguno" };
	@SuppressWarnings("rawtypes")
	private DefaultComboBoxModel modelCbx;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	private String[] nombreColumna = { "Producto" };
	private DefaultTableModel modelTable;
	private JTable table;
	private JTextField txtCantidad;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JLabel lblDescripcion;
	private JTextField txtDescripcion;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BusquedaProductosCombosVista(ABMComboVista Vista) {
		super(Vista, true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				BusquedaProductosCombosVista.class
						.getResource("/Iconos/pizza_1.PNG")));

		setTitle(" Buscar Producto");
		setBounds(100, 100, 515, 413);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);

		this.modelCbx = new DefaultComboBoxModel<>(this.cbx);
		comboBox = new JComboBox(this.modelCbx);
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(15, 16, 210, 26);
		getContentPane().add(comboBox);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 100, 474, 157);
		getContentPane().add(scrollPane);

		this.modelTable = new WDefaultTableModel(null, this.nombreColumna);
		table = new WTable(this.modelTable);
		scrollPane.setViewportView(table);

		JLabel lblCantidad = new JLabel("Cantidad: ");
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCantidad.setBounds(15, 273, 99, 25);
		getContentPane().add(lblCantidad);

		txtCantidad = new JTextField();
		txtCantidad.setBounds(124, 270, 146, 26);
		getContentPane().add(txtCantidad);
		txtCantidad.setColumns(10);

		btnAceptar = new JButton(" Aceptar");
		btnAceptar.setIcon(new ImageIcon(BusquedaProductosCombosVista.class
				.getResource("/Iconos/OK.png")));
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAceptar.setBounds(199, 324, 140, 40);
		getContentPane().add(btnAceptar);

		btnCancelar = new JButton(" Cancelar");
		btnCancelar.setIcon(new ImageIcon(BusquedaProductosCombosVista.class
				.getResource("/Iconos/salir.png")));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setBounds(349, 324, 140, 40);
		getContentPane().add(btnCancelar);

		lblDescripcion = new JLabel("Descripcion: ");
		lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDescripcion.setBounds(15, 53, 109, 25);
		getContentPane().add(lblDescripcion);

		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(113, 53, 376, 25);
		getContentPane().add(txtDescripcion);
		txtDescripcion.setColumns(10);

	}

	public void Open() {
		this.setVisible(true);
	}

	public void Close() {
		this.setVisible(false);
	}

	@SuppressWarnings("rawtypes")
	public DefaultComboBoxModel getModelCbx() {
		return modelCbx;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getComboBox() {
		return comboBox;
	}

	public String[] getNombreColumna() {
		return nombreColumna;
	}

	public DefaultTableModel getModelTable() {
		return modelTable;
	}

	public JTable getTable() {
		return table;
	}

	public JTextField getTxtCantidad() {
		return txtCantidad;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public JLabel getLblDescripcion() {
		return lblDescripcion;
	}

	public JTextField getTxtDescripcion() {
		return txtDescripcion;
	}
}