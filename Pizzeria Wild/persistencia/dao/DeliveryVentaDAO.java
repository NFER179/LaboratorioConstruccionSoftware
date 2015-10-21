package dao;

import java.util.List;
import dto.DeliveryVentaDTO;
import dto.VentaDTO;

public interface DeliveryVentaDAO {
	
	/* Ventas para determinado delivery. */
	public List<DeliveryVentaDTO> VentasParaDelivery(String Fecha, int NumDelivery);

	/* Venta no entregada por determinada razon. */
	public void VentaNoEntregada(String Fecha, int NumPedido, VentaDTO Venta, String Observacion);
}
