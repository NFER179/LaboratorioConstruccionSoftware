package modelo;

import java.util.List;

import mail.MailWildPizzeria;

import utilidades.Fecha;
import utilidades.Msj;

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
		return this.solicitud.GetSolicitudesActualesNoRecepcionadas();
	}

	public int ObtenerNumNuevaSolicitud(String Fecha) {
		return this.solicitud.GetNuevoNumeroSolicitud(Fecha);
	}

	public void EnviarSolicitud(SolicitudDTO Solicitud, String Proveedor,
			List<MateriaPrimaSolicitudDTO> MateriasPrimas) {

		if (Solicitud.getEffdt().equals(Fecha.CurrentDate())) {
			if (this.solicitud.Existe(Solicitud)) {
				this.solicitud.ActualizarSolicitud(Solicitud, Proveedor,
						MateriasPrimas);
			} else {
				this.solicitud.CrearSolicitud(Solicitud, Proveedor,
						MateriasPrimas);
			}
		} else {
			Solicitud.setFecha_envio(Fecha.CurrentDate());
			Solicitud.setReferenciaNumPedido(this.solicitud
					.GetNuevoNumeroSolicitud(Fecha.CurrentDate()));
			this.solicitud.ActualizarSolicitud(Solicitud, Proveedor,
					MateriasPrimas);

			SolicitudDTO soli = this.SolicitudReferenteA(Solicitud);
			this.solicitud.CrearSolicitud(soli, Proveedor, MateriasPrimas);
			this.solicitud.Enviar(soli);
		}
		this.solicitud.Enviar(Solicitud);
		this.EnviarMailSolicitud(Solicitud, Proveedor, MateriasPrimas);
	}

	private void EnviarMailSolicitud(SolicitudDTO solicitud, String Proveedor,
			List<MateriaPrimaSolicitudDTO> MateriasPrimas) {
		/* Conseguir el mail del proveedor */
		String[] pReceptor = { "nicofer179@gmail.com" };// JNVR ADD RECEPTORES!

		/* Armar mensaje */
		String enter = "\n";
		String tab = "\t";
		String pMensaje = "Por medio del presente hago pedido de productos."
				+ enter + enter;

		for (MateriaPrimaSolicitudDTO mps : MateriasPrimas) {
			pMensaje = pMensaje + mps.getMateriaPrima() + tab
					+ mps.getCantidad() + enter;
		}

		pMensaje = pMensaje + enter + "Desde ya muchas gracias." + enter
				+ "PizzeriaWild";

		MailWildPizzeria Sender = new MailWildPizzeria(pReceptor,
				"Solicitud Materia Prima", pMensaje);
		// JNVR ADD
		try {
			Sender.mandarMail();
		} catch (Exception e) {
			Msj.advertencia("Atencion", "No se pudo enviar el mail");
		}
	}

	public void GuardarSolicitud(SolicitudDTO Solicitud, String Proveedor,
			List<MateriaPrimaSolicitudDTO> MateriasPrimas) {
		if (this.solicitud.Existe(Solicitud)) {
			this.solicitud.ActualizarSolicitud(Solicitud, Proveedor,
					MateriasPrimas);
		} else {
			this.solicitud.CrearSolicitud(Solicitud, Proveedor, MateriasPrimas);
		}
	}

	private SolicitudDTO SolicitudReferenteA(SolicitudDTO arg0) {
		return new SolicitudDTO(arg0.getFecha_envio(),
				arg0.getReferenciaNumPedido(), arg0.getEstado(),
				arg0.getFecha_envio(), arg0.getReferenciaNumPedido(),
				arg0.getFechaEntrega(), arg0.getCosto());
	}

	public ProveedorDTO ObtenerProveedor(String FechaSolicitud,
			String NumeroSolicitud) {
		return this.solicitud.GetProveedor(FechaSolicitud, NumeroSolicitud);
	}

	public List<MateriaPrimaSolicitudDTO> GetMateriasPrimas(String Fecha,
			String NumPedido) {
		return this.solicitud.GetMaterasPrimasPara(Fecha, NumPedido);
	}

	public void RecepcionarSolicitud(String Fecha, String NumSolicitud,
			int Costo) {
		this.solicitud.Recepcionar(Fecha, NumSolicitud, Costo);
	}

	public List<SolicitudDTO> ObtenerCurSolicidesRecibidas() {
		return this.solicitud.GetEntregadas(Fecha.CurrentDate(),
				Fecha.CurrentDate());
	}

	public int ObtenerCurCantidadSolicitudesEntregadas() {
		return this.solicitud.GetCantidadEntregadas(Fecha.CurrentDate(),
				Fecha.CurrentDate());
	}

	public int ObtenerCurCostoSolicituides() {
		return this.solicitud.GetCostos(Fecha.CurrentDate(),
				Fecha.CurrentDate());
	}

	public List<SolicitudDTO> ObtenerTodasSolicitudes() {
		return this.solicitud.GetAll();
	}
}