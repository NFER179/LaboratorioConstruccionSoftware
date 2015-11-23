package dto;

public class ComboActivoDTO {

	private int comboId;
	private String efft;
	private int precio;
	private boolean activo;

	public ComboActivoDTO(int ComboId, String Effdt, int Precio, boolean Activo) {
		this.comboId = ComboId;
		this.efft = Effdt;
		this.precio = Precio;
		this.activo = Activo;
	}

	public int getComboId() {
		return comboId;
	}

	public void setComboId(int comboId) {
		this.comboId = comboId;
	}

	public String getEfft() {
		return efft;
	}

	public void setEfft(String efft) {
		this.efft = efft;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
}