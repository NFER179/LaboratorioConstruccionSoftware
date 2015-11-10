package dto;

public class ProveedorDTO {

	private String proveedorId;
	private String nombre;
	private String telefono;
	private String mail;
	private boolean activo;
	
	public ProveedorDTO(String ProveedorId, String Nombre, String Telefono, String Mail, boolean Activo) {
		this.proveedorId = ProveedorId;
		this.nombre = Nombre;
		this.telefono = Telefono;
		this.mail = Mail;
		this.activo = Activo;
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

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public static String ParseActivoShortString(boolean Arg0) {
		if(Arg0)
			return "Y";
		else
			return "N";
	}
	
	public static String ParseActivoLongString(boolean Arg0) {
		if(Arg0)
			return "Si";
		else
			return "No";
	}
	
	public static boolean ParseActivoBoolean(String Arg0) {
		if(Arg0.trim().toUpperCase().equals("Y") | Arg0.trim().toUpperCase().equals("Si"))
			return true;
		else
			return false;
	}
}
