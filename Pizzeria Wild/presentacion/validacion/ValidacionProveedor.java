package validacion;

import javax.swing.JOptionPane;

import vista.ProveedorVista;

public class ValidacionProveedor {

	private ProveedorVista vtProveedor;
	
	public ValidacionProveedor(ProveedorVista Vista){
		this.vtProveedor = Vista;
	}

	public boolean ModificarValido() {
		boolean valido = true;
		
		if(this.vtProveedor.getTable().getSelectedRowCount() == 0) {
			valido = false;
			String mensaje = "Debe Seleccionar el Proveedor que Desea Modificar.";
			String titulo = "Informacion";
			JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
		}
		
		return valido;
	}
}
