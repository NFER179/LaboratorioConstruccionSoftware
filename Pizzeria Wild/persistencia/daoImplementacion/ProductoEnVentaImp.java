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
		String sqlString = "select vp.* from venta_producto vp where "
				+ "vp.producto in (select p.product_id from producto p where p.cocina = 'Y') "
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
		String sqlString = "select vp.producto, vp.sabor, sum(vp.cantidad) as 'cantidad' "
				+ "from venta p, venta_producto vp "
				+ "where p.effdt = vp.effdt "
				+ "and p.num_venta = vp.num_venta "
				+ "and p.estado = 'Pendiente' "
				+ "and vp.producto in (select p1.product_id from producto p1 where p1.cocina = 'Y') "
				+ "group by vp.producto, vp.sabor";
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
}