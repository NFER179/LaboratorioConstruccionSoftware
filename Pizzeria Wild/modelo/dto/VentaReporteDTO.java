package dto;

public class VentaReporteDTO {
	private int puesto;
	private String producto;
	private int cantidad;

	public VentaReporteDTO(int puesto, String producto, int cantidad) {
		super();
		this.puesto = puesto;
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public int getPuesto() {
		return puesto;
	}

	public void setPuesto(int puesto) {
		this.puesto = puesto;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}
