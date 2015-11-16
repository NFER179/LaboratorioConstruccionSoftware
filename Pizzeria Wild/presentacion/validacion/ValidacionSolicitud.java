package validacion;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import controlador.ControladorSolicitud;

import vista.SolicitudCompraVista;

public class ValidacionSolicitud {

	private SolicitudCompraVista vtSolicitudCompra;
	private ControladorSolicitud ctrSolicitud;
	
	public ValidacionSolicitud(SolicitudCompraVista Vista, ControladorSolicitud Ctr) {
		this.vtSolicitudCompra = Vista;
		this.ctrSolicitud = Ctr;
	}
	
	private boolean TablaSolicitudesHoy() {
		if(!this.ctrSolicitud.VistaHoy()) {
			String mensaje = "Para Realizar Esta Accion Debe Encontrarse en la Vista de Solicitudes del Dia.";
			String titulo = "Informacion";
			JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
		}
		
		return this.ctrSolicitud.VistaHoy();
	}
	
	public boolean ModificarValido(){
		boolean Modificar = true;
		
		if(this.TablaSolicitudesHoy()) {
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
		}
		else
			Modificar = false;
		
		return Modificar;
	}

	public boolean SolicitudEntregadaValida() {
		boolean Valido = true;
		
		if(this.TablaSolicitudesHoy()) {
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
		}
		else
			Valido = false;
		
		return Valido;
	}

	public boolean NuevaSolicitudValida() {
		return this.TablaSolicitudesHoy();
	}

	public boolean InformacionValido() {
		boolean Valido = true;
		
		if(this.vtSolicitudCompra.getTable().getSelectedRowCount() < 1){
			Valido = false;
			String mensaje = "Debe Seleccionar una Solicitud para Poder Ver su Informacion.";
			String titulo = "Informacion Seleccion";
			JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
		}
		
		return Valido;
	}
}
