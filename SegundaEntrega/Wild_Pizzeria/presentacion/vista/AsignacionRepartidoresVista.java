package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

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

public class AsignacionRepartidoresVista extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private JTextField txtRepartidor;
	private JButton btnBuscarrepartidor;
	private JTextField txtNombrerepartidor;
	private DefaultTableModel ModelTable;
	private String[] NombreColumnas = {"Pedido","Direccion"};
	private JTable table;
	private JButton btnAsignar;
	private JButton btnCancelar;

	
	public AsignacionRepartidoresVista(JFrame Frame) {
		
		super(Frame, true);
		
		this.setTitle("Asignar Pedidos a Repartidor");
		this.setBounds(100, 100, 425, 362);
		this.getContentPane().setLayout(new BorderLayout());
		this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.getContentPane().add(contentPanel, BorderLayout.CENTER);
		this.contentPanel.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel lblAsignarA = new JLabel("Asignar a:");
		lblAsignarA.setBounds(10, 11, 83, 14);
		this.contentPanel.add(lblAsignarA);
		
		this.txtRepartidor = new JTextField();
		this.txtRepartidor.setEnabled(false);
		this.txtRepartidor.setEditable(false);
		this.txtRepartidor.setBounds(80, 8, 120, 20);
		this.contentPanel.add(this.txtRepartidor);
		this.txtRepartidor.setColumns(10);
		
		this.btnBuscarrepartidor = new JButton("Buscar");
		this.btnBuscarrepartidor.setBounds(210, 7, 89, 23);
		this.contentPanel.add(this.btnBuscarrepartidor);
		
		this.txtNombrerepartidor = new JTextField();
		this.txtNombrerepartidor.setEditable(false);
		this.txtNombrerepartidor.setEnabled(false);
		this.txtNombrerepartidor.setBounds(80, 36, 322, 20);
		this.contentPanel.add(this.txtNombrerepartidor);
		this.txtNombrerepartidor.setColumns(10);
		
		JLabel lblPedido = new JLabel("Pedido:");
		lblPedido.setBounds(10, 67, 83, 14);
		this.contentPanel.add(lblPedido);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(10, 92, 392, 193);
		this.contentPanel.add(scrollPane);
		
		this.ModelTable = new DefaultTableModel(null, this.NombreColumnas);
		
		this.table = new JTable(this.ModelTable);
		table.getColumnModel().getColumn(1).setPreferredWidth(76);
		scrollPane.setViewportView(this.table);
		
		this.btnAsignar = new JButton("Asignar");
		this.btnAsignar.setBounds(210, 294, 89, 23);
		this.contentPanel.add(this.btnAsignar);
		
		this.btnCancelar = new JButton("Cancelar");
		this.btnCancelar.setBounds(313, 294, 89, 23);
		this.contentPanel.add(this.btnCancelar);
	}
	
	public void Open() {
		this.setVisible(true);
	}
	
	public void Close() {
		this.setVisible(false);
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

	public JButton getBtnAsignar() {
		return btnAsignar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}
	
	
}