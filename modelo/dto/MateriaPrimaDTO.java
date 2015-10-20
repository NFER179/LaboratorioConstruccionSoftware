package dto;

public class MateriaPrimaDTO {

	private String nombre;
	private String unidad;
	
	public MateriaPrimaDTO (String Nombre, String Unidad) {
		this.nombre = Nombre;
		this.unidad = Unidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}
}