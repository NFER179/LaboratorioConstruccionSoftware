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

}
