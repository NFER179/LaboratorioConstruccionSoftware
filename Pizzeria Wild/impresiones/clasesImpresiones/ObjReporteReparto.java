package clasesImpresiones;

import java.util.List;

import dto.RepartidoReporteDTO;

public class ObjReporteReparto extends ObjImprimible {
	private static final int maxPag = 10;
	private static final String templatePath = "reporte_reparto_template";
	private List<RepartidoReporteDTO> repartos;
	private String nombreRepartidor;

	public ObjReporteReparto(String fecha, String nombreRepartidor,
			List<RepartidoReporteDTO> repartos) {
		super(nombreRepartidor + fecha, fecha, templatePath, 1, maxPag);
		this.setNombreRepartidor(nombreRepartidor);
		this.repartos = repartos;
	}

	@Override
	public int getCantidadHojas() {
		return (int) Math.ceil(this.repartos.size()
				/ (getMaxPaginacion() * 1.0));
	}

	public String getNombreRepartidor() {
		return nombreRepartidor;
	}

	public List<RepartidoReporteDTO> getRepartos() {
		return repartos;
	}

	public void setRepartos(List<RepartidoReporteDTO> repartos) {
		this.repartos = repartos;
	}

	public void setNombreRepartidor(String nombreRepartidor) {
		this.nombreRepartidor = nombreRepartidor;
	}

	public class ObjReparto {
		private int numReparto;
		private List<ObjPedido> pedidos;

		public ObjReparto(int numReparto, List<ObjPedido> pedidos) {
			this.numReparto = numReparto;
			this.pedidos = pedidos;
		}

		public void agregarPedido(int numPedido, String cliente,
				boolean entregado, double costo) {
			ObjPedido pedido = new ObjPedido(numPedido, cliente, entregado,
					costo);
			this.pedidos.add(pedido);
		}

		public int getNumReparto() {
			return numReparto;
		}

		public void setNumReparto(int numReparto) {
			this.numReparto = numReparto;
		}

		public List<ObjPedido> getPedidos() {
			return pedidos;
		}

		public void setPedidos(List<ObjPedido> pedidos) {
			this.pedidos = pedidos;
		}
	}

}
