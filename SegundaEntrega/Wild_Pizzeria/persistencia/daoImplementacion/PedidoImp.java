package daoImplementacion;

import conexion.ConectorDB;
import dao.PedidoDAO;
import dto.PedidoDTO;
import dto.ProductoEnPedidoDTO;

import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PedidoImp implements PedidoDAO{

	private ConectorDB conector;
	
	public PedidoImp() {
		this.conector = ConectorDB.GetInstancia();
	}
	
	private boolean toBoolean(String arg0) {
		if ( arg0.equals("Y") )
			return true;
		else
			return false;
	}
	
	@Override
	public List<PedidoDTO> pedidosPendientes() {
		
		Statement stm = this.conector.GetStatement();
		String stmString = "select * from pedido where estado = 'pendiente'";
		ResultSet rs = null;
		List<PedidoDTO> pedidosPendientes = new ArrayList<PedidoDTO>();
		
		try {
			rs = stm.executeQuery(stmString);
			
			while (rs.next()) {
				pedidosPendientes.add(new PedidoDTO(rs.getInt("num_pedido"), 
						rs.getString("cliente"), 
						rs.getString("direccion"), 
						rs.getInt("precio"),
						rs.getString("fecha_hora"),
						rs.getString("estado"), 
						rs.getString("observaciones"), 
						this.toBoolean(rs.getString("delivery")))
						);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {//Se ejecuta siempre
			this.conector.CloseConnection();
		}
		return pedidosPendientes;
	}

	@Override
	public int UltimoNumPedido() {
		
		Statement stm = this.conector.GetStatement();
		String sqlString = "select max(num_pedido) from pedido";
		ResultSet rs = null;
		int NumPedido = 0;
		
		try {
			rs = stm.executeQuery(sqlString);
			while (rs.next()) {
				NumPedido = rs.getInt(1);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			this.conector.CloseConnection();
		}
		
		return NumPedido;
	}
	
	@Override
	public void CrearNuevoPedido(PedidoDTO Pedido) {
		
		Statement stm = this.conector.GetStatement();
		String sqlString = "insert into pedido values("+Pedido.getNumPedido()+",'"
				+Pedido.getCliente()+"','"
				+Pedido.getDireccion()+"',"
				+Pedido.getPrecio()+",'"
				+Pedido.getFecha_hora()+"','"
				+Pedido.getEstado()+"','"
				+Pedido.getObservacion()+"','"
				+Pedido.getStringDelivery()+"')";
		
		try {
			stm.executeUpdate(sqlString);
			
			for (ProductoEnPedidoDTO p:Pedido.getProductos()) {
				stm.executeUpdate("insert into producto_pedido value("+Pedido.getNumPedido()+",'"
						+p.getProducto()+"','"
						+p.getSabor()+"',"
						+p.getCantidad()+")");
			}
		}
		catch(Exception e) {
			/*podria ser un eliminar todas las lineas que tengan el numde pedido.*/
			e.printStackTrace();
		}
		
		finally {
			this.conector.CloseConnection();
		}
	}
}
