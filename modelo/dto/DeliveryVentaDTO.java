package dto;

public class DeliveryVentaDTO {
	
	private String fecha;
	private int nunDelivery;
	private String fechaVenta;
	private int numVenta;
	private String estado;
	private String observacionNoEntregado;
	
	public DeliveryVentaDTO(String Fecha, int NumDelivery, String FechaVenta, int NumVenta, String Estado, String ObsNoEntrega) {
		this.fecha = Fecha;
		this.nunDelivery = NumDelivery;
		this.fechaVenta = FechaVenta;
		this.numVenta = NumVenta;
		this.estado = Estado;
		this.observacionNoEntregado = ObsNoEntrega;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getNunDelivery() {
		return nunDelivery;
	}

	public void setNunDelivery(int nunDelivery) {
		this.nunDelivery = nunDelivery;
	}

	public String getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(String fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public int getNumVenta() {
		return numVenta;
	}

	public void setNumVenta(int numVenta) {
		this.numVenta = numVenta;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getObservacionNoEntregado() {
		return observacionNoEntregado;
	}

	public void setObservacionNoEntregado(String observacionNoEntregado) {
		this.observacionNoEntregado = observacionNoEntregado;
	}
}