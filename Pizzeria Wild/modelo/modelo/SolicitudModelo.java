package modelo;

import java.util.Calendar;
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
		Calendar c = Calendar.getInstance();
		
		String año = Integer.toString(c.get(Calendar.YEAR));
		String mes = Integer.toString(c.get(Calendar.MONTH));
		if(mes.length() == 1) 
			mes = "0" +  mes;
		String dia = Integer.toString(c.get(Calendar.DATE));
		if(dia.length() == 1) 
			dia = "0" + dia;
		
		String CurrentDate = año + "-" + mes + "-" + dia;
		
		if(Solicitud.getEffdt().equals(CurrentDate)) {
			if(this.solicitud.Existe(Solicitud)) {
				this.solicitud.ActualizarSolicitud(Solicitud, Proveedor, MateriasPrimas);
			}
			else{
				this.solicitud.CrearSolicitud(Solicitud, Proveedor, MateriasPrimas);
			}
		}
		else {
			Solicitud.setFecha_envio(CurrentDate);
			Solicitud.setReferenciaNumPedido(this.solicitud.GetNuevoNumeroSolicitud(CurrentDate));
			this.solicitud.ActualizarSolicitud(Solicitud, Proveedor, MateriasPrimas);
			
			SolicitudDTO soli = this.SolicitudReferenteA(Solicitud);
			this.solicitud.CrearSolicitud(soli, Proveedor, MateriasPrimas);
			this.solicitud.Enviar(soli);
		}
		this.solicitud.Enviar(Solicitud);
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