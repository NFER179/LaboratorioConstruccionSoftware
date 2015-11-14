package clasesImpresiones;

public class ObjPedido {
	private int numPedido;
	private String cliente;
	private boolean entregado;

	public ObjPedido(int numPedido, String cliente, boolean entregado,
			double costo) {
		super();
		this.numPedido = numPedido;
		this.cliente = cliente;
		this.entregado = entregado;
		this.costo = costo;
	}

	public int getNumPedido() {
		return numPedido;
	}

	public void setNumPedido(int numPedido) {
		this.numPedido = numPedido;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public boolean isEntregado() {
		return entregado;
	}

	public void setEntregado(boolean entregado) {
		this.entregado = entregado;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	private double costo;
}
