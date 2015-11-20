package modelo;

import java.util.List;

import dao.CategoriaDAO;
import daoImplementacion.CategoriaImp;
import dto.CategoriaDTO;
import dto.MateriaPrimaDTO;

public class CategoriaModelo {

	private CategoriaDAO categoria;

	public CategoriaModelo() {
		this.categoria = new CategoriaImp();
	}

	public List<CategoriaDTO> ObtenerCategorias() {
		return this.categoria.GetCategorias();
	}

	public List<MateriaPrimaDTO> ObtenerMateriasPrimasPara(String Categoria) {
		return this.categoria.GetMateriasPrimasPara(Categoria);
	}

	public void ActualizarDescripcion(CategoriaDTO Categoria) {
		this.categoria.ActualizarDescripcion(Categoria);
	}

	public void QuitarAsignaciones(CategoriaDTO Categoria) {
		this.categoria.QuitarAsignacion(Categoria);
	}

	public void AsignarMateriaPrima(CategoriaDTO Categoria,
			MateriaPrimaDTO MateriaPrima) {
		this.categoria.AsignarMateriaPrima(Categoria, MateriaPrima);
	}

	public void EliminarCategoria(CategoriaDTO Categoria) {
		this.categoria.EliminarCategoria(Categoria);

	}

	public void CrearCategoria(CategoriaDTO Categoria) {
		this.categoria.InsertCategoria(Categoria);
	}

	public String ObtenerDescripcion(String Categoria) {
		return this.categoria.GetDescripcion(Categoria);
	}

	public CategoriaDTO ObtenerCategoria(String Categoria) {
		return this.categoria.GetCategoria(Categoria);
	}

	public static boolean EqualsCategorias(CategoriaDTO arg0, CategoriaDTO arg1) {
		if (arg0.getIdCategoria().equals(arg1.getIdCategoria())
				& arg0.getDescripcion().equals(arg1.getDescripcion())) {
			return true;
		}
		return false;
	}

	public static boolean HayRepetidas(List<CategoriaDTO> arg0,
			List<CategoriaDTO> arg1) {
		boolean repetidas = false;

		for (CategoriaDTO c1 : arg0) {
			for (CategoriaDTO c2 : arg1) {
				if (CategoriaModelo.EqualsCategorias(c1, c2))
					repetidas = true;
			}
		}

		return repetidas;
	}

	public void EliminarAsignacionMP(MateriaPrimaDTO mp) {
		this.categoria.EliminarAsignacionMP(mp);
	}
}
