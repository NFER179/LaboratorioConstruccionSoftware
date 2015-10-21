package modelo;

import java.util.List;

import dao.DeliveryVentaDAO;
import daoImplementacion.DeliveryVentaImp;
import dto.DeliveryVentaDTO;
import dto.VentaDTO;

public class DeliveryVentaModelo {
	
	private DeliveryVentaDAO deliveryVenta;
	
	public DeliveryVentaModelo() {
		this.deliveryVenta = new DeliveryVentaImp();
	}
	
	public List<DeliveryVentaDTO> GetVentasPara(String Fecha, int NumDelivery) {
		return this.deliveryVenta.VentasParaDelivery(Fecha, NumDelivery);
	}

	public void VentaNoEntregada(String Fecha, int NumPedido, VentaDTO Venta, String Observacion) {
		this.deliveryVenta.VentaNoEntregada(Fecha, NumPedido, Venta, Observacion);
	}
}
