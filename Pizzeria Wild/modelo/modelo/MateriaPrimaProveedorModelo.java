package modelo;

import dao.MateriaPrimaProveedorDAO;
import daoImplementacion.MateriaPrimaProveedorImp;
import dto.MateriaPrimaProveedorDTO;
import dto.ProveedorDTO;

public class MateriaPrimaProveedorModelo {

	private MateriaPrimaProveedorDAO mpProveedor;
	
	public MateriaPrimaProveedorModelo() {
		this.mpProveedor = new MateriaPrimaProveedorImp();
	}

	public void EliminarDatosPara(ProveedorDTO proveedor) {
		this.mpProveedor.DeleteAllProductTo(proveedor);
	}

	public void CargarMateriasPrimas(MateriaPrimaProveedorDTO mpProductor) {
		this.mpProveedor.CargarMP(mpProductor);
	}
}
