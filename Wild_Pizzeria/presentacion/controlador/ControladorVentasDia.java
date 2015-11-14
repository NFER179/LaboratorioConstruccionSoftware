package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

import modelo.SolicitudModelo;
import modelo.VentaModelo;

import dto.ProveedorDTO;
import dto.SolicitudDTO;
import dto.VentaDTO;

import vista.ReporteVista;
import vista.VentasDiasVista;

public class ControladorVentasDia implements ActionListener {

	private VentasDiasVista vtVentasDia;
	private VentaModelo mdlventa;
	private SolicitudModelo mdlSolicitud;

	public ControladorVentasDia(ReporteVista Vista) {
		this.vtVentasDia = new VentasDiasVista(Vista);
		this.vtVentasDia.getBtnVolver().addActionListener(this);

		this.mdlventa = new VentaModelo();
		this.mdlSolicitud = new SolicitudModelo();
	}

	public void inicializar() {
		this.CargarValores();
		this.vtVentasDia.Open();
	}

	private void CargarValores() {
		this.CargarCantdadVentas();
		this.CargarVentas();
		this.CargarGanancias();
		
		this.CargarCantidadSolicitudes();
		this.CargarSolicitudes();
		this.CargarPerdidas();
		
		this.CargarTotalGanancias();
	}

	private void CargarCantdadVentas() {
		String CantidadFacturadas = Integer.toString(this.mdlventa
				.ObtenerCurCantidadVentasFacturadas());
		this.vtVentasDia.getTxtCantidadFacturadas().setText(CantidadFacturadas);
	}

	private void CargarVentas() {
		this.vtVentasDia.getModelFacturadas().setRowCount(0);
		this.vtVentasDia.getModelFacturadas().setColumnCount(0);
		this.vtVentasDia.getModelFacturadas().setColumnIdentifiers(
				this.vtVentasDia.getNombreColumnasVentas());
		for (VentaDTO venta : this.mdlventa.ObtenerCurVentasFacturadas()) {
			Object[] fila = { venta.getFecha(), venta.getNumVenta(),
					venta.getCliente(), "$ " + venta.getPrecio() };
			this.vtVentasDia.getModelFacturadas().addRow(fila);
		}
		JTable tabla = this.vtVentasDia.getTblFacturadas();
		tabla.setModel(this.vtVentasDia.getModelFacturadas());
	}

	private void CargarGanancias() {
		String Ganancias = Integer.toString(this.mdlventa
				.ObtenerCurGananciaFacturadas());
		this.vtVentasDia.getTxtTotalfacturadas().setText("$ " + Ganancias);
	}

	private void CargarCantidadSolicitudes() {
		String Cantidad = Integer.toString(this.mdlSolicitud.ObtenerCurCantidadSolicitudesEntregadas());
		this.vtVentasDia.getTxtCantidadCanceladas().setText(Cantidad);
	}

	private void CargarSolicitudes() {
		this.vtVentasDia.getModelCanceladas().setRowCount(0);
		this.vtVentasDia.getModelCanceladas().setColumnCount(0);
		this.vtVentasDia.getModelCanceladas().setColumnIdentifiers(
				this.vtVentasDia.getNombreColumnasSolicitudes());
		for (SolicitudDTO solicitud : this.mdlSolicitud.ObtenerCurSolicidesRecibidas()) {
			ProveedorDTO proveedordto = this.mdlSolicitud.ObtenerProveedor(solicitud.getEffdt(), Integer.toString(solicitud.getNumPedido()));
			String proveedor = proveedordto.getNombre();
			Object[] fila = { solicitud.getEffdt(), solicitud.getNumPedido(), proveedor, "$ " + solicitud.getCosto() };
			this.vtVentasDia.getModelCanceladas().addRow(fila);
		}
		JTable tabla = this.vtVentasDia.getTblCanceladas();
		tabla.setModel(this.vtVentasDia.getModelCanceladas());
	}

	private void CargarPerdidas() {
		String Perdidas = Integer.toString(this.mdlSolicitud.ObtenerCurCostoSolicituides());
		this.vtVentasDia.getTxtTotalcanceladas().setText("$ " + Perdidas);
	}

	private void CargarTotalGanancias() {
		int Ganancias = this.mdlventa.ObtenerCurGananciaFacturadas();
		int Perdidas = this.mdlSolicitud.ObtenerCurCostoSolicituides();
		int Total = Ganancias - Perdidas;

		String TotalS = Integer.toString(Total);
		this.vtVentasDia.getTxtGananciasTotales().setText("$ " + TotalS);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == vtVentasDia.getBtnVolver()) {
			this.vtVentasDia.Close();
		}
	}
}