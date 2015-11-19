package clasesImpresiones;

import java.util.List;

import utilidades.Fecha;

import dto.VentaReporteDTO;

public class ObjReporteVentass extends ObjReporteRangoFechas {

	private static final int maxPag = 16;
	private static final String templatePath = "reporte_ventas_template";

	public ObjReporteVentass(String fechaDesde, String fechaHasta,
			List<VentaReporteDTO> lista) {
		super("Ventas " + Fecha.CurrentDate(), templatePath, 0, maxPag,
				fechaDesde, fechaHasta, lista);
	}

}
