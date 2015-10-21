package controlador;

import vista.Log;
import vista.Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogControlador implements ActionListener{

	public Log log;
	public Vista vista;

	public LogControlador(Log log) {
		this.log = log;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.log.getBtnAceptar()) {
			this.vista = new Vista();
			this.vista.Open();
			this.log.Close();
		}
		else if(arg0.getSource() == this.log.getBtnCancelar()) {
			this.log.Close();
		}
	}
}