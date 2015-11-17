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

	public void QuitarProducto(String producto) {
		this.producto.DeleteProducto(producto);
	}
	
	public static boolean ParseToBoolean(String arg0) {
		if(arg0.equals("Y")) {
			return true;
		}
		else 
			return false;
	}
}
