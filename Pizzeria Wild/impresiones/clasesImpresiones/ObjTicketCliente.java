package clasesImpresiones;

import java.util.ArrayList;
import java.util.List;

public class ObjTicketCliente {

	public String nombreDocumento;
	List<ObjProductoTicket> productos;
	public double totalFinal;
	String fecha;

	public ObjTicketCliente() {
		productos = new ArrayList<ObjProductoTicket>();
	}

	public ObjTicketCliente(String pNombreDocumento, double pTotalFinal,
			String pFecha, List<ObjProductoTicket> pProductos) {
		this.nombreDocumento = pNombreDocumento;
		this.totalFinal = pTotalFinal;
		this.fecha = pFecha;
		this.productos = pProductos;
	}

	public void addProducto(String pProducto, int pCantidad, double pPrecio,
			double pTotal) {
		ObjProductoTicket nuevo = new ObjProductoTicket(pProducto, pCantidad,
				pPrecio, pTotal);
		productos.add(nuevo);
	}

	public class ObjProductoTicket {
		public String producto;
		public int cantidad;
		public double precio;
		public double total;

		public ObjProductoTicket(String pProducto, int pCantidad,
				double pPrecio, double pTotal) {
			this.precio = pPrecio;
			this.producto = pProducto;
			this.total = pTotal;
			this.cantidad = pCantidad;
		}
	}
}
