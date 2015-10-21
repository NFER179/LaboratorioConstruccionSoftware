package daoImplementacion;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexion.ConectorDB;
import dao.MateriaPrimaDAO;
import dto.MateriaPrimaDTO;

public class MateriaPrimaImp implements MateriaPrimaDAO{

	private ConectorDB conector;
	
	public MateriaPrimaImp() {
		this.conector = ConectorDB.GetInstancia();
	}
	
	@Override
	public List<MateriaPrimaDTO> GetMateriasPrimas() {
		
		Statement stm = this.conector.GetStatement();
		String sqlString = "select * from materia_prima";
		ResultSet rs = null;
		List<MateriaPrimaDTO> materiasPrimas = new ArrayList<MateriaPrimaDTO>();
		
		try {
			rs = stm.executeQuery(sqlString);
			
			while (rs.next()) {
				materiasPrimas.add(new MateriaPrimaDTO(rs.getString("materia_prima"), rs.getString("unidad")));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			this.conector.CloseConnection();
		}
		
		return materiasPrimas;
	}
	
	@Override
	public void InsertMateriaPrima(MateriaPrimaDTO MateriaPrima) {
		Statement stm = this.conector.GetStatement();
		String sqlString = "insert into materia_prima value('" + MateriaPrima.getNombre() + "', '" + MateriaPrima.getUnidad() + "')";
		
		try {
			stm.executeUpdate(sqlString);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<MateriaPrimaDTO> GetMateriasPrimasSinAsignar() {

		Statement stm = this.conector.GetStatement();
		String sqlString = "select mp.* from materia_prima mp " +
						"where mp.materia_prima not in (select mpc.materia_prima " +
													"from mp_categoria mpc)";
		ResultSet rs = null;
		List<MateriaPrimaDTO> materiasPrimas = new ArrayList<MateriaPrimaDTO>();
		
		try{
			rs = stm.executeQuery(sqlString);
			
			while(rs.next()) {
				materiasPrimas.add(new MateriaPrimaDTO(rs.getString("materia_prima"), rs.getString("unidad")));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			this.conector.CloseConnection();
		}
		
		return materiasPrimas;
	}

//	@Override
//	public void AsignarMTaCategoria(String MateriaPrima, String Categoria) {
//		
//		Statement stm = this.conector.GetStatement();
//		String sqlString = "insert into mp_categoria value('" + Categoria + "','" + MateriaPrima + "')";
//		
//		try{
//			stm.executeUpdate(sqlString);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//		finally {
//			this.conector.CloseConnection();
//		}
//	}
}