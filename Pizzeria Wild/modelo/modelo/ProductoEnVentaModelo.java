package modelo;

import dao.ProductoEnVentaDAO;
import daoImplementacion.ProductoEnVentaImp;

public class ProductoEnVentaModelo {

	@SuppressWarnings("unused")
	private ProductoEnVentaDAO productos;

	public ProductoEnVentaModelo() {
		this.productos = new ProductoEnVentaImp();
	}
}
