package daoImplementacion;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexion.ConectorDB;
import dao.DeliveryDAO;
import dto.DeliveryDTO;
import dto.VentaDTO;

public class DeliveryImp implements DeliveryDAO {

	private ConectorDB conector;
	
	public DeliveryImp() {
		this.conector = ConectorDB.GetInstancia();
	}
	
	@Override
	public int GetNumNuevoDelivery(String Fecha) {
		
		Statement stm = this.conector.GetStatement();
		String sqlString = "select max(num_delivery) as 'num_delivery' from delivery where effdt = '" + Fecha + "'";
		ResultSet rs = null;
		int numNuevoDelivery = 0;
		
		try {
			rs = stm.executeQuery(sqlString);
			
			while(rs.next()) {
				numNuevoDelivery = rs.getInt("num_delivery") + 1;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			this.conector.CloseConnection();
		}
		
		return numNuevoDelivery;
	}

	@Override
	public void InsertDelivery(String Fecha, int NumDelivery, int Repartidor, String Hora) {
		Statement stm = this.conector.GetStatement();
		String sqlString = "insert into delivery value('" + Fecha + "', " + 
														NumDelivery + ", " + 
														Repartidor + ", '" +
														Hora + "')";
		
		try {
			stm.executeUpdate(sqlString);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.conector.CloseConnection();
		}
	}

	@Override
	public void InsertVentaIn(String Fecha, int NumDelivery, List<VentaDTO> Ventas) {
		
		Statement stm = this.conector.GetStatement();
		
		try {
			for(VentaDTO venta:Ventas) {
				String sqlString = "insert into delivery_venta values('"+ Fecha +"', " +
						NumDelivery + ", '" +
						venta.getFecha() + "', " +
						venta.getNumVenta() +", 'pendiente', '')";
				stm.executeUpdate(sqlString);
			}
		}
		catch(Exception e) {
			/* se podra haceer un delete. */
			e.printStackTrace();
		}
		finally {
			this.conector.CloseConnection();
		}
	}

	@Override
	public List<DeliveryDTO> GetDeliverysPendientes() {
		
		Statement stm = this.conector.GetStatement();
		String sqlString = "select * from delivery " +
						"where (effdt, num_delivery) in (select effdt, num_delivery " +
														"from delivery_venta " +
														"where estado = 'pendiente') " +
						"group by effdt, num_delivery";
		ResultSet rs = null;
		List<DeliveryDTO> Deliverys = new ArrayList<DeliveryDTO>();
		
		try {
			rs = stm.executeQuery(sqlString);
			
			while(rs.next()) {
				Deliverys.add(new DeliveryDTO(rs.getString("effdt"), 
								rs.getInt("num_delivery"), 
								rs.getInt("empleado_id"), 
								rs.getString("hora")));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			this.conector.CloseConnection();
		}
		
		return Deliverys;
	}

	@Override
	public void FinalizarPedidoDeDelivery(String FechaDelivery, int NumDelivery, VentaDTO Venta) {
		
		Statement stm = this.conector.GetStatement();
		String sqlString = "update delivery_venta set estado = 'entregado' " +
						"where effdt = '" + FechaDelivery + "' " +
						"and num_delivery = " + NumDelivery + " " +
						"and fecha_venta = '" + Venta.getFecha() + "' " +
						"and num_venta = " + Venta.getNumVenta();
		
		try {
			stm.executeUpdate(sqlString);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}