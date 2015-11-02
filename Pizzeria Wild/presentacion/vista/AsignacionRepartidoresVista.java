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
		
		this.setTitle("Armar Delivery");
		this.setBounds(100, 100, 472, 436);
		this.getContentPane().setLayout(new BorderLayout());
		this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.getContentPane().add(contentPanel, BorderLayout.CENTER);
		this.contentPanel.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel lblNumDelivery = new JLabel("Num Delivery:");
		lblNumDelivery.setBounds(10, 11, 83, 14);
		contentPanel.add(lblNumDelivery);
		
		this.txtNumdelivery = new JTextField();
		this.txtNumdelivery.setEnabled(false);
		this.txtNumdelivery.setEditable(false);
		this.txtNumdelivery.setBounds(80, 8, 86, 20);
		this.contentPanel.add(this.txtNumdelivery);
		this.txtNumdelivery.setColumns(10);
		
		this.lblFecha = new JLabel("Fecha:");
		this.lblFecha.setBounds(176, 11, 46, 14);
		this.contentPanel.add(this.lblFecha);
		
		this.txtFecha = new JTextField();
		this.txtFecha.setEditable(false);
		this.txtFecha.setEnabled(false);
		this.txtFecha.setBounds(228, 8, 86, 20);
		this.contentPanel.add(this.txtFecha);
		this.txtFecha.setColumns(10);
		
		this.lblHora = new JLabel("Hora:");
		this.lblHora.setBounds(324, 11, 46, 14);
		this.contentPanel.add(lblHora);
		
		this.txtHora = new JTextField();
		this.txtHora.setEditable(false);
		this.txtHora.setEnabled(false);
		this.txtHora.setBounds(368, 8, 86, 20);
		this.contentPanel.add(txtHora);
		this.txtHora.setColumns(10);
		
		JLabel lblAsignarA = new JLabel("Asignar a:");
		lblAsignarA.setBounds(10, 41, 83, 14);
		this.contentPanel.add(lblAsignarA);
		
		this.txtRepartidor = new JTextField();
		this.txtRepartidor.setEnabled(false);
		this.txtRepartidor.setEditable(false);
		this.txtRepartidor.setBounds(80, 38, 120, 20);
		this.contentPanel.add(this.txtRepartidor);
		this.txtRepartidor.setColumns(10);
		
		this.btnBuscarrepartidor = new JButton("Buscar");
		this.btnBuscarrepartidor.setBounds(210, 37, 89, 23);
		this.contentPanel.add(this.btnBuscarrepartidor);
		
		this.txtNombrerepartidor = new JTextField();
		this.txtNombrerepartidor.setEditable(false);
		this.txtNombrerepartidor.setEnabled(false);
		this.txtNombrerepartidor.setBounds(80, 66, 374, 20);
		this.contentPanel.add(this.txtNombrerepartidor);
		this.txtNombrerepartidor.setColumns(10);
		
		JLabel lblPedido = new JLabel("Pedido:");
		lblPedido.setBounds(10, 97, 83, 14);
		this.contentPanel.add(lblPedido);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(10, 122, 444, 118);
		this.contentPanel.add(scrollPane);
		
		this.ModelTable = new WDefaultTableModel(null, this.NombreColumnas);
		
		this.table = new WTable(this.ModelTable);
		table.getColumnModel().getColumn(1).setPreferredWidth(76);
		scrollPane.setViewportView(this.table);
		
		JLabel lblObservacionDelivery = new JLabel("Observacion Delivery: ");
		lblObservacionDelivery.setBounds(10, 251, 142, 14);
		contentPanel.add(lblObservacionDelivery);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 276, 444, 81);
		contentPanel.add(scrollPane_1);
		
		txtObservacion = new JTextArea();
		txtObservacion.setLineWrap(true);
		txtObservacion.setWrapStyleWord(true);
		scrollPane_1.setViewportView(txtObservacion);
		
		this.btnAsignar = new JButton("Asignar");
		this.btnAsignar.setBounds(266, 368, 89, 23);
		this.contentPanel.add(this.btnAsignar);
		
		this.btnCancelar = new JButton("Cancelar");
		this.btnCancelar.setBounds(365, 368, 89, 23);
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