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

	public boolean ExisteProvedor(String Proveedor) {
		if(this.proveedor.GetProveedor(Proveedor) == null)
			return false;
		else
			return true;
	}

	public ProveedorDTO ObtenerProveedor(String ProveedorId) {
		return this.proveedor.GetProveedor(ProveedorId);
	}

	public List<CategoriaDTO> ObtenerCategorias(String proveedorId) {
		return this.proveedor.GetCategorias(proveedorId);
	}

	public void Actualizar(ProveedorDTO proveedor) {
		this.proveedor.Update(proveedor);
	}

	public void CrearProveedor(ProveedorDTO proveedor) {
		this.proveedor.Insert(proveedor);
	}

	public void EliminarProveedor(String proveedor) {
		this.proveedor.Delete(proveedor);
	}

	public void ElinarAsignacionMP(CategoriaDTO cat, MateriaPrimaDTO mp) {
		this.proveedor.DeleteAsignacionMP(cat, mp);
	}
}