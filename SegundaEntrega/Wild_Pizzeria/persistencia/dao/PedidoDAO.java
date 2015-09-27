package dao;

import dto.PedidoDTO;
import java.util.List;

public interface PedidoDAO {

	/* Obtencion de pedidos */
	public List<PedidoDTO> pedidosPendientes();
	
	/* Ultimo Num de Pedido */
	public int UltimoNumPedido();
	
	/* Agregar un nuevo pedido */
	public void CrearNuevoPedido(PedidoDTO Pedido);
}
