package dto;

public class SolicitudDTO {

	private String effdt;
	private int numPedido;
	private boolean enviado;
	
	public SolicitudDTO(String Fecha, int NumPedido, boolean Enviado){
		this.effdt = Fecha;
		this.numPedido = NumPedido;
		this.enviado = Enviado;
	}
	
	public static boolean StringToBoolean(String arg0) {
		if(arg0.equals("Y"))
			return true;
		return false;
	}
	
	public String GetEstado() {
		if (this.enviado)
			return "Enviado";
		return "Guardado";
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

	public boolean isEnviado() {
		return enviado;
	}

	public void setEnviado(boolean enviado) {
		this.enviado = enviado;
	}
	
	public String GetYesNo() {
		if (this.enviado)
			return "Y";
		return "N";
	}
	
	public void setEnviado(String arg0) {
		if (arg0.equals("Y"))
			this.enviado = true;
		else
			this.enviado = false;
	}
}
