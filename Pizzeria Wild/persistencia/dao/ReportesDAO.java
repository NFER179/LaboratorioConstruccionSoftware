package dao;

import java.util.List;

import dto.ClienteReporteDTO;
import dto.RepartidoReporteDTO;
import dto.VentaReporteDTO;

public interface ReportesDAO {

	public List<ClienteReporteDTO> getMejoresClientes(String fechaDesde,
			String fechaHasta);

	public List<RepartidoReporteDTO> getInformeReparitodes(String from, String to,
			int idRepartidor) throws Exception;

	public List<VentaReporteDTO> getReporteVentas(String from, String to) throws Exception;
}
