package dao;

import java.util.List;

import dto.ComboActivoDTO;
import dto.ComboDTO;
import dto.ComboProductoDTO;
import dto.ComboVentaDTO;
import dto.VentaDTO;

public interface ComboDAO {

	/* Obtine combo Activos */
	public List<ComboDTO> GetCombos();

	/* Obtiene el maximo numero de combo */
	public int GetMaxNumCombo();

	/* Obtiene la cantidad de Filas que tiene el combo. */
	public int GetCountRowFor(ComboDTO c);

	/*Ingresa nuevo combo a la base*/
	public void Insert(ComboDTO c);

	/* Ingresa nuevas Effdt para un determinado combo. */
	public void InsertEffdt(ComboActivoDTO cActivo);

	/* Updatea la fecha */
	public void UpdateEffdt(ComboActivoDTO cActivo);

	/* Elimina todos los productos para un combo */
	public void DeleteProductos(ComboActivoDTO cActivo);

	/* ingresa los productos que conforman al combo */
	public void InsertProducto(ComboProductoDTO cp);

	/*Obtiene producto de determinado combo en determinada fecha.*/
	public List<ComboProductoDTO> GetProductos(ComboActivoDTO cActivo);

	/*  */
	public List<ComboActivoDTO> GetCurrentCombos(ComboDTO combo);

	public void UpdateDescripcion(ComboDTO c);

	public void DeleteEffdt(ComboActivoDTO cActivo);

	public int GetPrecio(ComboDTO c);

	public List<ComboVentaDTO> GetComboIn(VentaDTO venta);

	public ComboDTO GetCombo(int comboId);

//	public int GetCantidadEnVenta(VentaDTO venta, ComboVentaDTO ca);

	public String GetNewEffdt(ComboDTO c);

	public List<ComboDTO> GetCombosActivos();

	public void InsertIntoComboVenta(ComboVentaDTO comboVenta);

	public void DeteleCombosFrom(VentaDTO venta);
}
