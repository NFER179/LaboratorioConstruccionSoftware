package dto;

public class ComboVentaDTO {

	int numVenta;
	String fechaVenta;
	int numCombo;
	String fechaCombo;
	int cantidad;
	public ComboVentaDTO(int numVenta, String fechaVenta, int numCombo,
			String fechaCombo, int cantidad) {
		super();
		this.numVenta = numVenta;
		this.fechaVenta = fechaVenta;
		this.numCombo = numCombo;
		this.fechaCombo = fechaCombo;
		this.cantidad = cantidad;
	}
	public int getNumVenta() {
		return numVenta;
	}
	public void setNumVenta(int numVenta) {
		this.numVenta = numVenta;
	}
	public String getFechaVenta() {
		return fechaVenta;
	}
	public void setFechaVenta(String fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	public int getNumCombo() {
		return numCombo;
	}
	public void setNumCombo(int numCombo) {
		this.numCombo = numCombo;
	}
	public String getFechaCombo() {
		return fechaCombo;
	}
	public void setFechaCombo(String fechaCombo) {
		this.fechaCombo = fechaCombo;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}	
}
