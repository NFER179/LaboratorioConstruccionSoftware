package main;

import controlador.ControladorVenta;

public class Main {

	public static void main(String[] args) {
		boolean ini = true;
		if (Sistema.esPrimeraEjecucion())
			ini = Sistema.inicializarAplicacion();
		if (ini)
			new ControladorVenta().Inicializar();
	}
}
