package dto;

public class ClienteReporteDTO {

	private int precio;
	private String nombre;
	private int posicion;
	private String fechaUltimaCompra;

	public ClienteReporteDTO(int precio, String nombre, int posicion,
			String fechaUltimaCompra) { 
		this.precio = precio;
		this.nombre = nombre;
		this.posicion = posicion;
		this.fechaUltimaCompra = fechaUltimaCompra;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public String getFechaUltimaCompra() {
		return fechaUltimaCompra;
	}

	public void setFechaUltimaCompra(String fechaUltimaCompra) {
		this.fechaUltimaCompra = fechaUltimaCompra;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
