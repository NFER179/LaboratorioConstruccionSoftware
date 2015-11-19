package clasesImpresiones;

import java.util.List;

import utilidades.Fecha;

import dto.VentaReporteDTO;

public class ObjReporteVentas extends ObjImprimible {
	private static final int maxPag = 10;
	private static final String templatePath = "reporte_ventas_template";
	private String fechaDesde;
	private String fechaHasta;
	private List<VentaReporteDTO> productos;

	public ObjReporteVentas(String fechaDesde, String fechaHasta, int dia,
			int semana, List<VentaReporteDTO> lista) {
		super("Reporte ventas " + fechaDesde, Fecha.CurrentDate(),
				templatePath, 0, maxPag); 
		this.fechaHasta = fechaHasta;
		this.fechaDesde = fechaDesde;
		this.productos = lista;
	}

	@Override
	public int getCantidadHojas() {
		return (int) Math.ceil(this.productos.size()
				/ (getMaxPaginacion() * 1.0));
	}

	public List<VentaReporteDTO> getProductos() {
		return productos;
	}

	public void setProductos(List<VentaReporteDTO> productos) {
		this.productos = productos;
	}

	public String getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(String fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	public String getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(String fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public class ObjProductoReporteVentas {
		private int posicion;
		private int cantidad;
		private String nombre;

		public int getPosicion() {
			return posicion;
		}

		public ObjProductoReporteVentas(int posicion, int cantidad,
				String nombre) {
			this.posicion = posicion;
			this.cantidad = cantidad;
			this.nombre = nombre;
		}

		public void setPosicion(int posicion) {
			this.posicion = posicion;
		}

		public int getCantidad() {
			return cantidad;
		}

		public void setCantidad(int cantidad) {
			this.cantidad = cantidad;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
	}
}
