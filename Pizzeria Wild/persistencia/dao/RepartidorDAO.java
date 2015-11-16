package dao;

import java.util.List;
import dto.RepartidorDTO;

public interface RepartidorDAO {
	/* Obtener todos los repartidores de la base. */
	public List<RepartidorDTO> GetRepartidores();

	/* Obtener un repartidor en especial. */
	public RepartidorDTO GetRepartidor(int RepartidorId);

//	/* Asigna Pedidos a Repartidor. */
//	public void ArmarDelivery(int Repartidor, List<VentaDTO> Pedidos);

	/* Desasigna Pedido de los repartidores, por no haber entregado el pedido. */
	public void DesasignarPedido(int NumPedido);

	/* Obtiene los Repartidores Activos. */
	public List<RepartidorDTO> GetActivos();

	/* Inserta un nuevo repartidor. */
	public void Insert(RepartidorDTO repartidor);

	/* Modifica Repartidor. */
	public void Alter(RepartidorDTO repartidor);

	/* Consigue un nuevo ID */
	public int GetNuevoId();
}
