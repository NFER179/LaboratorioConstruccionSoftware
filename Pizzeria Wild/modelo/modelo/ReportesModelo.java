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
			int idRepartidor) throws Exception {
		return this.repartidor.getInformeReparitodes(fecha, idRepartidor);
	}

	public List<ClienteReporteDTO> GetMejoresClientes(String fechaDesde,
			String fechaHasta) throws Exception {
		return this.repartidor.getMejoresClientes(fechaDesde, fechaHasta);
	}

	public List<VentaReporteDTO> GetVentas(String condiciones) throws Exception {
		return this.repartidor.getReporteVentas(condiciones);
	}

}
