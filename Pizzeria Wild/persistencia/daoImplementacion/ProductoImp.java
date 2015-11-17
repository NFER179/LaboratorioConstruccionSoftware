package daoImplementacion;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.ProductoModelo;

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
				productos.add(new ProductoDTO(rs.getString("product_id"), rs.getString("descripcion"),
						ProductoModelo.ParseToBoolean(rs.getString("mixta")), 
						ProductoModelo.ParseToBoolean(rs.getString("cocina"))));
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

	@Override
	public void DeleteProducto(String producto) {
		Statement stm = this.conector.GetStatement();
		String deleteSabores = "delete from sabor_producto where product_id = '" + producto + "'";
		String deleteProducto = "delete from producto where product_id = '" + producto + "'";
		
		try {
			stm.executeUpdate(deleteSabores);
			stm.executeUpdate(deleteProducto);
		}
		catch(Exception e) {
			e.printStackTrace();
		                                                                                                                                                }
		finally {
			this.conector.CloseConnection();
		}
	}

	@Override
	public void Insert(ProductoDTO producto) {
		Statement stm = this.conector.GetStatement();
		String sqlString = "insert into producto values('" + producto.getProductoId() + "', '" +
							producto.getDescipcion() + "', '" + 
							ProductoModelo.ParseToShortString(producto.isMixta()) + "', '" + 
							ProductoModelo.ParseToShortString(producto.isElaboraCocina())+ "')";
		
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
	public void Modify(ProductoDTO producto) {
		Statement stm = this.conector.GetStatement();
		String sqlString = "update producto set descripcion = '" + producto.getDescipcion() + "', " +
							"mixta = 'Y' , cocina = '" + ProductoModelo.ParseToShortString(producto.isElaboraCocina()) + "' where product_id = '" + producto.getProductoId() + "'";
		
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
	public ProductoDTO GetProducto(String producto) {
		Statement stm = this.conector.GetStatement();
		String sqlString = "select * from producto where product_id = '" + producto + "'";
		ResultSet rs = null;
		ProductoDTO pr = null;
		
		try {
			rs = stm.executeQuery(sqlString);
			
			while(rs.next()){
				String ProductoId = rs.getString("product_id");
				String Descripcion = rs.getString("descripcion");
				boolean ElaboraCocina = ProductoModelo.ParseToBoolean(rs.getString("cocina"));
				
				pr = new ProductoDTO(ProductoId, Descripcion, false, ElaboraCocina);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.conector.CloseConnection();
		}
		
		return pr;
	}
}