package dto;

public class CategoriaDTO {

	private String idCategoria;
	private String descripcion;
	
	public CategoriaDTO(String IdCategoria, String Descripcion) {
		this.idCategoria = IdCategoria;
		this.descripcion = Descripcion;
	}

	public String getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(String idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
