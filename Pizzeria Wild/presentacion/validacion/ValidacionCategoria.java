package validacion;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import modelo.ProveedorModelo;

import dto.CategoriaDTO;

import utilidades.Msj;
import vista.CategoriaVista;

public class ValidacionCategoria {

	private CategoriaVista vtCategoria;
	private ProveedorModelo mdlProveedor;

	public ValidacionCategoria(CategoriaVista arg0) {
		this.vtCategoria = arg0;
		this.mdlProveedor = new ProveedorModelo();
	}

	public boolean SePuedeEliminar() {
		boolean sePuedeEliminar = true;

		JTable tabla = this.vtCategoria.getTable();
		int seleccionada = tabla.getSelectedRow();
		if (seleccionada < 0) {
			Msj.error("Error de seleccion",
					"Debe seleccionar una categoria a eliminar");
		} else {
			String categoriaId = tabla.getValueAt(seleccionada, 0).toString()
					.trim();
			String descripcion = tabla.getValueAt(seleccionada, 1).toString()
					.trim();
			CategoriaDTO categoria = new CategoriaDTO(categoriaId, descripcion);

			if (this.mdlProveedor.TieneAsignadoCategoria(categoria)) {
				sePuedeEliminar = false;
				JOptionPane
						.showMessageDialog(this.vtCategoria,
								"No se puede Eliminar por Estar asignada a un proveedor");
			}
		}
		return sePuedeEliminar;
	}
}
