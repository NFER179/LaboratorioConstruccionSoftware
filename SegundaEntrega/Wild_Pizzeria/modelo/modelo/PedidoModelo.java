package modelo;

import java.util.List;

import dto.PedidoDTO;
import dao.PedidoDAO;
import daoImplementacion.PedidoImp;

public class PedidoModelo {

	private PedidoDAO pedido;
	
	public PedidoModelo() {
		this.pedido = new PedidoImp();
	}
	
	public int GetNuevoNumeroPedido() {
		return this.pedido.UltimoNumPedido() + 1;
	}
	
	public void agregarPedido(PedidoDTO nuevoPedido) {
		this.pedido.CrearNuevoPedido(nuevoPedido);
	}
	
	public void cancelarPedido(int NumPedido) {
		this.pedido.CancelarPedido(NumPedido);
	}
	
	public List<PedidoDTO> obtenerPedidosPendientesCocina() {
		return this.pedido.pedidosPendientesCocina();
	}
	
	public List<PedidoDTO> GetPedidoSinFacturar() {
		return this.pedido.PedidoPendientesEntregar();
	}

	public void ModificarPedido(PedidoDTO Pedido) {
		this.pedido.ModificarPedido(Pedido);
	}

	public PedidoDTO GetPedido(int PedidoID) {
		return this.pedido.GetPedido(PedidoID);
	}

	public void FinalizarPedido(int NumPedido) {
		this.pedido.FacturarPedido(NumPedido);		
	}

	public void PedidoArmado(int NumPedido) {
		this.pedido.PedidoArmado(NumPedido);
	}
}
