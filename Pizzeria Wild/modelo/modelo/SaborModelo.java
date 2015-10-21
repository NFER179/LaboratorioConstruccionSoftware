package modelo;

import java.util.List;

import dao.SaborDAO;
import daoImplementacion.SaborImp;
import dto.SaborDTO;

public class SaborModelo {
	
	private SaborDAO sabor;
	
	public SaborModelo() {
		this.sabor = new SaborImp();
	}
	
	public List<SaborDTO> GetSabores(String Producto) {
		return this.sabor.GetSabores(Producto);
	}
	
	public int GetPrecio(String Producto, String Sabor) {
		return this.sabor.GetPrecio(Producto, Sabor);
	}
}
