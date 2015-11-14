package dto;

public class MateriaPrimaSolicitudDTO {

	private String materiaPrima;
	private int cantidad;
	
	public MateriaPrimaSolicitudDTO(String MateriaPrima, int Cantidad) {
		this.materiaPrima = MateriaPrima;
		this.cantidad = Cantidad;
	}
	
	public String getMateriaPrima() {
		return materiaPrima;
	}

	public void setMateriaPrima(String materiaPrima) {
		this.materiaPrima = materiaPrima;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
