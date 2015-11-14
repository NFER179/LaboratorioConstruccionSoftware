package vista;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import objetosVistaCustom.WDefaultTableModel;
import objetosVistaCustom.WTable;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.ImageIcon;

public class VentasDiasVista extends JDialog {
	
	private JTextField txtCantidadFacturadas;
	private String[] nombreColumnasVentas = {"Fecha Venta","Numero Venta","Cliente","Facturado"};
	private DefaultTableModel modelFacturadas;
	private JTable tblFacturadas;
	private JScrollPane scrollPaneFacturadas;
	private JTextField txtTotalfacturadas;
	private JTextField txtCantidadCanceladas;
	private String[] nombreColumnasSolicitudes = {"Fecha Solicitud","Numero Solicitud","Proveedor","Cobrado"};
	private DefaultTableModel modelCanceladas;
	private JTable tblCanceladas;
	private JScrollPane scrollPaneCanceladas;
	private JTextField txtTotalcanceladas;
	private JTextField txtGananciasTotales;
	private JButton btnVolver;

	public VentasDiasVista(ReporteVista Vista) {
		super(Vista,true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentasDiasVista.class.getResource("/Iconos/pizza_1.PNG")));
		setTitle(" Ventas del Dia");
		
		setBounds(100, 100, 450, 487);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblCantidadVentasFacturadas = new JLabel("Cantidad Ventas Facturadas:");
		lblCantidadVentasFacturadas.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCantidadVentasFacturadas.setBounds(10, 11, 165, 14);
		getContentPane().add(lblCantidadVentasFacturadas);
		
		txtCantidadFacturadas = new JTextField();
		txtCantidadFacturadas.setEnabled(false);
		txtCantidadFacturadas.setEditable(false);
		txtCantidadFacturadas.setBounds(197, 8, 86, 20);
		getContentPane().add(txtCantidadFacturadas);
		txtCantidadFacturadas.setColumns(10);
		
		scrollPaneFacturadas = new JScrollPane();
		scrollPaneFacturadas.setBounds(10, 36, 422, 100);
		getContentPane().add(scrollPaneFacturadas);
		
		this.modelFacturadas = new WDefaultTableModel(null, this.nombreColumnasVentas);
		tblFacturadas = new WTable(this.modelFacturadas);
		scrollPaneFacturadas.setViewportView(tblFacturadas);
		
		JLabel lblTotalFacturadas = new JLabel("Total Facturadas:");
		lblTotalFacturadas.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTotalFacturadas.setBounds(236, 147, 100, 14);
		getContentPane().add(lblTotalFacturadas);
		
		txtTotalfacturadas = new JTextField();
		txtTotalfacturadas.setEditable(false);
		txtTotalfacturadas.setEnabled(false);
		txtTotalfacturadas.setBounds(346, 144, 86, 20);
		getContentPane().add(txtTotalfacturadas);
		txtTotalfacturadas.setColumns(10);
		
		JLabel lblCantidadVentasCanceladas = new JLabel("Cantidad Ventas Canceladas:");
		lblCantidadVentasCanceladas.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCantidadVentasCanceladas.setBounds(10, 175, 165, 14);
		getContentPane().add(lblCantidadVentasCanceladas);
		
		txtCantidadCanceladas = new JTextField();
		txtCantidadCanceladas.setEnabled(false);
		txtCantidadCanceladas.setEditable(false);
		txtCantidadCanceladas.setBounds(197, 172, 86, 20);
		getContentPane().add(txtCantidadCanceladas);
		txtCantidadCanceladas.setColumns(10);
		
		scrollPaneCanceladas = new JScrollPane();
		scrollPaneCanceladas.setBounds(10, 203, 422, 100);
		getContentPane().add(scrollPaneCanceladas);
		
		this.modelCanceladas = new WDefaultTableModel(null, this.nombreColumnasSolicitudes);
		tblCanceladas = new WTable(this.modelCanceladas);
		scrollPaneCanceladas.setViewportView(tblCanceladas);
		
		JLabel lblTotalCanceladas = new JLabel("Total Canceladas:");
		lblTotalCanceladas.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTotalCanceladas.setBounds(236, 314, 100, 14);
		getContentPane().add(lblTotalCanceladas);
		
		txtTotalcanceladas = new JTextField();
		txtTotalcanceladas.setEditable(false);
		txtTotalcanceladas.setEnabled(false);
		txtTotalcanceladas.setBounds(346, 311, 86, 20);
		getContentPane().add(txtTotalcanceladas);
		txtTotalcanceladas.setColumns(10);
		
		JLabel lblTotalGananciasDel = new JLabel("Total Ganancias del Dia:");
		lblTotalGananciasDel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTotalGananciasDel.setBounds(10, 354, 165, 14);
		getContentPane().add(lblTotalGananciasDel);
		
		txtGananciasTotales = new JTextField();
		txtGananciasTotales.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtGananciasTotales.setEditable(false);
		txtGananciasTotales.setEnabled(false);
		txtGananciasTotales.setBounds(33, 389, 142, 40);
		getContentPane().add(txtGananciasTotales);
		txtGananciasTotales.setColumns(10);
		
		btnVolver = new JButton(" Volver");
		btnVolver.setIcon(new ImageIcon(VentasDiasVista.class.getResource("/Iconos/Volver.png")));
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVolver.setBounds(292, 402, 140, 40);
		getContentPane().add(btnVolver);
	}

	public void Open() {
		this.setVisible(true);
	}
	
	public void Close() {
		this.setVisible(false);
	}

	public String[] getNombreColumnasVentas() {
		return nombreColumnasVentas;
	}

	public JTextField getTxtCantidadFacturadas() {
		return txtCantidadFacturadas;
	}

	public DefaultTableModel getModelFacturadas() {
		return modelFacturadas;
	}

	public JTable getTblFacturadas() {
		return tblFacturadas;
	}

	public JScrollPane getScrollPaneFacturadas() {
		return scrollPaneFacturadas;
	}

	public JTextField getTxtTotalfacturadas() {
		return txtTotalfacturadas;
	}

	public JTextField getTxtCantidadCanceladas() {
		return txtCantidadCanceladas;
	}

	public DefaultTableModel getModelCanceladas() {
		return modelCanceladas;
	}

	public JTable getTblCanceladas() {
		return tblCanceladas;
	}

	public JScrollPane getScrollPaneCanceladas() {
		return scrollPaneCanceladas;
	}

	public JTextField getTxtTotalcanceladas() {
		return txtTotalcanceladas;
	}

	public JTextField getTxtGananciasTotales() {
		return txtGananciasTotales;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public String[] getNombreColumnasSolicitudes() {
		return nombreColumnasSolicitudes;
	}
	
}