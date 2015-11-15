package vista;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import objetosVistaCustom.WDefaultTableModel;
import objetosVistaCustom.WTable;


@SuppressWarnings("serial")
public class BusquedaClienteVista extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private JTable table;
	private DefaultTableModel modelCliente;
	private String[] nombreColumnas = {"ID Cliente", "Nombre"};
	private JButton btnAceptar;
	private JButton btnCancelar;

	public BusquedaClienteVista(JDialog FramePadre) {
		super(FramePadre, true);
		
		this.setTitle("Busqueda de Cliente");
		this.setBounds(100, 100, 328, 260);
		this.getContentPane().setLayout(new BorderLayout());
		this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.getContentPane().add(contentPanel, BorderLayout.CENTER);
		this.contentPanel.setLayout(null);
		this.setLocationRelativeTo(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 300, 167);
		this.contentPanel.add(scrollPane);

		this.modelCliente = new WDefaultTableModel(null, this.nombreColumnas);
		this.table = new WTable(this.modelCliente);
		this.table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);

		this.btnAceptar = new JButton("Aceptar");
		this.btnAceptar.setBounds(122, 189, 89, 23);
		this.contentPanel.add(btnAceptar);

		this.btnCancelar = new JButton("Cancelar");
		this.btnCancelar.setBounds(221, 189, 89, 23);
		this.contentPanel.add(btnCancelar);		
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
}