package validacion;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import modelo.VentaModelo;

import dto.VentaDTO;

import utilidades.Str;
import vista.VentasVista;

public class ValidacionVenta {
	
	private VentasVista vtVenta;
	private VentaModelo mdlVenta;
	
	public ValidacionVenta(VentasVista arg0) {
		this.vtVenta = arg0;
		this.mdlVenta = new VentaModelo();
	}
	
	public boolean CancelarValido() {
		JTable tabla = this.vtVenta.GetTable();
		
		if(tabla.getSelectedRowCount() == 0) {
			String mensaje = "Debe Seleccionar al Menos una Venta para Poder Cancelar.";
			String titulo = "Información de Cancelación";
			JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		return true;
	}

	public boolean EntregarValido() {
		JTable tabla = this.vtVenta.GetTable();
		
		if(tabla.getSelectedRowCount() == 0) {
			String mensaje = "Debe Seleccionar al Menos una Venta para Poder Entregar.";
			String titulo = "Información de Entrega";
			JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		return true;
	}
	
	public boolean ModificarValido() {
		boolean Modificar = true;
		
		String Mensaje = "Debe Seleccionar la Venta que Desea Modificar.";
		String Titulo = "Informacion de Seleccion.";
		
		Modificar = this.FilaSeleccionada(Mensaje, Titulo);
		
		if(this.vtVenta.GetTable().getSelectedRowCount() == 1) {
			if(!this.GetVentaSeleccionada().getEstado().toUpperCase().equals("VIAJE")){
				if(this.GetVentaSeleccionada().getEstado().toUpperCase().equals("ARMADO")) {
					Modificar = false;
					Mensaje = "No Puede Modificar Ventas que Esten Armadas en Mostrador.";
					Titulo = "Error";
					JOptionPane.showMessageDialog(null, Mensaje, Titulo, JOptionPane.ERROR_MESSAGE);
				}
			}
			else{
				Modificar = false;
				Mensaje = "No Puede Modificar Ventas que Esten en Viaje.";
				Titulo = "Error";
				JOptionPane.showMessageDialog(null, Mensaje, Titulo, JOptionPane.ERROR_MESSAGE);
			}
		}
		else {
			Modificar = false;
			Mensaje = "Debe Seleccionar una Unica Fila.";
			Titulo = "Informacion.";
			JOptionPane.showMessageDialog(null, Mensaje, Titulo, JOptionPane.INFORMATION_MESSAGE);			
		}
			
		return Modificar;
	}
	
	private boolean FilaSeleccionada(String Mensaje, String Titulo) {
		JTable tabla = this.vtVenta.GetTable();
		
		if(tabla.getSelectedRowCount() == 0) {
			JOptionPane.showMessageDialog(null, Mensaje, Titulo, JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		
		return true;
	}
	
	private VentaDTO GetVentaSeleccionada() {
		VentaDTO ret = null;
		
		int SelectedRows = this.vtVenta.GetTable().getSelectedRow();
		JTable table = this.vtVenta.GetTable();
		
		String fecha = Str.trim(table.getValueAt(SelectedRows, 0));
		int numVenta = Str.toInt(table.getValueAt(SelectedRows, 1));
		
		ret = this.mdlVenta.GetVenta(fecha, numVenta);
		return ret;
	}

	public boolean InformarValido() {
		boolean Informar = true;
		JTable tabla = this.vtVenta.GetTable();
		
		if(tabla.getSelectedRowCount() != 1) {
			String titulo = "Informacion de Seleccion";
			String mensaje = "Debe Seleccionar una Venta Para Ver su Informacion";
			JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
			Informar = false;
		}
		
		return Informar;
	}
}