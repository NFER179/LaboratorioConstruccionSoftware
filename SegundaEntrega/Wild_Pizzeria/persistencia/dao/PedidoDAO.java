package dao;

import dto.PedidoDTO;
import java.util.List;

public interface PedidoDAO {

	/* Obtener pedido que no estan cancelados ni finalizados. */
	public List<PedidoDTO> PedidoPendientesEntregar();
	
	/* Obtencion de pedidos pendiente */
	public List<PedidoDTO> pedidosPendientesCocina();
	
	/* Ultimo Num de Pedido */
	public int UltimoNumPedido();
	
	/* Agregar un nuevo pedido */
	public void CrearNuevoPedido(PedidoDTO Pedido);

	/* Por la referencia de pedido lo cancela. */
	public void CancelarPedido(int numPedido);

	/* Modifica los pedido. */
	public void ModificarPedido(PedidoDTO pedido);

	/* Trae la imformacion de un pedido en particular. */
	public PedidoDTO GetPedido(int pedidoID);
	
	/* Por la referencia de pedido lo pone en estado entregado al cliente. */
	public void FacturarPedido(int NumPedido);

	/* Por la referencia de pedido lo pone en estado armado */
	public void PedidoArmado(int numPedido);
}
