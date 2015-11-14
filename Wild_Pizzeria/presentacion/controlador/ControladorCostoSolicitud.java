package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import validacion.ValidacionCostoSolicitud;
import vista.CostoSolicitudVista;
import vista.SolicitudCompraVista;

public class ControladorCostoSolicitud implements ActionListener {

	private CostoSolicitudVista vtCosto;
	private ControladorSolicitud ctrSolicitud;
	private ValidacionCostoSolicitud vlCostoSolicitud;
	
	public ControladorCostoSolicitud(ControladorSolicitud Ctr, SolicitudCompraVista Vista) {
		this.vtCosto = new CostoSolicitudVista(Vista);
		
		this.vtCosto.getBtnRecepcionar().addActionListener(this);
		this.vtCosto.getBtnCancelar().addActionListener(this);
		
		this.ctrSolicitud = Ctr;
		this.vlCostoSolicitud = new ValidacionCostoSolicitud(this.vtCosto);
	}
	
	public void Inicializar(){
		this.vtCosto.Open();
	}
	
	private void AsignarCosto() {
		String CostoString = this.vtCosto.getTextField().getText().trim();
		int costo = Integer.parseInt(CostoString);
		
		this.ctrSolicitud.InicializarRecepcionamiento(costo);
		
		this.vtCosto.Close();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == this.vtCosto.getBtnRecepcionar()) {
			if(this.vlCostoSolicitud.CostoValido()) {
				this.AsignarCosto();
			}
		}else if(arg0.getSource() == this.vtCosto.getBtnCancelar()) {
			this.vtCosto.Close();
		}
	}

}
