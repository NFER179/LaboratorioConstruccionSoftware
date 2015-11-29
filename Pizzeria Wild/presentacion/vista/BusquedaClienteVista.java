package vista;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import objetosVistaCustom.WDefaultTableModel;
import objetosVistaCustom.WTable;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JTextField;

public class BusquedaClienteVista extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	@SuppressWarnings("rawtypes")
	private TableRowSorter sorter;
	private DefaultTableModel modelCliente;
	private String[] nombreColumnas = { "ID Cliente", "Nombre" };
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JTextField txtFiltro;
	private JButton btnBuscar;

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}

	@SuppressWarnings("unchecked")
	public BusquedaClienteVista(JDialog FramePadre) {
		super(FramePadre, true);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				BusquedaClienteVista.class.getResource("/Iconos/pizza_1.PNG")));

		this.setTitle(" Busqueda de Cliente");
		this.setBounds(100, 100, 328, 459);
		this.getContentPane().setLayout(new BorderLayout());
		this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.getContentPane().add(contentPanel, BorderLayout.CENTER);
		this.contentPanel.setLayout(null);
		this.setLocationRelativeTo(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 30, 300, 333);
		this.contentPanel.add(scrollPane);

		this.modelCliente = new WDefaultTableModel(null, this.nombreColumnas);
		this.table = new WTable(this.modelCliente);
		this.table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);

		this.sorter = new TableRowSorter<TableModel>(modelCliente);
		table.setRowSorter(sorter);

		this.btnAceptar = new JButton("Aceptar");
		btnAceptar.setIcon(new ImageIcon(BusquedaClienteVista.class
				.getResource("/Iconos/OK.png")));
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.btnAceptar.setBounds(10, 374, 140, 40);
		this.contentPanel.add(btnAceptar);

		this.btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(BusquedaClienteVista.class
				.getResource("/Iconos/salir.png")));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.btnCancelar.setBounds(170, 374, 140, 40);
		this.contentPanel.add(btnCancelar);

		txtFiltro = new JTextField();
		txtFiltro.setBounds(10, 11, 218, 20);
		contentPanel.add(txtFiltro);
		txtFiltro.setColumns(10);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(221, 10, 89, 23);
		contentPanel.add(btnBuscar);
	}

	public void Open() {
		this.setVisible(true);
	}

	public void Close() {
		this.setVisible(false);
	}

	public JTable getTable() {
		return table;
	}

	public DefaultTableModel getModelCliente() {
		return modelCliente;
	}

	public String[] getNombreColumnas() {
		return nombreColumnas;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	@SuppressWarnings("rawtypes")
	public TableRowSorter getSorter() {
		return sorter;
	}

	@SuppressWarnings("rawtypes")
	public void setSorter(TableRowSorter sorter) {
		this.sorter = sorter;
	}

	public JTextField getTxtFiltro() {
		return txtFiltro;
	}

	public void setTxtFiltro(JTextField txtFiltro) {
		this.txtFiltro = txtFiltro;
	}
}