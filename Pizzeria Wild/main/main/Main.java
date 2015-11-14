package main;

import vista.Vista;
import controlador.Controlador;
import controlador.ControladorVenta;

public class Main {
	
	public static void main(String[] args) {
//		Vista vista = new Vista();
//		Controlador controlador = new Controlador(vista);
//		controlador.Inicializar();
		ControladorVenta controlador = new ControladorVenta();
		controlador.Inicializar();
	}
}