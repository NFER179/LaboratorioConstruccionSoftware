package daoImplementacion;

import conexion.ConectorDB;
import dao.VentaDAO;
import dto.VentaDTO;
import dto.ProductoEnVentaDTO;

import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import utilidades.Fecha;

public class VentaImp implements VentaDAO{

	private ConectorDB conector;
	
	public VentaImp() {
		this.conector = ConectorDB.GetInstancia();
	}
	
	private boolean toBoolean(String arg0) {
		if ( arg0.equals("Y") )
			return true;
		else
			return false;
	}
	
	@Override
	public List<VentaDTO> VentasPendientesEntregar() {
		
		Statement stm = this.conector.GetStatement();
		String sqlString = "select * from venta where estado <> 'Cancelado' and estado <> 'Facturado'";
		ResultSet rs = null;
		List<VentaDTO> ventas = new ArrayList<VentaDTO>();
		
		try {
			rs = stm.executeQuery(sqlString);
			
			while (rs.next()) {
				ventas.add(new VentaDTO(rs.getString("effdt"), 
						rs.getInt("num_venta"), 
						rs.getString("cliente"), 
						rs.getString("direccion"),
						rs.getString("tel_Cliente"),
						rs.getInt("precio"),
						rs.getString("hora"),
						rs.getString("estado"), 
						rs.getString("observaciones"), 
						this.toBoolean(rs.getString("delivery")),
						rs.getString("obs_delivery")));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			this.conector.CloseConnection();
		}
		
		return ventas;
	}
	
	@Override
	public List<VentaDTO> VentasPendientesCocina() {
		
		Statement stm = this.conector.GetStatement();
		String stmString = "select * from venta where estado = 'pendiente' order by effdt, num_venta";
		ResultSet rs = null;
		List<VentaDTO> ventassPendientes = new ArrayList<VentaDTO>();
		
		try {
			rs = stm.executeQuery(stmString);
			
			while (rs.next()) {
				ventassPendientes.add(new VentaDTO(rs.getString("effdt"), 
						rs.getInt("num_venta"), 
						rs.getString("cliente"), 
						rs.getString("direccion"),
						rs.getString("tel_Cliente"),
						rs.getInt("precio"),
						rs.getString("hora"),
						rs.getString("estado"), 
						rs.getString("observaciones"), 
						this.toBoolean(rs.getString("delivery")),
						rs.getString("obs_delivery")));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {//Se ejecuta siempre
			this.conector.CloseConnection();
		}
		return ventassPendientes;
	}

	@Override
	public int UltimoNumVenta(String Fecha) {
		
		Statement stm = this.conector.GetStatement();
		String sqlString = "select max(num_venta) from venta where effdt = '" + Fecha + "'";
		ResultSet rs = null;
		int NumVenta = 0;
		
		try {
			rs = stm.executeQuery(sqlString);
			while (rs.next()) {
				NumVenta = rs.getInt(1);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			this.conector.CloseConnection();
		}
		
		return NumVenta;
	}
	
	@Override
	public void CrearNuevaVenta(VentaDTO Venta) {
		
		Statement stm = this.conector.GetStatement();
		String sqlString = "insert into venta values('" + Venta.getFecha() +"', "
				+Venta.getNumVenta()+",'"
				+Venta.getCliente()+"','"
				+Venta.getDireccion()+"','"
				+Venta.getTel()+"',"
				+Venta.getPrecio()+",'"
				+Venta.getHora()+"','"
				+Venta.getEstado()+"','"
				+Venta.getObservacion()+"','"
				+Venta.getStringDelivery()+"', '"
				+Venta.getObservacionDelivery()+"')";
		
		try {
			stm.executeUpdate(sqlString);
			
			for (ProductoEnVentaDTO p:Venta.getProductos()) {
				stm.executeUpdate("insert into venta_producto value('"+ Venta.getFecha()+"',"
						+Venta.getNumVenta()+",'"
						+p.getProducto()+"','"
						+p.getSabor()+"',"
						+p.getCantidad()+")");
			}
		}
		catch(Exception e) {
			/*podria ser un eliminar todas las lineas que tengan el num de venta.*/
			e.printStackTrace();
		}
		
		finally {
			this.conector.CloseConnection();
		}
	}
	
	@Override
	public void CancelarVenta(String Fecha, int NumVenta) {
		
		Statement stm = this.conector.GetStatement();
		String sqlString = "update venta set estado = 'cancelado' where effdt = '"+ Fecha +"' and num_venta = '" + NumVenta + "'";
		
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
	public void ModificarVenta(VentaDTO Venta) {
		
		Statement stm = this.conector.GetStatement();
		String sqlString = "update venta set cliente = '" + Venta.getCliente()
				+ "', direccion = '" + Venta.getCliente()
				+ "', tel_cliente = '" + Venta.getTel()
				+ "', precio = " + Venta.getPrecio()
				+ ", estado = 'Pendiente'"
				+ ", observaciones = '" + Venta.getObservacion()
				+ "', delivery = '" + Venta.getStringDelivery()
				+ "', obs_delivery = '" + Venta.getObservacionDelivery()
				+ "' where effdt = '" + Venta.getFecha() 
				+ "' and num_venta = '" + Venta.getNumVenta() + "'";
		
		try {
			stm.executeUpdate(sqlString);
			
			stm.execute("delete from venta_producto where effdt = '" + Venta.getFecha() + "' and num_venta = " + Venta.getNumVenta());
			
			for (ProductoEnVentaDTO p:Venta.getProductos()) {
				stm.executeUpdate("insert into venta_producto value('" + Venta.getFecha() + "', "
						+Venta.getNumVenta()+",'"
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
	public VentaDTO GetVenta(String Fecha, int Venta) {
		Statement stm = this.conector.GetStatement();
		String sqlString = "select * from venta where effdt = '" + Fecha + "' and num_venta = " + Venta;
		String sqlString2 = "select * from venta_producto where effdt = '" + Fecha + "' and num_venta = " + Venta;
		ResultSet rs = null;
		VentaDTO venta = null;
		
		try {
			rs = stm.executeQuery(sqlString);
			
			while (rs.next()) {
				venta = new VentaDTO(rs.getString("effdt"),
						rs.getInt("num_venta"),
						rs.getString("cliente"), 
						rs.getString("direccion"), 
						rs.getString("tel_cliente"),
						rs.getInt("precio"), 
						rs.getString("hora"), 
						rs.getString("estado"), 
						rs.getString("observaciones"), 
						toBoolean(rs.getString("delivery")),
						rs.getString("obs_delivery"));
			}
			
			rs = stm.executeQuery(sqlString2);
			
			while (rs.next()) {
				venta.agregarProducto(rs.getString("producto"), 
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
		
		return venta;
	}

	@Override
	public void FacturarVenta(String Fecha, int NumVenta) {
		
		Statement stm = this.conector.GetStatement();
		String sqlString = "update venta set estado = 'facturado' where effdt = '" + Fecha + "' and num_venta = "+ NumVenta;
		
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
	public void VentaArmado(String Fecha, int NumVenta) {
		
		Statement stm = this.conector.GetStatement();
		String sqlString = "update venta set estado = 'armado' where effdt = '" + Fecha + "' and num_venta = " + NumVenta;
		
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
	public void EnviarVentas(List<VentaDTO> Ventas) {
		
		Statement stm = this.conector.GetStatement();
		String sqlString;
		
		for(VentaDTO venta:Ventas){
			sqlString = "update venta set estado = 'viaje' where effdt = '" + venta.getFecha() + "' and num_venta = " + venta.getNumVenta();
			
			try {
				stm.executeUpdate(sqlString);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		this.conector.CloseConnection();
	}
	
	@Override
	public List<VentaDTO> GetVentasEnViaje() {
		
		Statement stm = this.conector.GetStatement();
		String sqlString = "select * from venta where estado = 'Viaje'";
		ResultSet rs = null;
		List<VentaDTO> ventas = new ArrayList<VentaDTO>();
		
		try {
			rs = stm.executeQuery(sqlString);
			
			while(rs.next()) {
				ventas.add(new VentaDTO(rs.getString("effdt"), 
									rs.getInt("num_venta"), 
									rs.getString("cliente"), 
									rs.getString("direccion"), 
									rs.getString("tel_cliente"), 
									rs.getInt("precio"), 
									rs.getString("hora"), 
									rs.getString("estado"), 
									rs.getString("observaciones"), 
									this.toBoolean(rs.getString("delivery")),
									rs.getString("obs_delivery")));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		finally {
			this.conector.CloseConnection();
		}
		
		return ventas;
	}

	@Override
	public int GetCantidadFacturadas(String FromDate, String ToDate) {
		
		Statement stm = this.conector.GetStatement();
		String sqlString = "select count(*) as 'cantidad' from venta " +
							"where estado = 'Facturado' " +
							"and effdt between '" + FromDate + "' and '" + ToDate + "'";
		ResultSet rs = null;
		int Cantidad = 0;
		
		try{
			rs = stm.executeQuery(sqlString);
			
			while(rs.next()) {
				Cantidad = rs.getInt("cantidad");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.conector.CloseConnection();
		}
		
		return Cantidad;
	}

	@Override
	public List<VentaDTO> GetFacturadas(String FromDate, String ToDate) {
		
		Statement stm = this.conector.GetStatement();
		String sqlString = "select * from venta where estado = 'Facturado' " +
				"and effdt between '" + FromDate + "' and '" + ToDate + "'";
		ResultSet rs = null;
		List<VentaDTO> facturadas = new ArrayList<VentaDTO>();
		
		try{
			rs = stm.executeQuery(sqlString);
			
			while(rs.next()) {
				facturadas.add(new VentaDTO(rs.getString("effdt"), 
									rs.getInt("num_venta"), 
									rs.getString("cliente"), 
									rs.getString("direccion"), 
									rs.getString("tel_cliente"), 
									rs.getInt("precio"), 
									rs.getString("hora"), 
									rs.getString("estado"), 
									rs.getString("observaciones"), 
									this.toBoolean(rs.getString("delivery")),
									rs.getString("obs_delivery")));
			}
				
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.conector.CloseConnection();
		}
		
		return facturadas;
	}

	@Override
	public int GetGananciaFacturadas(String FromDate, String ToDate) {
		
		Statement stm = this.conector.GetStatement();
		String sqlString = "select sum(precio) as 'ganancia' from venta " +
							"where estado = 'Facturado' " +
							"and effdt between '" + FromDate + "' and '" + ToDate + "'";
		ResultSet rs = null;
		int ganancia = 0;
		
		try{
			rs = stm.executeQuery(sqlString);
			
			while(rs.next()) {
				ganancia = rs.getInt("ganancia");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.conector.CloseConnection();
		}
		
		return ganancia;
	}

	@Override
	public int GetCantidadCanceladas(String FromDate, String ToDate) {
		
		Statement stm = this.conector.GetStatement();
		String sqlString = "select count(*) as 'cantidad' from venta " +
							"where estado = 'Cancelado' " +
							"and effdt between '" + FromDate + "' and '" + ToDate + "'";
		ResultSet rs = null;
		int cantidad = 0;

		try{
			rs = stm.executeQuery(sqlString);
			
			while(rs.next()) {
				cantidad = rs.getInt("cantidad");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.conector.CloseConnection();
		}
		
		return cantidad;
	}

	@Override
	public List<VentaDTO> GetCanceladas(String FromDate, String ToDate) {
		
		Statement stm = this.conector.GetStatement();
		String sqlString = "select * from venta where estado = 'Cancelado' " +
				"and effdt between '" + FromDate + "' and '" + ToDate + "'";
		ResultSet rs = null;
		List<VentaDTO> canceladas = new ArrayList<VentaDTO>();
		
		try{
			rs = stm.executeQuery(sqlString);
			
			while(rs.next()) {
				canceladas.add(new VentaDTO(rs.getString("effdt"), 
									rs.getInt("num_venta"), 
									rs.getString("cliente"), 
									rs.getString("direccion"), 
									rs.getString("tel_cliente"), 
									rs.getInt("precio"), 
									rs.getString("hora"), 
									rs.getString("estado"), 
									rs.getString("observaciones"), 
									this.toBoolean(rs.getString("delivery")),
									rs.getString("obs_delivery")));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.conector.CloseConnection();
		}
		
		return canceladas;
	}

	@Override
	public int GetPerdidas(String FromDate, String ToDate) {
		
		Statement stm = this.conector.GetStatement();
		String sqlString = "select sum(precio) as 'total' from venta where estado = 'Cancelado' " +
				"and effdt between '" + FromDate + "' and '" + ToDate + "'";
		ResultSet rs = null;
		int perdidas = 0;
		
		try {
			rs = stm.executeQuery(sqlString);
			
			while(rs.next()) {
				perdidas = rs.getInt("total");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.conector.CloseConnection();
		}
		
		return perdidas;
	}

	@Override
	public List<VentaDTO> GetAllVentas() {
		
		Statement stm = this.conector.GetStatement();
		String sqlString = "select * from venta";
		ResultSet rs = null;
		List<VentaDTO> ventas = new ArrayList<VentaDTO>();
		
		try{
			rs = stm.executeQuery(sqlString);
			
			while(rs.next()) {
				String Fecha = rs.getString("effdt");
				int NumVenta = rs.getInt("num_venta");
				String Cliente = rs.getString("cliente");
				String Direccion = rs.getString("direccion");
				String Tel = rs.getString("tel_cliente");
				int Precio = rs.getInt("precio");
				String Hora = rs.getString("hora");
				String Estado = rs.getString("estado");
				String Observacion = rs.getString("Observaciones");
				boolean Delivery = this.toBoolean(rs.getString("delivery"));
				String ObservacionDelivery = rs.getString("obs_delivery");
				
				ventas.add(new VentaDTO(Fecha, NumVenta, Cliente, Direccion, Tel, Precio, Hora, Estado, Observacion, Delivery, ObservacionDelivery));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.conector.CloseConnection();
		}
		return ventas;
	}

	@Override
	public String GetFechaInicioVentas() {
		Statement stm = this.conector.GetStatement();
		String sqlString = "select min(effdt) as 'fecha' from venta";
		ResultSet rs = null;
		String fecha = Fecha.CurrentDate();
		
		try {
			rs = stm.executeQuery(sqlString);
			
			while(rs.next()) {
				fecha = rs.getString("fecha");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.conector.CloseConnection();
		}
		
		return fecha;
	}
}