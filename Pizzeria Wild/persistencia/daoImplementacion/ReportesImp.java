package daoImplementacion;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexion.ConectorDB;

import dao.ReportesDAO;
import dto.ClienteReporteDTO;
import dto.RepartidoReporteDTO;
import dto.VentaReporteDTO;

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
		System.out.println(sqlString);
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
	public List<RepartidoReporteDTO> getInformeReparitodes(String fecha,
			int idRepartidor) {
		Statement stm;
		String sqlString = String.format(repartos, fecha, idRepartidor);
		System.out.println(sqlString);
		ResultSet rs = null;
		List<RepartidoReporteDTO> lstCliente = new ArrayList<RepartidoReporteDTO>();

		try {
			stm = this.conector.GetStatement();
			rs = stm.executeQuery(sqlString);

			while (rs.next()) {
				lstCliente.add(new RepartidoReporteDTO(rs.getInt("reparto"), rs
						.getString("cliente"), rs.getInt("pedido"), rs
						.getString("estado"), rs.getInt("precio")));
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
	public List<VentaReporteDTO> getReporteVentas(String condiciones) {
		Statement stm;
		String sqlString = String.format(reporteVentas, condiciones);
		ResultSet rs = null;
		List<VentaReporteDTO> lstVentas = new ArrayList<VentaReporteDTO>();

		try {
			stm = this.conector.GetStatement();
			rs = stm.executeQuery(sqlString);

			int posicion = 1;
			while (rs.next()) {
				lstVentas.add(new VentaReporteDTO(posicion, rs
						.getString("producto"), rs.getInt("cantidad")));
				posicion++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			this.conector.CloseConnection();
		}

		return lstVentas;
	}

	private static String reporteVentas = "select * from ("
			+ " select CONCAT(vp.producto ,', ' , vp.sabor ) as producto, "
			+ " sum(vp.cantidad) as cantidad,  vp.effdt as fecha "
			+ " from venta_producto as vp inner join venta as v "
			+ " on vp.effdt = v.effdt and vp.num_venta = v.num_venta  "
			+ " where v.estado = 'Facturado' "
			+ " group by vp.producto, vp.sabor " + " order by cantidad desc"
			+ ") as n where fecha >= '%s' and fecha <= '%s' ;";

	private static String repartos = "select d.num_delivery as reparto, "
			+ " v.num_venta as pedido, v.cliente, dv.estado , v.precio "
			+ " from delivery as d inner join venta as v "
			+ " on d.effdt = v.effdt inner join delivery_venta as dv "
			+ " on d.effdt = dv.effdt and d.num_delivery = dv.num_delivery "
			+ " and v.num_venta = dv.num_venta "
			+ " where dv.effdt = '%s' and empleado_id = %s";

	private static int cantidadMejoresClientes = 10;
	private static String mejoresClientes = "SELECT v.cliente as nombre, sum(v.precio) as total, max(v.effdt) as fecha FROM venta as v  where v.effdt >= '%s' and v.effdt <= '%s' and v.estado = 'Facturado' GROUP BY v.cliente order by total desc, fecha asc limit "
			+ cantidadMejoresClientes + " ;";

}
