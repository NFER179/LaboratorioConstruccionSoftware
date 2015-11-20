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
		setIconImage(Toolkit.getDefaultToolkit().getImage(SolicitudCompraVista.class.getResource("/Iconos/pizza_1.PNG")));
		setResizable(false);
		setTitle(" Solicitud");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 494, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 315, 407);
		contentPane.add(scrollPane);
		
		this.modelTable = new WDefaultTableModel(null, this.nombreColumnas);
		table = new WTable(this.modelTable);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		btnNuevaSolicitud = new JButton(" Nueva");
		btnNuevaSolicitud.setIcon(new ImageIcon(SolicitudCompraVista.class.getResource("/Iconos/Nuevo.png")));
		btnNuevaSolicitud.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNuevaSolicitud.setBounds(335, 11, 140, 40);
		contentPane.add(btnNuevaSolicitud);
		
		btnModificar = new JButton(" Modificar");
		btnModificar.setIcon(new ImageIcon(SolicitudCompraVista.class.getResource("/Iconos/modificar.png")));
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModificar.setBounds(335, 62, 140, 40);
		contentPane.add(btnModificar);
		
		btnInformacion = new JButton(" Informacion");
		btnInformacion.setIcon(new ImageIcon(SolicitudCompraVista.class.getResource("/Iconos/info.png")));
		btnInformacion.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnInformacion.setBounds(335, 209, 140, 40);
		contentPane.add(btnInformacion);
		
		btnSolicitudeEntregada = new JButton(" Entregada");
		btnSolicitudeEntregada.setIcon(new ImageIcon(SolicitudCompraVista.class.getResource("/Iconos/Entrega.png")));
		btnSolicitudeEntregada.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSolicitudeEntregada.setBounds(335, 136, 140, 40);
		contentPane.add(btnSolicitudeEntregada);
		
		btnTodasSolicitudes = new JButton(" Todas");
		btnTodasSolicitudes.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTodasSolicitudes.setBounds(335, 260, 140, 40);
		contentPane.add(btnTodasSolicitudes);
		
		btnVolver = new JButton("Volver");
		btnVolver.setIcon(new ImageIcon(SolicitudCompraVista.class.getResource("/Iconos/Volver.png")));
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVolver.setBounds(335, 378, 140, 40);
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