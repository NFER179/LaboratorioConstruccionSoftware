package dao;

import java.util.List;

import dto.ProductoDTO;

public interface ProductoDAO {
	/* Obtiene los productos de la base. */
	public List<ProductoDTO> getProductos();
	/* Devuelve la descripcion. */
	public String GetDescipcion(String Producto);
}
