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

public class SolicitudCompraVista extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel modelTable;
	private String[] nombreColumnas = {"Fecha","Numero Solicitud","Estado"};
	private JTable table;
	private JButton btnNuevaSolicitud;
	private JButton btnModificar;
	private JButton btnInformacion;
	private JButton btnTodasSolicitudes;
	private JButton btnVolver;
	private JButton btnSolicitudeEntregada;

	public SolicitudCompraVista() {
		setResizable(false);
		setTitle("Solicitud");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 510, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 315, 244);
		contentPane.add(scrollPane);
		
		this.modelTable = new WDefaultTableModel(null, this.nombreColumnas);
		table = new WTable(this.modelTable);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		btnNuevaSolicitud = new JButton("Nueva Solicitud");
		btnNuevaSolicitud.setBounds(335, 11, 159, 23);
		contentPane.add(btnNuevaSolicitud);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(335, 45, 159, 23);
		contentPane.add(btnModificar);
		
		btnInformacion = new JButton("Informacion");
		btnInformacion.setBounds(335, 79, 159, 23);
		contentPane.add(btnInformacion);
		
		btnSolicitudeEntregada = new JButton("Solicitud Entregada");
		btnSolicitudeEntregada.setBounds(335, 113, 159, 23);
		contentPane.add(btnSolicitudeEntregada);
		
		btnTodasSolicitudes = new JButton("Todas las Solicitudes");
		btnTodasSolicitudes.setBounds(335, 147, 159, 23);
		contentPane.add(btnTodasSolicitudes);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(335, 232, 159, 23);
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

	public JButton getBtnNuevaSolicitud() {
		return btnNuevaSolicitud;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JButton getBtnInformacion() {
		return btnInformacion;
	}

	public JButton getBtnTodasSolicitudes() {
		return btnTodasSolicitudes;
	}

	public JButton getBtnSolicitudEntregada() {
		return btnSolicitudeEntregada;
	}
}