package dao;

import java.util.List;

import dto.ComboDTO;

public interface ComboDAO {

	/* Obtine combo Activos */
	public List<ComboDTO> GetActivos();

	/* Obtiene el maximo numero de combo */
	public int GetMaxNumCombo();

}
