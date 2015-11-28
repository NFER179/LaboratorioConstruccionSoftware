package daoImplementacion;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexion.ConectorDB;

import dao.ProductoEnVentaDAO;
import dto.ProductoEnVentaDTO;

public class ProductoEnVentaImp implements ProductoEnVentaDAO {

	private ConectorDB conector;

	public ProductoEnVentaImp() {
		this.conector = ConectorDB.GetInstancia();
	}

	@Override
	public List<ProductoEnVentaDTO> GetProductosPara(String Fecha, int Venta) {

		Statement stm = this.conector.GetStatement();
//		String sqlString = "select vp.* from venta_producto vp where "
//				+ "vp.producto in (select p.product_id from producto p where p.cocina = 'Y') "
//				+ "and vp.effdt = '" + Fecha + "' and vp.num_venta = " + Venta;
		String sqlString = "select productos_cocina.effdt " +
							", productos_cocina.num_venta " +
							", productos_cocina.producto " +
							", productos_cocina.sabor " +
							", sum(productos_cocina.cantidad) as cantidad " +
							"from (" +
							"select vp.effdt " +
							", vp.num_venta " +
							", vp.producto " +
							", vp.sabor " +
							", vp.cantidad " +
							"from venta_producto vp " +
							", venta v " +
							"where vp.producto in (select p.product_id " +
							"						from producto p " +
							"						where p.cocina = 'Y') " +
							"and v.effdt = vp.effdt " +
							"and v.num_venta = vp.num_venta " +
							"and v.estado = 'Pendiente' " +
							"union " +
							"select a.effdt, a.num_venta, d.product_id, d.sabor, (b.cantidad * d.cantidad) " + 
							"from venta a " +
							", combo_venta b " +
							", combo_activo c " +
							", combo_producto d " +
							", producto e " +
							"where a.effdt = b.effdt " +
							"  and a.num_venta = b.num_venta " +
							"  and a.estado = 'Pendiente' " +
							"  and b.combo_id = c.combo_id " +
							"  and c.effdt = (select max(c1.effdt) " +
							"  		from combo_activo c1 " +
							"  		where c1.combo_id = c.combo_id " +
							"  		  and c1.effdt <= a.effdt) " +
							"  and d.combo_id = c.combo_id " +
							"  and d.effdt = c.effdt " +
							"  and e.product_id = d.product_id " +
							"  and e.cocina = 'Y') productos_cocina " +
							"where productos_cocina.effdt = '" + Fecha + "'" +
							"  and productos_cocina.num_venta = " + Venta + " " +
							"group by productos_cocina.effdt ,productos_cocina.num_venta ,productos_cocina.producto ,productos_cocina.sabor";
		ResultSet rs = null;
		List<ProductoEnVentaDTO> productos = new ArrayList<ProductoEnVentaDTO>();

		try {
			rs = stm.executeQuery(sqlString);

			while (rs.next()) {
				productos.add(new ProductoEnVentaDTO(rs.getString("producto"),
						rs.getString("sabor"), rs.getInt("cantidad")));
			}

		} catch (Exception e) {
			System.out.println(sqlString);
			e.printStackTrace();
		}

		finally {
			this.conector.CloseConnection();
		}

		return productos;
	}

	@Override
	public List<ProductoEnVentaDTO> GetProductosNoCocina(String Fecha, int Venta) {

		Statement stm = this.conector.GetStatement();
		String sqlString = "select vp.* from venta_producto vp where "
				+ "vp.producto in (select p.product_id from producto p where p.cocina = 'N') "
				+ "and vp.effdt = '" + Fecha + "' and vp.num_venta = " + Venta;
		ResultSet rs = null;
		List<ProductoEnVentaDTO> productos = new ArrayList<ProductoEnVentaDTO>();

		try {
			rs = stm.executeQuery(sqlString);

			while (rs.next()) {
				productos.add(new ProductoEnVentaDTO(rs.getString("producto"),
						rs.getString("sabor"), rs.getInt("cantidad")));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			this.conector.CloseConnection();
		}

		return productos;
	}

	@Override
	public List<ProductoEnVentaDTO> GetFaltantesElabracion() {

		Statement stm = this.conector.GetStatement();
//		String sqlString = "select vp.producto, vp.sabor, sum(vp.cantidad) as 'cantidad' "
//				+ "from venta p, venta_producto vp "
//				+ "where p.effdt = vp.effdt "
//				+ "and p.num_venta = vp.num_venta "
//				+ "and p.estado = 'Pendiente' "
//				+ "and vp.producto in (select p1.product_id from producto p1 where p1.cocina = 'Y') "
//				+ "group by vp.producto, vp.sabor";
		String sqlString = "select productos_cocina.producto as 'producto' " +
				", productos_cocina.sabor 'sabor' " +
				", sum(productos_cocina.cantidad) as 'cantidad' " + 
				"from ( " +
				"select vp.producto " +
				", vp.sabor " +
				", sum(vp.cantidad) as 'cantidad' " +
				"from venta p " +
				", venta_producto vp " +
				"where p.effdt = vp.effdt " +
				"  and p.num_venta = vp.num_venta " +
				"  and p.estado = 'Pendiente' " +
				"  and vp.producto in (select p1.product_id from producto p1 where p1.cocina = 'Y') " +
				"group by vp.producto, vp.sabor " + 
				"union " +
				"select d.product_id " +
				", d.sabor " +
				", sum((b.cantidad * d.cantidad)) as 'cantidad' " +
				"from venta a " +
				", combo_venta b " +
				", combo_activo c " +
				", combo_producto d " +
				", producto e " +
				"where a.effdt = b.effdt " +
				"  and a.num_venta = b.num_venta " +
				"  and b.combo_id = c.combo_id " +
				"  and a.estado = 'Pendiente' " +
				"  and c.effdt = (select max(c1.effdt) " +
				"  		from combo_activo c1 " +
				"  		where c1.combo_id = c.combo_id " +
				"  		  and c1.effdt <= a.effdt) " +
				"  and d.combo_id = c.combo_id " +
				"  and d.effdt = c.effdt " +
				"  and e.product_id = d.product_id " +
				"  and e.cocina = 'Y' " +
				"group by d.product_id, d.sabor) productos_cocina " +
				"group by productos_cocina.producto ,productos_cocina.sabor";
		ResultSet rs = null;
		List<ProductoEnVentaDTO> productos = new ArrayList<ProductoEnVentaDTO>();

		try {
			rs = stm.executeQuery(sqlString);
			while (rs.next()) {
				productos.add(new ProductoEnVentaDTO(rs.getString("producto"),
						rs.getString("sabor"), rs.getInt("cantidad")));
			}

		} catch (Exception e) {
			System.out.println(sqlString);
			e.printStackTrace();
		}

		finally {
			this.conector.CloseConnection();
		}

		return productos;
	}
}