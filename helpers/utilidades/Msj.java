package utilidades;

import javax.swing.JOptionPane;

/** JNVR - Clase custom para mostrar mensajes (JOptionPane) */
public class Msj {

	public static void error(String titulo, String mensaje) {
		showMessage(mensaje, titulo, JOptionPane.ERROR_MESSAGE);
	}

	public static void pregunta(String titulo, String mensaje) {
		showMessage(mensaje, titulo, JOptionPane.QUESTION_MESSAGE);
	}

	public static void info(String titulo, String mensaje) {
		showMessage(mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
	}

	public static void advertencia(String titulo, String mensaje) {
		showMessage(mensaje, titulo, JOptionPane.WARNING_MESSAGE);
	}

	private static void showMessage(String titulo, String mensaje,
			int tipoMnesaje) {
		JOptionPane.showMessageDialog(null, titulo, mensaje, tipoMnesaje);
	}
}
