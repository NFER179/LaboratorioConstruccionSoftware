package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.CategoriaDTO;
import dto.MateriaPrimaDTO;

public interface MateriaPrimaDAO {

	/* Obtener todas las materias primas existentes. */
	public List<MateriaPrimaDTO> GetMateriasPrimas();
	
	/* Inserta una nueva materia prima en la base de datos. */
	public void InsertMateriaPrima(MateriaPrimaDTO MateriaPrima);
	
	/* Obtiene las Categorias que aun no han sido asignadas. */
	public List<MateriaPrimaDTO> GetMateriasPrimasSinAsignar();

	/* Asigna la Materia Prima a una Categoria. */
//	public void AsignarMTaCategoria(String materiaPrima, String categoria);
}
