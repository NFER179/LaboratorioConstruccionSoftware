package clasesImpresiones;

import java.util.ArrayList;
import java.util.List;

import dto.ProductoEnVentaDTO;

public class ObjItinerario extends ObjModel {

	private List<objPuntoItinerario> puntos;
	private ObjDatosRepartidor repartidor;

	public ObjItinerario(String nombreArchivo, String fecha, int id) {
		super(nombreArchivo, fecha, "Itinerario", id);
		this.puntos = new ArrayList<objPuntoItinerario>();
	}

	public ObjItinerario(String nombreArchivo, String fecha, int id,
			List<objPuntoItinerario> pPuntos) {
		super(nombreArchivo, fecha, "Itinerario", id);
		this.puntos = pPuntos;
	}

	@Override
	public String[] getParametros() {
		return new String[] { getFecha(), getId() + "", getRepartidor().nombre,
				getRepartidor().getDatosVehiculo(),
				getRepartidor().getNumTelefono() };
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

	public class ObjDatosRepartidor {
		private String nombre;
		private String datosVehiculo;
		private String numTelefono;

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getDatosVehiculo() {
			return datosVehiculo;
		}

		public void setDatosVehiculo(String datosVehiculo) {
			this.datosVehiculo = datosVehiculo;
		}

		public String getNumTelefono() {
			return numTelefono;
		}

		public void setNumTelefono(String numTelefono) {
			this.numTelefono = numTelefono;
		}
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
