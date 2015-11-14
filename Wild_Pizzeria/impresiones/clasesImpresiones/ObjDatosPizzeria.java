package clasesImpresiones;

public class ObjDatosPizzeria {
	private String direccion;
	private String telefono;

	public ObjDatosPizzeria() {
		this.setDireccion("Av. Siempreviva 159");
		this.setTelefono("0303456");
	}

	public ObjDatosPizzeria(String direccion, String telefono) {
		this.direccion = direccion;
		this.telefono = telefono;
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
