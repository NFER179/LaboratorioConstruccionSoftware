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
						rs.getString("direccion"),
						rs.getString("vehiculo_id"),
						rs.getString("tipo_vehiculo"),
						rs.getString("modelo_vehiculo"),
						RepartidorDTO.ParseActivoBoolean(rs.getString("activo"))));
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
				repartidor = new RepartidorDTO(rs.getInt("empleado_id"), 
						rs.getString("nombre"), 
						rs.getString("apellido"), 
						rs.getString("tel"),
						rs.getString("direccion"), 
						rs.getString("vehiculo_id"), 
						rs.getString("tipo_vehiculo"), 
						rs.getString("modelo_vehiculo"), 
						RepartidorDTO.ParseActivoBoolean(rs.getString("activo")));
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

	@Override
	public List<RepartidorDTO> GetActivos() {
		Statement stm = this.conector.GetStatement();
		String sqlString = "select * from repartidor where activo = 'Y'";
		ResultSet rs = null;
		List<RepartidorDTO> repartidores = new ArrayList<RepartidorDTO>();
		
		try {
			rs = stm.executeQuery(sqlString);
			
			while(rs.next()){
				int RepartidorId = rs.getInt("empleado_id");
				String Nombre = rs.getString("nombre");
				String Apellido = rs.getString("apellido");
				String Tel = rs.getString("tel");
				String Direccion = rs.getString("direccion");
				String VehiculoId = rs.getString("vehiculo_id");
				String TipoVehiculo = rs.getString("tipo_vehiculo");
				String ModeloVehiculo = rs.getString("modelo_vehiculo");
				boolean Activo = RepartidorDTO.ParseActivoBoolean(rs.getString("activo"));
				
				RepartidorDTO r = new RepartidorDTO(RepartidorId, Nombre, Apellido, Tel, Direccion, VehiculoId, TipoVehiculo, ModeloVehiculo, Activo);
				repartidores.add(r);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			this.conector.CloseConnection();
		}
		return repartidores;
	}

	@Override
	public void Insert(RepartidorDTO repartidor) {
		Statement stm = this.conector.GetStatement();
		String sqlString = "insert into repartidor values("+ repartidor.getRepartidorId() + ", '" +
							repartidor.getNombre() + "', '" +
							repartidor.getApellido() + "', '" +
							repartidor.getTel() + "', '" +
							repartidor.getDireccion() + "', '" +
							repartidor.getVehiculoId() + "', '" +
							repartidor.getTipoVehiculo() + "', '" +
							repartidor.getModeloVehiculo() + "', '" +
							repartidor.GetShortStringActivo()+ "')";
		
		try{
			stm.executeUpdate(sqlString);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally{
			this.conector.CloseConnection();
		}
	}

	@Override
	public void Alter(RepartidorDTO repartidor) {
		Statement stm = this.conector.GetStatement();
		String sqlString = "update repartidor set nombre = '" + repartidor.getNombre() + "', " +
												"apellido = '" + repartidor.getApellido() + "', " +
												"tel = '" + repartidor.getTel() + "', " +
												"direccion = '" + repartidor.getDireccion() + "', " +
												"vehiculo_id = '" + repartidor.getVehiculoId() + "', " +
												"tipo_vehiculo = '" + repartidor.getTipoVehiculo() +  "', " +
												"modelo_vehiculo = '" + repartidor.getModeloVehiculo() + "', " +
												"activo = '" + repartidor.GetShortStringActivo() + "' " +
												"where empleado_id = " + repartidor.getRepartidorId();
		
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
	public int GetNuevoId() {
		Statement stm = this.conector.GetStatement();
		String sqlString = "select max(empleado_id) as 'empleado_id' from repartidor";
		ResultSet rs = null;
		int numRepartidor = 1;
		
		try {
			rs = stm.executeQuery(sqlString);
			
			while(rs.next()) {
				numRepartidor = rs.getInt("empleado_id") + 1;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.conector.CloseConnection();
		}
		
		return numRepartidor;
	}
}