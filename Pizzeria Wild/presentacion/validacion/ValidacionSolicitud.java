package validacion;

import javax.swing.JOptionPane;

import vista.SolicitudCompraVista;

public class ValidacionSolicitud {

	private SolicitudCompraVista vtSolicitudCompra;
	
	public ValidacionSolicitud(SolicitudCompraVista Vista) {
		this.vtSolicitudCompra = Vista;
	}
	
	public boolean ModificarValido(){
		boolean Modificar = true;
		
		if(this.vtSolicitudCompra.getTable().getSelectedRowCount() < 1){
			Modificar = false;
			String mensaje = "Debe Seleccionar una Solicitud para Poder Modificarla.";
			String titulo = "Informacion Seleccion";
			JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
		}
		
		return Modificar;
	}
}
