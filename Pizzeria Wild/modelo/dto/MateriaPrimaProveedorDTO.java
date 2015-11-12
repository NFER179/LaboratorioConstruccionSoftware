package dto;

public class MateriaPrimaProveedorDTO {

	private String proveedorId;
	private String categoria;
	private String materiaPrima;
	
	public MateriaPrimaProveedorDTO(String Proveedor, String Categoria, String MateriaPrima) {
		this.proveedorId = Proveedor;
		this.categoria = Categoria;
		this.materiaPrima = MateriaPrima;
	}

	public String getProveedorId() {
		return proveedorId;
	}

	public void setProveedorId(String proveedorId) {
		this.proveedorId = proveedorId;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getMateriaPrima() {
		return materiaPrima;
	}

	public void setMateriaPrima(String materiaPrima) {
		this.materiaPrima = materiaPrima;
	}
	
}
