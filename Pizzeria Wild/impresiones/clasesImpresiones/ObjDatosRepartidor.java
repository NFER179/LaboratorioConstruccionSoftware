package clasesImpresiones;

public class ObjDatosRepartidor {

	private String nombre;
	private String datosVehiculo;
	private String numTelefono;

	public ObjDatosRepartidor(String nombre, String datosVehiculo,
			String numTelefono) {
		this.nombre = nombre;
		this.datosVehiculo = datosVehiculo;
		this.numTelefono = numTelefono;
	}

	@Override
	public String toString() {
		return "Repartidor: " + nombre + "\n Vehiculo" + datosVehiculo
				+ ", Numero de Telefono:" + numTelefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDatosVehiculo() {
		return datosVehiculo;
	}

	public void setDatosVehiculo(String datosVehiculo) {
		this.datosVehiculo = datosVehiculo;
	}

	public String getNumTelefono() {
		return numTelefono;
	}

	public void setNumTelefono(String numTelefono) {
		this.numTelefono = numTelefono;
	}
}