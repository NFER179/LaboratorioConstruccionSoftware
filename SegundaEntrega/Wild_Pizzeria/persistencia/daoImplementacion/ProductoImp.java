package daoImplementacion;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.ProductoDAO;
import dto.ProductoDTO;
import conexion.ConectorDB;

public class ProductoImp implements ProductoDAO {

	private ConectorDB conector;
	
	public ProductoImp() {
		this.conector = ConectorDB.GetInstancia();
	}
	
	@Override
	public List<ProductoDTO> getProductos() {
		
		Statement stm = this.conector.GetStatement();
		String sqlString = "select * from producto";
		ResultSet rs = null;
		List<ProductoDTO> productos = new ArrayList<ProductoDTO>();
		
		try {
			rs = stm.executeQuery(sqlString);
			
			while (rs.next()) {
				productos.add(new ProductoDTO(rs.getString("product_id"), rs.getString("descripcion")));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			this.conector.CloseConnection();
		}
		
		return productos;
	}

	@Override
	public String GetDescipcion(String Producto) {
		
		Statement stm = this.conector.GetStatement();
		String sqlString = "select descripcion from producto where product_id = '" + Producto + "'";
		ResultSet rs = null;
		String descr = "";
		
		try {
			rs = stm.executeQuery(sqlString);
			
			while(rs.next()) {
				descr = rs.getString("descripcion");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			this.conector.CloseConnection();
		}
		
		return descr;
	}
}