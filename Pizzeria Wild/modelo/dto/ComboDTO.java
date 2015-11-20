package dto;

public class ComboDTO {

	private int comboId;
	private String descripcion;
	private String inicio;
	private String fin;
	private int precio;

	public ComboDTO(int ComboId, String Descripcion, String FechaInicio, String FechaFin, int Precio) {
		this.comboId = ComboId;
		this.descripcion = Descripcion;
		this.inicio = FechaInicio;
		this.fin = FechaFin;
		this.precio = Precio;
	}

	public int getComboId() {
		return comboId;
	}

	public void setComboId(int comboId) {
		this.comboId = comboId;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getInicio() {
		return inicio;
	}

	public void setInicio(String inicio) {
		this.inicio = inicio;
	}

	public String getFin() {
		return fin;
	}

	public void setFin(String fin) {
		this.fin = fin;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
}
