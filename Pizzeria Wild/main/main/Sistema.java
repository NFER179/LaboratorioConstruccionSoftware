package main;

import java.sql.SQLException;

import controlador.ControladorCreacionUsuario;

import utilidades.Msj;
import archivos.ManejoArchivos;
import backUp.BackUp;

public class Sistema {

	private static String rutaIni = "configs/conf/init.txt";
	private static String rutaUserPass = "configs/conf/usuario.txt";

	public static boolean esPrimeraEjecucion() {
		boolean ret = true;
		try {
			String texto = ManejoArchivos.getTextoArchivo(rutaIni);
			ret = Boolean.parseBoolean(texto);
		} catch (Exception e) {
		}
		return ret;
	}

	public static void inicializarAplicacion() {
		inicializarBaseDeDatos();
		modificarPrimeraEjecucion();
		BackUp.guardarDump();
		new ControladorCreacionUsuario();
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
		ManejoArchivos.modificarTextoArchivo(rutaIni, nuevoValor);
	}

	public static void newUsuario(String user, String pass, String phone,
			String dir) {
		crearUsuario(user, pass);
		modificarUserPass(user, pass, phone, dir);
	}

	private static void crearUsuario(String user, String pass) {
		try {
			BackUp.crearUsuario(user, pass);
		} catch (SQLException e) {
			Msj.error("Error", "Error al crear el usuario");
		}
	}

	private static void modificarUserPass(String user, String pass,
			String phone, String dir) {
		String nuevoValor = "user:%s; pass:%s; db:PizzeriaWild; phone:%s; dir:%s;";
		nuevoValor = String.format(nuevoValor, user, pass, phone, dir);
		ManejoArchivos.modificarTextoArchivo(rutaUserPass, nuevoValor);
	}
}
