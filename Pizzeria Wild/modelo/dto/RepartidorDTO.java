package dto;

public class RepartidorDTO {
	
	private int repartidorId;
	private String nombre;
	private String apellido;
	private String tel;
	private String direccion;
	private String vehiculoId;
	private boolean activo;
	
	
	public RepartidorDTO(int RepartidorId, String Nombre, String Apellido, String Tel, String Direccion, String VehiculoId, boolean Activo) {
		this.repartidorId = RepartidorId;
		this.nombre = Nombre;
		this.apellido = Apellido;
		this.tel = Tel;
		this.direccion = Direccion;
		this.vehiculoId = VehiculoId;
		this.activo = Activo;
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

	public String getVehiculoId() {
		return vehiculoId;
	}

	public void setVehiculoId(String vehiculoId) {
		this.vehiculoId = vehiculoId;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public static boolean ParseActivoBoolean(String arg0) {
		if(arg0.toUpperCase().trim().equals("Y")) {
			return true;
		}
		else
			return false;
	}
	
	public static String ParseActivoString(boolean arg0) {
		if(arg0)
			return "Y";
		else
			return "N";
	}
}