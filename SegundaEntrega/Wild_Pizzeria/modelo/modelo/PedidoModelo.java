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
	
	public void cancelarPedido(PedidoDTO pedido) {
		
	}
	
	public List<PedidoDTO> obtenerPedidosPendientes() {
		return this.pedido.pedidosPendientes();
	}
}
