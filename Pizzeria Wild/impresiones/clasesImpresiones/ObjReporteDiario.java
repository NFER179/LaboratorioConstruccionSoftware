package clasesImpresiones;

import java.util.List;

import dto.ProductoEnVentaDTO;

public class ObjReporteDiario extends ObjImprimible {
	private static final int maxPag = 20;
	private static final String tipo = "Reporte Diario";

	public ObjReporteDiario(String nombreArchivo, String fecha, int id) {
		super(nombreArchivo, fecha, tipo, id, maxPag);
	}
 
	List<ProductoEnVentaDTO> productos; 
	double total;

	public int getCantidadHojas() {
		return 0;
	}

}
