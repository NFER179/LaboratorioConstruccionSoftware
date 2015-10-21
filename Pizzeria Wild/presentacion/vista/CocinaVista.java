package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

import objetosVistaCustom.WDefaultTableModel;
import objetosVistaCustom.WTable;

@SuppressWarnings("serial")
public class CocinaVista extends JFrame {

	private JPanel contentPane;
	private String[] nombreColumnasPedidos = {"Producto","Sabor","Cantidad"};
	private JTextField txtPeido1;
	private JScrollPane scrollPane1;
	private DefaultTableModel modelTable1;
	private JTable tblPedido1;
	private JTextField txtPeido2;
	private JScrollPane scrollPane2;
	private DefaultTableModel modelTable2;
	private JTable tblPedido2;
	private JTextField txtPeido3;
	private JScrollPane scrollPane3;
	private DefaultTableModel modelTable3;
	private JTable tblPedido3;
	private JTextField txtPeido4;
	private JScrollPane scrollPane4;
	private DefaultTableModel modelTable4;
	private JTable tblPedido4;
	private JTextField txtPeido5;
	private JScrollPane scrollPane5;
	private DefaultTableModel modelTable5;
	private JTable tblPedido5;
	private JTextField txtPeido6;
	private JScrollPane scrollPane6;
	private DefaultTableModel modelTable6;
	private JTable tblPedido6;
	private JScrollPane scrollPanePedidosPendientes;
	private DefaultTableModel modelTablePendientes;
	private JTable tblProductosPendientes;

