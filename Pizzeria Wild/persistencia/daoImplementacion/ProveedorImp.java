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
				boolean Activo = ProveedorDTO.ParseActivoBoolean(rs.getString("activo"));
				proveedores.add(new ProveedorDTO(ProveedorId, Nombre, Telefono, Mail, Activo));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.conector.CloseConnection();
		}
		
		return proveedores;
	}

	@Override
	public List<ProveedorDTO> GetProveedoresActivos() {
		
		Statement stm = this.conector.GetStatement();
		String sqlString = "select * from proveedor where activo = 'Y'";
		ResultSet rs = null;
		List<ProveedorDTO> proveedores = new ArrayList<ProveedorDTO>();
		
		try {
			rs = stm.executeQuery(sqlString);
			
			while(rs.next()) {
				String ProveedorId = rs.getString("proveedor_id");
				String Nombre = rs.getString("Nombre");
				String Telefono = rs.getString("telefono");
				String Mail = rs.getString("mail");
				boolean Activo = ProveedorDTO.ParseActivoBoolean(rs.getString("activo"));
				proveedores.add(new ProveedorDTO(ProveedorId, Nombre, Telefono, Mail, Activo));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.conector.CloseConnection();
		}
		
		return proveedores;
	}

	@Override
	public ProveedorDTO GetProveedor(String Proveedor) {
		Statement stm = this.conector.GetStatement();
		String sqlString = "select * from proveedor where proveedor_id = '" + Proveedor + "'";
		ProveedorDTO proveedor = null;
		ResultSet rs = null;
		
		try {
			rs = stm.executeQuery(sqlString);
			
			while(rs.next()) {
				String ProveedorId = rs.getString("proveedor_id");
				String Nombre = rs.getString("nombre");
				String Telefono = rs.getString("telefono");
				String Mail = rs.getString("mail");
				boolean Activo = ProveedorDTO.ParseActivoBoolean(rs.getString("activo"));
				
				proveedor = new ProveedorDTO(ProveedorId, Nombre, Telefono, Mail, Activo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			this.conector.CloseConnection();
		}
		
		return proveedor;
	}

	@Override
	public List<CategoriaDTO> GetCategorias(String proveedorId) {
		Statement stm = this.conector.GetStatement();
		String sqlString = "select ca.* " +
							"from categoria ca " +
							"where ca.categoria_id in (select mpr.categoria_id " +
														"from mp_proveedor mpr " +
														"where mpr.proveedor_id = '" + proveedorId + "')";
		ResultSet rs = null;
		List<CategoriaDTO> categorias = new ArrayList<CategoriaDTO>();
		
		try {
			rs = stm.executeQuery(sqlString);
			
			while(rs.next()){
				String IdCategoria = rs.getString("categoria_id");
				String Descripcion = rs.getString("descripcion");
				categorias.add(new CategoriaDTO(IdCategoria, Descripcion));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.conector.CloseConnection();
		}
		
		return categorias;
	}

	@Override
	public void Update(ProveedorDTO proveedor) {
		Statement stm = this.conector.GetStatement();
		String sqlString = "update proveedor set nombre = '" + proveedor.getNombre() + "', " +
							"telefono = '" + proveedor.getTelefono() + "', " +
							"mail = '" + proveedor.getMail() + "', " + 
							"activo = '" + ProveedorDTO.ParseActivoShortString(proveedor.isActivo()) + "' " +
							"where proveedor_id = '" + proveedor.getProveedorId() + "' ";
		
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
	public void Insert(ProveedorDTO proveedor) {
		Statement stm = this.conector.GetStatement();
		String sqlString = "insert into proveedor value('" +
							proveedor.getProveedorId() + "', '" +
							proveedor.getNombre() + "', '" +
							proveedor.getTelefono() + "', '" +
							proveedor.getMail() + "', '" +
							ProveedorDTO.ParseActivoShortString(proveedor.isActivo()) + "')";
		
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
	public void Delete(String proveedor) {
		Statement stm = this.conector.GetStatement();
		String sqlDeleteProveedor = "delete from proveedor where proveedor_id = '" + proveedor + "'";
		String sqlDeleteMTProveedor = "delete from mp_proveedor where proveedor_id = '" + proveedor + "'";
		
		try {
			stm.executeUpdate(sqlDeleteMTProveedor);
			stm.executeUpdate(sqlDeleteProveedor);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.conector.CloseConnection();
		}
	}

	@Override
	public void DeleteAsignacionMP(CategoriaDTO cat, MateriaPrimaDTO mp) {
		Statement stm = this.conector.GetStatement();
		String sqlString = "delete from mp_proveedor where categoria_id = '"+cat.getIdCategoria()+"' and materia_prima = '"+mp.getNombre()+"'";
		
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