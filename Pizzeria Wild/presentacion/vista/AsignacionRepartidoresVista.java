package vista;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import objetosVistaCustom.WDefaultTableModel;
import objetosVistaCustom.WTable;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class AsignacionRepartidoresVista extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private JTextField txtNumdelivery;
	private JLabel lblFecha;
	private JTextField txtFecha;
	private JLabel lblHora;
	private JTextField txtHora;
	private JTextField txtRepartidor;
	private JButton btnBuscarrepartidor;
	private JTextField txtNombrerepartidor;
	private DefaultTableModel ModelTable;
	private String[] NombreColumnas = {"Fecha Pedido","Pedido","Direccion","Observacion Delivery"};
	private JTable table;
	private JTextArea txtObservacion;
	private JButton btnAsignar;
	private JButton btnCancelar;
	
	public AsignacionRepartidoresVista(JFrame Frame) {
		
		super(Frame, true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(AsignacionRepartidoresVista.class.getResource("/Iconos/pizza_1.PNG")));
		
		this.setTitle(" Armar Delivery");
		this.setBounds(100, 100, 500, 467);
		this.getContentPane().setLayout(new BorderLayout());
		this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.getContentPane().add(contentPanel, BorderLayout.CENTER);
		this.contentPanel.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel lblNumDelivery = new JLabel("Delivery:");
		lblNumDelivery.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumDelivery.setBounds(10, 11, 83, 14);
		contentPanel.add(lblNumDelivery);
		
		this.txtNumdelivery = new JTextField();
		this.txtNumdelivery.setEnabled(false);
		this.txtNumdelivery.setEditable(false);
		this.txtNumdelivery.setBounds(80, 8, 109, 20);
		this.contentPanel.add(this.txtNumdelivery);
		this.txtNumdelivery.setColumns(10);
		
		this.lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.lblFecha.setBounds(204, 14, 46, 14);
		this.contentPanel.add(this.lblFecha);
		
		this.txtFecha = new JTextField();
		this.txtFecha.setEditable(false);
		this.txtFecha.setEnabled(false);
		this.txtFecha.setBounds(256, 11, 86, 20);
		this.contentPanel.add(this.txtFecha);
		this.txtFecha.setColumns(10);
		
		this.lblHora = new JLabel("Hora:");
		lblHora.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.lblHora.setBounds(352, 14, 46, 14);
		this.contentPanel.add(lblHora);
		
		this.txtHora = new JTextField();
		this.txtHora.setEditable(false);
		this.txtHora.setEnabled(false);
		this.txtHora.setBounds(396, 11, 86, 20);
		this.contentPanel.add(txtHora);
		this.txtHora.setColumns(10);
		
		JLabel lblAsignarA = new JLabel("Asignar a:");
		lblAsignarA.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAsignarA.setBounds(35, 56, 83, 14);
		this.contentPanel.add(lblAsignarA);
		
		this.txtRepartidor = new JTextField();
		this.txtRepartidor.setEnabled(false);
		this.txtRepartidor.setEditable(false);
		this.txtRepartidor.setBounds(105, 53, 188, 20);
		this.contentPanel.add(this.txtRepartidor);
		this.txtRepartidor.setColumns(10);
		
		this.btnBuscarrepartidor = new JButton("Buscar");
		btnBuscarrepartidor.setIcon(new ImageIcon(AsignacionRepartidoresVista.class.getResource("/Iconos/Buscar.png")));
		this.btnBuscarrepartidor.setBounds(303, 52, 120, 49);
		this.contentPanel.add(this.btnBuscarrepartidor);
		
		this.txtNombrerepartidor = new JTextField();
		this.txtNombrerepartidor.setEditable(false);
		this.txtNombrerepartidor.setEnabled(false);
		this.txtNombrerepartidor.setBounds(105, 81, 188, 20);
		this.contentPanel.add(this.txtNombrerepartidor);
		this.txtNombrerepartidor.setColumns(10);
		
		JLabel lblPedido = new JLabel("Pedido:");
		lblPedido.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPedido.setBounds(10, 97, 83, 14);
		this.contentPanel.add(lblPedido);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(10, 122, 472, 158);
		this.contentPanel.add(scrollPane);
		
		this.ModelTable = new WDefaultTableModel(null, this.NombreColumnas);
		
		this.table = new WTable(this.ModelTable);
		table.getColumnModel().getColumn(1).setPreferredWidth(76);
		scrollPane.setViewportView(this.table);
		
		JLabel lblObservacionDelivery = new JLabel("Observacion Delivery: ");
		lblObservacionDelivery.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblObservacionDelivery.setBounds(10, 291, 142, 14);
		contentPanel.add(lblObservacionDelivery);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 316, 472, 55);
		contentPanel.add(scrollPane_1);
		
		txtObservacion = new JTextArea();
		txtObservacion.setLineWrap(true);
		txtObservacion.setWrapStyleWord(true);
		scrollPane_1.setViewportView(txtObservacion);
		
		this.btnAsignar = new JButton("Asignar");
		btnAsignar.setIcon(new ImageIcon(AsignacionRepartidoresVista.class.getResource("/Iconos/OK.png")));
		this.btnAsignar.setBounds(192, 382, 140, 40);
		this.contentPanel.add(this.btnAsignar);
		
		this.btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(AsignacionRepartidoresVista.class.getResource("/Iconos/salir.png")));
		this.btnCancelar.setBounds(342, 382, 140, 40);
		this.contentPanel.add(this.btnCancelar);
	}
	
	public void Open() {
		this.setVisible(true);
	}
	
	public void Close() {
		this.setVisible(false);
	}

	public JTextField getTxtNumdelivery() {
		return txtNumdelivery;
	}

	public JLabel getLblFecha() {
		return lblFecha;
	}

	public JTextField getTxtFecha() {
		return txtFecha;
	}

	public JLabel getLblHora() {
		return lblHora;
	}

	public JTextField getTxtHora() {
		return txtHora;
	}

	public JTextField getTxtRepartidor() {
		return txtRepartidor;
	}

	public JButton getBtnBuscarrepartidor() {
		return btnBuscarrepartidor;
	}

	public JTextField getTxtNombrerepartidor() {
		return txtNombrerepartidor;
	}

	public DefaultTableModel getModelTable() {
		return ModelTable;
	}

	public String[] getNombreColumnas() {
		return NombreColumnas;
	}

	public JTable getTable() {
		return table;
	}
	
	public JTextArea getTxtObservacion() {
		return txtObservacion;
	}

	public JButton getBtnAsignar() {
		return btnAsignar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}
}