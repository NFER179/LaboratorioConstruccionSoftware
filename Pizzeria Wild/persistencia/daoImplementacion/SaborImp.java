package daoImplementacion;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.SaborDAO;
import dto.SaborDTO;
import conexion.ConectorDB;

public class SaborImp implements SaborDAO {

	private ConectorDB conector;
	
	public SaborImp() {
		this.conector = ConectorDB.GetInstancia();
	}
	
	@Override
	public List<SaborDTO> GetSabores(String Producto) {
		
		Statement stm = this.conector.GetStatement();
		String sqlString = "select * from sabor_producto where product_id = '" + Producto + "'";
		ResultSet rs = null;
		List<SaborDTO> sabores = new ArrayList<SaborDTO>();
		
		try {
			rs = stm.executeQuery(sqlString);
			
			while (rs.next()) {
				sabores.add(new SaborDTO(rs.getString("sabor"), rs.getInt("precio")));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			this.conector.CloseConnection();
		}
		
		return sabores;
	}
	
	@Override
	public int GetPrecio(String Producto, String Sabor) {
		
		Statement stm = this.conector.GetStatement();
		String sqlString = "select precio from sabor_producto where product_id = '" + Producto 
				+ "' and sabor = '" + Sabor + "'";
		ResultSet rs = null;
		int precio = 0;
		
		try {
			rs = stm.executeQuery(sqlString);
			
			while (rs.next()) {
				precio = rs.getInt("precio");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		finally{
			this.conector.CloseConnection();
		}
		
		return precio;
	}
}
