package dto;

public class ComboDTO {
	
	private int id;
	private String descripcion;
	
	public ComboDTO(int Id, String Descripcion) {
		this.id = Id;
		this.descripcion = Descripcion;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
