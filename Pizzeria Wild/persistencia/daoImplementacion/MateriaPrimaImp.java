package daoImplementacion;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexion.ConectorDB;
import dao.MateriaPrimaDAO;
import dto.MateriaPrimaDTO;

public class MateriaPrimaImp implements MateriaPrimaDAO {

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
				materiasPrimas.add(new MateriaPrimaDTO(rs
						.getString("materia_prima"), rs.getString("unidad")));
			}
		} catch (Exception e) {
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
		String sqlString = "insert into materia_prima values('"
				+ MateriaPrima.getNombre() + "', '" + MateriaPrima.getUnidad()
				+ "')";

		try {
			stm.executeUpdate(sqlString);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<MateriaPrimaDTO> GetMateriasPrimasSinAsignar() {

		Statement stm = this.conector.GetStatement();
		String sqlString = "select mp.* from materia_prima mp "
				+ "where mp.materia_prima not in (select mpc.materia_prima "
				+ "from mp_categoria mpc)";
		ResultSet rs = null;
		List<MateriaPrimaDTO> materiasPrimas = new ArrayList<MateriaPrimaDTO>();

		try {
			rs = stm.executeQuery(sqlString);

			while (rs.next()) {
				materiasPrimas.add(new MateriaPrimaDTO(rs
						.getString("materia_prima"), rs.getString("unidad")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			this.conector.CloseConnection();
		}

		return materiasPrimas;
	}

	@Override
	public String GetUnidad(String MateriaPrima) {
		Statement stm = this.conector.GetStatement();
		String sqlString = "select mp.unidad from materia_prima mp "
				+ "where materia_prima = '" + MateriaPrima + "'";
		ResultSet rs = null;
		String unidad = "";

		try {
			rs = stm.executeQuery(sqlString);

			while (rs.next()) {
				unidad = rs.getString("unidad");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.conector.CloseConnection();
		}

		return unidad;
	}

	@Override
	public int GetCantMT(String NombreMT) {
		Statement stm = this.conector.GetStatement();
		String sqlString = "select count(*) as 'cantidad' from materia_prima "
				+ "where materia_prima = '" + NombreMT + "'";
		ResultSet rs = null;
		int cantidad = 0;

		try {
			rs = stm.executeQuery(sqlString);

			while (rs.next()) {
				cantidad = rs.getInt("cantidad");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.conector.CloseConnection();
		}

		return cantidad;
	}

	@Override
	public MateriaPrimaDTO GetMateriaPrima(String nombre) {

		Statement stm = this.conector.GetStatement();
		String sqlString = "select * from materia_prima where materia_prima = '"
				+ nombre + "'";
		ResultSet rs = null;
		MateriaPrimaDTO materiasPrima = null;

		try {
			rs = stm.executeQuery(sqlString);

			while (rs.next()) {
				materiasPrima = new MateriaPrimaDTO(
						rs.getString("materia_prima"), rs.getString("unidad"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			this.conector.CloseConnection();
		}

		return materiasPrima;
	}

	@Override
	public void Delete(MateriaPrimaDTO mp) {
		Statement stm = this.conector.GetStatement();
		String sqlString = "delete from materia_prima where materia_prima = '" + mp.getNombre()  + "'";
		
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

	// @Override
	// public void AsignarMTaCategoria(String MateriaPrima, String Categoria) {
	//
	// Statement stm = this.conector.GetStatement();
	// String sqlString = "insert into mp_categoria value('" + Categoria + "','"
	// + MateriaPrima + "')";
	//
	// try{
	// stm.executeUpdate(sqlString);
	// }catch(Exception e) {
	// e.printStackTrace();
	// }
	//
	// finally {
	// this.conector.CloseConnection();
	// }
	// }
}