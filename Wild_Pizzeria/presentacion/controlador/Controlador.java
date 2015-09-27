package controlador;

import vista.Vista;
import vista.Log;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {

	private Vista vista;
	private Log log;
	
	public Controlador(Vista vista) {
		this.vista = vista;
		this.vista.GetBtnPedidos().addActionListener(this);
	}
	
	public void Inicializar() {
//		this.vista.Close();
		this.vista.Open();
//		this.log = new Log();
//		this.log.Open();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.vista.GetBtnPedidos()) {
			ControladorPedido cp = new ControladorPedido(this);
			cp.Inicializar();
			this.vista.Close();
		}
	}
}