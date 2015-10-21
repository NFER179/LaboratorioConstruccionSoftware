package dto;

public class RepartidorDTO {
	
	private int repartidorId;
	private String nombre;
	private String apellido;
	private String tel;
	private String direccion;
	
	public RepartidorDTO(int RepartidorId, String Nombre, String Apellido, String Tel, String Direccion) {
		this.repartidorId = RepartidorId;
		this.nombre = Nombre;
		this.apellido = Apellido;
		this.tel = Tel;
		this.direccion = Direccion;
	}

	public int getRepartidorId() {
		return repartidorId;
	}

	public void setRepartidorId(int repartidorId) {
		this.repartidorId = repartidorId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
}