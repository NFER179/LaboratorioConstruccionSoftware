package dto;

public class ProductoEnVentaDTO {
	private String producto;
	private String sabor;
	private int cantidad;
	
	public ProductoEnVentaDTO(String Producto, String Sabor, int Cantidad) {
		this.producto = Producto;
		this.sabor = Sabor;
		this.cantidad = Cantidad;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getSabor() {
		return this.sabor;
	}
	
	public void setSabor(String Sabor) {
		this.sabor = Sabor;
	}
	
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}
