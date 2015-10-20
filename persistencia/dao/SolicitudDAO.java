package dao;

import java.util.List;

import dto.SolicitudDTO;

public interface SolicitudDAO {

	/* Obtiene las solicitudes. */
	public List<SolicitudDTO> GetSolicitudes();
}
