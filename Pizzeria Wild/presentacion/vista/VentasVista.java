package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import objetosVistaCustom.WDefaultTableModel;
import objetosVistaCustom.WTable;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

@SuppressWarnings("serial")
public class VentasVista extends JFrame {

	private JPanel contentPane;
	private JTable tableVentas;
	private DefaultTableModel modelVentas;
	private String[] nombreColumnas = { "Fecha", "Nº Venta", "Cliente",
			"Valor a Cobrar", "Estado", "A Domicilio" };
	private JButton btnNuevaVenta;
	private JButton btnCancelarVenta;
	private JButton btnVentaEntregada;
	private JButton btnEnviar;
	private JButton btnEnViaje;
	private JButton btnEnMostrador;
	private JButton btnInformacin;
	private JButton btnModificar;
	private JButton btnVolverInicio;
//	private JMenuItem mntmReporteDiario;
//	private JMenuItem mntmReporteSemanal;
//	private JMenuItem mntmReporteMensual;
//	private JMenuItem mntmNuevoProveedor;
//	private JMenuItem mntmBusquedaDeProveedores;
//
//	private JMenuItem mntmNuevaSolicitud;
//	private JMenuItem mntmEditarSolicitudesGuardadas;

	public VentasVista() {

		this.setResizable(false);
		this.setTitle("Ventas");
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setBounds(100, 100, 702, 419);
		
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		this.contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
//		JMenuBar menuBar_1 = new JMenuBar();
//		setJMenuBar(menuBar_1);

//		JMenu mnReportes = new JMenu("Reportes");
//		menuBar_1.add(mnReportes);

//		mntmReporteDiario = new JMenuItem("Reporte Diario");
//		mnReportes.add(mntmReporteDiario);

//		mntmReporteSemanal = new JMenuItem("Reporte Semanal");
//		mnReportes.add(mntmReporteSemanal);

//		mntmReporteMensual = new JMenuItem("Reporte Mensual");
//		mnReportes.add(mntmReporteMensual);

//		JMenu mnProveedores = new JMenu("Proveedores");
//		menuBar_1.add(mnProveedores);

//		mntmNuevoProveedor = new JMenuItem("Nuevo Proveedor");
//		mnProveedores.add(mntmNuevoProveedor);

//		mntmBusquedaDeProveedores = new JMenuItem("Busqueda de Proveedores");
//		mnProveedores.add(mntmBusquedaDeProveedores);

//		JMenu mnMateriasPrimas = new JMenu("Materias Primas");
//		menuBar_1.add(mnMateriasPrimas);

//		mntmNuevaSolicitud = new JMenuItem("Nueva Solicitud");
//		mnMateriasPrimas.add(mntmNuevaSolicitud);

//		mntmEditarSolicitudesGuardadas = new JMenuItem(
//				"Editar Solicitudes Guardadas");
//		mnMateriasPrimas.add(mntmEditarSolicitudesGuardadas);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 8, 526, 307);
		this.contentPane.add(scrollPane);

		this.modelVentas = new WDefaultTableModel(null, this.nombreColumnas);
		this.tableVentas = new WTable(this.modelVentas);
		scrollPane.setViewportView(tableVentas);

		this.btnNuevaVenta = new JButton("Nueva Venta");
		this.btnNuevaVenta.setBounds(10, 326, 140, 23);

		this.contentPane.add(btnNuevaVenta);

		this.btnCancelarVenta = new JButton("Cancelar Venta");
		this.btnCancelarVenta.setBounds(160, 326, 140, 23);
		this.contentPane.add(btnCancelarVenta);

		this.btnVentaEntregada = new JButton("Venta Entregada");
		this.btnVentaEntregada.setBounds(310, 326, 140, 23);
		this.contentPane.add(btnVentaEntregada);

		this.btnEnviar = new JButton("Enviar");
		this.btnEnviar.setBounds(546, 8, 140, 23);
		this.contentPane.add(btnEnviar);

		this.btnEnViaje = new JButton("En Viaje");
		this.btnEnViaje.setBounds(546, 42, 140, 23);
		this.contentPane.add(btnEnViaje);

		this.btnEnMostrador = new JButton("En mostrador");
		this.btnEnMostrador.setBounds(546, 76, 140, 23);
		this.contentPane.add(btnEnMostrador);

		this.btnInformacin = new JButton("Informaci\u00F3n");
		this.btnInformacin.setBounds(546, 110, 140, 23);
		this.contentPane.add(btnInformacin);

		this.btnModificar = new JButton("Modificar");
		this.btnModificar.setBounds(546, 144, 140, 23);
		this.contentPane.add(btnModificar);

		this.btnVolverInicio = new JButton("Volver Inicio");
		this.btnVolverInicio.setBounds(460, 326, 140, 23);
		this.contentPane.add(btnVolverInicio);
	}

//	public JMenuItem getMntmReporteSemanal() {
//		return mntmReporteSemanal;
//	}

//	public JMenuItem getMntmReporteMensual() {
//		return mntmReporteMensual;
//	}

//	public JMenuItem getMntmNuevoProveedor() {
//		return mntmNuevoProveedor;
//	}

//	public JMenuItem getMntmBusquedaDeProveedores() {
//		return mntmBusquedaDeProveedores;
//	}

//	public JMenuItem getMntmNuevaSolicitud() {
//		return mntmNuevaSolicitud;
//	}

//	public JMenuItem getMntmEditarSolicitudesGuardadas() {
//		return mntmEditarSolicitudesGuardadas;
//	}

	public void Open() {
		this.setVisible(true);
	}

	public void Close() {
		this.setVisible(false);
	}

	public JTable GetTable() {
		return this.tableVentas;
	}

//	public JMenuItem getMntmReporteDiario() {
//		return mntmReporteDiario;
//	}

	public DefaultTableModel GetModelVenta() {
		return this.modelVentas;
	}

	public String[] GetNombreColumnas() {
		return this.nombreColumnas;
	}

	public JButton GetBtnNuevaVenta() {
		return this.btnNuevaVenta;
	}

	public JButton GetBtnCancelarVenta() {
		return this.btnCancelarVenta;
	}

	public JButton GetBtnVentaEntregada() {
		return this.btnVentaEntregada;
	}

	public JButton GetBtnEnviar() {
		return this.btnEnviar;
	}

	public JButton GetBtnEnViaje() {
		return this.btnEnViaje;
	}

	public JButton GetBtnEnMostrador() {
		return this.btnEnMostrador;
	}

	public JButton GetBtnModificar() {
		return this.btnModificar;
	}

	public JButton GetBtnInformacin() {
		return this.btnInformacin;
	}

	public JButton GetBtnVolverInicio() {
		return this.btnVolverInicio;
	}
}