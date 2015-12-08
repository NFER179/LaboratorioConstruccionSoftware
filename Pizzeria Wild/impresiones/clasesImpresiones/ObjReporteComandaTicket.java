package clasesImpresiones;

import java.util.List;

import utilidades.Fecha;

public class ObjReporteComandaTicket extends ObjImprimible {

	private static final int maxPag = 11;
	private static final String templatePath = "template_comanda_ticket";
	private ObjDatosCliente cliente;
	private String observaciones;
	private String observacionDelivery;
	private List<ObjProductoTicketComanda> listaProductos;
	private List<ObjProductoTicketComanda> listaCocina;
	private static String nombreCarpeta = "Comanda y Ticket";

	public ObjReporteComandaTicket(ObjDatosCliente cliente, String fecha,
			int id, String observaciones, String observacionDelivery,
			List<ObjProductoTicketComanda> listaProductos,
			List<ObjProductoTicketComanda> listaCocina) {
		super(" TC " + cliente.getNombre() + "(" + id + ")", fecha,
				templatePath, id, maxPag, nombreCarpeta);
		this.observacionDelivery = observacionDelivery;
		this.observaciones = observaciones;
		this.listaProductos = listaProductos;
		this.listaCocina = listaCocina;
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

	public List<ObjProductoTicketComanda> getListaCocina() {
		return listaCocina;
	}

	public void setListaCocina(List<ObjProductoTicketComanda> listaCocina) {
		this.listaCocina = listaCocina;
	}

}
