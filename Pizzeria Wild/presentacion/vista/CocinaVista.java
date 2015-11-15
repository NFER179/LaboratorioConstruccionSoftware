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
import javax.swing.JTextPane;

@SuppressWarnings("serial")
public class CocinaVista extends JFrame {

	private JPanel contentPane;
	private String[] nombreColumnasPedidos = {"Producto","Cantidad"};
	private JTextField txtPeido1;
	private JScrollPane scrollPane1;
	private DefaultTableModel modelTable1;
	private JTable tblPedido1;
	private JScrollPane scrollPaneTxt1;
	private JTextPane txtPane1;
	private JTextField txtPeido2;
	private JScrollPane scrollPane2;
	private DefaultTableModel modelTable2;
	private JTable tblPedido2;
	private JScrollPane scrollPaneTxt2;
	private JTextPane txtPane2;
	private JTextField txtPeido3;
	private JScrollPane scrollPane3;
	private DefaultTableModel modelTable3;
	private JTable tblPedido3;
	private JScrollPane scrollPaneTxt3;
	private JTextPane txtPane3;
	private JTextField txtPeido4;
	private JScrollPane scrollPane4;
	private DefaultTableModel modelTable4;
	private JTable tblPedido4;
	private JScrollPane scrollPaneTxt4;
	private JTextPane txtPane4;
	private JTextField txtPeido5;
	private JScrollPane scrollPane5;
	private DefaultTableModel modelTable5;
	private JTable tblPedido5;
	private JScrollPane scrollPaneTxt5;
	private JTextPane txtPane5;
	private JTextField txtPeido6;
	private JScrollPane scrollPane6;
	private DefaultTableModel modelTable6;
	private JTable tblPedido6;
	private JScrollPane scrollPaneTxt6;
	private JTextPane txtPane6;
	private JScrollPane scrollPanePedidosPendientes;
	private DefaultTableModel modelTablePendientes;
	private JTable tblProductosPendientes;