	public CocinaVista() {
		this.setTitle("Pedidos por Elaborar");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setBounds(100, 100, 800, 485);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		this.contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		this.txtPeido1 = new JTextField();
		this.txtPeido1.setEditable(false);
		this.txtPeido1.setEnabled(false);
		this.txtPeido1.setBounds(69, 11, 86, 20);
		this.contentPane.add(txtPeido1);
		this.txtPeido1.setColumns(10);
		
		this.scrollPane1 = new JScrollPane();
		this.scrollPane1.setBounds(10, 42, 250, 103);
		this.contentPane.add(scrollPane1);
		
		this.modelTable1 = new WDefaultTableModel(null, this.nombreColumnasPedidos);
		this.tblPedido1 = new WTable(this.modelTable1);
		this.scrollPane1.setViewportView(tblPedido1);
		
		this.txtPeido2 = new JTextField();
		this.txtPeido2.setEnabled(false);
		this.txtPeido2.setEditable(false);
		this.txtPeido2.setColumns(10);
		this.txtPeido2.setBounds(329, 11, 86, 20);
		this.contentPane.add(txtPeido2);
		
		this.scrollPane2 = new JScrollPane();
		this.scrollPane2.setBounds(270, 42, 250, 103);
		this.contentPane.add(scrollPane2);
		
		this.modelTable2 = new WDefaultTableModel(null, this.nombreColumnasPedidos);
		this.tblPedido2 = new WTable(this.modelTable2);
		this.scrollPane2.setViewportView(tblPedido2);
		
		this.txtPeido3 = new JTextField();
		this.txtPeido3.setEnabled(false);
		this.txtPeido3.setEditable(false);
		this.txtPeido3.setColumns(10);
		this.txtPeido3.setBounds(69, 157, 86, 20);
		this.contentPane.add(txtPeido3);
		
		this.scrollPane3 = new JScrollPane();
		this.scrollPane3.setBounds(10, 188, 250, 103);
		this.contentPane.add(scrollPane3);
		
		this.modelTable3 = new WDefaultTableModel(null, this.nombreColumnasPedidos);
		this.tblPedido3 = new WTable(this.modelTable3);
		this.scrollPane3.setViewportView(tblPedido3);
		
		this.txtPeido4 = new JTextField();
		this.txtPeido4.setEnabled(false);
		this.txtPeido4.setEditable(false);
		this.txtPeido4.setColumns(10);
		this.txtPeido4.setBounds(329, 156, 86, 20);
		this.contentPane.add(txtPeido4);
		
		this.scrollPane4 = new JScrollPane();
		this.scrollPane4.setBounds(270, 187, 250, 103);
		this.contentPane.add(scrollPane4);
		
		this.modelTable4 = new WDefaultTableModel(null, this.nombreColumnasPedidos);
		this.tblPedido4 = new WTable(this.modelTable4);
		this.scrollPane4.setViewportView(tblPedido4);
		
		this.txtPeido5 = new JTextField();
		this.txtPeido5.setEnabled(false);
		this.txtPeido5.setEditable(false);
		this.txtPeido5.setColumns(10);
		this.txtPeido5.setBounds(69, 302, 86, 20);
		this.contentPane.add(txtPeido5);
		
		this.scrollPane5 = new JScrollPane();
		this.scrollPane5.setBounds(10, 333, 250, 103);
		this.contentPane.add(scrollPane5);
		
		this.modelTable5 = new WDefaultTableModel(null, this.nombreColumnasPedidos);
		this.tblPedido5 = new WTable(this.modelTable5);
		this.scrollPane5.setViewportView(tblPedido5);
		
		this.txtPeido6 = new JTextField();
		this.txtPeido6.setEnabled(false);
		this.txtPeido6.setEditable(false);
		this.txtPeido6.setColumns(10);
		this.txtPeido6.setBounds(329, 302, 86, 20);
		this.contentPane.add(txtPeido6);
		
		this.scrollPane6 = new JScrollPane();
		this.scrollPane6.setBounds(270, 332, 250, 103);
		this.contentPane.add(scrollPane6);
		
		this.modelTable6 = new WDefaultTableModel(null, this.nombreColumnasPedidos);
		this.tblPedido6 = new WTable(this.modelTable6);
		this.scrollPane6.setViewportView(tblPedido6);
		
		this.scrollPanePedidosPendientes = new JScrollPane();
		this.scrollPanePedidosPendientes.setBounds(530, 42, 254, 394);
		this.contentPane.add(scrollPanePedidosPendientes);
		
		this.modelTablePendientes = new WDefaultTableModel(null, this.nombreColumnasPedidos);
		this.tblProductosPendientes = new WTable(this.modelTablePendientes);
		this.scrollPanePedidosPendientes.setViewportView(this.tblProductosPendientes);
		
		JLabel lblPedido = new JLabel("Pedido:");
		lblPedido.setBounds(10, 14, 69, 14);
		contentPane.add(lblPedido);
		
		JLabel label = new JLabel("Pedido:");
		label.setBounds(10, 160, 69, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Pedido:");
		label_1.setBounds(10, 305, 69, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Pedido:");
		label_2.setBounds(270, 14, 69, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Pedido:");
		label_3.setBounds(270, 160, 69, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Pedido:");
		label_4.setBounds(270, 305, 69, 14);
		contentPane.add(label_4);
	}
	
	public void Open() {
		this.setVisible(true);
	}
	
	public void Close() {
		this.setVisible(false);
	}

	public String[] getNombreColumnasPedidos() {
		return nombreColumnasPedidos;
	}

	public JTextField getTxtPeido1() {
		return txtPeido1;
	}

	public DefaultTableModel getModelTable1() {
		return modelTable1;
	}

	public JTable getTblPedido1() {
		return tblPedido1;
	}

	public JTextField getTxtPeido2() {
		return txtPeido2;
	}

	public DefaultTableModel getModelTable2() {
		return modelTable2;
	}

	public JTable getTblPedido2() {
		return tblPedido2;
	}

	public JTextField getTxtPeido3() {
		return txtPeido3;
	}

	public DefaultTableModel getModelTable3() {
		return modelTable3;
	}

	public JTable getTblPedido3() {
		return tblPedido3;
	}

	public JTextField getTxtPeido4() {
		return txtPeido4;
	}

	public DefaultTableModel getModelTable4() {
		return modelTable4;
	}

	public JTable getTblPedido4() {
		return tblPedido4;
	}

	public JTextField getTxtPeido5() {
		return txtPeido5;
	}

	public DefaultTableModel getModelTable5() {
		return modelTable5;
	}

	public JTable getTblPedido5() {
		return tblPedido5;
	}

	public JTextField getTxtPeido6() {
		return txtPeido6;
	}

	public DefaultTableModel getModelTable6() {
		return modelTable6;
	}

	public JTable getTblPedido6() {
		return tblPedido6;
	}

	public DefaultTableModel getModelTablePendientes() {
		return modelTablePendientes;
	}

	public JTable getTblProductosPendientes() {
		return tblProductosPendientes;
	}
}