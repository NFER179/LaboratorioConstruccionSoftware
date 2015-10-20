package daoImplementacion;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexion.ConectorDB;
import dao.ProveedorDAO;
import dto.CategoriaDTO;
import dto.MateriaPrimaDTO;
import dto.ProveedorDTO;

public class ProveedorImp implements ProveedorDAO {

	private ConectorDB conector;
	
	public ProveedorImp() {
		this.conector = ConectorDB.GetInstancia();
	}
	
	@Override
	public int GetCountProveedoresConCategoria(CategoriaDTO Categoria) {
		
		Statement stm = this.conector.GetStatement();
		String sqlString = "select count(proveedor_id) as 'count' from mp_proveedor " +
						"where categoria_id = '" + Categoria.getIdCategoria() + "'";
		ResultSet rs = null;
		int count = 0;
		
		try {
			rs = stm.executeQuery(sqlString);
			
			while(rs.next()) {
				count = rs.getInt("count");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			this.conector.CloseConnection();
		}
		
		return count;
	}

	@Override
	public List<MateriaPrimaDTO> GetMateriasPrimasProveedor(String Proveedor) {
		
		Statement stm = this.conector.GetStatement();
		String sqlString = "select mp.* from materia_prima mp " +
						"where mp.materia_prima in (select mpp.materia_prima from mp_proveedor mpp " +
						"where proveedor_id = '" + Proveedor + "')";
		ResultSet rs = null;
		List<MateriaPrimaDTO> materiasPrima = new ArrayList<MateriaPrimaDTO>();
		
		try {
			rs = stm.executeQuery(sqlString);
					
			while(rs.next()) {
				String materiaPrima = rs.getString("materia_prima");
				String unidad = rs.getString("unidad");
				materiasPrima.add(new MateriaPrimaDTO(materiaPrima, unidad));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			this.conector.CloseConnection();
		}
		
		return materiasPrima;
	}

	@Override
	public List<ProveedorDTO> GetProveedores() {
		
		Statement stm = this.conector.GetStatement();
		String sqlString = "select * from proveedor";
		ResultSet rs = null;
		List<ProveedorDTO> proveedores = new ArrayList<ProveedorDTO>();
		
		try {
			rs = stm.executeQuery(sqlString);
			
			while(rs.next()) {
				String ProveedorId = rs.getString("proveedor_id");
				String Nombre = rs.getString("Nombre");
				String Telefono = rs.getString("telefono");
				String Mail = rs.getString("mail");
				proveedores.add(new ProveedorDTO(ProveedorId, Nombre, Telefono, Mail));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.conector.CloseConnection();
		}
		
		return proveedores;
	}
}