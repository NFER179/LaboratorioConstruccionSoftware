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
	
	public List<RepartidorDTO> ObtenerTodosLosRepartidores() {
		return this.repartidor.GetRepartidores();
	}

	public RepartidorDTO ObtenerRepartidor(int RepartidorId) {
		return this.repartidor.GetRepartidor(RepartidorId);
	}

	public List<RepartidorDTO> ObtenerRepartidoresActivos() {
		return this.repartidor.GetActivos();
	}

	public void CrearRepartidor(RepartidorDTO repartidor) {
		this.repartidor.Insert(repartidor);
	}

	public void ModificarRepartidor(RepartidorDTO repartidor) {
		this.repartidor.Alter(repartidor);
	}

	public int ObtenerNumNuevoRepartidor() {
		return this.repartidor.GetNuevoId();
	}

//	public void AsignarPedidos(int RepartidorId, List<VentaDTO> Pedidos) {
//		this.repartidor.ArmarDelivery(RepartidorId, Pedidos);
//	}

//	public void DesasignarVenta(int NumPedido) {
//		this.repartidor.DesasignarPedido(NumPedido);
//	}
}