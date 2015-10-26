package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.ReporteVista;

public class ControladorReporte implements ActionListener {

	private Controlador ctr;
	private ReporteVista vtReporte;
	
	public ControladorReporte(Controlador Ctr, ReporteVista Vista){
		this.ctr = Ctr;
		
		this.vtReporte = Vista;
		this.vtReporte.getBtnVentasDelDia().addActionListener(this);
		
		this.vtReporte.getBtnVolver().addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == this.vtReporte.getBtnVentasDelDia()){
			
		}
		else if(arg0.getSource() == this.vtReporte.getBtnVolver()) {
			
		}
	}
}
