package modelo;

import java.util.List;

import dao.MateriaPrimaDAO;
import daoImplementacion.MateriaPrimaImp;
import dto.CategoriaDTO;
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

	public MateriaPrimaDTO ObtenerMateriaPrima(String nombre) {
		return this.materiaPrima.GetMateriaPrima(nombre);
	}

	public static boolean SeEncuentraEn(String mp, List<MateriaPrimaDTO> mps) {
		for(MateriaPrimaDTO mpdto:mps){
			if(mp.equals(mpdto.getNombre()))
				return true;
		}
		return false;
	}

	public static boolean EqualsMP(MateriaPrimaDTO m1, MateriaPrimaDTO m2) {
		if(m1.getNombre().equals(m2.getNombre()) & m1.getUnidad().equals(m2.getUnidad()))
			return true;
		return false;
	}
	
	public static boolean HayRepetidos(List<MateriaPrimaDTO> arg0, List<MateriaPrimaDTO> arg1) {
		for(MateriaPrimaDTO mp1:arg0){
			for(MateriaPrimaDTO mp2:arg1) {
				if(MateriaPrimaModelo.EqualsMP(mp1, mp2))
					return true;
			}
		}
		
		return false;
	}

//	public void AsignarACategoria(String MateriaPrima, String Categoria) {
//		this.materiaPrima.AsignarMTaCategoria(MateriaPrima, Categoria);
//	}
}