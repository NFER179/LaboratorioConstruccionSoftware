package dao;

import java.util.List;

import dto.MateriaPrimaSolicitudDTO;
import dto.SolicitudDTO;

public interface SolicitudDAO {

	/* Obtiene las solicitudes. */
	public List<SolicitudDTO> GetSolicitudes();

	/* Obtiene un Nuevo Numero de Solicitud. */
	public int GetNuevoNumeroSolicitud(String Fecha);

	/* Crea una Solicitud con estado de enviada. */
	public void EnviarSolicitud(SolicitudDTO solicitud, String proveedor,
			List<MateriaPrimaSolicitudDTO> materiasPrimas);
}
