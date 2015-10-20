package clasesImpresiones;

import dto.ProductoDTO;

public class ObjProducto extends ProductoDTO {

	private int cantidad;
	private String sabor;

	/* DEFAULT */
	public ObjProducto(String ProductoId, String Descripcion) {
		super(ProductoId, Descripcion);
	}

	public ObjProducto(String ProductoId, String Descripcion, String Sabor,
			int Cantidad) {
		super(ProductoId, Descripcion);
		this.cantidad = Cantidad;
		this.sabor = Sabor;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

}
