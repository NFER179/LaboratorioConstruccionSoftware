package dao;

import java.util.List;

import dto.CategoriaDTO;
import dto.MateriaPrimaDTO;
import dto.ProveedorDTO;

public interface ProveedorDAO {

	/* cantidad de proveedorres con una determinada categoria. */
	public int GetCountProveedoresConCategoria(CategoriaDTO Categoria);

	/* Materias primas asignadas al proveedor. */
	public List<MateriaPrimaDTO> GetMateriasPrimasProveedor(String proveedor);

	/* ObtenerProveedores */
	public List<ProveedorDTO> GetProveedores();

	/* Obtiene los Proveedores Activos. */
	public List<ProveedorDTO> GetProveedoresActivos();

	/* Obtiene al Proveedor del cual se pasa como parametro su ID. */
	public ProveedorDTO GetProveedor(String proveedor);

	/* Obtiene las categoarias de un determinado proveedor */
	public List<CategoriaDTO> GetCategorias(String proveedorId);

	/* Actualiza los Datos del Proveedor. */
	public void Update(ProveedorDTO proveedor);

	/* Inserta en al Base a un proveedor */
	public void Insert(ProveedorDTO proveedor);

	/* Eliminacion de proveedor */
	public void Delete(String proveedor);

	/* Borra la asignacio nde materia prima. */
	public void DeleteAsignacionMP(CategoriaDTO cat, MateriaPrimaDTO mp);

}
