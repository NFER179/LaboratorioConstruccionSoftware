package dto;

public class ProductoComboDTO {
	private String id;
	private String producto;
	private String sabor;
	private int cantidad;

	public ProductoComboDTO(String Id, String Producto, String Sabor, int Cantidad) {
		this.id = Id;
		this.producto = Producto;
		this.sabor = Sabor;
		this.cantidad = Cantidad;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
