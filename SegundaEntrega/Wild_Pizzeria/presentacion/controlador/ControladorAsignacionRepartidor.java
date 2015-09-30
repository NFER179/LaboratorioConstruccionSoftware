package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

import vista.AsignacionRepartidoresVista;

public class ControladorAsignacionRepartidor implements ActionListener{

	private AsignacionRepartidoresVista vtAsignacionRepartidores;
	private ControladorPedido ctrPedido;
	
	public ControladorAsignacionRepartidor(ControladorPedido ControladorPedido, JFrame Frame) {
		this.vtAsignacionRepartidores = new AsignacionRepartidoresVista(Frame);
		this.vtAsignacionRepartidores.getBtnBuscarrepartidor().addActionListener(this);
		this.vtAsignacionRepartidores.getBtnAsignar().addActionListener(this);
		this.vtAsignacionRepartidores.getBtnCancelar().addActionListener(this);
		
		this.ctrPedido = ControladorPedido;
	}

	public void Inicializar(){
		
		this.vtAsignacionRepartidores.Open();
	}
	
	private void CargarTabla() {
		this.vtAsignacionRepartidores.getModelTable().setRowCount(0);
		this.vtAsignacionRepartidores.getModelTable().setColumnCount(0);
		this.vtAsignacionRepartidores.getModelTable().setColumnIdentifiers(this.vtAsignacionRepartidores.getNombreColumnas());
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.vtAsignacionRepartidores.getBtnBuscarrepartidor()) {
			
		}
		else if (arg0.getSource() == this.vtAsignacionRepartidores.getBtnAsignar()) {
			
		}
		else if (arg0.getSource() == this.vtAsignacionRepartidores.getBtnCancelar()) {
			this.ctrPedido.Inicializar();
			this.vtAsignacionRepartidores.Close();
		}
	}	
}