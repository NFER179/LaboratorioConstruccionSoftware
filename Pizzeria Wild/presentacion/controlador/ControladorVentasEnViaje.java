package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dto.DeliveryDTO;
import dto.DeliveryVentaDTO;
import dto.VentaDTO;
import modelo.DeliveryModelo;
import modelo.DeliveryVentaModelo;
import modelo.VentaModelo;
import utilidades.Msj;
import utilidades.Str;
import vista.VentasEnViajeVista;
import vista.VentasVista;

public class ControladorVentasEnViaje implements ActionListener {

	private VentasEnViajeVista vtVentasEnViaje;
	private VentaModelo mdlVenta;
	private ControladorVenta ctrVenta;
	private DeliveryModelo mdlDelivery;
	private String fechadeliverySeleccionado;
	private int numPedidoSeleccionado;
	private DeliveryVentaModelo mdlDeliveryVenta;
	private VentasVista vtVentas;

	private static int columnaFecha = 0;
	private static int columnaNumVenta = 1;

	public ControladorVentasEnViaje(ControladorVenta CtrVenta, VentasVista Vista) {
		this.vtVentas = Vista;
		this.vtVentasEnViaje = new VentasEnViajeVista(Vista);
		addListeners();
		this.ctrVenta = CtrVenta;
		this.mdlVenta = new VentaModelo();
		this.mdlDelivery = new DeliveryModelo();
		this.mdlDeliveryVenta = new DeliveryVentaModelo();
	}

	public void Iniciar() {
		this.CargarTablaDelivery();
		this.vtVentas.Close();
		this.vtVentasEnViaje.Open();
	}

	private void addListeners() {
		this.vtVentasEnViaje.getBtnSeleccionardelivery()
				.addActionListener(this);
		this.vtVentasEnViaje.getBtnEntregado().addActionListener(this);
		this.vtVentasEnViaje.getBtnNoEntregado().addActionListener(this);
		this.vtVentasEnViaje.getBtnAceptar().addActionListener(this);
	}

	private void CargarTablaDelivery() {
		/* Carga la tabla de delivery. */
		VentasEnViajeVista vista = this.vtVentasEnViaje;
		DefaultTableModel tablaDelivery = vista.getModelTableDelivery();
		tablaDelivery.setRowCount(0);
		tablaDelivery.setColumnCount(0);

		String[] nombresColumnas = vista.getNombreColumnasDelivery();
		tablaDelivery.setColumnIdentifiers(nombresColumnas);
		for (DeliveryDTO delivery : this.mdlDelivery.DeliverysEnViaje()) {
			String numDelivery = delivery.getNumDelivery() + ""; // toString()
			Object[] fila = { delivery.getFecha(), numDelivery };
			tablaDelivery.addRow(fila);
		}
		this.vtVentasEnViaje.getTableDelivery().setModel(tablaDelivery);
	}

	private List<VentaDTO> VentasSeleccionadas() {
		List<VentaDTO> ventas = new ArrayList<VentaDTO>();
		int[] filasMarcadas = this.vtVentasEnViaje.getTableVentas()
				.getSelectedRows();
		JTable tablaVentas = this.vtVentasEnViaje.getTableVentas();
		for (int i = 0; i < filasMarcadas.length; i++) {
			int filaActual = filasMarcadas[i];
			String fechaActual = tablaVentas
					.getValueAt(filaActual, columnaFecha).toString().trim();
			int numVentaActual = Integer.parseInt(tablaVentas
					.getValueAt(filaActual, columnaNumVenta).toString().trim());
			ventas.add(this.mdlVenta.GetVenta(fechaActual, numVentaActual));
		}
		return ventas;
	}

	private void VentasEntregados(List<VentaDTO> Ventas) {
		for (VentaDTO venta : Ventas) {
			this.mdlDelivery.DeliverysEntregados(
					this.fechadeliverySeleccionado, this.numPedidoSeleccionado,
					venta);
			this.mdlVenta.FinalizarVenta(venta.getFecha(), venta.getNumVenta());
		}
		this.CargarTablaDelivery();
	}

	private void VentaNoEntregada(VentaDTO Venta, String Observacion) {
		this.mdlDeliveryVenta.VentaNoEntregada(this.fechadeliverySeleccionado,
				this.numPedidoSeleccionado, Venta, Observacion);
		this.mdlVenta.VentaArmado(Venta.getFecha(), Venta.getNumVenta());

		this.CargarTablaDelivery();
	}

