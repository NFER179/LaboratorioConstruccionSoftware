package clasesImpresiones;

public class ObjDatosPizzeria {
	private String direccion;
	private String telefono;

	private ObjDatosPizzeria(String direccion, String telefono) {
		this.setDireccion(direccion);
		this.setTelefono(telefono);
	}

	public static ObjDatosPizzeria getDatos() {
		return new ObjDatosPizzeria("Av. Siempreviva 159", "0303456");
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
}
