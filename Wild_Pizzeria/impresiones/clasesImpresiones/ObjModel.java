package clasesImpresiones;

public abstract class ObjModel {

	private String nombreArchivo;
	private String fecha;
	private int id;
	public static String path = "C:/%s.pdf";
	private String tipo;
 
	public ObjModel(String nombreArchivo, String fecha, String tipo, int id) {
		this.nombreArchivo = nombreArchivo;
		this.fecha = fecha;
		this.id = id;
		this.tipo = tipo;
	}

	public abstract String[] getParametros();
	
	public String getRuta() {
		return String.format(path, nombreArchivo);
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
}
