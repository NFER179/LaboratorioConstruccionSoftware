package dao;

import java.util.List;

import dto.MateriaPrimaDTO;

public interface MateriaPrimaDAO {

	/* Obtener todas las materias primas existentes. */
	public List<MateriaPrimaDTO> GetMateriasPrimas();

	/* Inserta una nueva materia prima en la base de datos. */
	public void InsertMateriaPrima(MateriaPrimaDTO MateriaPrima);

	/* Obtiene las Categorias que aun no han sido asignadas. */
	public List<MateriaPrimaDTO> GetMateriasPrimasSinAsignar();

	/* Obtiene la unidad de la materia prima. */
	public String GetUnidad(String MateriaPrima);

	/* Obtiene la cantidad de materia prima con ese nombre */
	public int GetCantMT(String NombreMT);

	/* Obtiene la Materia Prima especificada. */
	public MateriaPrimaDTO GetMateriaPrima(String nombre);

	/* Asigna la Materia Prima a una Categoria. */
	// public void AsignarMTaCategoria(String materiaPrima, String categoria);
}
