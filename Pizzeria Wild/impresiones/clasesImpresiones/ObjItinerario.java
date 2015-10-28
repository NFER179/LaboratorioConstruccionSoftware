package clasesImpresiones;

import java.util.ArrayList;
import java.util.List;

import dto.ProductoEnVentaDTO;

public class ObjItinerario extends ObjImprimible {

	private List<objPuntoItinerario> puntos;
	private ObjDatosRepartidor repartidor;
	private static final int maxPag = 20;
	private static final String tipo = "Itinerario";
	
	public ObjItinerario(String nombreArchivo, String fecha, int id) {
		super(nombreArchivo, fecha, tipo, id, maxPag);
		this.puntos = new ArrayList<objPuntoItinerario>();
	}

	public ObjItinerario(String nombreArchivo, String fecha, int id,
			List<objPuntoItinerario> pPuntos,
			ObjDatosRepartidor pDatosRepartidor) {
		super(nombreArchivo, fecha, "Itinerario", id, maxPag);
		this.puntos = pPuntos;
		this.repartidor = pDatosRepartidor;
	}

	@Override
	public String[] getParametros(int numPagina) {
		return new String[] { getFecha(), getId() + "",
				getRepartidor().toString() };
	}

	public void addPunto(String pDireccion, String pObservaciones,
			List<ProductoEnVentaDTO> pProductos) {
		this.puntos.add(new objPuntoItinerario(pDireccion, pObservaciones,
				pProductos));
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

	public class objPuntoItinerario {
		String direccion;
		String observaciones;
		List<ProductoEnVentaDTO> productos;

		public objPuntoItinerario(String pDireccion, String pObservaciones,
				List<ProductoEnVentaDTO> pProductos) {
			this.direccion = pDireccion;
			this.observaciones = pObservaciones;
			this.productos = pProductos;
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

		public List<ProductoEnVentaDTO> getProductos() {
			return productos;
		}

		public void setProductos(List<ProductoEnVentaDTO> productos) {
			this.productos = productos;
		}
	}

}
