package vista;

import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import objetosVistaCustom.WDefaultTableModel;
import objetosVistaCustom.WTable;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class SeleccionMateriaPrimaSolicitudVista extends JDialog {
	private static final long serialVersionUID = 1L;
	private DefaultTableModel modelTable;
	private String[] nombreColumnas = { "Materia Prima", "Unidad" };
	private JTable table;
	private JTextField txtCantidad;
	private JButton btnAceptar;
	private JButton btnCancelar;

	public SeleccionMateriaPrimaSolicitudVista(CreacionSolicitudVista arg0) {
		super(arg0, true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				SeleccionMateriaPrimaSolicitudVista.class
						.getResource("/Iconos/pizza_1.PNG")));

		setTitle("Seleccion Materia Prima");
		setBounds(100, 100, 380, 453);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 352, 309);
		getContentPane().add(scrollPane);

		this.modelTable = new WDefaultTableModel(null, this.nombreColumnas);
		table = new WTable(this.modelTable);
		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JLabel lblCantidad = new JLabel("Cantidad: ");
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCantidad.setBounds(208, 335, 69, 20);
		getContentPane().add(lblCantidad);

		txtCantidad = new JTextField();
		txtCantidad.setBounds(276, 332, 86, 25);
		getContentPane().add(txtCantidad);
		txtCantidad.setColumns(10);

		btnAceptar = new JButton(" Aceptar");
		btnAceptar.setIcon(new ImageIcon(
				SeleccionMateriaPrimaSolicitudVista.class
						.getResource("/Iconos/OK.png")));
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAceptar.setBounds(10, 368, 140, 40);
		getContentPane().add(btnAceptar);

		btnCancelar = new JButton(" Cancelar");
		btnCancelar.setIcon(new ImageIcon(
				SeleccionMateriaPrimaSolicitudVista.class
						.getResource("/Iconos/salir.png")));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setBounds(222, 368, 140, 40);
		getContentPane().add(btnCancelar);
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

	public JTextField getTxtCantidad() {
		return txtCantidad;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}
}