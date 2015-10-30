package clasesImpresiones;

import java.util.List;

import modelo.ProductoEnVentaModelo;
import modelo.VentaModelo;

import dto.ProductoEnVentaDTO;
import dto.VentaDTO;

public class ObjComanda {

	List<ProductoEnVentaDTO> listaProductos;
	String observaciones;
	String fecha;
	String hora;
	String nombreCliente;

	private void CargarValores(String fecha, int numPedido) {
		ProductoEnVentaModelo mdlPV = new ProductoEnVentaModelo();
		VentaModelo venta = new VentaModelo();
		
		this.listaProductos = venta.GetProductosEnVenta(fecha, numPedido);
		VentaDTO v = venta.GetVenta(fecha, numPedido);
		this.observaciones = v.getObservacion();
		this.fecha = fecha;
		this.hora = v.getHora();
		this.nombreCliente = v.getCliente();
	}
}
