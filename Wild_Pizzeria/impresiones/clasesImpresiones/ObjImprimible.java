package clasesImpresiones;

public abstract class ObjImprimible {

	private String nombreArchivo;
	private String fecha;
	private int id; 
	private String templateName;
	private int maxPaginacion;

	public ObjImprimible(String nombreArchivo, String fecha,
			String templateName, int id,
			int maxPaginacion) {
		this.nombreArchivo = nombreArchivo;
		this.fecha = fecha;
		this.id = id;
		this.maxPaginacion = maxPaginacion;
		this.templateName = templateName;
	}
	
	public abstract int getCantidadHojas();
 
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String tipo) {
		this.templateName = tipo;
	}
	
	public int getMaxPaginacion() {
		return maxPaginacion;
	}

	public void setMaxPaginacion(int maxPaginacion) {
		this.maxPaginacion = maxPaginacion;
	}

}
