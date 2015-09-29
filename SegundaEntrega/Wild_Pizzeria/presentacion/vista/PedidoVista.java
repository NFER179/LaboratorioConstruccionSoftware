package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class PedidoVista extends JFrame {
	
	private JPanel contentPane;
	private JTable tablePedidos;
	private DefaultTableModel modelPedidos;
	private String[] nombreColumnas = {"Nº Pedido","Cliente","Valor a Cobrar","Estado","A Domicilio"};
	private JButton btnNuevoPedido;
	private JButton btnCancelarPedido;
	private JButton btnPedidoEntregado;
	private JButton btnEnviar;
	private JButton btnEnViaje;
	private JButton btnEnMostrador;
	private JButton btnInformacin;
	private JButton btnModificar;
	private JButton btnVolverInicio;

	public PedidoVista() {
		
		this.setResizable(false);
		this.setTitle("Pedidos");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 702, 405);
		
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		this.contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 526, 315);
		this.contentPane.add(scrollPane);
		
		this.modelPedidos = new DefaultTableModel(null,this.nombreColumnas);
		this.tablePedidos = new JTable(this.modelPedidos);
		scrollPane.setViewportView(tablePedidos);
		
		this.btnNuevoPedido = new JButton("Nuevo Pedido");
		this.btnNuevoPedido.setBounds(10, 337, 140, 23);
		
		this.contentPane.add(btnNuevoPedido);
		
		this.btnCancelarPedido = new JButton("Cancelar Pedido");
		this.btnCancelarPedido.setBounds(160, 337, 140, 23);
		this.contentPane.add(btnCancelarPedido);
		
		this.btnPedidoEntregado = new JButton("Pedido Entregado");
		this.btnPedidoEntregado.setBounds(310, 337, 140, 23);
		this.contentPane.add(btnPedidoEntregado);
		
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
		this.btnVolverInicio.setBounds(460, 337, 140, 23);
		this.contentPane.add(btnVolverInicio);
	}
	
	public void Open() {
		this.setVisible(true);
	}
	
	public void Close() {
		this.setVisible(false);
	}

	public JTable GetTable() {
		return this.tablePedidos;
	}
	
	public DefaultTableModel GetModelPedido() {
		return this.modelPedidos;
	}
	
	public String[] GetNombreColumnas() {
		return this.nombreColumnas;
	}
	
	public JButton GetBtnNuevoPedido() {
		return this.btnNuevoPedido;
	}
	
	public JButton GetBtnCancelarPedido() {
		return this.btnCancelarPedido;
	}
	
	public JButton GetBtnPedidoEntregado() {
		return this.btnPedidoEntregado;
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