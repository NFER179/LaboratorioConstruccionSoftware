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
	public List<PedidoDTO> PedidoPendientesEntregar() {
		
		Statement stm = this.conector.GetStatement();
		String sqlString = "select * from pedido where estado <> 'Cancelado' and estado <> 'Facturado'";
		ResultSet rs = null;
		List<PedidoDTO> pedidos = new ArrayList<PedidoDTO>();
		
		try {
			rs = stm.executeQuery(sqlString);
			
			while (rs.next()) {
				pedidos.add(new PedidoDTO(rs.getInt("num_pedido"), 
						rs.getString("cliente"), 
						rs.getString("direccion"),
						rs.getString("tel_Cliente"),
						rs.getInt("precio"),
						rs.getString("fecha_hora"),
						rs.getString("estado"), 
						rs.getString("observaciones"), 
						this.toBoolean(rs.getString("delivery"))));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			this.conector.CloseConnection();
		}
		
		return pedidos;
	}
	
	@Override
	public List<PedidoDTO> pedidosPendientesCocina() {
		
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
						rs.getString("tel_Cliente"),
						rs.getInt("precio"),
						rs.getString("fecha_hora"),
						rs.getString("estado"), 
						rs.getString("observaciones"), 
						this.toBoolean(rs.getString("delivery"))));
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
				+Pedido.getDireccion()+"','"
				+Pedido.getTel()+"',"
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
	
	@Override
	public void CancelarPedido(int NumPedido) {
		
		Statement stm = this.conector.GetStatement();
		String sqlString = "update pedido set estado = 'cancelado' where num_pedido = '" + NumPedido + "'";
		
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
	public void ModificarPedido(PedidoDTO Pedido) {
		
		Statement stm = this.conector.GetStatement();
		String sqlString = "update pedido set cliente = '" + Pedido.getCliente()
				+ "', direccion = '" + Pedido.getCliente()
				+ "', tel_cliente = '" + Pedido.getTel()
				+ "', precio = " + Pedido.getPrecio()
				+ ", estado = 'Pendiente'"
				+ ", observaciones = '" + Pedido.getObservacion()
				+ "', delivery = '" + Pedido.getStringDelivery()
				+ "' where num_pedido = '" + Pedido.getNumPedido() + "'";
		
		try {
			stm.executeUpdate(sqlString);
			
			stm.execute("delete from producto_pedido where num_pedido = " + Pedido.getNumPedido());
			
			for (ProductoEnPedidoDTO p:Pedido.getProductos()) {
				stm.executeUpdate("insert into producto_pedido value("+Pedido.getNumPedido()+",'"
						+p.getProducto()+"','"
						+p.getSabor()+"',"
						+p.getCantidad()+")");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public PedidoDTO GetPedido(int Pedido) {
		Statement stm = this.conector.GetStatement();
		String sqlString = "select * from pedido where num_pedido = " + Pedido;
		String sqlString2 = "select * from producto_pedido where num_pedido = " + Pedido;
		ResultSet rs = null;
		PedidoDTO pedido = null;
		
		try {
			rs = stm.executeQuery(sqlString);
			
			while (rs.next()) {
				pedido = new PedidoDTO(Pedido, 
						rs.getString("cliente"), 
						rs.getString("direccion"), 
						rs.getString("tel_cliente"),
						rs.getInt("precio"), 
						rs.getString("fecha_hora"), 
						rs.getString("estado"), 
						rs.getString("observaciones"), 
						toBoolean(rs.getString("delivery")));
			}
			
			rs = stm.executeQuery(sqlString2);
			
			while (rs.next()) {
				pedido.agregarProducto(rs.getString("producto"), 
									rs.getString("sabor"), 
									rs.getInt("cantidad"));
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			this.conector.CloseConnection();
		}
		
		return pedido;
	}

	@Override
	public void FacturarPedido(int NumPedido) {
		
		Statement stm = this.conector.GetStatement();
		String sqlString = "update pedido set estado = 'facturado' where num_pedido = '"+ NumPedido +"'";
		
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
	public void PedidoArmado(int NumPedido) {
		
		Statement stm = this.conector.GetStatement();
		String sqlString = "update pedido set estado = 'armado' where num_pedido = '" + NumPedido + "'";
		
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