package validacion;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import dto.CategoriaDTO;
import dto.ProveedorModelo;

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
		String categoriaId = tabla.getValueAt(seleccionada, 0).toString().trim();
		String descripcion = tabla.getValueAt(seleccionada, 1).toString().trim();
		CategoriaDTO categoria = new CategoriaDTO(categoriaId, descripcion);
		
		if (this.mdlProveedor.TieneAsignadoCategoria(categoria)) {
			sePuedeEliminar = false;
			JOptionPane.showMessageDialog(this.vtCategoria, "No se puede Eliminar");
		}
		
		return sePuedeEliminar;
	}
}
