package dto;

import java.util.ArrayList;
import java.util.List;

public class ProductoDTO {
	
	private String productoId;
	private String descipcion;
	private boolean mixta;
	private boolean elaboraCocina;
	
	//private List<SaborDTO> sabores;
	
	public ProductoDTO(String ProductoId, String Descripcion, boolean Mixta, boolean ElaboraCocina) {
		this.productoId = ProductoId;
		this.descipcion = Descripcion;
		this.mixta = Mixta;
		this.elaboraCocina = ElaboraCocina;
		//this.sabores = new ArrayList<SaborDTO>();
	}
	
//	public void AgregarSabor(SaborDTO Sabor) {
//		//this.sabores.add(Sabor);
//	}

	public String getProductoId() {
		return productoId;
	}

	public void setProductoId(String productoId) {
		this.productoId = productoId;
	}

	public String getDescipcion() {
		return descipcion;
	}

	public void setDescipcion(String descipcion) {
		this.descipcion = descipcion;
	}

	public boolean isMixta() {
		return mixta;
	}

	public void setMixta(boolean mixta) {
		this.mixta = mixta;
	}

	public boolean isElaboraCocina() {
		return elaboraCocina;
	}

	public void setElaboraCocina(boolean elaboraCocina) {
		this.elaboraCocina = elaboraCocina;
	}
//	public List<SaborDTO> getSabores() {
//		return sabores;
//	}
//
//	public void setSabores(List<SaborDTO> sabores) {
//		this.sabores = sabores;
//	}
	
}