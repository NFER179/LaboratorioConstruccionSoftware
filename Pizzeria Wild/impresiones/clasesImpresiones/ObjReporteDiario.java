package clasesImpresiones;

import java.util.List;

import dto.ProductoEnVentaDTO;

public class ObjReporteDiario extends ObjImprimible {
	private static final int maxPag = 10;
	private static final String tipo = "reporte_diario_template";
	private List<Object> items;

	public ObjReporteDiario(String nombreArchivo, String fecha, int id) {
		super(nombreArchivo, fecha, tipo, id, maxPag);
	}

	List<ProductoEnVentaDTO> productos;
	double total;

	public int getCantidadHojas() {
		return (int) Math.ceil(getItems().size() / (getMaxPaginacion() * 1.0));
	}

	public List<Object> getItems() {
		return items;
	}

	public void setItems(List<Object> items) {
		this.items = items;
	}

}
