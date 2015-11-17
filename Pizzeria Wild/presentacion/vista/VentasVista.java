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
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private JButton btnProveedores;
	private JButton btnBackUp;
	private JLabel lblVentasDelDia;
	private JButton btnRepartidores;
	private JButton btnClientes;
	private JButton btnProductos;
//	private JMenuItem mntmReporteDiario;
//	private JMenuItem mntmReporteSemanal;
//	private JMenuItem mntmReporteMensual;
//	private JMenuItem mntmNuevoProveedor;
//	private JMenuItem mntmBusquedaDeProveedores;
//
//	private JMenuItem mntmNuevaSolicitud;
//	private JMenuItem mntmEditarSolicitudesGuardadas;

	public JButton getBtnBackUp() {
		return btnBackUp;
	}

	public void setBtnBackUp(JButton btnBackUp) {
		this.btnBackUp = btnBackUp;
	}

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
		this.setBounds(100, 100, 994, 419);
		
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		this.contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		lblVentasDelDia = new JLabel("Ventas del Dia:");
		lblVentasDelDia.setBounds(160, 11, 140, 14);
		contentPane.add(lblVentasDelDia);
		
		btnSolicitudes = new JButton("Solicitudes");
		btnSolicitudes.setBounds(10, 36, 140, 23);
		contentPane.add(btnSolicitudes);
		
		btnCategorias = new JButton("Categorias");
		btnCategorias.setBounds(10, 70, 140, 23);
		contentPane.add(btnCategorias);
		
		btnMateriasPrimas = new JButton("Materias Primas");
		btnMateriasPrimas.setBounds(10, 104, 140, 23);
		contentPane.add(btnMateriasPrimas);
		
		btnReportes = new JButton("Reportes");
		btnReportes.setBounds(10, 138, 140, 23);
		contentPane.add(btnReportes);
		
		btnProveedores = new JButton("Proveedores");
		btnProveedores.setBounds(10, 172, 140, 23);
		contentPane.add(btnProveedores);
		
		btnRepartidores = new JButton("Repartidores");
		btnRepartidores.setBounds(10, 206, 140, 23);
		contentPane.add(btnRepartidores);
		
		btnClientes = new JButton("Clientes");
		btnClientes.setBounds(10, 240, 140, 23);
		contentPane.add(btnClientes);
		
		btnProductos = new JButton("Productos");
		btnProductos.setBounds(10, 274, 140, 23);
		contentPane.add(btnProductos);
		
		btnBackUp = new JButton("Back Up");
		btnBackUp.setBounds(10, 308, 140, 23);
		contentPane.add(btnBackUp);
		
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
		scrollPane.setBounds(160, 36, 668, 306);
		this.contentPane.add(scrollPane);

		this.modelVentas = new WDefaultTableModel(null, this.nombreColumnas);
		this.tableVentas = new WTable(this.modelVentas);
		scrollPane.setViewportView(tableVentas);

		this.btnEnviar = new JButton("Enviar");
		this.btnEnviar.setBounds(838, 36, 140, 23);
		this.contentPane.add(btnEnviar);

		this.btnEnViaje = new JButton("En Viaje");
		this.btnEnViaje.setBounds(838, 70, 140, 23);
		this.contentPane.add(btnEnViaje);

		this.btnEnMostrador = new JButton("En mostrador");
		this.btnEnMostrador.setBounds(838, 104, 140, 23);
		this.contentPane.add(btnEnMostrador);

		this.btnInformacin = new JButton("Informaci\u00F3n");
		this.btnInformacin.setBounds(838, 138, 140, 23);
		this.contentPane.add(btnInformacin);

		this.btnModificar = new JButton("Modificar");
		this.btnModificar.setBounds(838, 172, 140, 23);
		this.contentPane.add(btnModificar);
		
		btnTodasLasVentas = new JButton("Todas las Ventas");
		btnTodasLasVentas.setBounds(838, 206, 140, 23);
		contentPane.add(btnTodasLasVentas);
		
		this.btnNuevaVenta = new JButton("Nueva Venta");
		this.btnNuevaVenta.setBounds(160, 353, 140, 23);
		this.contentPane.add(btnNuevaVenta);
		
		this.btnCancelarVenta = new JButton("Cancelar Venta");
		this.btnCancelarVenta.setBounds(310, 353, 140, 23);
		this.contentPane.add(btnCancelarVenta);
		
		this.btnVentaEntregada = new JButton("Venta Entregada");
		this.btnVentaEntregada.setBounds(460, 353, 140, 23);
		this.contentPane.add(btnVentaEntregada);

		this.btnSalir = new JButton("Salir");
		this.btnSalir.setBounds(610, 353, 140, 23);
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

	public JTable getTableVentas() {
		return this.tableVentas;
	}

//	public JMenuItem getMntmReporteDiario() {
//		return mntmReporteDiario;
//	}

	public DefaultTableModel getModelVentas() {
		return this.modelVentas;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public String[] getNombreColumnas() {
		return this.nombreColumnas;
	}

	public JButton getBtnNuevaVenta() {
		return this.btnNuevaVenta;
	}

	public JButton getBtnCancelarVenta() {
		return this.btnCancelarVenta;
	}

	public JButton getBtnVentaEntregada() {
		return this.btnVentaEntregada;
	}

	public JButton getBtnEnviar() {
		return this.btnEnviar;
	}

	public JButton getBtnEnViaje() {
		return this.btnEnViaje;
	}

	public JButton getBtnEnMostrador() {
		return this.btnEnMostrador;
	}

	public JButton getBtnModificar() {
		return this.btnModificar;
	}

	public JButton getBtnInformacin() {
		return this.btnInformacin;
	}

	public JButton getBtnSalir() {
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

	public JButton getBtnProveedores() {
		return btnProveedores;
	}

	public JLabel getLblVentasDelDia() {
		return lblVentasDelDia;
	}

	public JButton getBtnRepartidores() {
		return btnRepartidores;
	}

	public JButton getBtnClientes() {
		return btnClientes;
	}

	public JButton getBtnProductos() {
		return btnProductos;
	}
	
}