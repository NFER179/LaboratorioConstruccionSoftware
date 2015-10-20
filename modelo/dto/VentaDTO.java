package dto;

import java.util.ArrayList;
import java.util.List;

public class VentaDTO {
	
	private String fecha;
	private int numVenta;
	private String cliente;
	private String direccion;
	private String tel;
	private int precio;
	private String hora;
	private String estado;
	private String observacion;
	private boolean delivery;
	private String observacionesDelivery;
	private List<ProductoEnVentaDTO> productos;

	public VentaDTO(String Fecha, int NumVenta, String Cliente, String Direccion, String Tel, int Precio, String Hora, String Estado, String Observacion, boolean Delivery, String ObservacionDelivery) {
		this.fecha = Fecha;
		this.numVenta = NumVenta;
		this.cliente = Cliente;
		this.direccion = Direccion;
		this.tel = Tel;
		this.precio = Precio;
		this.hora = Hora;
		this.estado = Estado;
		this.observacion = Observacion;
		this.delivery = Delivery;
		this.observacionesDelivery = ObservacionDelivery;
		this.productos = new ArrayList<ProductoEnVentaDTO>();
	}
	
	public void agregarProducto(String Producto, String Sabor, int Cantidad) {
		boolean noEstaenPedido = true;
		
		for (ProductoEnVentaDTO pp:this.productos){
			if (pp.getProducto().equals(Producto)){	
			pp.setCantidad(Cantidad);
			noEstaenPedido = false;
			}
		}
		
		if (noEstaenPedido) {
			this.productos.add(new ProductoEnVentaDTO(Producto, Sabor, Cantidad));
		}
	}
	
	public void quitarProducto(SaborDTO Producto) {
		ProductoEnVentaDTO app = null;
		
		for(ProductoEnVentaDTO pp:this.productos){
			if (pp.getProducto().equals(Producto))
				app = pp;
		}
		this.productos.remove(app);
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String Fecha) {
		this.fecha = Fecha;
	}
	
	public int getNumVenta() {
		return numVenta;
	}

	public void setNumVenta(int numVenta) {
		this.numVenta = numVenta;
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
	
	public String getTel() {
		return tel;
	}

	public void setTel(String Tel) {
		this.tel = Tel;
	}
	
	public String getHora() {
		return this.hora;
	}

	public void setHora(String Hora) {
		this.hora = Hora;
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

	public String getObservacionDelivery() {
		return observacionesDelivery;
	}

	public void setObservacionDelivery(String ObservacionDelivery) {
		this.observacionesDelivery = ObservacionDelivery;
	}
	
	public int getPrecio() {
		return precio;
	}

	public List<ProductoEnVentaDTO> getProductos() {
		return productos;
	}
}
