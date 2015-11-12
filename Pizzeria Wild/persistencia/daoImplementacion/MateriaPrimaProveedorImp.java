package daoImplementacion;

import java.sql.Statement;

import conexion.ConectorDB;

import dao.MateriaPrimaProveedorDAO;
import dto.MateriaPrimaProveedorDTO;
import dto.ProveedorDTO;

public class MateriaPrimaProveedorImp implements MateriaPrimaProveedorDAO {

	private ConectorDB conector;
	
	public MateriaPrimaProveedorImp() {
		this.conector = ConectorDB.GetInstancia();
	}
	
	@Override
	public void DeleteAllProductTo(ProveedorDTO proveedor) {
		Statement stm = this.conector.GetStatement();
		String sqlString = "delete from mp_proveedor where proveedor_id = '" + proveedor.getProveedorId() + "'";
		
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
	public void CargarMP(MateriaPrimaProveedorDTO mpProveedor) {
		Statement stm = this.conector.GetStatement();
		String sqlString = "insert into mp_proveedor value('" + mpProveedor.getProveedorId() + 
							"', '" + mpProveedor.getCategoria() + "', '" + mpProveedor.getMateriaPrima() + "')";
		
		try{
			stm.executeUpdate(sqlString);
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.conector.CloseConnection();
		}
	}

}
