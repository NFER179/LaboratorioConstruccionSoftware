package dao;

import java.util.List;

import dto.ProductoDTO;
import dto.SaborDTO;

public interface SaborDAO {
	/* Devuelve los sabores para un determinado producto. */
	public List<SaborDTO> GetSabores(String Producto);
	/* Devuelve el precio. */
	public int GetPrecio(String Producto, String Sabor);
	/* Eliminar sabores para producto determinado */
	public void DeleteFor(ProductoDTO producto);
	/* inserta sabores para producto. */
	public void Insert(ProductoDTO producto, SaborDTO sabor);
}
