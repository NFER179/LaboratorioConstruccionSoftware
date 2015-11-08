package dto;

public class SolicitudDTO {

	private String effdt;
	private int numPedido;
	private String estado;
	private String fecha_envio;
	private int referenciaNumPedido;
	private String fechaEntrega;
	private int costo;
	
	public SolicitudDTO(String Fecha, int NumPedido, String Estado, String FechaEnvio, int ReferenciaNumeroPedido, String FechaEntrega, int Costo){
		this.effdt = Fecha;
		this.numPedido = NumPedido;
		this.estado = Estado;
		this.fecha_envio = FechaEnvio;
		this.referenciaNumPedido = ReferenciaNumeroPedido;
		this.fechaEntrega = FechaEntrega;
		this.costo = Costo;
	}
	
	public static boolean StringToBoolean(String arg0) {
		if(arg0.equals("Y"))
			return true;
		return false;
	}

	public String getEffdt() {
		return effdt;
	}

	public void setEffdt(String effdt) {
		this.effdt = effdt;
	}

	public int getNumPedido() {
		return numPedido;
	}

	public void setNumPedido(int numPedido) {
		this.numPedido = numPedido;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFecha_envio() {
		return fecha_envio;
	}

	public void setFecha_envio(String fecha_envio) {
		this.fecha_envio = fecha_envio;
	}

	public int getReferenciaNumPedido() {
		return referenciaNumPedido;
	}

	public void setReferenciaNumPedido(int referenciaNumPedido) {
		this.referenciaNumPedido = referenciaNumPedido;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public String getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	
}
