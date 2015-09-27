package dao;

import java.util.List;
import dto.SaborDTO;

public interface SaborDAO {
	/* Devuelve los sabores para un determinado producto. */
	public List<SaborDTO> GetSabores(String Producto);
	/* Devuelve el precio. */
	public int GetPrecio(String Producto, String Sabor);
}
