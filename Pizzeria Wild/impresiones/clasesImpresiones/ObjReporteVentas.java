package clasesImpresiones;

import java.util.List;

import utilidades.Fecha;

import dto.VentaReporteDTO;

public class ObjReporteVentas extends ObjReporteRangoFechas {

	private static final int maxPag = 16;
	private static final String templatePath = "reporte_ventas_template";
	private static String nombreCarpeta = "Ventas";

	public ObjReporteVentas(String fechaDesde, String fechaHasta,
			List<VentaReporteDTO> lista) {
		super("Ventas " + Fecha.CurrentDateFormato(), templatePath, 0, maxPag,
				fechaDesde, fechaHasta, lista, nombreCarpeta);
	}

}
