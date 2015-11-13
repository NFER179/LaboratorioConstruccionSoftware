package modelo;

import java.util.List;

import dao.ReportesDAO; 
import daoImplementacion.ReportesImp;
import dto.ClienteReporteDTO;
import dto.RepartidoReporteDTO; 
import dto.VentaReporteDTO;

public class ReportesModelo {
	private ReportesDAO repartidor;

	public ReportesModelo() {
		this.repartidor = new ReportesImp();
	}

	public List<RepartidoReporteDTO> GetRepartidores(String fecha,
			int idRepartidor) {
		return this.repartidor.getInformeReparitodes(fecha, idRepartidor);
	}

	public List<ClienteReporteDTO> GetMejoresClientes(String fechaDesde,
			String fechaHasta) {
		return this.repartidor.getMejoresClientes(fechaDesde, fechaHasta);
	}

	public List<VentaReporteDTO> GetVentas(String condiciones) {
		return this.repartidor.getReporteVentas(condiciones);
	}

}
