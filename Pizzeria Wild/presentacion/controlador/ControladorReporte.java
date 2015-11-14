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
		this.vtReporte.getBtnVolver().addActionListener(this);
	}

	public void Inicializar() {
		this.vtReporte.Open();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if (source == this.vtReporte.getBtnVentasDelDia()) {
			accionVentasDelDia();
		} else if (source == this.vtReporte.getBtnVolver()) {
			accionVolver();
		}
	}

	private void accionVolver() {
		this.ctr.Return();
		this.vtReporte.Close();
	}

	private void accionVentasDelDia() {
		ControladorVentasDia ctrVentasDia = new ControladorVentasDia(
				this.vtReporte);
		ctrVentasDia.inicializar();
	}
}
