package dto;

public class SaborDTO {
	
	private String nombre;
	private int precio;
	
	public SaborDTO(String Nombre, int Precio) {
		this.nombre = Nombre;
		this.precio = Precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
}
