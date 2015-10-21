package dao;

import java.util.List;

import dto.ProductoEnVentaDTO;

public interface ProductoEnVentaDAO {

	/* Devuelve los productos en determinado pedido. */
	public List<ProductoEnVentaDTO> GetProductosPara(String Fecha, int Venta);

	/* Trae por producto la cantidad de cada sabor que falta por elaborar */
	public List<ProductoEnVentaDTO> GetFaltantesElabracion();
}
