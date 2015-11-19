package clasesImpresiones;

import java.util.List;

import utilidades.Fecha;

public class ObjReporteRangoFechas extends ObjImprimible {

	private String fechaDesde;
	private String fechaHasta;
	private List<?> lista;

	public ObjReporteRangoFechas(String nombreArchivo, String templateName,
			int id, int maxPaginacion, String fechaDesde, String fechaHasta,
			List<?> lista) {
		super(nombreArchivo, Fecha.CurrentDate(), templateName, id,
				maxPaginacion);
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
		this.lista = lista;
	}

	public String getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(String fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public String getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(String fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	public List<?> getLista() {
		return lista;
	}

	public void setLista(List<?> lista) {
		this.lista = lista;
	}

	@Override
	public int getCantidadHojas() {
		return (int) Math.ceil(this.lista.size() / (getMaxPaginacion() * 1.0));
	}

}
