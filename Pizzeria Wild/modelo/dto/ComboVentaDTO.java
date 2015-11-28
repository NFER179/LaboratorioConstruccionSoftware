package dto;

public class ComboVentaDTO {

	String fechaVenta;
	int numVenta;
	int numCombo;
	int cantidad;
	
	public ComboVentaDTO(String fechaVenta, int numVenta, int numCombo,	int cantidad) {
		this.fechaVenta = fechaVenta;
		this.numVenta = numVenta;
		this.numCombo = numCombo;
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
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}	
}
