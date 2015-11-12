package dao;

import dto.MateriaPrimaProveedorDTO;
import dto.ProveedorDTO;

public interface MateriaPrimaProveedorDAO {

	/* Borra todos los datos de materias primas para un determinado proveedor. */
	public void DeleteAllProductTo(ProveedorDTO proveedor);

	/* Carga Materias Primas para Determinado Productor. */
	public void CargarMP(MateriaPrimaProveedorDTO mpProductor);

}
