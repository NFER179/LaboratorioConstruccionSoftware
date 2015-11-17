package dto;

public class ComboDTO {

	private int comboId;
	private String fecha;
	private String descripcion;
	private int precio;
	private boolean estado;
	
	public void ComboDTO(int ComboId, String Fecha, String Descripcion, int Precio, boolean Estado) {
		this.comboId = ComboId;
		this.fecha = Fecha;
		this.descripcion = Descripcion;
		this.precio = Precio;
		this.estado = Estado;
	}

	public int getComboId() {
		return comboId;
	}

	public void setComboId(int comboId) {
		this.comboId = comboId;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getLongActivo() {
		if(this.estado){
			return "Si";
		}
		else
			return "No";
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
}
