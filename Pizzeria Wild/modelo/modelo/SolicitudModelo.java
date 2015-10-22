package modelo;

import java.util.List;

import dao.SolicitudDAO;
import daoImplementacion.SolicitudImp;
import dto.MateriaPrimaSolicitudDTO;
import dto.SolicitudDTO;

public class SolicitudModelo {

	private SolicitudDAO solicitud;
	
	public SolicitudModelo() {
		solicitud = new SolicitudImp();
	}

	public List<SolicitudDTO> ObtenerSolicitudes() {
		return this.solicitud.GetSolicitudes();
	}

	public int ObtenerNumNuevaSolicitud(String Fecha) {
		return this.solicitud.GetNuevoNumeroSolicitud(Fecha);
	}

	public void EnviarSolicitud(SolicitudDTO Solicitud, String Proveedor, List<MateriaPrimaSolicitudDTO> MateriasPrimas) {
		this.solicitud.EnviarSolicitud(Solicitud, Proveedor, MateriasPrimas);
	}
}
