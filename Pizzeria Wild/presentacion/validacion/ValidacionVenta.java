package validacion;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import vista.VentasVista;

public class ValidacionVenta {
	
	private VentasVista vtVenta;
	
	public ValidacionVenta(VentasVista arg0) {
		this.vtVenta = arg0;
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
}