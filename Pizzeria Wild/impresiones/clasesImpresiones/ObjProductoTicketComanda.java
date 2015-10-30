package clasesImpresiones;

public class ObjProductoTicketComanda {

	private int cantidad;
	private double precio;
	private String material;
	private String und;

	public ObjProductoTicketComanda(int cantidad, double precio,
			String materia, String und) {
		this.cantidad = cantidad;
		this.precio = precio;
		this.material = materia;
		this.und = und;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getUnd() {
		return und;
	}

	public void setUnd(String und) {
		this.und = und;
	};
}
