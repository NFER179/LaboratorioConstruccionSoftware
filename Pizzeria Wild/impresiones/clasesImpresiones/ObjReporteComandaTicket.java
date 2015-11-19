package clasesImpresiones;

import java.util.List; 

public class ObjReporteComandaTicket extends ObjImprimible {

	private static final int maxPag = 11;
	private static final String templatePath = "template_comanda_ticket";
	private ObjDatosCliente cliente;
	private String observaciones;
	private String observacionDelivery;
	private List<ObjProductoTicketComanda> listaProductos;

	public ObjReporteComandaTicket(ObjDatosCliente cliente, String fecha, int id) {
		super(cliente.getNombre() + "_" + id, fecha, templatePath, id, maxPag);
	}

	public ObjReporteComandaTicket(ObjDatosCliente cliente, String fecha, int id,
			String observaciones, String observacionDelivery,
			List<ObjProductoTicketComanda> listaProductos) {
		super(cliente.getNombre() + "_" + id, fecha, templatePath, id, maxPag);
		this.observacionDelivery = observacionDelivery;
		this.observaciones = observaciones;
		this.listaProductos = listaProductos;
		this.cliente = cliente;
	}

	public int getCantidadHojas() {
		return (int) Math.ceil(getListaProductos().size()
				/ (getMaxPaginacion() * 1.0));
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public ObjDatosCliente getCliente() {
		return cliente;
	}

	public void setCliente(ObjDatosCliente cliente) {
		this.cliente = cliente;
	}

	public List<ObjProductoTicketComanda> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<ObjProductoTicketComanda> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public String getObservacionDelivery() {
		return observacionDelivery;
	}

	public void setObservacionDelivery(String observacionDelivery) {
		this.observacionDelivery = observacionDelivery;
	}

}
