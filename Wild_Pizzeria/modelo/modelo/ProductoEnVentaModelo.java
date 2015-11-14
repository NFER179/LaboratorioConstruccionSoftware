package modelo;

import dao.ProductoEnVentaDAO;
import daoImplementacion.ProductoEnVentaImp;
import dto.ProductoEnVentaDTO;

public class ProductoEnVentaModelo {

	private ProductoEnVentaDAO productos;
	
	public ProductoEnVentaModelo() {
		this.productos = new ProductoEnVentaImp();
	}
}
