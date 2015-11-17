package modelo;

import java.util.List;

import dao.ProductoDAO;
import daoImplementacion.ProductoImp;
import dto.ProductoDTO;

public class ProductoModelo {

	private ProductoDAO producto; 
	
	public ProductoModelo() {
		this.producto = new ProductoImp();
	}
	
	public List<ProductoDTO> ObtenerProductos(){
		return this.producto.getProductos();
	}
	
	public String ObtenerDescr(String Producto) {
		return this.producto.GetDescipcion(Producto);
	}
}
