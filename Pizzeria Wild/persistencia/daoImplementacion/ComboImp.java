package daoImplementacion;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexion.ConectorDB;
import dao.ComboDAO;
import dto.ComboDTO;

public class ComboImp implements ComboDAO{
	
	private ConectorDB conecctor = ConectorDB.GetInstancia();

	@Override
	public List<ComboDTO> GetActivos() {
		Statement stm = this.conecctor.GetStatement();
		String sqlString = "select c.* from combo c " +
							"where c.effdt = (select max(c1.effdt) from combo c1 " +
											"where c1.combo_id = c.combo_id" +
											"and c1.effdt <= curdate()) " +
							"and c.estado = 'Y'";
		ResultSet rs = null;
		List<ComboDTO> combos = new ArrayList<ComboDTO>();
		
		try{
			rs = stm.executeQuery(sqlString);
			
			while(rs.next()) {
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.conecctor.CloseConnection();
		}
		
		return combos;
	}
}
