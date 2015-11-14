package validacionesCampos;

public class Valida {

	public static boolean esDecimalPositivo(String input) {
		if (esDecimalValido(input)) {
			double value = Double.parseDouble(input);
			return value > 0;
		}
		return false;
	}

	public static boolean esEnteroPositivo(String input) {
		if (esEnteroValido(input)) {
			double value = Integer.parseInt(input);
			return value > 0;
		}
		return false;
	}

	public static boolean esDecimalValido(String input) {
		if (!esNullOVacio(input)) {
			try {
				Double.parseDouble(input);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		return false;
	}

	public static boolean esEnteroValido(String input) {
		if (!esNullOVacio(input)) {
			try {
				Integer.parseInt(input);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		return false;
	}

	public static boolean largoValido(String input, int maxLength) {
		if (!esNullOVacio(input)) {
			input = input.trim();
			return input.length() <= maxLength;
		}
		return false;
	}

	public static boolean esNullOVacio(String input) {
		return (input == null) ? true : input.trim().isEmpty();
	}
}
