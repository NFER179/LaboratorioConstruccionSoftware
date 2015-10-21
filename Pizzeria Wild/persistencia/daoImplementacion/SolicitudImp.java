package daoImplementacion;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexion.ConectorDB;
import dao.SolicitudDAO;
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
				
				solicitudes.add(new SolicitudDTO(fechaPedido, numPedido, enviado));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.conector.CloseConnection();
		}
		
		return solicitudes;
	}
}
