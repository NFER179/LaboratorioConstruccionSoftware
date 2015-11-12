package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.ReporteVista;

public class ControladorReporte implements ActionListener {

	private ControladorVenta ctr;
	private ReporteVista vtReporte;

	public ControladorReporte(ControladorVenta Ctr) {
		this.ctr = Ctr;
		this.vtReporte = new ReporteVista();
		addListeners();
	}

	private void addListeners() {
		this.vtReporte.getBtnVentasDelDia().addActionListener(this);
		this.vtReporte.getBtnMejoresClientes().addActionListener(this);
		this.vtReporte.getBtnRepartidores().addActionListener(this);
		this.vtReporte.getBtnVentas().addActionListener(this);
		this.vtReporte.getBtnVolver().addActionListener(this);
	}

	public void Inicializar() {
		this.vtReporte.Open();
	}

	private void accionVentasDelDia() {
		ControladorVentasDia ctrVentasDia = new ControladorVentasDia(
				this.vtReporte);
		ctrVentasDia.inicializar();
	}
	
	private void ReporteMejoresClientes() {
		// TODO Auto-generated method stub
		
	}
	
	private void ReporteRepartidores() {
		// TODO Auto-generated method stub
		
	}
	
	private void ReporteVentas() {
		// TODO Auto-generated method stub
		
	}
	
	private void accionVolver() {
		this.ctr.Return();
		this.vtReporte.Close();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if (source == this.vtReporte.getBtnVentasDelDia()) {
			accionVentasDelDia();
		} else if(source == this.vtReporte.getBtnMejoresClientes()) {
			this.ReporteMejoresClientes();
		} else if(source == this.vtReporte.getBtnRepartidores()) {
			this.ReporteRepartidores();
		} else if(source == this.vtReporte.getBtnVentas()) {
			this.ReporteVentas();
		} else if (source == this.vtReporte.getBtnVolver()) {
			accionVolver();
		}
	}
}
