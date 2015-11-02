package dto;

public class DeliveryDTO {
	
	String fecha;
	int numDelivery;
	int repartidor;
	String hora;
	String observacion;
	
	public DeliveryDTO(String Fecha, int numDelivery, int Repartidor, String Hora, String Observacion) {
		this.fecha = Fecha;
		this.numDelivery = numDelivery;
		this.repartidor = Repartidor;
		this.hora = Hora;
		this.observacion = Observacion;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getNumDelivery() {
		return numDelivery;
	}

	public void setNumDelivery(int numDelivery) {
		this.numDelivery = numDelivery;
	}

	public int getRepartidor() {
		return repartidor;
	}

	public void setRepartidor(int repartidor) {
		this.repartidor = repartidor;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
}