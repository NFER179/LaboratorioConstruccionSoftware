package validacion;
 
import javax.swing.JTable;

import controlador.ControladorSolicitud;

import utilidades.Msj;
import vista.SolicitudCompraVista;

public class ValidacionSolicitud {

	private SolicitudCompraVista vtSolicitudCompra;
	private ControladorSolicitud ctrSolicitud;

	public ValidacionSolicitud(SolicitudCompraVista Vista,
			ControladorSolicitud Ctr) {
		this.vtSolicitudCompra = Vista;
		this.ctrSolicitud = Ctr;
	}

	private boolean TablaSolicitudesHoy() {
		if (!this.ctrSolicitud.VistaHoy()) {
			String mensaje = "Para Realizar Esta Accion Debe Encontrarse en la Vista de Solicitudes del Dia.";
			String titulo = "Informacion";
			Msj.info(titulo, mensaje);
		}

		return this.ctrSolicitud.VistaHoy();
	}

	public boolean ModificarValido() {
		boolean ret = true;

		if (this.TablaSolicitudesHoy()) {
			JTable tabla = this.vtSolicitudCompra.getTable();
			if (tabla.getSelectedRowCount() < 1) {
				ret = false;
				String mensaje = "Debe Seleccionar una Solicitud para Poder Modificarla.";
				String titulo = "Informacion Seleccion";
				Msj.info(titulo, mensaje);
			} else {
				int filaSeleccionada = tabla.getSelectedRow();
				String titulo = "Informacion de Modificacion";
				String mensaje = "";
				String filaMarcada = tabla.getValueAt(filaSeleccionada, 2)
						.toString().trim().toUpperCase();
				if (filaMarcada.equals("ENVIADO")) {
					ret = false;
					mensaje = "No Puede Modificar Solicitudes que estan Enviadas.";
					Msj.info(titulo, mensaje);
				} else if (filaMarcada.equals("RECIBIDO")) {
					ret = false;
					mensaje = "No Puede Modificar Solicitudes que estan recibidas.";
					Msj.info(titulo, mensaje);
				}
			}

		} else
			ret = false;

		return ret;
	}

	public boolean SolicitudEntregadaValida() {
		boolean Valido = true;

		if (this.TablaSolicitudesHoy()) {
			JTable tabla = this.vtSolicitudCompra.getTable();
			if (tabla.getSelectedRowCount() < 1) {
				Valido = false;
				String mensaje = "Debe Seleccionar una Solicitud para Poder Recepcionarla.";
				String titulo = "Informacion Seleccion";
				Msj.info(titulo, mensaje);
			} else {
				int filaSeleccionada = tabla.getSelectedRow();
				String filaMarcada = tabla.getValueAt(filaSeleccionada, 2)
						.toString().toUpperCase().trim();
				String titulo = "Informacion de Recepcion";
				String mensaje = "";
				if (filaMarcada.equals("GUARDADO")) {
					Valido = false;
					mensaje = "No Puede Recepcionar Solicitudes que no entan enviadas.";
					Msj.info(titulo, mensaje);
				} else if (filaMarcada.equals("RECIBIDO")) {
					Valido = false;
					mensaje = "Esta solicitud ya fue recibida";
					Msj.info(titulo, mensaje);
				}
			}
		} else
			Valido = false;

		return Valido;
	}

	public boolean NuevaSolicitudValida() {
		return this.TablaSolicitudesHoy();
	}

	public boolean InformacionValido() {
		boolean Valido = true;

		if (this.vtSolicitudCompra.getTable().getSelectedRowCount() < 1) {
			Valido = false;
			String mensaje = "Debe Seleccionar una Solicitud para Poder Ver su Informacion.";
			String titulo = "Informacion Seleccion";
			Msj.info(titulo, mensaje);
		}

		return Valido;
	}
}
