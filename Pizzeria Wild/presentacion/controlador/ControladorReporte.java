package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.ReporteVista;

public class ControladorReporte implements ActionListener {

	private Controlador ctr;
	private ReporteVista vtReporte;
	
	public ControladorReporte(Controlador Ctr){
		this.ctr = Ctr;
		
		this.vtReporte = new ReporteVista();
		this.vtReporte.getBtnVentasDelDia().addActionListener(this);
		
		this.vtReporte.getBtnVolver().addActionListener(this);
	}
	
	public void Inicializar() {
		this.vtReporte.Open();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == this.vtReporte.getBtnVentasDelDia()){
			ControladorVentasDia ctrVentasDia = new ControladorVentasDia(this, this.vtReporte);
			ctrVentasDia.inicializar();
		}
		else if(arg0.getSource() == this.vtReporte.getBtnVolver()) {
			this.ctr.Return();
			this.vtReporte.Close();
		}
	}
}
