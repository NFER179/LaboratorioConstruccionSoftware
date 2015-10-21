package daoImplementacion;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexion.ConectorDB;

import dao.DeliveryVentaDAO;
import dto.DeliveryVentaDTO;
import dto.VentaDTO;

public class DeliveryVentaImp implements DeliveryVentaDAO {

	private ConectorDB conector;
	
	public DeliveryVentaImp() {
		this.conector = ConectorDB.GetInstancia();
	}
	
	@Override
	public List<DeliveryVentaDTO> VentasParaDelivery(String Fecha, int NumDelivery) {
		
		Statement stm = this.conector.GetStatement();
		String sqlString = "select * from delivery_venta " +
							"where effdt = '" + Fecha + "' " +
							"and num_delivery = " + NumDelivery + " " +
							"and estado = 'pendiente'";
		ResultSet rs = null;
		List<DeliveryVentaDTO> deliveryVentas = new ArrayList<DeliveryVentaDTO>();
		
		try {
			rs = stm.executeQuery(sqlString);
			
			while(rs.next()) {
				deliveryVentas.add(new DeliveryVentaDTO(rs.getString("effdt"), 
									rs.getInt("num_delivery"), 
									rs.getString("fecha_venta"), 
									rs.getInt("num_venta"), 
									rs.getString("estado"), 
									rs.getString("obs_noentregado")));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			this.conector.CloseConnection();
		}
		
		return deliveryVentas;
	}

	public void VentaNoEntregada(String Fecha, int NumVenta, VentaDTO Venta, String Observacion) {
		
		Statement stm = this.conector.GetStatement();
		String sqlString = "update delivery_venta set estado = 'no entregado', obs_noentregado = '" + Observacion + "' " +
						"where effdt = '" + Fecha + "' " +
						"and num_delivery = " + NumVenta + " " +
						"and fecha_venta = '" + Venta.getFecha() + "' " +
						"and num_venta = " + Venta.getNumVenta();

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
