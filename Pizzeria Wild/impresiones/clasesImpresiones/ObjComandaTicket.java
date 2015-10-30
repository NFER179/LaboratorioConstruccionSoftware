package clasesImpresiones;

import java.util.List;

import dto.ProductoEnVentaDTO;

public class ObjComandaTicket extends ObjImprimible {

	private static final int maxPag = 20;
	private static final String tipo = "Commanda y Cliente";

	public ObjComandaTicket(String nombreArchivo, String fecha, int id) {
		super(nombreArchivo, fecha, tipo, id, maxPag);
		// TODO Auto-generated constructor stub
	}

	List<ProductoEnVentaDTO> listaProductos;
	String observaciones;
	String fecha;
	String hora;
	String nombre;
 

	public int getCantidadHojas() {
		return 0;
	}

}
