package dao;

import java.util.List;

import dto.MateriaPrimaSolicitudDTO;
import dto.ProveedorDTO;
import dto.SolicitudDTO;

public interface SolicitudDAO {

	/* Obtiene las solicitudes. */
	public List<SolicitudDTO> GetSolicitudesActualesGuardadas();

	/* Obtiene un Nuevo Numero de Solicitud. */
	public int GetNuevoNumeroSolicitud(String Fecha);

	/* Crea una Solicitud con estado guardada. */
	public void CrearSolicitud(SolicitudDTO Solicitud, String Proveedor,
			List<MateriaPrimaSolicitudDTO> MateriasPrimas);

	/* Controla si la solicitud Existe. */
	public boolean Existe(SolicitudDTO Solicitud);

	/* Actualiza las solicitudes */
	public void ActualizarSolicitud(SolicitudDTO solicitud, String Proveedor, List<MateriaPrimaSolicitudDTO> MateriasPrimas);

	/* Pone la solicitud en estado enviado. */
	public void Enviar(SolicitudDTO Solicitud);

	/* Obtiene el proveedor de la solicitud */
	public ProveedorDTO GetProveedor(String fechaSolicitud, String numeroSolicitud);

	/* Obtienelas mateias primas para un pedido */
	public List<MateriaPrimaSolicitudDTO> GetMaterasPrimasPara(String fecha, String numPedido);
}