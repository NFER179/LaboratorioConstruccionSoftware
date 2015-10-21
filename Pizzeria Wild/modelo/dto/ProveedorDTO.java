package dto;

public class ProveedorDTO {

	private String proveedorId;
	private String nombre;
	private String telefono;
	private String mail;
	
	public ProveedorDTO(String ProveedorId, String Nombre, String Telefono, String Mail) {
		this.proveedorId = ProveedorId;
		this.nombre = Nombre;
		this.telefono = Telefono;
		this.mail = Mail;
	}

	public String getProveedorId() {
		return proveedorId;
	}

	public void setProveedorId(String proveedorId) {
		this.proveedorId = proveedorId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
}
