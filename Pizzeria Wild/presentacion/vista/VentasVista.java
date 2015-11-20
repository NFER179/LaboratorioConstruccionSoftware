
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
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;

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

	private JButton btnCombos;

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

		this.setResizable(false);
		this.setTitle("Ventas");
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setBounds(0, 0, 1080, 740);
		
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		this.contentPane.setLayout(null);
		//this.setLocationRelativeTo(null);
//////////////////////////////////////////////////////////////		
	btnCombos = new JButton("Combos");
	btnCombos.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCombos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCombos.setBounds(10, 426, 140, 40);
		contentPane.add(btnCombos);

//////////////////////////////////////////////////////////////


	lblVentasDelDia = new JLabel("Ventas del Dia:");
		lblVentasDelDia.setForeground(Color.WHITE);
		lblVentasDelDia.setBackground(Color.WHITE);
		lblVentasDelDia.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblVentasDelDia.setBounds(160, 11, 140, 25);
		contentPane.add(lblVentasDelDia);
		
		btnSolicitudes = new JButton("Solicitudes");
		btnSolicitudes.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSolicitudes.setBounds(10, 33, 140, 40);
		contentPane.add(btnSolicitudes);
		
		btnCategorias = new JButton("Categorias");
		btnCategorias.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCategorias.setBounds(10, 135, 140, 40);
		contentPane.add(btnCategorias);
		
		btnMateriasPrimas = new JButton("Materias Primas");
		btnMateriasPrimas.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnMateriasPrimas.setBounds(10, 84, 140, 40);
		contentPane.add(btnMateriasPrimas);
		
		btnReportes = new JButton("Reportes");
		btnReportes.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnReportes.setBounds(10, 525, 140, 40);
		contentPane.add(btnReportes);
		
		btnProveedores = new JButton("Proveedores");
		btnProveedores.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnProveedores.setBounds(10, 219, 140, 40);
		contentPane.add(btnProveedores);
		
		btnRepartidores = new JButton("Repartidores");
		btnRepartidores.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRepartidores.setBounds(10, 321, 140, 40);
		contentPane.add(btnRepartidores);
		
		btnClientes = new JButton("Clientes");
		btnClientes.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnClientes.setBounds(10, 372, 140, 40);
		contentPane.add(btnClientes);
		
		btnProductos = new JButton("Productos");
		btnProductos.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnProductos.setBounds(10, 270, 140, 40);
		contentPane.add(btnProductos);
		
		btnBackUp = new JButton("Back Up");
		btnBackUp.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBackUp.setBounds(10, 576, 140, 40);
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
		scrollPane.setBounds(160, 36, 745, 580);
		this.contentPane.add(scrollPane);

		this.modelVentas = new WDefaultTableModel(null, this.nombreColumnas);
		this.tableVentas = new WTable(this.modelVentas);
		scrollPane.setViewportView(tableVentas);

		this.btnEnviar = new JButton("Enviar");
		btnEnviar.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.btnEnviar.setBounds(924, 270, 140, 40);
		this.contentPane.add(btnEnviar);

		this.btnEnViaje = new JButton("En Viaje");
		btnEnViaje.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.btnEnViaje.setBounds(924, 321, 140, 40);
		this.contentPane.add(btnEnViaje);

		this.btnEnMostrador = new JButton("En mostrador");
		btnEnMostrador.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.btnEnMostrador.setBounds(924, 186, 140, 40);
		this.contentPane.add(btnEnMostrador);

		this.btnInformacin = new JButton("Informaci\u00F3n");
		btnInformacin.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.btnInformacin.setBounds(924, 449, 140, 40);
		this.contentPane.add(btnInformacin);

		this.btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.btnModificar.setBounds(924, 372, 140, 40);
		this.contentPane.add(btnModificar);
		
		btnTodasLasVentas = new JButton("Todas las Ventas");
		btnTodasLasVentas.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTodasLasVentas.setBounds(924, 500, 140, 40);
		contentPane.add(btnTodasLasVentas);
		
		this.btnNuevaVenta = new JButton("Nueva Venta");
		btnNuevaVenta.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.btnNuevaVenta.setBounds(924, 33, 140, 40);
		this.contentPane.add(btnNuevaVenta);
		
		this.btnCancelarVenta = new JButton("Cancelar Venta");
		btnCancelarVenta.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.btnCancelarVenta.setBounds(924, 84, 140, 40);
		this.contentPane.add(btnCancelarVenta);
		
		this.btnVentaEntregada = new JButton("Venta Entregada");
		btnVentaEntregada.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.btnVentaEntregada.setBounds(924, 135, 140, 40);
		this.contentPane.add(btnVentaEntregada);

		this.btnSalir = new JButton(" Salir");
		btnSalir.setBackground(new Color(255, 228, 196));
		btnSalir.setIcon(new ImageIcon(VentasVista.class.getResource("/Iconos/salir.png")));
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.btnSalir.setBounds(924, 645, 140, 40);
		this.contentPane.add(btnSalir);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentasVista.class.getResource("/Iconos/catering_pizzetas_y_empanadas.png")));
		lblNewLabel.setBounds(0, 0, 1074, 708);
		contentPane.add(lblNewLabel);
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

////////////////////////////////////////////
public JButton getBtnCombos() {
		return btnCombos;
	}

///////////////////////////////////////////


}