package modelo;

import java.util.List;

import dao.SolicitudDAO;
import daoImplementacion.SolicitudImp;
import dto.SolicitudDTO;

public class SolicitudModelo {

	private SolicitudDAO solicitud;
	
	public SolicitudModelo() {
		solicitud = new SolicitudImp();
	}

	public List<SolicitudDTO> ObtenerSolicitudes() {
		return this.solicitud.GetSolicitudes();
	}
}
