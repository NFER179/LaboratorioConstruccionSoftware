package dto;

import java.util.ArrayList;
import java.util.List;

public class PedidoDTO {
	
	private int numPedido;
	private String cliente;
	private String direccion;
	private int precio;
	private String fecha_hora;
	private String estado;
	private String observacion;
	private boolean delivery;
	private List<ProductoEnPedidoDTO> productos;

	public PedidoDTO(int NumPedido, String Cliente, String Direccion,int Precio, String Fecha_hora, String Estado, String Observacion, boolean Delivery) {
		this.numPedido = NumPedido;
		this.cliente = Cliente;
		this.direccion = Direccion;
		this.precio = Precio;
		this.fecha_hora = Fecha_hora;
		this.estado = Estado;
		this.observacion = Observacion;
		this.delivery = Delivery;
		this.productos = new ArrayList<ProductoEnPedidoDTO>();
	}
	
	public void agregarProducto(String Producto, String Sabor, int Cantidad) {
		boolean noEstaenPedido = true;
		
		for (ProductoEnPedidoDTO pp:this.productos){
			if (pp.getProducto().equals(Producto)){	
			pp.setCantidad(Cantidad);
			noEstaenPedido = false;
			}
		}
		
		if (noEstaenPedido) {
			this.productos.add(new ProductoEnPedidoDTO(Producto, Sabor, Cantidad));
		}
		
		this.calcularPrecio();
		
	}
	
	public void quitarProducto(SaborDTO Producto) {
		ProductoEnPedidoDTO app = null;
		
		for(ProductoEnPedidoDTO pp:this.productos){
			if (pp.getProducto().equals(Producto))
				app = pp;
		}
		
		this.productos.remove(app);
		
		this.calcularPrecio();
	}
	
	private void calcularPrecio() {
//		this.precio = 0;
//		/* Falta Primero calcular el precio de combos y en base a eso restar los que estan en un combo. */
//		for (ProductoEnPedidoDTO pp:this.productos){
//			precio = precio + (pp.getCantidad() * pp.getProducto().getPrecio());			
//		}
	}

	public int getNumPedido() {
		return numPedido;
	}

	public void setNumPedido(int numPedido) {
		this.numPedido = numPedido;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String Direccion) {
		this.direccion = Direccion;
	}	
	
	public String getFecha_hora() {
		return this.fecha_hora;
	}

	public void setFecha_hora(String fecha_hora) {
		this.fecha_hora = fecha_hora;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public boolean isDelivery() {
		return delivery;
	}

	public void setDelivery(boolean delivery) {
		this.delivery = delivery;
	}
	
	public String getStringDelivery() {
		if (this.delivery)
			return "Y";
		else
			return "N";
	}

	public int getPrecio() {
		return precio;
	}

	public List<ProductoEnPedidoDTO> getProductos() {
		return productos;
	}
}
