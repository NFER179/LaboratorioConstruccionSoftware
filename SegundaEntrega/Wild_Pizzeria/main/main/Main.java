package main;

import vista.Vista;
import controlador.Controlador;

public class Main {
	
	public static void main(String[] args) {
		Vista vista = new Vista();
		Controlador controlador = new Controlador(vista);
		controlador.Inicializar();
	}
}