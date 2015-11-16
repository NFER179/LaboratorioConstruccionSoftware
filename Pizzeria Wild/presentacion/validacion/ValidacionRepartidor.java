package validacion;

import javax.swing.JOptionPane;

import vista.RepartidorVista;

public class ValidacionRepartidor {
	
	private RepartidorVista vtRepartidor;
	
	public ValidacionRepartidor(RepartidorVista Vista) {
		this.vtRepartidor = Vista;
	}

	public boolean ModificarValido() {
		boolean valido = true;
		
		if(this.vtRepartidor.getTable().getSelectedRowCount() == 0) {
			valido = false;
			String mensaje = "Debe Seleccionar un Proveedor para Modificar";
			String titulo = "Informacion";
			JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
		}
		
		return valido;
	}
}
