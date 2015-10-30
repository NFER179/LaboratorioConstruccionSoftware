package clasesImpresiones;

import java.util.List;

import clasesImpresiones.ObjItinerario.objPuntoItinerario;

import dto.ProductoEnVentaDTO;

public class ObjComandaTicket extends ObjImprimible {

	private static final int maxPag = 10;
	private static final String tipo = "template_comanda_ticket";
	private ObjDatosCliente cliente;
	private String observaciones;
	private List<ObjProductoTicketComanda> listaProductos;

	public ObjComandaTicket(ObjDatosCliente cliente, String fecha, int id) {
		super(cliente.getNombre() + "_" + id, fecha, tipo, id, maxPag);

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

}
