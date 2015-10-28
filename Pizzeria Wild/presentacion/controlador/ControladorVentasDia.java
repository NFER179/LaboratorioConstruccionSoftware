package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

import modelo.VentaModelo;

import dto.VentaDTO;

import vista.ReporteVista;
import vista.VentasDiasVista;

public class ControladorVentasDia implements ActionListener {

	private VentasDiasVista vtVentasDia;
	private ControladorReporte ctrReporte;
	private VentaModelo mdlventa;
	
	public ControladorVentasDia(ControladorReporte Ctr, ReporteVista Vista) {
		this.vtVentasDia = new VentasDiasVista(Vista);
		this.vtVentasDia.getBtnVolver().addActionListener(this);
		
		this.ctrReporte = Ctr;
		this.mdlventa = new VentaModelo();
	}
	
	public void inicializar() {
		this.CargarValores();
		this.vtVentasDia.Open();
	}
	
	private void CargarValores() {
		this.CargarCantdadVentasFacturadas();
		this.CargarFacturadas();
		this.CargarGananciaFacturadas();
		this.CargarCantidadVentasCanceladas();
		this.CargarCanceladas();
		this.CargarPerdidaCanceladas();
		this.CargarTotalGanancias();
	}

	private void CargarCantdadVentasFacturadas() {
		String CantidadFacturadas = Integer.toString(this.mdlventa.ObtenerCurCantidadVentasFacturadas());
		this.vtVentasDia.getTxtCantidadFacturadas().setText(CantidadFacturadas);
	}
	private void CargarFacturadas() {
		this.vtVentasDia.getModelFacturadas().setRowCount(0);
		this.vtVentasDia.getModelFacturadas().setColumnCount(0);
		this.vtVentasDia.getModelFacturadas().setColumnIdentifiers(this.vtVentasDia.getNombreColumnas());
		for(VentaDTO venta:this.mdlventa.ObtenerCurVentasFacturadas()) {
			Object[] fila = {venta.getFecha(), venta.getNumVenta(), venta.getCliente(), "$ " + venta.getPrecio()};
			this.vtVentasDia.getModelFacturadas().addRow(fila);
		}
		JTable tabla = this.vtVentasDia.getTblFacturadas();
		tabla.setModel(this.vtVentasDia.getModelFacturadas());
	}
	
	private void CargarGananciaFacturadas() {
		String Ganancias = Integer.toString(this.mdlventa.ObtenerCurGananciaFacturadas());
		this.vtVentasDia.getTxtTotalfacturadas().setText("$ " + Ganancias);
	}
	
	private void CargarCantidadVentasCanceladas() {
		String Cantidad = Integer.toString(this.mdlventa.ObtenerCurCantidadVentasCanceladas());
		this.vtVentasDia.getTxtCantidadCanceladas().setText(Cantidad);
	}
	
	private void CargarCanceladas() {
		this.vtVentasDia.getModelCanceladas().setRowCount(0);
		this.vtVentasDia.getModelCanceladas().setColumnCount(0);
		this.vtVentasDia.getModelCanceladas().setColumnIdentifiers(this.vtVentasDia.getNombreColumnas());
		for(VentaDTO venta:this.mdlventa.ObtenerCurVentasCanceladas()) {
			Object[] fila = {venta.getFecha(), venta.getNumVenta(), venta.getCliente(), "$ " + venta.getPrecio()};
			this.vtVentasDia.getModelCanceladas().addRow(fila);
		}
		JTable tabla = this.vtVentasDia.getTblCanceladas();
		tabla.setModel(this.vtVentasDia.getModelCanceladas());
	}
	
	private void CargarPerdidaCanceladas() {
		String Perdidas = Integer.toString(this.mdlventa.ObtenerCurPerdidaCanceladas());
		this.vtVentasDia.getTxtTotalcanceladas().setText("$ " + Perdidas);
	}
	
	private void CargarTotalGanancias() {
		int Ganancias = this.mdlventa.ObtenerCurGananciaFacturadas();
		int Perdidas = this.mdlventa.ObtenerCurPerdidaCanceladas();
		int Total = Ganancias - Perdidas;
		
		String TotalS = Integer.toString(Total);
		this.vtVentasDia.getTxtGananciasTotales().setText("$ " + TotalS);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == vtVentasDia.getBtnVolver()) {
			this.vtVentasDia.Close();
		}
	}
}