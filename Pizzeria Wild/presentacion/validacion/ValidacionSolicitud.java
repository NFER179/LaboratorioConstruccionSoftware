package validacion;

import javax.swing.JOptionPane;
import javax.swing.JTable;

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
		else {
			JTable tabla = this.vtSolicitudCompra.getTable();
			int filaSeleccionada = tabla.getSelectedRow();
			if(tabla.getValueAt(filaSeleccionada, 2).toString().toUpperCase().trim().equals("ENVIADO")) {
				Modificar = false;
				String mensaje = "No Puede Modificar Solicitudes que estan Enviadas.";
				String titulo = "Informacion de Modificacion";
				JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
		return Modificar;
	}

	public boolean SolicitudEntregadaValida() {
		boolean Valido = true;
		
		if(this.vtSolicitudCompra.getTable().getSelectedRowCount() < 1){
			Valido = false;
			String mensaje = "Debe Seleccionar una Solicitud para Poder Recepcionarla.";
			String titulo = "Informacion Seleccion";
			JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			JTable tabla = this.vtSolicitudCompra.getTable();
			int filaSeleccionada = tabla.getSelectedRow();
			if(tabla.getValueAt(filaSeleccionada, 2).toString().toUpperCase().trim().equals("GUARDADO")) {
				Valido = false;
				String mensaje = "No Puede Recpcionar Solicitudes que no entan enviadas.";
				String titulo = "Informacion de Recepcion";
				JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
		return Valido;
	}
}
