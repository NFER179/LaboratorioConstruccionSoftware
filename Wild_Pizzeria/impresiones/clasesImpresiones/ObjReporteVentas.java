package clasesImpresiones;

import java.util.List;

public class ObjReporteVentas extends ObjImprimible {
	private static final int maxPag = 10;
	private static final String tipo = "reporte_ventas_template";
	private String familia;
	private int dia;
	private int semana;
	private List<ObjProductoReporteVentas> productos;

	public ObjReporteVentas(String fecha, String familia, int dia, int semana) {
		super("Reporte ventas " + fecha, fecha, tipo, 0, maxPag);
		this.familia = familia;
		this.dia = dia;
		this.semana = semana;
	}

	public void agregarProducto(int posicion, int cantidad, String nombre) {
		ObjProductoReporteVentas producto = new ObjProductoReporteVentas(
				posicion, cantidad, nombre);
		this.productos.add(producto);
	}

	@Override
	public int getCantidadHojas() {
		return (int) Math.ceil(this.productos.size()
				/ (getMaxPaginacion() * 1.0));
	}

	public String getFamilia() {
		return familia;
	}

	public void setFamilia(String familia) {
		this.familia = familia;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getSemana() {
		return semana;
	}

	public void setSemana(int semana) {
		this.semana = semana;
	}

	public List<ObjProductoReporteVentas> getProductos() {
		return productos;
	}

	public void setProductos(List<ObjProductoReporteVentas> productos) {
		this.productos = productos;
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
