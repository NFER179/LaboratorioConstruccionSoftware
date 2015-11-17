package dao;

import java.util.List;

import dto.ProductoDTO;

public interface ProductoDAO {
	/* Obtiene los productos de la base. */
	public List<ProductoDTO> getProductos();
	/* Devuelve la descripcion. */
	public String GetDescipcion(String Producto);
	/* Elimina el producto de la base de datos. */
	public void DeleteProducto(String producto);
	/* Ingresa Producto en la base de datos. */
	public void Insert(ProductoDTO producto);
	/* Modifica productor. */
	public void Modify(ProductoDTO producto);
	/* Obtiene el producto desde la base. */
	public ProductoDTO GetProducto(String producto);
}
