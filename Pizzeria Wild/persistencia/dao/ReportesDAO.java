package dao;

import java.util.List;

import dto.ClienteReporteDTO;
import dto.RepartidoReporteDTO;
import dto.VentaReporteDTO;

public interface ReportesDAO {

	public List<ClienteReporteDTO> getMejoresClientes(String fechaDesde,
			String fechaHasta);

	public List<RepartidoReporteDTO> getInformeReparitodes(String fecha,
			int idRepartidor);

	public List<VentaReporteDTO> getReporteVentas(String[] condiciones);
}
