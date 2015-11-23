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
		String sqlString = "select c.* from combo c ";
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

	@Override
	public int GetMaxNumCombo() {
		Statement stm = this.conecctor.GetStatement();
		String sqlString = "select max(id) as 'id' from combo";
		ResultSet rs = null;
		int max = 0;
		
		try {
			rs = stm.executeQuery(sqlString);
			
			while(rs.next()) {
				max = rs.getInt("id");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.conecctor.CloseConnection();
		}
		
		return max;
	}
}
