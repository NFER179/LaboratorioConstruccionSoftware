package clasesImpresiones;

import java.util.List;

public class ObjReporteMejoresClientes extends ObjImprimible {

	private static final int maxPag = 10;
	private static final String tipo = "reporte_clientes_template";
	private List<ObjDatosCliente> clientes;
	private String fechaHasta;
	private String fechaDesde;

	public ObjReporteMejoresClientes(String fechaDesde, String fechaHasta) {
		super("Mejores Clientes " + fechaDesde, "", tipo, 0, maxPag);
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
	}

	public void agregarCliente(int posicion, String nombre, double acumulado,
			String ultimaCompra) {
		ObjDatosCliente cliente = new ObjDatosCliente(posicion, nombre,
				acumulado, ultimaCompra);
		this.clientes.add(cliente);
	}

	@Override
	public int getCantidadHojas() {
		return 1;
	}

	public List<ObjDatosCliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<ObjDatosCliente> clientes) {
		this.clientes = clientes;
	}

	public String getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(String fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public String getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(String fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	public class ObjDatosCliente {
		private int posicion;
		private String nombre;
		private double acumulado;
		private String ultimaCompra;

		public ObjDatosCliente(int posicion, String nombre, double acumulado,
				String ultimaCompra) {
			super();
			this.posicion = posicion;
			this.nombre = nombre;
			this.acumulado = acumulado;
			this.ultimaCompra = ultimaCompra;
		}

		public int getPosicion() {
			return posicion;
		}

		public void setPosicion(int posicion) {
			this.posicion = posicion;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public double getAcumulado() {
			return acumulado;
		}

		public void setAcumulado(double acumulado) {
			this.acumulado = acumulado;
		}

		public String getUltimaCompra() {
			return ultimaCompra;
		}

		public void setUltimaCompra(String ultimaCompra) {
			this.ultimaCompra = ultimaCompra;
		}
	}
}
