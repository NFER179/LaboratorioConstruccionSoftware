package daoImplementacion;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import conexion.ConectorDB;
import dao.CategoriaDAO;
import dto.CategoriaDTO;
import dto.MateriaPrimaDTO;

public class CategoriaImp implements CategoriaDAO {

	private ConectorDB conector;
	
	public CategoriaImp(){
		this.conector = ConectorDB.GetInstancia();
	}
	
	@Override
	public List<CategoriaDTO> GetCategorias() {
		
		Statement stm = this.conector.GetStatement();
		String sqlString = "select * from categoria";
		ResultSet rs = null;
		List<CategoriaDTO> categorias = new ArrayList<CategoriaDTO>();
		
		try {
			rs = stm.executeQuery(sqlString);
			
			while(rs.next()) {
				categorias.add(new CategoriaDTO(rs.getString("categoria_id"), rs.getString("descripcion")));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			this.conector.CloseConnection();
		}
		
		return categorias;
	}

	@Override
	public List<MateriaPrimaDTO> GetMateriasPrimasPara(String Categoria) {
		
		Statement stm = this.conector.GetStatement();
		String sqlString = "select mpc.materia_prima from mp_categoria mpc " +
						"where categoria_id = '" + Categoria + "'";
		ResultSet rs = null;
		List<MateriaPrimaDTO> materiasPrimas = new ArrayList<MateriaPrimaDTO>();
		
		try {
			rs = stm.executeQuery(sqlString);
			
			while(rs.next()) {
				materiasPrimas.add(new MateriaPrimaDTO(rs.getString("materia_prima"),""));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return materiasPrimas;
	}

	@Override
	public void ActualizarDescripcion(CategoriaDTO Categoria) {
		
		Statement stm = this.conector.GetStatement();
		String sqlString = "update categoria set descripcion = '" + Categoria.getDescripcion() + "' " +
						"where categoria_id = '" + Categoria.getIdCategoria() + "'";
		
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
	public void QuitarAsignacion(CategoriaDTO Categoria) {
		
		Statement stm = this.conector.GetStatement();
		String sqlString = "delete from mp_categoria " +
						"where categoria_id = '" + Categoria.getIdCategoria() + "'";
		
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
	public void AsignarMateriaPrima(CategoriaDTO Categoria, MateriaPrimaDTO MateriaPrima) {
		
		Statement stm = this.conector.GetStatement();
		String sqlString = "insert into mp_categoria value('" + Categoria.getIdCategoria() + "', '" + MateriaPrima.getNombre() + "')";
		
		try{
			stm.executeUpdate(sqlString);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			this.conector.CloseConnection();
		}
	}

	@Override
	public void EliminarCategoria(CategoriaDTO Categoria) {
		
		Statement stm = this.conector.GetStatement();
		String sqlString = "delete from categoria " +
						"where categoria_id = '" + Categoria.getIdCategoria() + "'";
		
		try {
			stm.executeUpdate(sqlString);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void InsertCategoria(CategoriaDTO Categoria) {

		Statement stm = this.conector.GetStatement();
		String sqlString = "insert into categoria value('" + Categoria.getIdCategoria() + "', '" + Categoria.getDescripcion() + "')";
		
		try{
			stm.executeUpdate(sqlString);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public String GetDescripcion(String Categoria) {
		
		Statement stm = this.conector.GetStatement();
		String sqlString = "select descripcion from categoria " +
						"where categoria_id = '" + Categoria + "'";
		ResultSet rs = null;
		String descr = "";
		
		try {
			rs = stm.executeQuery(sqlString);
			
			while(rs.next()) {
				descr = rs.getString("descripcion");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		finally{
			this.conector.CloseConnection();
		}
		
		return descr;
	}
}