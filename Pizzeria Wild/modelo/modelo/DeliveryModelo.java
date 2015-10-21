package modelo;

import java.util.List;

import dao.DeliveryDAO;
import daoImplementacion.DeliveryImp;
import dto.DeliveryDTO;
import dto.VentaDTO;

public class DeliveryModelo {
	
	private DeliveryDAO delivery;
	
	public DeliveryModelo() {
		this.delivery = new DeliveryImp();
	}
	
	public int NumNuevoDeliverry(String Fecha) {
		return this.delivery.GetNumNuevoDelivery(Fecha);
	}
	
	public void IngresarNuevodelivery(String Fecha, int NumDelivery, int Repartidor, String Hora) {
		this.delivery.InsertDelivery(Fecha, NumDelivery, Repartidor, Hora);
	}

	public void AgregarVentas(String Fecha, int NumDelivery, List<VentaDTO> Ventas) {
		this.delivery.InsertVentaIn(Fecha, NumDelivery, Ventas);	
	}

	public List<DeliveryDTO> DeliverysEnViaje() {
		return this.delivery.GetDeliverysPendientes();
	}

	public void DeliverysEntregados(String FechaDelivery, int NumDelivery, VentaDTO Venta) {
		this.delivery.FinalizarPedidoDeDelivery(FechaDelivery, NumDelivery, Venta);
	}
}
