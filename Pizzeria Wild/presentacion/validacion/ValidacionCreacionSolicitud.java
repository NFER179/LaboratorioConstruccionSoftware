package validacion;

import java.awt.Color;

import javax.swing.JOptionPane;

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
			this.vtCreacion.getTxtIdproveedor().setBackground(Color.orange);
			String mensaje = "No Puede Seleccionar Materias Primas sin Elegir Un Proveedor";
			String titulo = "Error";
			JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
		}
	}
}
