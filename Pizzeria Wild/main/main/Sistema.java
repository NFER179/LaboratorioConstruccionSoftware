package main;

import utilidades.Msj;
import backUp.BackUp;

public class Sistema {

	private static String rutaIni = "configs/init.txt";

	public static boolean esPrimeraEjecucion() {
		boolean ret = true;
		try {
			String texto = BackUp.getTextoArchivo(rutaIni);
			ret = Boolean.parseBoolean(texto);
		} catch (Exception e) {
		}
		return ret;
	}

	public static void inicializarAplicacion() {
		inicializarBaseDeDatos();
		modificarPrimeraEjecucion();
	}

	private static void inicializarBaseDeDatos() {
		try {
			BackUp.inicializarBD();
		} catch (Exception e) {
			Msj.error(
					"Error",
					"Error al inicializar la base de datos \n Por favor contactese con el proveedor");
		}

	}

	private static void modificarPrimeraEjecucion() {
		String nuevoValor = "false";
		BackUp.modificarTextoArchivo(rutaIni, nuevoValor);
	}

}
