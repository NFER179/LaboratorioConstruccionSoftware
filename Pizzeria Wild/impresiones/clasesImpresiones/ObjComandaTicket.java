package clasesImpresiones;

import java.util.List;

import dto.ProductoEnVentaDTO;

public class ObjComandaTicket extends ObjModel {

	public ObjComandaTicket(String nombreArchivo, String fecha, int id) {
		super(nombreArchivo, fecha, "Commanda y Cliente", id);
		// TODO Auto-generated constructor stub
	}

	List<ProductoEnVentaDTO> listaProductos;
	String observaciones;
	String fecha;
	String hora;
	String nombre;
	@Override
	public String[] getParametros() {
		// TODO Auto-generated method stub
		return null;
	}

}
