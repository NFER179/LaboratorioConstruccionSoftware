package dao;

import java.util.List;

import dto.ClienteReporteDTO;
import dto.RepartidorDTO;

public interface ReportesDAO {

	public List<ClienteReporteDTO> getMejoresClientes(String fechaDesde,
			String fechaHasta);

	public List<Object> getInformeReparitodes(String fechaDesde,
			String fechaHasta);

	public List<Object> getMejoresClieFs(String fechaDesde, String fechaHasta);
}
