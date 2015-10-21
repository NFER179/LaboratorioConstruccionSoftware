package clasesImpresiones;

import java.util.ArrayList;
import java.util.List;

import dto.ProductoEnVentaDTO;

public class ObjItinerario {
	public String nombreArchivo;
	public List<objPuntoItinerario> puntos;

	public ObjItinerario() {
		puntos = new ArrayList<objPuntoItinerario>();
		nombreArchivo = "";
	}

	public ObjItinerario(List<objPuntoItinerario> pPuntos, String pNombreArchivo) {
		this.puntos = pPuntos;
		this.nombreArchivo = pNombreArchivo;
	}

	public void addPunto(String pDireccion, String pObservaciones,
			List<ProductoEnVentaDTO> pProductos) {
		this.puntos.add(new objPuntoItinerario(pDireccion, pObservaciones,
				pProductos));
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
