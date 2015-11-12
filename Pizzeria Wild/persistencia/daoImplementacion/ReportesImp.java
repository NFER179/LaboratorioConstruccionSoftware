package daoImplementacion;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexion.ConectorDB;

import dao.ReportesDAO; 
import dto.ClienteReporteDTO;

public class ReportesImp implements ReportesDAO {

	private ConectorDB conector;

	public ReportesImp() {
		this.conector = ConectorDB.GetInstancia();
	}

	@Override
	public List<ClienteReporteDTO> getMejoresClientes(String fechaDesde,
			String fechaHasta) {
		Statement stm;
		String sqlString = String.format(mejoresClientes, fechaDesde,
				fechaHasta);
		ResultSet rs = null;
		List<ClienteReporteDTO> lstCliente = new ArrayList<ClienteReporteDTO>();

		try {
			stm = this.conector.GetStatement();
			rs = stm.executeQuery(sqlString);

			int posicion = 1;
			while (rs.next()) {
				lstCliente.add(new ClienteReporteDTO(rs.getInt("total"), rs
						.getString("nombre"), posicion, rs.getString("fecha")));
				posicion++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			this.conector.CloseConnection();
		}

		return lstCliente;
	}

	@Override
	public List<Object> getInformeReparitodes(String fechaDesde,
			String fechaHasta) {
		return null;
	}

	@Override
	public List<Object> getMejoresClieFs(String fechaDesde, String fechaHasta) {
		// TODO Auto-generated method stub
		return null;
	}

	private static String mejoresClientes = "SELECT v.cliente as nombre, "
			+ "sum(v.precio) as total, max(v.effdt) as fecha"
			+ "FROM venta as v " + "where v.effdt >= %s and v.effdt <= %s"
			+ "and v.estado = 'Facturado'" + "GROUP BY v.cliente"
			+ "order by total desc, fecha asc";

}
