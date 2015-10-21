package utilidades;

/** JNVR - Clase de utilidades para trabajar con String */
public class Str {

	/** Toma un Objeto, lo convierte a string y luego le aplica trim() */
	public static String trim(Object str) {
		return (str != null) ? str.toString().trim() : "";
	}

	/** Parsea a entero un string */
	public static int toInt(String value) {
		return Integer.parseInt(value);
	}

	/** Realiza el trim y luego parsea a entero */
	public static int toInt(Object value) {
		String trimedValue = trim(value);
		return toInt(trimedValue);
	}
}
