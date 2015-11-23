package modelo;

import java.util.List;

import dao.ComboDAO;
import daoImplementacion.ComboImp;
import dto.ComboDTO;

public class ComboModelo {

	private ComboDAO combo;
	
	public ComboModelo() {
		this.combo = new ComboImp();
	}

	public List<ComboDTO> ObtenerCombosActivos() {
		return this.combo.GetActivos();
	}

	public int ObtenerNuevoIdCombo() {
		int max = this.combo.GetMaxNumCombo();
		return max + 1;
	}
}
