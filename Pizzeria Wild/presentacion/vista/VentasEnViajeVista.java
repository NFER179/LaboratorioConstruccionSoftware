/** Clase Creada por Nicolas Fernandez 30/09/2015, Vista para ingresar pedidos entregados y no entregados.**/
package vista;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import javax.swing.ListSelectionModel;

import objetosVistaCustom.WDefaultTableModel;
import objetosVistaCustom.WTable;

@SuppressWarnings("serial")
public class VentasEnViajeVista extends JDialog {
	
	private DefaultTableModel ModelTableDelivery;
	private String[] NombreColumnasDelivery = {"Fecha Delivery", "Num Delivery"};
	private JTable tableDelivery;
	private JButton btnSeleccionardelivery;
	private DefaultTableModel ModelTableVentas;
	private String[] NombreColumnasVentas = {"Fecha Venta", "NumVenta"};
	private JTable tableVentas;
	private JButton btnEntregado;
	private JButton btnNoEntregado;
	private JButton btnAceptar;

	public VentasEnViajeVista(JFrame Frame) {
		super(Frame, true);
		
		this.setTitle("Pedidos en Viaje");
		this.setBounds(100, 100, 551, 290);
		this.getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 172, 197);
		this.getContentPane().add(scrollPane);
		
		this.ModelTableDelivery = new WDefaultTableModel(null, this.NombreColumnasDelivery);
		
		this.tableDelivery = new WTable(this.ModelTableDelivery);
		tableDelivery.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(this.tableDelivery);
		
		this.btnSeleccionardelivery = new JButton(">>");
		this.btnSeleccionardelivery.setBounds(192, 96, 60, 23);
		this.getContentPane().add(btnSeleccionardelivery);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(262, 11, 151, 197);
		this.getContentPane().add(scrollPane_1);

		this.ModelTableVentas = new WDefaultTableModel(null, this.NombreColumnasVentas);
		this.tableVentas = new WTable(this.ModelTableVentas);
		scrollPane_1.setViewportView(this.tableVentas);
		
		this.btnEntregado = new JButton("Entregado");
		this.btnEntregado.setBounds(423, 8, 110, 23);
		this.getContentPane().add(btnEntregado);
		
		this.btnNoEntregado = new JButton("No Entregado");
		this.btnNoEntregado.setBounds(423, 44, 110, 23);
		this.getContentPane().add(btnNoEntregado);
		
		this.btnAceptar = new JButton("Aceptar");
		this.btnAceptar.setBounds(423, 222, 110, 23);
		this.getContentPane().add(btnAceptar);
	}
	
	public void Open(){
		this.setVisible(true);
	}
	
	public void Close(){
		this.setVisible(false);
	}

	public DefaultTableModel getModelTableDelivery() {
		return ModelTableDelivery;
	}

	public String[] getNombreColumnasDelivery() {
		return NombreColumnasDelivery;
	}

	public JTable getTableDelivery() {
		return tableDelivery;
	}

	public JButton getBtnSeleccionardelivery() {
		return btnSeleccionardelivery;
	}

	public DefaultTableModel getModelTableVentas() {
		return ModelTableVentas;
	}

	public String[] getNombreColumnasVentas() {
		return NombreColumnasVentas;
	}

	public JTable getTableVentas() {
		return tableVentas;
	}

	public JButton getBtnEntregado() {
		return btnEntregado;
	}

	public JButton getBtnNoEntregado() {
		return btnNoEntregado;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}
}