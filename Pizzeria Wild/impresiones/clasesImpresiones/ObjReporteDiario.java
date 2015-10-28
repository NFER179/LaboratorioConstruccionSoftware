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

	@Override
	public String[] getParametros(int numPagina) {
		// TODO Auto-generated method stub
		return null;
	}

}
