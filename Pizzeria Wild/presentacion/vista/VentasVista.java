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
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;
import java.awt.ComponentOrientation;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.ScrollPaneConstants;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

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
	private JLabel lblNewLabel;
//	private JMenuItem mntmReporteDiario;
//	private JMenuItem mntmReporteSemanal;
//	private JMenuItem mntmReporteMensual;
//	private JMenuItem mntmNuevoProveedor;
//	private JMenuItem mntmBusquedaDeProveedores;
//
//	private JMenuItem mntmNuevaSolicitud;
//	private JMenuItem mntmEditarSolicitudesGuardadas;

	public VentasVista() {
		setResizable(false);
		setType(Type.POPUP);
		setFont(new Font("Dialog", Font.BOLD, 12));
		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentasVista.class.getResource("/Iconos/pizza_1.PNG")));
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		initialize();
	}
	
	private void initialize() {
		this.setTitle("Ventas");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(10, 10, 1078, 640);
		
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		this.setContentPane(contentPane);
		this.contentPane.setLayout(null);
		//this.setLocationRelativeTo(null);
		
		btnSolicitudes = new JButton("Solicitudes");
		btnSolicitudes.setIgnoreRepaint(true);
		btnSolicitudes.setAutoscrolls(true);
		btnSolicitudes.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSolicitudes.setBounds(20, 204, 140, 40);
		contentPane.add(btnSolicitudes);
		
		btnCategorias = new JButton("Categorias");
		btnCategorias.setBackground(new Color(240, 255, 240));
		btnCategorias.setIgnoreRepaint(true);
		btnCategorias.setAutoscrolls(true);
		btnCategorias.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCategorias.setBounds(20, 21, 140, 40);
		contentPane.add(btnCategorias);
		
		btnMateriasPrimas = new JButton("Materias \r\nPrimas");
		btnMateriasPrimas.setBackground(new Color(240, 255, 240));
		btnMateriasPrimas.setIgnoreRepaint(true);
		btnMateriasPrimas.setAutoscrolls(true);
		btnMateriasPrimas.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnMateriasPrimas.setBounds(20, 123, 140, 40);
		contentPane.add(btnMateriasPrimas);
		
		btnReportes = new JButton("Reportes");
		btnReportes.setBackground(new Color(204, 204, 255));
		btnReportes.setIgnoreRepaint(true);
		btnReportes.setAutoscrolls(true);
		btnReportes.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnReportes.setBounds(20, 292, 140, 40);
		contentPane.add(btnReportes);
		
		btnProveedores = new JButton("Proveedores");
		btnProveedores.setBackground(new Color(240, 255, 240));
		btnProveedores.setIgnoreRepaint(true);
		btnProveedores.setAutoscrolls(true);
		btnProveedores.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnProveedores.setBounds(20, 72, 140, 40);
		contentPane.add(btnProveedores);
		
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
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setViewportBorder(UIManager.getBorder("ComboBox.border"));
		scrollPane.setAutoscrolls(true);
		scrollPane.setBounds(183, 22, 710, 518);
		this.contentPane.add(scrollPane);

		this.modelVentas = new WDefaultTableModel(null, this.nombreColumnas);
		this.tableVentas = new WTable(this.modelVentas);
		scrollPane.setViewportView(tableVentas);

		this.btnEnviar = new JButton("Enviar");
		btnEnviar.setBackground(new Color(240, 248, 255));
		btnEnviar.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.btnEnviar.setBounds(903, 292, 140, 40);
		this.contentPane.add(btnEnviar);

		this.btnEnViaje = new JButton("En Viaje");
		btnEnViaje.setBackground(new Color(240, 248, 255));
		btnEnViaje.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.btnEnViaje.setBounds(903, 347, 140, 40);
		this.contentPane.add(btnEnViaje);

		this.btnEnMostrador = new JButton("En mostrador");
		btnEnMostrador.setBackground(new Color(240, 248, 255));
		btnEnMostrador.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.btnEnMostrador.setBounds(903, 398, 140, 40);
		this.contentPane.add(btnEnMostrador);

		this.btnInformacin = new JButton("Informaci\u00F3n");
		btnInformacin.setBackground(new Color(204, 204, 255));
		btnInformacin.setAutoscrolls(true);
		btnInformacin.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.btnInformacin.setBounds(20, 398, 140, 40);
		this.contentPane.add(btnInformacin);

		this.btnModificar = new JButton("Modificar");
		btnModificar.setBackground(new Color(255, 228, 225));
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.btnModificar.setBounds(903, 123, 140, 40);
		this.contentPane.add(btnModificar);
		
		btnTodasLasVentas = new JButton("Todas las Ventas");
		btnTodasLasVentas.setBackground(new Color(204, 204, 255));
		btnTodasLasVentas.setAutoscrolls(true);
		btnTodasLasVentas.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTodasLasVentas.setBounds(20, 347, 140, 40);
		contentPane.add(btnTodasLasVentas);
		
		this.btnNuevaVenta = new JButton("Nueva Venta");
		btnNuevaVenta.setBackground(new Color(255, 228, 225));
		btnNuevaVenta.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.btnNuevaVenta.setBounds(903, 21, 140, 40);
		this.contentPane.add(btnNuevaVenta);
		
		this.btnCancelarVenta = new JButton("Cancelar Venta");
		btnCancelarVenta.setBackground(new Color(255, 228, 225));
		btnCancelarVenta.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.btnCancelarVenta.setBounds(903, 72, 140, 40);
		this.contentPane.add(btnCancelarVenta);
		
		this.btnVentaEntregada = new JButton("Venta Entregada");
		btnVentaEntregada.setBackground(Color.WHITE);
		btnVentaEntregada.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.btnVentaEntregada.setBounds(903, 204, 140, 40);
		this.contentPane.add(btnVentaEntregada);

		this.btnSalir = new JButton("Salir");
		btnSalir.setIcon(new ImageIcon(VentasVista.class.getResource("/Iconos/Salir.png")));
		btnSalir.setBackground(new Color(255, 228, 225));
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.btnSalir.setBounds(903, 526, 140, 53);
		this.contentPane.add(btnSalir);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentasVista.class.getResource("/Iconos/pizza-with-olives-hd-1080p-wallpapers-download-1144x644.jpg")));
		lblNewLabel.setBounds(10, 10, 1052, 584);
		contentPane.add(lblNewLabel);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane, btnSolicitudes, btnCategorias, btnMateriasPrimas, btnReportes, btnProveedores, scrollPane, tableVentas, btnEnviar, btnEnViaje, btnEnMostrador, btnInformacin, btnModificar, btnTodasLasVentas, btnNuevaVenta, btnCancelarVenta, btnVentaEntregada, btnSalir, lblNewLabel}));
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
}