	private void CargarDeliverySeleccionado() {
		JTable tablaDelivery = this.vtVentasEnViaje.getTableDelivery();
		int filaSeleccionada = tablaDelivery.getSelectedRow();

		this.fechadeliverySeleccionado = Str.trim(tablaDelivery.getValueAt(
				filaSeleccionada, columnaFecha));

		this.numPedidoSeleccionado = Str.toInt(tablaDelivery.getValueAt(
				filaSeleccionada, columnaNumVenta));
	}

	private void CargarTablaVentas() {
		this.vtVentasEnViaje.getModelTableVentas().setRowCount(0);
		this.vtVentasEnViaje.getModelTableVentas().setColumnCount(0);
		this.vtVentasEnViaje.getModelTableVentas().setColumnIdentifiers(
				this.vtVentasEnViaje.getNombreColumnasVentas());
		for (DeliveryVentaDTO dv : this.mdlDeliveryVenta.GetVentasPara(
				this.fechadeliverySeleccionado, this.numPedidoSeleccionado)) {
			Object[] fila = { dv.getFechaVenta(),
					Integer.toString(dv.getNumVenta()) };
			this.vtVentasEnViaje.getModelTableVentas().addRow(fila);
		}
		this.vtVentasEnViaje.getTableVentas().setModel(
				this.vtVentasEnViaje.getModelTableVentas());
	}

	private void CargarTablaVentasSumarizando() {
		for (DeliveryVentaDTO dv : this.mdlDeliveryVenta.GetVentasPara(
				this.fechadeliverySeleccionado, this.numPedidoSeleccionado)) {
			boolean existeFila = false;
			DefaultTableModel tabla = this.vtVentasEnViaje
					.getModelTableVentas();
			int cantFilas = tabla.getRowCount();
			for (int i = 0; i < cantFilas; i++) {
				boolean esLaFila = tabla.getValueAt(i, 0).equals(
						dv.getFechaVenta());
				esLaFila &= tabla.getValueAt(i, 1).equals(
						Integer.toString(dv.getNumVenta()));
				if (esLaFila)
					existeFila = true;
			}
			if (!existeFila)
				agregoFila(dv);
		}
		this.vtVentasEnViaje.getTableVentas().setModel(
				this.vtVentasEnViaje.getModelTableVentas());
	}

	private void agregoFila(DeliveryVentaDTO dv) {
		Object[] fila = { dv.getFechaVenta(),
				Integer.toString(dv.getNumVenta()) };
		DefaultTableModel tabla = this.vtVentasEnViaje.getModelTableVentas();
		tabla.addRow(fila);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		VentasEnViajeVista vista = this.vtVentasEnViaje;
		if (source == vista.getBtnSeleccionardelivery())
			accionSeleccionarDelivery();
		else if (source == vista.getBtnEntregado())
			accionEntregado();
		else if (source == vista.getBtnNoEntregado())
			accionNoEntregado();
		else if (source == vista.getBtnAceptar())
			accionAceptar();
		else
			System.out.println("Estado Ilegal");
	}

	private void accionAceptar() {
		this.ctrVenta.Inicializar();
		this.vtVentasEnViaje.Close();
		this.vtVentas.Open();
	}

	private void accionNoEntregado() {
		int[] Seleccionadas = this.vtVentasEnViaje.getTableVentas()
				.getSelectedRows();
		if (Seleccionadas.length == 1) {
			String obs = JOptionPane.showInputDialog(null);
			JTable table = this.vtVentasEnViaje.getTableVentas();
			String fecha = table.getValueAt(Seleccionadas[0], 0).toString()
					.trim();
			int numVenta = Integer.parseInt(table
					.getValueAt(Seleccionadas[0], 1).toString().trim());
			this.VentaNoEntregada(this.mdlVenta.GetVenta(fecha, numVenta), obs);
			this.CargarTablaVentas();
		} else {
			String titulo = "Error Seleccion Venta.";
			String mensaje = "Solo Puede Cancelar de a una Venta.";
			Msj.error(titulo, mensaje);
		}
	}

	private void accionEntregado() {
		List<VentaDTO> ventas = this.VentasSeleccionadas();
		if (ventas.size() > 0) {
			this.VentasEntregados(ventas);
			this.CargarTablaVentas();
		} else {
			String titulo = "Error Seleccion Venta.";
			String mensaje = "Debe Seleccionar al Menos una Venta";
			Msj.error(titulo, mensaje);
		}
	}

	private void accionSeleccionarDelivery() {
		if (this.vtVentasEnViaje.getTableDelivery().getSelectedRows().length >= 1) {
			this.CargarDeliverySeleccionado();
			// NO DEBE RECARGAR, SINO CONCATENAR
			// this.CargarTablaVentas();
			CargarTablaVentasSumarizando();
		}
	}
}