	public CocinaVista() {
		this.setTitle("Pedidos por Elaborar");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setBounds(100, 100, 1235, 485);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		this.contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel lblPedido = new JLabel("Pedido:");
		lblPedido.setBounds(10, 14, 69, 14);
		contentPane.add(lblPedido);
		
		this.txtPeido1 = new JTextField();
		this.txtPeido1.setEditable(false);
		this.txtPeido1.setEnabled(false);
		this.txtPeido1.setBounds(69, 11, 86, 20);
		this.contentPane.add(txtPeido1);
		this.txtPeido1.setColumns(10);
		
		this.scrollPane1 = new JScrollPane();
		this.scrollPane1.setBounds(10, 42, 296, 103);
		this.contentPane.add(scrollPane1);
		
		this.modelTable1 = new WDefaultTableModel(null, this.nombreColumnasPedidos);
		this.tblPedido1 = new WTable(this.modelTable1);
		this.scrollPane1.setViewportView(tblPedido1);
		
		scrollPaneTxt1 = new JScrollPane();
		scrollPaneTxt1.setBounds(10, 156, 296, 63);
		contentPane.add(scrollPaneTxt1);
		
		txtPane1 = new JTextPane();
		scrollPaneTxt1.setViewportView(txtPane1);
		txtPane1.setEnabled(false);
		txtPane1.setEditable(false);
		
		JLabel label = new JLabel("Pedido:");
		label.setBounds(622, 14, 69, 14);
		contentPane.add(label);
		
		this.txtPeido2 = new JTextField();
		this.txtPeido2.setEnabled(false);
		this.txtPeido2.setEditable(false);
		this.txtPeido2.setColumns(10);
		this.txtPeido2.setBounds(375, 11, 86, 20);
		this.contentPane.add(txtPeido2);
		
		this.scrollPane2 = new JScrollPane();
		this.scrollPane2.setBounds(316, 42, 296, 103);
		this.contentPane.add(scrollPane2);
		
		this.modelTable2 = new WDefaultTableModel(null, this.nombreColumnasPedidos);
		this.tblPedido2 = new WTable(this.modelTable2);
		this.scrollPane2.setViewportView(tblPedido2);
		
		scrollPaneTxt2 = new JScrollPane();
		scrollPaneTxt2.setBounds(316, 156, 294, 61);
		contentPane.add(scrollPaneTxt2);
		
		txtPane2 = new JTextPane();
		scrollPaneTxt2.setViewportView(txtPane2);
		txtPane2.setEnabled(false);
		txtPane2.setEditable(false);
		
		JLabel label_1 = new JLabel("Pedido:");
		label_1.setBounds(316, 233, 69, 14);
		contentPane.add(label_1);
		
		this.txtPeido3 = new JTextField();
		this.txtPeido3.setEnabled(false);
		this.txtPeido3.setEditable(false);
		this.txtPeido3.setColumns(10);
		this.txtPeido3.setBounds(681, 11, 86, 20);
		this.contentPane.add(txtPeido3);
		
		this.scrollPane3 = new JScrollPane();
		this.scrollPane3.setBounds(622, 42, 296, 103);
		this.contentPane.add(scrollPane3);
		
		this.modelTable3 = new WDefaultTableModel(null, this.nombreColumnasPedidos);
		this.tblPedido3 = new WTable(this.modelTable3);
		this.scrollPane3.setViewportView(tblPedido3);
		
		scrollPaneTxt3 = new JScrollPane();
		scrollPaneTxt3.setBounds(622, 156, 294, 61);
		contentPane.add(scrollPaneTxt3);
		
		txtPane3 = new JTextPane();
		scrollPaneTxt3.setViewportView(txtPane3);
		txtPane3.setEnabled(false);
		txtPane3.setEditable(false);
		
		JLabel label_2 = new JLabel("Pedido:");
		label_2.setBounds(316, 14, 69, 14);
		contentPane.add(label_2);
		
		this.txtPeido4 = new JTextField();
		this.txtPeido4.setEnabled(false);
		this.txtPeido4.setEditable(false);
		this.txtPeido4.setColumns(10);
		this.txtPeido4.setBounds(69, 230, 86, 20);
		this.contentPane.add(txtPeido4);
		
		this.scrollPane4 = new JScrollPane();
		this.scrollPane4.setBounds(10, 261, 296, 103);
		this.contentPane.add(scrollPane4);
		
		this.modelTable4 = new WDefaultTableModel(null, this.nombreColumnasPedidos);
		this.tblPedido4 = new WTable(this.modelTable4);
		this.scrollPane4.setViewportView(tblPedido4);
		
		scrollPaneTxt4 = new JScrollPane();
		scrollPaneTxt4.setBounds(10, 375, 294, 61);
		contentPane.add(scrollPaneTxt4);
		
		txtPane4 = new JTextPane();
		scrollPaneTxt4.setViewportView(txtPane4);
		txtPane4.setEnabled(false);
		txtPane4.setEditable(false);
		
		JLabel label_3 = new JLabel("Pedido:");
		label_3.setBounds(10, 234, 69, 14);
		contentPane.add(label_3);
		
		this.txtPeido5 = new JTextField();
		this.txtPeido5.setEnabled(false);
		this.txtPeido5.setEditable(false);
		this.txtPeido5.setColumns(10);
		this.txtPeido5.setBounds(375, 230, 86, 20);
		this.contentPane.add(txtPeido5);
		
		this.scrollPane5 = new JScrollPane();
		this.scrollPane5.setBounds(316, 261, 296, 103);
		this.contentPane.add(scrollPane5);
		
		this.modelTable5 = new WDefaultTableModel(null, this.nombreColumnasPedidos);
		this.tblPedido5 = new WTable(this.modelTable5);
		this.scrollPane5.setViewportView(tblPedido5);
		
		scrollPaneTxt5 = new JScrollPane();
		scrollPaneTxt5.setBounds(316, 375, 294, 61);
		contentPane.add(scrollPaneTxt5);
		
		txtPane5 = new JTextPane();
		scrollPaneTxt5.setViewportView(txtPane5);
		txtPane5.setEnabled(false);
		txtPane5.setEditable(false);
		
		JLabel label_4 = new JLabel("Pedido:");
		label_4.setBounds(622, 234, 69, 14);
		contentPane.add(label_4);
		
		this.txtPeido6 = new JTextField();
		this.txtPeido6.setEnabled(false);
		this.txtPeido6.setEditable(false);
		this.txtPeido6.setColumns(10);
		this.txtPeido6.setBounds(681, 231, 86, 20);
		this.contentPane.add(txtPeido6);
		
		this.scrollPane6 = new JScrollPane();
		this.scrollPane6.setBounds(622, 261, 296, 103);
		this.contentPane.add(scrollPane6);
		
		this.modelTable6 = new WDefaultTableModel(null, this.nombreColumnasPedidos);
		this.tblPedido6 = new WTable(this.modelTable6);
		this.scrollPane6.setViewportView(tblPedido6);
		
		scrollPaneTxt6 = new JScrollPane();
		scrollPaneTxt6.setBounds(622, 375, 294, 61);
		contentPane.add(scrollPaneTxt6);
		
		txtPane6 = new JTextPane();
		scrollPaneTxt6.setViewportView(txtPane6);
		txtPane6.setEnabled(false);
		txtPane6.setEditable(false);
		
		this.scrollPanePedidosPendientes = new JScrollPane();
		this.scrollPanePedidosPendientes.setBounds(926, 42, 296, 394);
		this.contentPane.add(scrollPanePedidosPendientes);
		
		this.modelTablePendientes = new WDefaultTableModel(null, this.nombreColumnasPedidos);
		this.tblProductosPendientes = new WTable(this.modelTablePendientes);
		this.scrollPanePedidosPendientes.setViewportView(this.tblProductosPendientes);
	}
	
	public void Open() {
		this.setVisible(true);
	}
	
	public void Close() {
		this.dispose();
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

	public JTextPane getTxtPane1() {
		return txtPane1;
	}

	public JTextPane getTxtPane2() {
		return txtPane2;
	}

	public JTextPane getTxtPane3() {
		return txtPane3;
	}

	public JTextPane getTxtPane4() {
		return txtPane4;
	}

	public JTextPane getTxtPane5() {
		return txtPane5;
	}

	public JTextPane getTxtPane6() {
		return txtPane6;
	}

	public JScrollPane getScrollPane1() {
		return scrollPane1;
	}

	public JScrollPane getScrollPaneTxt1() {
		return scrollPaneTxt1;
	}

	public JScrollPane getScrollPane2() {
		return scrollPane2;
	}

	public JScrollPane getScrollPaneTxt2() {
		return scrollPaneTxt2;
	}

	public JScrollPane getScrollPane3() {
		return scrollPane3;
	}

	public JScrollPane getScrollPaneTxt3() {
		return scrollPaneTxt3;
	}

	public JScrollPane getScrollPane4() {
		return scrollPane4;
	}

	public JScrollPane getScrollPaneTxt4() {
		return scrollPaneTxt4;
	}

	public JScrollPane getScrollPane5() {
		return scrollPane5;
	}

	public JScrollPane getScrollPaneTxt5() {
		return scrollPaneTxt5;
	}

	public JScrollPane getScrollPane6() {
		return scrollPane6;
	}

	public JScrollPane getScrollPaneTxt6() {
		return scrollPaneTxt6;
	}

	public JScrollPane getScrollPanePedidosPendientes() {
		return scrollPanePedidosPendientes;
	}
}