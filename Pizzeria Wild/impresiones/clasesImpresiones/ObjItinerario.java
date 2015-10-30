package clasesImpresiones;

import java.util.ArrayList;
import java.util.List;

public class ObjItinerario extends ObjImprimible {

	private List<objPuntoItinerario> puntos;
	private ObjDatosRepartidor repartidor;
	private static final int maxPag = 9;
	private static final String tipo = "template_itinerario";
	private String observacionGral;

	public ObjItinerario(String fecha, int id,
			ObjDatosRepartidor pDatosRepartidor, String observacionPedido) {
		super(pDatosRepartidor.getNombre() + "_" + id, fecha, tipo, id, maxPag);
		this.puntos = new ArrayList<objPuntoItinerario>();
		this.repartidor = pDatosRepartidor;
	}

	public ObjItinerario(String fecha, int id,
			List<objPuntoItinerario> pPuntos,
			ObjDatosRepartidor pDatosRepartidor, String observacionPedido) {
		super(pDatosRepartidor.getNombre() + "_" + id, fecha, tipo, id, maxPag);
		this.puntos = pPuntos;
		this.repartidor = pDatosRepartidor;
	}

	public int getCantidadHojas() {
		return (int) Math.ceil(getPuntos().size() / (getMaxPaginacion() * 1.0));
	}

	public void addPunto(String pDireccion, String pObservaciones,
			int numPedido, double costo) {
		this.puntos.add(new objPuntoItinerario(pDireccion, pObservaciones,
				numPedido, costo));
	}

	public List<objPuntoItinerario> getPuntos() {
		return puntos;
	}

	public void setPuntos(List<objPuntoItinerario> puntos) {
		this.puntos = puntos;
	}

	public ObjDatosRepartidor getRepartidor() {
		return repartidor;
	}

	public void setRepartidor(ObjDatosRepartidor repartidor) {
		this.repartidor = repartidor;
	}

	public String getObservacionGral() {
		return observacionGral;
	}

	public void setObservacionGral(String observacionGral) {
		this.observacionGral = observacionGral;
	}

	public class objPuntoItinerario {
		private String direccion;
		private String observaciones;
		private double costo;
		private int numPedido;

		public objPuntoItinerario(String pDireccion, String pObservaciones,
				int numPedido, double costo) {
			this.direccion = pDireccion;
			this.observaciones = pObservaciones;
			this.numPedido = numPedido;
			this.costo = costo;
		}

		public String getDireccion() {
			return direccion;
		}

		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}

		public String getObservaciones() {
			return observaciones;
		}

		public void setObservaciones(String observaciones) {
			this.observaciones = observaciones;
		}

		public double getCosto() {
			return costo;
		}

		public void setCosto(double costo) {
			this.costo = costo;
		}

		public int getNumPedido() {
			return numPedido;
		}

		public void setNumPedido(int numPedido) {
			this.numPedido = numPedido;
		}
	}

}
