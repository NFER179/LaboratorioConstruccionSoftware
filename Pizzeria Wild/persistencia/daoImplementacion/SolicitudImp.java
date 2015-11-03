package daoImplementacion;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexion.ConectorDB;
import dao.SolicitudDAO;
import dto.MateriaPrimaSolicitudDTO;
import dto.ProveedorDTO;
import dto.SolicitudDTO;

public class SolicitudImp implements SolicitudDAO {

	private ConectorDB conector;
	
	public SolicitudImp(){
		this.conector = ConectorDB.GetInstancia();
	}
	
	@Override
	public List<SolicitudDTO> GetSolicitudesActualesGuardadas() {
		
		Statement stm = this.conector.GetStatement();
		String sqlString = "select p.* from pedido p " +
							"where (p.effdt = curdate() and p.estado = 'Enviado') " +
							"or p.estado = 'Guardado'";
		ResultSet rs = null;
		List<SolicitudDTO> solicitudes = new ArrayList<SolicitudDTO>();
		
		try {
			rs = stm.executeQuery(sqlString);
			
			while(rs.next()) {
				String fechaPedido = rs.getString("effdt");
				int numPedido = Integer.parseInt(rs.getString("num_pedido"));
				String enviado = (rs.getString("estado"));
				String fecha_envio = rs.getString("fecha_envio");
				int refNumPedido = rs.getInt("ref_num_pedido");
				int costo = rs.getInt("costo");
				
				solicitudes.add(new SolicitudDTO(fechaPedido, numPedido, enviado, fecha_envio, refNumPedido, costo));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.conector.CloseConnection();
		}
		
		return solicitudes;
	}

	@Override
	public int GetNuevoNumeroSolicitud(String Fecha) {
		Statement stm = this.conector.GetStatement();
		String sqlString = "select max(p.num_pedido) as 'num_pedido' from pedido p " +
						"where p.effdt = '" + Fecha + "'";
		ResultSet rs = null;
		int numSolicitud = 0;
		
		try{
			rs = stm.executeQuery(sqlString);
			
			while(rs.next()) {
				numSolicitud = rs.getInt("num_pedido") + 1;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.conector.CloseConnection();
		}
		
		return numSolicitud;
	}

	@Override
	public void CrearSolicitud(SolicitudDTO Solicitud, String Proveedor, List<MateriaPrimaSolicitudDTO> MateriasPrimas) {
		Statement stm = this.conector.GetStatement();
		String sqlStringPedido = "insert into pedido value('" + Solicitud.getEffdt() + "', " +
															Solicitud.getNumPedido() + ", '" +
															Solicitud.getEstado() + "', '" +
															Solicitud.getFecha_envio() + "', " +
															Solicitud.getReferenciaNumPedido() + ", " +
															Solicitud.getCosto() + ")";
		String sqlStringPedidoProveedor = "insert into pedido_proveedor value('" + Solicitud.getEffdt() + "'," +
															Solicitud.getNumPedido() + " , '" +
															Proveedor + "')";
		
		try{
			stm.executeUpdate(sqlStringPedido);
			stm.executeUpdate(sqlStringPedidoProveedor);
			String sqlSringPedidoMt;
			for(MateriaPrimaSolicitudDTO mts:MateriasPrimas){
				sqlSringPedidoMt = "insert into pedido_mp value('" + Solicitud.getEffdt() + "', " + 
																Solicitud.getNumPedido() + ", '" +
																mts.getMateriaPrima() + "', " +
																mts.getCantidad() + ")";
				stm.executeUpdate(sqlSringPedidoMt);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}

	@Override
	public boolean Existe(SolicitudDTO Solicitud) {
		
		Statement stm = this.conector.GetStatement();
		String sqlString = "select 'X' from pedido p " +
						"where p.effdt = '" + Solicitud.getEffdt() + "' " +
						"  and p.num_pedido = " + Solicitud.getNumPedido() ;
		ResultSet rs = null;
		boolean existe = false;
		
		try {
			rs = stm.executeQuery(sqlString);
			
			while(rs.next()) {
				existe = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return existe;
	}

	@Override
	public void ActualizarSolicitud(SolicitudDTO Solicitud, String Proveedor, List<MateriaPrimaSolicitudDTO> MateriasPrimas) {
		
		Statement stm = this.conector.GetStatement();
		String deletePedidoMateriaPrima = "delete from pedido_mp " +
										"where effdt = '" + Solicitud.getEffdt() + "' " +
										"and num_pedido = " + Solicitud.getNumPedido();
		String deletePedidoProveedor = "delete from pedido_proveedor " +
										"where effdt = '" + Solicitud.getEffdt() + "' " +
										"and num_pedido = " + Solicitud.getNumPedido();
		String deletePedido = "delete from pedido " +
								"where effdt = '" + Solicitud.getEffdt() + "' " +
								"and num_pedido = " + Solicitud.getNumPedido();
		
		try {
			stm.executeUpdate(deletePedidoMateriaPrima);
			stm.executeUpdate(deletePedidoProveedor);
			stm.executeUpdate(deletePedido);
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.conector.CloseConnection();
		}
		
		this.CrearSolicitud(Solicitud, Proveedor, MateriasPrimas);
	}

	@Override
	public void Enviar(SolicitudDTO Solicitud) {
		
		Statement stm = this.conector.GetStatement();
		String sqlString = "update pedido set estado = 'Enviado' " +
							"where effdt = '" + Solicitud.getEffdt() + "' " +
							"and num_pedido = " + Solicitud.getNumPedido();
		
		try {
			stm.executeUpdate(sqlString);
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.conector.CloseConnection();
		}
	}

	@Override
	public ProveedorDTO GetProveedor(String FechaSolicitud,	String NumeroSolicitud) {
		
		Statement stm = this.conector.GetStatement();
		String sqlString = "select p.* from proveedor p " +
							"where p.proveedor_id = (select pp.proveedor_id from pedido_proveedor pp " +
													"where pp.effdt = '" + FechaSolicitud + "' " +
													"and pp.num_pedido = " + NumeroSolicitud + ")";
		ResultSet rs = null;
		ProveedorDTO proveedor = null;
		
		try{
			rs = stm.executeQuery(sqlString);
			
			while(rs.next()) {
				String ProveedorId = rs.getString("proveedor_id");
				String Nombre = rs.getString("nombre");
				String Telefono = rs.getString("telefono");
				String Mail = rs.getString("mail");
				proveedor = new ProveedorDTO(ProveedorId, Nombre, Telefono, Mail);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.conector.CloseConnection();
		}
		
		return proveedor;
	}

	@Override
	public List<MateriaPrimaSolicitudDTO> GetMaterasPrimasPara(String Fecha, String NumPedido) {
		
		Statement stm = this.conector.GetStatement();
		String sqlString = "select pmp.materia_prima, pmp.cantidad " +
						"from pedido_mp pmp " +
						"where pmp.effdt = '" + Fecha + "' " +
						"and pmp.num_pedido = " + NumPedido;
		ResultSet rs = null;
		List<MateriaPrimaSolicitudDTO> solicitudes = new ArrayList<MateriaPrimaSolicitudDTO>();
		
		try{
			rs = stm.executeQuery(sqlString);
			
			while(rs.next()) {
				String MateriaPrima = rs.getString("materia_prima");
				int Cantidad = rs.getInt("cantidad");
				solicitudes.add(new MateriaPrimaSolicitudDTO(MateriaPrima, Cantidad));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.conector.CloseConnection();
		}
		
		return solicitudes;
	}

	
	@Override
	public void Recepcionar(String Fecha, String NumSolicitud, int Costo) {
		Statement stm = this.conector.GetStatement();
		String sqlString = "update pedido set estado = 'Recibido', costo = " + Costo + " " +
							"where effdt = '" + Fecha + "' " +
							"and num_pedido = '" + NumSolicitud + "'";
		
		try {
			stm.executeUpdate(sqlString);
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.conector.CloseConnection();
		}
	}
}