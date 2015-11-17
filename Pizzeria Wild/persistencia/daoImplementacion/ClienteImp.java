package daoImplementacion;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexion.ConectorDB;

import dao.ClienteDAO;
import dto.ClienteDTO;

public class ClienteImp implements ClienteDAO{

	private ConectorDB conector;
	
	public ClienteImp() {
		this.conector = ConectorDB.GetInstancia();
	}
	
	@Override
	public List<ClienteDTO> GetClientes() {
		
		Statement stm;
		String sqlString = "select * from cliente";
		ResultSet rs = null;
		List<ClienteDTO> lstCliente = new ArrayList<ClienteDTO>();
		
		try {
			stm = this.conector.GetStatement();
			rs = stm.executeQuery(sqlString);
			
			while (rs.next()) {
				lstCliente.add(new ClienteDTO(rs.getInt("id_cliente"), rs.getString("nombres"), 
						rs.getString("apellido"), rs.getString("direccion"), rs.getString("tel")));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			this.conector.CloseConnection();
		}
		
		return lstCliente;
	}
	
	@Override
	public ClienteDTO GetCliente(String ClienteID) {
		
		Statement stm;
		String sqlString = "select * from cliente where id_cliente = '" + ClienteID + "'";
		ResultSet rs = null;
		ClienteDTO c = null;
		
		try {
			stm = this.conector.GetStatement();
			rs = stm.executeQuery(sqlString);
			
			while(rs.next()) {
				c = new ClienteDTO(rs.getInt("id_cliente"), rs.getString("nombres"), rs.getString("apellido"), rs.getString("direccion"), rs.getString("tel"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			this.conector.CloseConnection();
		}
		
		return c;
	}

	@Override
	public int GetNewId() {
		Statement stm = this.conector.GetStatement();
		String sqlString = "select max(id_cliente) as 'id' from cliente";
		ResultSet rs = null;
		int num = 0;
		
		try{
			rs = stm.executeQuery(sqlString);
			
			while(rs.next()) {
				num = rs.getInt("id");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.conector.CloseConnection();
		}
		
		return num + 1;
	}

	@Override
	public void Insert(ClienteDTO cliente) {
		Statement stm = this.conector.GetStatement();
		String sqlString = "insert into cliente values("+cliente.getClienteId()+", '" +
							cliente.getNombre() + "', '" +
							cliente.getApellido() + "', '" + 
							cliente.getDireccion() + "', '" +
							cliente.getTel() + "')";
		
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
	public void Modify(ClienteDTO cliente) {
		Statement stm = this.conector.GetStatement();
		String sqlString = "update cliente set nombres = '" + cliente.getNombre() + "', " +
						"apellido = '" + cliente.getApellido() + "', " +
						"direccion = '" + cliente.getDireccion() + "', " +
						"tel = '" + cliente.getTel() + "' where id_cliente = " + cliente.getClienteId();
		
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