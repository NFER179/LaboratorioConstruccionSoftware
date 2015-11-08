package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import objetosVistaCustom.WDefaultTableModel;
import objetosVistaCustom.WTable;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

@SuppressWarnings("serial")
public class VentasVista extends JFrame {

	private JPanel contentPane;
	private JButton btnSolicitudes;
	private JButton btnCategorias;
	private JButton btnReportes;
	private JButton btnMateriasPrimas;
	private JTable tableVentas;
	private DefaultTableModel modelVentas;
	private String[] nombreColumnas = { "Fecha", "Nº Venta", "Cliente",
			"Valor a Cobrar", "Estado", "A Domicilio" };
	private JButton btnEnviar;
	private JButton btnEnViaje;
	private JButton btnEnMostrador;
	private JButton btnInformacin;
	private JButton btnModificar;
	private JButton btnTodasLasVentas;
	private JButton btnNuevaVenta;
	private JButton btnCancelarVenta;
	private JButton btnVentaEntregada;
	private JButton btnSalir;
//	private JMenuItem mntmReporteDiario;
//	private JMenuItem mntmReporteSemanal;
//	private JMenuItem mntmReporteMensual;
//	private JMenuItem mntmNuevoProveedor;
//	private JMenuItem mntmBusquedaDeProveedores;
//
//	private JMenuItem mntmNuevaSolicitud;
//	private JMenuItem mntmEditarSolicitudesGuardadas;

	public VentasVista() {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		initialize();
	}
	
	private void initialize() {

		this.setResizable(false);
		this.setTitle("Ventas");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 878, 419);
		
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		this.contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		btnSolicitudes = new JButton("Solicitudes");
		btnSolicitudes.setBounds(10, 11, 140, 23);
		contentPane.add(btnSolicitudes);
		
		btnCategorias = new JButton("Categorias");
		btnCategorias.setBounds(10, 45, 140, 23);
		contentPane.add(btnCategorias);
		
		btnMateriasPrimas = new JButton("Materias Primas");
		btnMateriasPrimas.setBounds(10, 79, 140, 23);
		contentPane.add(btnMateriasPrimas);
		
		btnReportes = new JButton("Reportes");
		btnReportes.setBounds(10, 113, 140, 23);
		contentPane.add(btnReportes);
		
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
		scrollPane.setBounds(186, 11, 526, 307);
		this.contentPane.add(scrollPane);

		this.modelVentas = new WDefaultTableModel(null, this.nombreColumnas);
		this.tableVentas = new WTable(this.modelVentas);
		scrollPane.setViewportView(tableVentas);

		this.btnEnviar = new JButton("Enviar");
		this.btnEnviar.setBounds(722, 11, 140, 23);
		this.contentPane.add(btnEnviar);

		this.btnEnViaje = new JButton("En Viaje");
		this.btnEnViaje.setBounds(722, 45, 140, 23);
		this.contentPane.add(btnEnViaje);

		this.btnEnMostrador = new JButton("En mostrador");
		this.btnEnMostrador.setBounds(722, 79, 140, 23);
		this.contentPane.add(btnEnMostrador);

		this.btnInformacin = new JButton("Informaci\u00F3n");
		this.btnInformacin.setBounds(722, 113, 140, 23);
		this.contentPane.add(btnInformacin);

		this.btnModificar = new JButton("Modificar");
		this.btnModificar.setBounds(722, 147, 140, 23);
		this.contentPane.add(btnModificar);
		
		btnTodasLasVentas = new JButton("Todas las Ventas");
		btnTodasLasVentas.setBounds(722, 181, 140, 23);
		contentPane.add(btnTodasLasVentas);
		
		this.btnNuevaVenta = new JButton("Nueva Venta");
		this.btnNuevaVenta.setBounds(186, 329, 140, 23);
		this.contentPane.add(btnNuevaVenta);
		
		this.btnCancelarVenta = new JButton("Cancelar Venta");
		this.btnCancelarVenta.setBounds(336, 329, 140, 23);
		this.contentPane.add(btnCancelarVenta);
		
		this.btnVentaEntregada = new JButton("Venta Entregada");
		this.btnVentaEntregada.setBounds(486, 329, 140, 23);
		this.contentPane.add(btnVentaEntregada);

		this.btnSalir = new JButton("Salir");
		this.btnSalir.setBounds(636, 329, 140, 23);
		this.contentPane.add(btnSalir);
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
	
	public void Salir() {
		this.setVisible(false);
		this.dispose();
		System.exit(0);
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

	public JButton GetBtnSalir() {
		return this.btnSalir;
	}

	public JButton getBtnTodasLasVentas() {
		return btnTodasLasVentas;
	}

	public JButton getBtnSolicitudes() {
		return btnSolicitudes;
	}

	public JButton getBtnCategorias() {
		return btnCategorias;
	}

	public JButton getBtnReportes() {
		return btnReportes;
	}

	public JButton getBtnMateriasPrimas() {
		return btnMateriasPrimas;
	}
}