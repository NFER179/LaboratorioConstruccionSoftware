package modelo;

import java.util.List;

import dao.MateriaPrimaDAO;
import daoImplementacion.MateriaPrimaImp;
import dto.MateriaPrimaDTO;

public class MateriaPrimaModelo {

	private MateriaPrimaDAO materiaPrima;
	
	public MateriaPrimaModelo() {
		this.materiaPrima = new MateriaPrimaImp();
	}
	
	public List<MateriaPrimaDTO> ObtenerMateriasPrimas() {
		return this.materiaPrima.GetMateriasPrimas();
	}

	public void RegistrarMateriaPrima(MateriaPrimaDTO MateriaPrima) {
		this.materiaPrima.InsertMateriaPrima(MateriaPrima);
	}

	public List<MateriaPrimaDTO> ObtenerMateriasPrimasSinAsignar() {
		return this.materiaPrima.GetMateriasPrimasSinAsignar();
	}

	public String ObtenerUnidad(String MateriaPrima) {
		return this.materiaPrima.GetUnidad(MateriaPrima);
	}

	public boolean Existe(String NombreMT) {
		if(this.materiaPrima.GetCantMT(NombreMT) > 0)
			return true;
		else{
			return false;	
		}
	}

//	public void AsignarACategoria(String MateriaPrima, String Categoria) {
//		this.materiaPrima.AsignarMTaCategoria(MateriaPrima, Categoria);
//	}
}