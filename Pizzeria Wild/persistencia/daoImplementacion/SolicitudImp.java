package daoImplementacion;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexion.ConectorDB;
import dao.SolicitudDAO;
import dto.MateriaPrimaSolicitudDTO;
import dto.SolicitudDTO;

public class SolicitudImp implements SolicitudDAO {

	private ConectorDB conector;
	
	public SolicitudImp(){
		this.conector = ConectorDB.GetInstancia();
	}
	
	@Override
	public List<SolicitudDTO> GetSolicitudes() {
		
		Statement stm = this.conector.GetStatement();
		String sqlString = "select * from pedido";
		ResultSet rs = null;
		List<SolicitudDTO> solicitudes = new ArrayList<SolicitudDTO>();
		
		try {
			rs = stm.executeQuery(sqlString);
			
			while(rs.next()) {
				String fechaPedido = rs.getString("effdt");
				int numPedido = Integer.parseInt(rs.getString("num_pedido"));
				boolean enviado = SolicitudDTO.StringToBoolean(rs.getString("enviado"));
				String fecha_envio = rs.getString("fecha_envio");
				
				solicitudes.add(new SolicitudDTO(fechaPedido, numPedido, enviado, fecha_envio));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.conector.CloseConnection();
		}
		
		return solicitudes;
	}

	@Override
	public int GetNuevoNumeroSolicitud(String Fecha) {
		Statement stm = this.conector.GetStatement();
		String sqlString = "select max(p.num_pedido) as 'num_pedido' from pedido p " +
						"where p.effdt = '" + Fecha + "'";
		ResultSet rs = null;
		int numSolicitud = 0;
		
		try{
			rs = stm.executeQuery(sqlString);
			
			while(rs.next()) {
				numSolicitud = rs.getInt("num_pedido") + 1;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.conector.CloseConnection();
		}
		
		return numSolicitud;
	}

	@Override
	public void EnviarSolicitud(SolicitudDTO Solicitud, String Proveedor, List<MateriaPrimaSolicitudDTO> MateriasPrimas) {
		Statement stm = this.conector.GetStatement();
		String sqlStringPedido = "insert into pedido value('" + Solicitud.getEffdt() + "', " +
															Solicitud.getNumPedido() + ", '" +
															Solicitud.GetYesNo() + "', '" +
															Solicitud.getFecha_envio() + "')";
		String sqlStringPedidoProveedor = "insert into pedido_proveedor value('" + Solicitud.getEffdt() + "'," +
															Solicitud.getNumPedido() + " , '" +
															Proveedor + "')";
		
		try{
			stm.executeUpdate(sqlStringPedido);
			stm.executeUpdate(sqlStringPedidoProveedor);
			String sqlSringPedidoMt;
			for(MateriaPrimaSolicitudDTO mts:MateriasPrimas){
				sqlSringPedidoMt = "insert into pedido_mp value('" + Solicitud.getEffdt() + "', " + 
																Solicitud.getNumPedido() + ", '" +
																mts.getMateriaPrima() + "', " +
																mts.getCantidad() + ")";
				stm.executeUpdate(sqlSringPedidoMt);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}
}