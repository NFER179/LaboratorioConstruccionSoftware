package clasesImpresiones;

import java.util.List;

import dto.ProductoEnVentaDTO;

public class ObjReporteDiario extends ObjModel {

	public ObjReporteDiario(String nombreArchivo, String fecha, int id) {
		super(nombreArchivo, fecha, "Reporte Diario", id);
		// TODO Auto-generated constructor stub
	}
	public String nombre;
	List<ProductoEnVentaDTO> productos;
	String fecha;
	double total;
	@Override
	public String[] getParametros() {
		// TODO Auto-generated method stub
		return null;
	}

}
