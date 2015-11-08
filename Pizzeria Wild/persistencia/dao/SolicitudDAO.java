package dao;

import java.util.List;

import dto.MateriaPrimaSolicitudDTO;
import dto.ProveedorDTO;
import dto.SolicitudDTO;

public interface SolicitudDAO {

	/* Obtiene las solicitudes. */
	public List<SolicitudDTO> GetSolicitudesActualesNoRecepcionadas();

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

	/* Recepcionar Solicitudes. */
	public void Recepcionar(String fecha, String numSolicitud, int Costo);

	/* Obtiene las Solicitudes entregadas en un determindo rango de fechas. */
	public List<SolicitudDTO> GetEntregadas(String FromDate, String ToDate);

	/* Obtiene la cantidad de Solicitudes Entregadas en un determinado rango. */
	public int GetCantidadEntregadas(String FromDate, String ToDate);

	/* Obtiene la cantidad de costo para un determinada rango de fechas. */
	public int GetCostos(String FromDate, String ToDate);

	/* Obtiene todas las solicitudes. */
	public List<SolicitudDTO> GetAll();
}