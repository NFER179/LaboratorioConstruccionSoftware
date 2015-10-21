package dto;

public class ClienteDTO {
	
	private int clienteId;
	private String nombre;
	private String apellido;
	private String direccion;
	private String tel;
	
	public ClienteDTO(int ClienteId, String Nombre, String Apellido, String Direccion, String Tel) {
		this.clienteId = ClienteId;
		this.nombre = Nombre;
		this.apellido = Apellido;
		this.direccion = Direccion;
		this.tel = Tel;
	}

	public int getClienteId() {
		return clienteId;
	}

	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
}