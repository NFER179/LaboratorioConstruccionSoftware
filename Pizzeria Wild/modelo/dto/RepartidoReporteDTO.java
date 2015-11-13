package dto;

public class RepartidoReporteDTO {
	private int reparto;
	private String cliente;
	private int pedido;
	private String entregado;
	private double monto;

	public RepartidoReporteDTO(int reparto, String cliente, int pedido,
			String entregado, double monto) {
		this.reparto = reparto;
		this.cliente = cliente;
		this.pedido = pedido;
		this.entregado = entregado;
		this.monto = monto;
	}

	public int getReparto() {
		return reparto;
	}

	public void setReparto(int reparto) {
		this.reparto = reparto;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public int getPedido() {
		return pedido;
	}

	public void setPedido(int pedido) {
		this.pedido = pedido;
	}

	public String getEntregado() {
		return entregado;
	}

	public void setEntregado(String entregado) {
		this.entregado = entregado;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

}
