package modelo;

import java.util.List;

import dao.ComboDAO;
import daoImplementacion.ComboImp;
import dto.ComboActivoDTO;
import dto.ComboDTO;
import dto.ComboProductoDTO;

public class ComboModelo {

	private ComboDAO combo;
	
	public ComboModelo() {
		this.combo = new ComboImp();
	}
	
	public static String ShortDesciption(boolean arg0) {
		if(arg0)
			return "Y";
		else
			return "N";
	}
	
	public static String LongDesciption(boolean arg0) {
		if(arg0)
			return "Si";
		else
			return "No";
	}
	
	public static Boolean ToBoolean(String arg0) {
		if(arg0.equals("Y"))
			return true;
		else
			return false;
	}

	public List<ComboDTO> ObtenerCombosActivos() {
		return this.combo.GetCombos();
	}

	public int ObtenerNuevoIdCombo() {
		int max = this.combo.GetMaxNumCombo();
		return max + 1;
	}

	public boolean NoExisteCombo(ComboDTO c) {
		boolean NoExiste = true;
		if(this.combo.GetCountRowFor(c) == 1){
			NoExiste = false;
		}
		return NoExiste;
	}

	public void CrearCombo(ComboDTO c) {
		this.combo.Insert(c);
	}

	public void CrearFechaEffdt(ComboActivoDTO cActivo) {
		this.combo.InsertEffdt(cActivo);
	}

	public void ModificarEffdt(ComboActivoDTO cActivo) {
		this.combo.UpdateEffdt(cActivo);
	}

	public void EliminarProductosDe(ComboActivoDTO cActivo) {
		this.combo.DeleteProductos(cActivo);
	}

	public void AgregarProducto(ComboProductoDTO cp) {
		this.combo.InsertProducto(cp);
	}

	public List<ComboProductoDTO> ObtenerProductosPara(ComboActivoDTO cActivo) {
		return this.combo.GetProductos(cActivo);
	}

	public List<ComboActivoDTO> ObtenerCombosEnAdelante(ComboDTO combo) {
		return this.combo.GetCurrentCombos(combo);
	}

	public void ModificarDescripcion(ComboDTO c) {
		this.combo.UpdateDescripcion(c);
	}

	public void EliminarEffdt(ComboActivoDTO cActivo) {
		this.combo.DeleteEffdt(cActivo);
	}
}
