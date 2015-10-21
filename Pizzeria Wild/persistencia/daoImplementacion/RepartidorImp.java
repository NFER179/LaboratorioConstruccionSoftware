package daoImplementacion;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import conexion.ConectorDB;
import dao.RepartidorDAO;
import dto.RepartidorDTO;

public class RepartidorImp implements RepartidorDAO{

	private ConectorDB conector;
	
	public RepartidorImp() {
		this.conector = ConectorDB.GetInstancia();
	}
	
	@Override
	public List<RepartidorDTO> GetRepartidores() {
		
		Statement stm = this.conector.GetStatement();
		String sqlString = "select * from repartidor";
		ResultSet rs = null;
		List<RepartidorDTO> lRepartidores = new ArrayList<RepartidorDTO>();
		
		try {
			rs = stm.executeQuery(sqlString);
			
			while (rs.next()) {
				lRepartidores.add(new RepartidorDTO(rs.getInt("empleado_id"), 
						rs.getString("nombre"), 
						rs.getString("apellido"),
						rs.getString("tel"),
						rs.getString("direccion")));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			this.conector.CloseConnection();
		}

		return lRepartidores;
	}
	
	@Override
	public RepartidorDTO GetRepartidor(int RepartidorId) {
		
		Statement stm = this.conector.GetStatement();
		String sqlString = "select * from repartidor where empleado_id = '" + RepartidorId + "'";
		ResultSet rs = null;
		RepartidorDTO repartidor = null;
		
		try {
			rs = stm.executeQuery(sqlString);
			
			while(rs.next()) {
				repartidor = new RepartidorDTO(rs.getInt("empleado_id"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("tel"),
						rs.getString("direccion"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			this.conector.CloseConnection();
		}
		
		return repartidor;
	}
	
//	public void ArmarDelivery(int RepartidorId, List<VentaDTO> Pedidos) {
//		 
//		Statement stm = this.conector.GetStatement();
//		String sqlString;
//		
//		for (VentaDTO pedido:Pedidos) {
//			sqlString = "insert into delivery_repartidor value(" + RepartidorId + ", " + pedido.getNumVenta() + ")";
//			
//			try{
//				stm.executeUpdate(sqlString);
//			}
//			catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
//		
//		this.conector.CloseConnection();
//	}
	
	@Override
	public void DesasignarPedido(int NumPedido) {
		
		Statement stm = this.conector.GetStatement();
		String sqlString = "delete from pedido_repartidor where num_pedido = " + NumPedido;
		
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
}