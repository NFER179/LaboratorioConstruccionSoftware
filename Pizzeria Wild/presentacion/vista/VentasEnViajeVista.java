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
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class VentasEnViajeVista extends JDialog {

	private DefaultTableModel ModelTableDelivery;
	private String[] NombreColumnasDelivery = { "Fecha Delivery",
			"Num Delivery" };
	private JTable tableDelivery;
	private JButton btnSeleccionardelivery;
	private DefaultTableModel ModelTableVentas;
	private String[] NombreColumnasVentas = { "Fecha Venta", "NumVenta" };
	private JTable tableVentas;
	private JButton btnEntregado;
	private JButton btnNoEntregado;
	private JButton btnAceptar;
	private JLabel lblNewLabel;

	public VentasEnViajeVista(JFrame Frame) {
		super(Frame, true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				VentasEnViajeVista.class.getResource("/Iconos/pizza_1.PNG")));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setTitle(" Pedidos en Viaje");
		this.setBounds(100, 100, 607, 429);
		this.getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 172, 373);
		this.getContentPane().add(scrollPane);

		this.ModelTableDelivery = new WDefaultTableModel(null,
				this.NombreColumnasDelivery);

		this.tableDelivery = new WTable(this.ModelTableDelivery);
		tableDelivery.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(this.tableDelivery);

		this.btnSeleccionardelivery = new JButton(">>");
		btnSeleccionardelivery.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.btnSeleccionardelivery.setBounds(192, 96, 60, 40);
		this.getContentPane().add(btnSeleccionardelivery);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(262, 11, 151, 373);
		this.getContentPane().add(scrollPane_1);

		this.ModelTableVentas = new WDefaultTableModel(null,
				this.NombreColumnasVentas);
		this.tableVentas = new WTable(this.ModelTableVentas);
		scrollPane_1.setViewportView(this.tableVentas);

		this.btnEntregado = new JButton(" Entregado");
		btnEntregado.setIcon(new ImageIcon(VentasEnViajeVista.class
				.getResource("/Iconos/Agregar.png")));
		btnEntregado.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.btnEntregado.setBounds(444, 11, 140, 40);
		this.getContentPane().add(btnEntregado);

		this.btnNoEntregado = new JButton(" No Entregado");
		btnNoEntregado.setIcon(new ImageIcon(VentasEnViajeVista.class
				.getResource("/Iconos/Quitar.png")));
		btnNoEntregado.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.btnNoEntregado.setBounds(444, 75, 140, 40);
		this.getContentPane().add(btnNoEntregado);

		this.btnAceptar = new JButton(" Aceptar");
		btnAceptar.setIcon(new ImageIcon(VentasEnViajeVista.class
				.getResource("/Iconos/OK.png")));
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.btnAceptar.setBounds(449, 344, 140, 40);
		this.getContentPane().add(btnAceptar);

		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentasEnViajeVista.class
				.getResource("/Iconos/Logo Pizzeria Wild .png")));
		lblNewLabel.setBounds(423, 113, 166, 213);
		getContentPane().add(lblNewLabel);
	}

	public void Open() {
		this.setVisible(true);
	}

	public void Close() {
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