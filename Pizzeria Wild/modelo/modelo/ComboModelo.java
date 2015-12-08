package modelo;

import java.util.List;

import dao.ComboDAO;
import daoImplementacion.ComboImp;
import dto.ComboActivoDTO;
import dto.ComboDTO;
import dto.ComboProductoDTO;
import dto.ComboVentaDTO;
import dto.VentaDTO;

public class ComboModelo {

	private ComboDAO combo;
	private VentaModelo mdlVenta;

	public ComboModelo() {
		this.combo = new ComboImp();

		this.mdlVenta = new VentaModelo();
	}

	public static String ShortDesciption(boolean arg0) {
		if (arg0)
			return "Y";
		else
			return "N";
	}

	public static String LongDesciption(boolean arg0) {
		if (arg0)
			return "Si";
		else
			return "No";
	}

	public static Boolean ToBoolean(String arg0) {
		if (arg0.equals("Y"))
			return true;
		else
			return false;
	}

	public List<ComboDTO> ObtenerCombos() {
		return this.combo.GetCombos();
	}

	public List<ComboDTO> ObtenerCombosActivos() {
		return this.combo.GetCombosActivos();
	}

	public List<ComboActivoDTO> ObtenerCombosActivosFecha() {
		return this.combo.GetCombosActivosFecha();
	}

	public int ObtenerNuevoIdCombo() {
		int max = this.combo.GetMaxNumCombo();
		return max + 1;
	}

	public boolean NoExisteCombo(ComboDTO c) {
		boolean NoExiste = true;
		if (this.combo.GetCountRowFor(c) == 1) {
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

	public int ObtenerPrecioActual(ComboDTO c) {
		return this.combo.GetPrecio(c);
	}

	public String ObtenerFechaActual(ComboDTO c) {
		return this.combo.GetFecha(c);
	}

	public List<ComboVentaDTO> ObtenerCombosEnVenta(VentaDTO venta) {
		return this.combo.GetComboIn(venta);
	}

	public ComboDTO ObtenerCombo(int comboId) {
		return this.combo.GetCombo(comboId);
	}

	public String ObtenerSiguienteFecha(ComboDTO c) {
		return this.combo.GetNewEffdt(c);
	}

	public void AgregarComboVenta(ComboVentaDTO comboVenta) {
		this.combo.InsertIntoComboVenta(comboVenta);
	}

	public void ModificarCombosEnVenta(List<ComboVentaDTO> combosVenta) {
		this.EliminarCombosDeVenta(this.mdlVenta.GetVenta(combosVenta.get(0)
				.getFechaVenta(), combosVenta.get(0).getNumVenta()));
		for (ComboVentaDTO cv : combosVenta) {
			this.AgregarComboVenta(cv);
		}
	}

	public void EliminarCombosDeVenta(VentaDTO venta) {
		this.combo.DeteleCombosFrom(venta);
	}
}
