package modelo;

import java.util.List;

import dao.SolicitudDAO;
import daoImplementacion.SolicitudImp;
import dto.MateriaPrimaSolicitudDTO;
import dto.ProveedorDTO;
import dto.SolicitudDTO;

public class SolicitudModelo {

	private SolicitudDAO solicitud;
	
	public SolicitudModelo() {
		solicitud = new SolicitudImp();
	}

	public List<SolicitudDTO> ObtenerSolicitudes() {
		return this.solicitud.GetSolicitudesActualesGuardadas();
	}

	public int ObtenerNumNuevaSolicitud(String Fecha) {
		return this.solicitud.GetNuevoNumeroSolicitud(Fecha);
	}

	public void EnviarSolicitud(SolicitudDTO Solicitud, String Proveedor, List<MateriaPrimaSolicitudDTO> MateriasPrimas) {
		this.solicitud.CrearSolicitud(Solicitud, Proveedor, MateriasPrimas);
		this.solicitud.Enviar(Solicitud);
		
		SolicitudDTO solicitud = this.SolicitudReferenteA(Solicitud);
		if(!this.solicitud.Existe(solicitud)) {
			this.solicitud.CrearSolicitud(solicitud, Proveedor, MateriasPrimas);
			this.solicitud.Enviar(solicitud);
		}
	}
	
	public void GuardarSolicitud(SolicitudDTO Solicitud, String Proveedor, List<MateriaPrimaSolicitudDTO> MateriasPrimas) {
		if(this.solicitud.Existe(Solicitud)){
			this.solicitud.ActualizarSolicitud(Solicitud, Proveedor, MateriasPrimas);
		}
		else {
			this.solicitud.CrearSolicitud(Solicitud, Proveedor, MateriasPrimas);
		}
	}
	
	private SolicitudDTO SolicitudReferenteA(SolicitudDTO arg0) {
		return new SolicitudDTO(arg0.getFecha_envio(), arg0.getReferenciaNumPedido(), arg0.isEnviado(), arg0.getFecha_envio(), arg0.getReferenciaNumPedido());
	}

	public ProveedorDTO ObtenerProveedor(String FechaSolicitud, String NumeroSolicitud) {
		return this.solicitud.GetProveedor(FechaSolicitud, NumeroSolicitud);
	}

	public List<MateriaPrimaSolicitudDTO> GetMateriasPrimas(String Fecha, String NumPedido) {
		return this.solicitud.GetMaterasPrimasPara(Fecha, NumPedido);
	}
}