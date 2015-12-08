package validacion;
 

import utilidades.Msj;
import vista.CostoSolicitudVista;

public class ValidacionCostoSolicitud {

	private CostoSolicitudVista vtCosto;
	
	public ValidacionCostoSolicitud(CostoSolicitudVista Vista) {
		this.vtCosto = Vista;
	}

	public boolean CostoValido() {
		boolean valido = true;
		
		try {
			int valor = Integer.parseInt(this.vtCosto.getTextField().getText().trim());
			if(valor<=0){
				valido = false;
				Msj.error("Error", "El costo debe ser un numero mayor que cero");
			}
		}catch(Exception e) {
			valido = false;
			String mensaje = "Ingrese numero valido";
			String titulo = "Error";
			Msj.error(titulo, mensaje);
		}
		
		return valido;
	}
}
