package dao;

import java.util.List;

import dto.CategoriaDTO;
import dto.MateriaPrimaDTO;

public interface CategoriaDAO {

	/* Obtiene las Categorias Cargadas en el Sistema. */
	public List<CategoriaDTO> GetCategorias();

	/* Obtiene Todas las Materias Primas que Tiene Asignada una Categoria. */
	public List<MateriaPrimaDTO> GetMateriasPrimasPara(String Categoria);

	/* Actualiza la descipcion. */
	public void ActualizarDescripcion(CategoriaDTO Categoria);

	/* Elimina las Asignaciones a Esta Categoria. */
	public void QuitarAsignacion(CategoriaDTO categoria);

	/* Asigna la MateriaPrima a una Categoria. */
	public void AsignarMateriaPrima(CategoriaDTO Categoria, MateriaPrimaDTO MateriaPrima);

	/* Elimina la Categoria Seleccionada. */
	public void EliminarCategoria(CategoriaDTO Categoria);

	/* Crea la categoria. */
	public void InsertCategoria(CategoriaDTO Categoria);

	/* Metodo por el cual se obtiene la descripcion. */
	public String GetDescripcion(String Categoria);

	/* Obtine la Categoria por Id que se Pasa. */
	public CategoriaDTO GetCategoria(String Categoria);

	/* Elimina la asignacion de mp */
	public void EliminarAsignacionMP(MateriaPrimaDTO mp);
}