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
	
	public List<ProductoDTO> GetProductos(){
		return this.producto.getProductos();
	}
	
	public String GetDescr(String Producto) {
		return this.producto.GetDescipcion(Producto);
	}
}
