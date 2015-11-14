package modelo;

import java.util.List;
import dao.RepartidorDAO;
import daoImplementacion.RepartidorImp;
import dto.RepartidorDTO;

public class RepartidorModelo {
	
	private RepartidorDAO repartidor;
	
	public RepartidorModelo() {
		this.repartidor = new RepartidorImp();
	}
	
	public List<RepartidorDTO> GetRepartidores() {
		return this.repartidor.GetRepartidores();
	}

	public RepartidorDTO GetRepartidor(int RepartidorId) {
		return this.repartidor.GetRepartidor(RepartidorId);
	}

//	public void AsignarPedidos(int RepartidorId, List<VentaDTO> Pedidos) {
//		this.repartidor.ArmarDelivery(RepartidorId, Pedidos);
//	}

//	public void DesasignarVenta(int NumPedido) {
//		this.repartidor.DesasignarPedido(NumPedido);
//	}
}