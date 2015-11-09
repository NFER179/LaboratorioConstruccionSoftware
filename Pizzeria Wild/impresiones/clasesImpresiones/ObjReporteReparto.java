package clasesImpresiones;

import java.util.List;

public class ObjReporteReparto extends ObjImprimible {
	private static final int maxPag = 10;
	private static final String tipo = "reporte_reparto_template";
	private List<ObjReparto> repartos;
	private String nombreRepartidor;

	public ObjReporteReparto(String fecha, int id, String nombreRepartidor) {
		super(nombreRepartidor + fecha, fecha, tipo, id, maxPag);
		this.setNombreRepartidor(nombreRepartidor);
	}

	public void agregarReparto(int numReparto, List<ObjPedido> pedidos) {
		ObjReparto reparto = new ObjReparto(numReparto, pedidos);
		this.repartos.add(reparto);
	}

	@Override
	public int getCantidadHojas() {
		return (int) Math.ceil(this.repartos.size()
				/ (getMaxPaginacion() * 1.0));
	}

	public String getNombreRepartidor() {
		return nombreRepartidor;
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
