package validacion;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import vista.CreacionSolicitudVista;

public class ValidacionCreacionSolicitud {

	private CreacionSolicitudVista vtCreacion;
	
	public ValidacionCreacionSolicitud(CreacionSolicitudVista Vista) {
		this.vtCreacion = Vista;
	}
	
	public boolean SeleccionMateriasPrimas() {
		boolean ProveedorSeleccionado = true;
		
		if (this.vtCreacion.getTxtIdproveedor().getText().equals("")) {
			ProveedorSeleccionado = false;
		}
		
		this.ErrorSeleccionProveedor(ProveedorSeleccionado);
		
		return ProveedorSeleccionado;
	}
	
	private void ErrorSeleccionProveedor(boolean ProveedorSeleccionado) {
		if(ProveedorSeleccionado) {
			this.vtCreacion.getTxtIdproveedor().setBackground(null);
		}
		else {
			this.vtCreacion.getTxtIdproveedor().setBackground(Color.RED);
			this.vtCreacion.getTxtDescrproveedor().setBackground(Color.RED);
			this.vtCreacion.getBtnBuscar().requestFocus();
			String mensaje = "No Puede Seleccionar Materias Primas sin Elegir Un Proveedor";
			String titulo = "Error";
			JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
		}
	}

	public boolean QuitarValido() {
		JTable tabla = this.vtCreacion.getTable();
		int filasSeleccionadas = tabla.getSelectedRows().length;
		if(filasSeleccionadas == 0) {
			String mensaje = "Debe Seleccionar Materias Primas para Quitar.";
			String titulo = "Información Quitar";
			JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		return true;
	}
}