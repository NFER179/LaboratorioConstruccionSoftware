package main;

import controlador.ControladorVenta;

public class Main {

	public static void main(String[] args) {
		if (Sistema.esPrimeraEjecucion())
			Sistema.inicializarAplicacion();
		new ControladorVenta().Inicializar();
	}
}
