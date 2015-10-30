package clasesImpresiones;

public abstract class ObjImprimible {

	private String nombreArchivo;
	private String fecha;
	private int id;
	public static String path = "Templates/%s-%d.pdf";
	private String tipo;
	private int maxPaginacion;

	public ObjImprimible(String nombreArchivo, String fecha, String tipo, int id,
			int maxPaginacion) {
		this.nombreArchivo = nombreArchivo;
		this.fecha = fecha;
		this.id = id;
		this.maxPaginacion = maxPaginacion;
		this.tipo = tipo;
	}
	
	public abstract int getCantidadHojas();

	public String getRuta(int numeroPagina) {
		return String.format(path, nombreArchivo, numeroPagina );
	}

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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public static String getPath() {
		return path;
	}

	public static void setPath(String path) {
		ObjImprimible.path = path;
	}

	public int getMaxPaginacion() {
		return maxPaginacion;
	}

	public void setMaxPaginacion(int maxPaginacion) {
		this.maxPaginacion = maxPaginacion;
	}

}
