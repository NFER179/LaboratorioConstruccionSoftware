package validacion;

import javax.swing.JOptionPane;

import vista.CostoSolicitudVista;

public class ValidacionCostoSolicitud {

	private CostoSolicitudVista vtCosto;
	
	public ValidacionCostoSolicitud(CostoSolicitudVista Vista) {
		this.vtCosto = Vista;
	}

	public boolean CostoValido() {
		boolean valido = true;
		
		try {
			Integer.parseInt(this.vtCosto.getTextField().getText().trim());
		}catch(Exception e) {
			valido = false;
			String mensaje = "Ingrese numero valido";
			String titulo = "Error";
			JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
		}
		
		return valido;
	}
}
