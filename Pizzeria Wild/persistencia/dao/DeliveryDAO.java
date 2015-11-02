package dao;

import java.util.List;

import dto.DeliveryDTO;
import dto.VentaDTO;

public interface DeliveryDAO {

	/* Trae el numero para un nuevo delivery. */
	public int GetNumNuevoDelivery(String Fecha);
	
	/* Ingresa un nuevo pedido de delivery. */
	public void InsertDelivery(String Fecha, int NumDelivery, int Repartidor, String Hora, String Observaciones);

	/* Inserta las ventas en un determinado delivery */
	public void InsertVentaIn(String Fecha, int NumDelivery, List<VentaDTO> Venta);

	/* Retorna una lista de deliverys que hasta el momento no fueron entregados. */
	public List<DeliveryDTO> GetDeliverysPendientes();

	/* Finaliza las ventas de cierto delivery. */
	public void FinalizarPedidoDeDelivery(String fechaDelivery, int numDelivery, VentaDTO venta);
}
