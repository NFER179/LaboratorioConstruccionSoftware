package clasesImpresiones;

public class ObjProductoTicketComanda {

	private int cantidad;
	private double precio;
	private String material;
	private String und;
	private String codigo;

	public ObjProductoTicketComanda(int cantidad, double precio,
			String materia, String und, String codigo) {
		this.cantidad = cantidad;
		this.precio = precio;
		this.material = materia;
		this.und = und;
		this.setCodigo(codigo);
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
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	};
}
