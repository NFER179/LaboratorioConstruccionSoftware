package modelo;

import java.util.List;

import dao.ProveedorDAO;
import daoImplementacion.ProveedorImp;
import dto.CategoriaDTO;
import dto.MateriaPrimaDTO;
import dto.ProveedorDTO;

public class ProveedorModelo {

	private ProveedorDAO proveedor;
	
	public ProveedorModelo() {
		this.proveedor = new ProveedorImp();
	}
	
	public boolean TieneAsignadoCategoria(CategoriaDTO Categoria) {
		if (this.proveedor.GetCountProveedoresConCategoria(Categoria) == 0) {
			return false;
		}
		return true;
	}

	public List<MateriaPrimaDTO> ObtenerMateriasPrimasDeProveedor(String Proveedor) {
		return this.proveedor.GetMateriasPrimasProveedor(Proveedor);
	}

	public List<ProveedorDTO> ObtenerProveedores() {
		return this.proveedor.GetProveedores();
	}

	public List<ProveedorDTO> ObtenerProveedoresActivos() {
		return this.proveedor.GetProveedoresActivos();
	}
}