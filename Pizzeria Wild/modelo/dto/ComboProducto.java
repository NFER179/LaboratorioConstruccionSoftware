package dto;

public class ComboProducto {
	
	private int id;
	private String effdt;
	private String producto;
	private String sabor;
	private int cantidad;
	
	public ComboProducto(int Id, String Effdt, String Producto, String Sabor, int Cantidad) {
		this.id = Id;
		this.effdt = Effdt;
		this.producto = Producto;
		this.sabor = Sabor;
		this.cantidad = Cantidad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEffdt() {
		return effdt;
	}

	public void setEffdt(String effdt) {
		this.effdt = effdt;
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
