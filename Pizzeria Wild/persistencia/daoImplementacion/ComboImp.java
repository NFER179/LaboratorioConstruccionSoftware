package daoImplementacion;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.ComboModelo;

import conexion.ConectorDB;
import dao.ComboDAO;
import dto.ComboActivoDTO;
import dto.ComboDTO;
import dto.ComboProductoDTO;

public class ComboImp implements ComboDAO{
	
	private ConectorDB conector = ConectorDB.GetInstancia();

	@Override
	public List<ComboDTO> GetCombos() {
		Statement stm = this.conector.GetStatement();
		String sqlString = "select c.* from combo c ";
		ResultSet rs = null;
		List<ComboDTO> combos = new ArrayList<ComboDTO>();
		
		try{
			rs = stm.executeQuery(sqlString);
			
			while(rs.next()) {
				int Id = rs.getInt("id");
				String Descripcion = rs.getString("descr");
				
				ComboDTO c = new ComboDTO(Id, Descripcion);
				combos.add(c);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.conector.CloseConnection();
		}
		
		return combos;
	}

	@Override
	public int GetMaxNumCombo() {
		Statement stm = this.conector.GetStatement();
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
			this.conector.CloseConnection();
		}
		
		return max;
	}

	@Override
	public int GetCountRowFor(ComboDTO c) {
		Statement  stm = this.conector.GetStatement();
		String sqlString = "select count(*) as 'cantidad' from combo " +
							"where id = " + c.getId();
		ResultSet rs = null;
		int count = 0;
		
		try {
			rs = stm.executeQuery(sqlString);
			
			while(rs.next()) {
				count = rs.getInt("cantidad");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.conector.CloseConnection();
		}
		
		return count;
	}

	@Override
	public void Insert(ComboDTO c) {
		Statement stm = this.conector.GetStatement();
		String sqlString = "insert into combo value("+c.getId()+", '"+c.getDescripcion()+"')";
		
		try{
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
	public void InsertEffdt(ComboActivoDTO cActivo) {
		Statement stm = this.conector.GetStatement();
		String sqlString = "insert into combo_activo value( "+
							cActivo.getComboId()+", '"+
							cActivo.getEfft()	+"', "+
							cActivo.getPrecio()	+", '"+
							ComboModelo.ShortDesciption(cActivo.isActivo())	+"') ";
		
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
	public void UpdateEffdt(ComboActivoDTO cActivo) {
		Statement stm = this.conector.GetStatement();
		String sqlString = "update combo_activo set precio = " + cActivo.getPrecio() +
							", estado = '" + ComboModelo.ShortDesciption(cActivo.isActivo()) + "' " +
							"where combo_id = "+ cActivo.getComboId() +" and effdt = '" + cActivo.getEfft() + "'";
		
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
	public void DeleteProductos(ComboActivoDTO cActivo) {
		Statement stm = this.conector.GetStatement();
		String sqlDelete = "delete from combo_producto where combo_id = " + cActivo.getComboId() + " and effdt = '" + cActivo.getEfft() + "'";
		
		try {
			stm.executeUpdate(sqlDelete);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.conector.CloseConnection();
		}
	}

	@Override
	public void InsertProducto(ComboProductoDTO cp) {
		Statement stm = this.conector.GetStatement();
		String sqlString = "insert into combo_producto value("+
							cp.getId()			+", '"+
							cp.getEffdt()		+"', '"+
							cp.getProducto()	+"', '"+
							cp.getSabor()		+"', "+
							cp.getCantidad()	+")";
		
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
	public List<ComboProductoDTO> GetProductos(ComboActivoDTO cActivo) {
		Statement stm = this.conector.GetStatement();
		String sqlString = "select * from combo_producto where combo_id = " + cActivo.getComboId() + " and effdt = '" + cActivo.getEfft() + "'";
		ResultSet rs = null;
		List<ComboProductoDTO> ps = new ArrayList<ComboProductoDTO>();
		
		try {
			rs = stm.executeQuery(sqlString);
			
			while(rs.next()) {
				String Producto = rs.getString("product_id");
				String Sabor = rs.getString("sabor");
				int Cantidad = rs.getInt("cantidad");
				
				ComboProductoDTO cp = new ComboProductoDTO(cActivo.getComboId(), cActivo.getEfft(), Producto, Sabor, Cantidad);
				
				ps.add(cp);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.conector.CloseConnection();
		}
		return ps;
	}

	@Override
	public List<ComboActivoDTO> GetCurrentCombos(ComboDTO combo) {
		Statement stm = this.conector.GetStatement();
		String sqlString = "select a.* from combo_activo a " +
							"where a.effdt >= (select max(b.effdt)" +
							"					from combo_activo b" +
							"					where a.combo_id = b.combo_id" +
							"					  and b.effdt <= curdate()) " +
							"and a.combo_id = " + combo.getId();
		ResultSet rs = null;
		List<ComboActivoDTO> aclist = new ArrayList<ComboActivoDTO>();
		
		try {
			rs = stm.executeQuery(sqlString);
			
			while(rs.next()) {
				String Effdt = rs.getString("effdt");
				int Precio = rs.getInt("precio");
				boolean Activo = ComboModelo.ToBoolean(rs.getString("estado"));
				
				ComboActivoDTO ca = new ComboActivoDTO(combo.getId(), Effdt, Precio, Activo);
				
				aclist.add(ca);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			this.conector.CloseConnection();
		}
		
		return aclist;
	}

	@Override
	public void UpdateDescripcion(ComboDTO c) {
		Statement stm = this.conector.GetStatement();
		String sqlString = "update combo set descr = '" + c.getDescripcion() + "' where id = " + c.getId();
		
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
	public void DeleteEffdt(ComboActivoDTO cActivo) {
		this.DeleteProductos(cActivo);
		Statement stm = this.conector.GetStatement();
		String sqlString = "delete from combo_activo where combo_id = "+cActivo.getComboId()+" and effdt = '"+cActivo.getEfft()+"'";
		
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
