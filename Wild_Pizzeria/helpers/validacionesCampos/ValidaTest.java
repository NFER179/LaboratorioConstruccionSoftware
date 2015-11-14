package validacionesCampos;

import static org.junit.Assert.*;
import org.junit.Test;

public class ValidaTest {

	@Test
	public void positiveIntegerValid0() {
		String input = "1";
		boolean evaluacion = Valida.esEnteroPositivo(input);
		assertTrue(evaluacion);
	}

	@Test
	public void positiveIntegerValid1() {
		String input = "456000097";
		boolean evaluacion = Valida.esEnteroPositivo(input);
		assertTrue(evaluacion);
	}

	@Test
	public void positiveIntegerValid2() {
		String input = "456000097";
		boolean evaluacion = Valida.esEnteroPositivo(input);
		assertTrue(evaluacion);
	}

	@Test
	public void positiveIntegerInvalid0() {
		String input = "***";
		boolean evaluacion = Valida.esEnteroPositivo(input);
		assertFalse(evaluacion);
	}

	@Test
	public void positiveIntegerInvalid1() {
		String input = "   ";
		boolean evaluacion = Valida.esEnteroPositivo(input);
		assertFalse(evaluacion);
	}

	@Test
	public void positiveIntegerInvalid2() {
		String input = "-1";
		boolean evaluacion = Valida.esEnteroPositivo(input);
		assertFalse(evaluacion);
	}

	@Test
	public void positiveIntegerInvalid3() {
		String input = "1.1119";
		boolean evaluacion = Valida.esEnteroPositivo(input);
		assertFalse(evaluacion);
	}

	@Test
	public void positiveIntegerInvalid4() {
		String input = "0";
		boolean evaluacion = Valida.esEnteroPositivo(input);
		assertFalse(evaluacion);
	}

	@Test
	public void positiveDoubleValid0() {
		String input = "1.0";
		boolean evaluacion = Valida.esDecimalPositivo(input);
		assertTrue(evaluacion);
	}

	@Test
	public void positiveDoubleValid1() {
		String input = "456000097.0";
		boolean evaluacion = Valida.esDecimalPositivo(input);
		assertTrue(evaluacion);
	}

	@Test
	public void positiveDoubleValid2() {
		String input = "0.00000001";
		boolean evaluacion = Valida.esDecimalPositivo(input);
		assertTrue(evaluacion);
	}

	@Test
	public void positiveDoubleInvalid0() {
		String input = "***";
		boolean evaluacion = Valida.esDecimalPositivo(input);
		assertFalse(evaluacion);
	}

	@Test
	public void positiveDoubleInvalid1() {
		String input = "   ";
		boolean evaluacion = Valida.esDecimalPositivo(input);
		assertFalse(evaluacion);
	}

	@Test
	public void positiveDoubleInvalid2() {
		String input = "-1.99";
		boolean evaluacion = Valida.esDecimalPositivo(input);
		assertFalse(evaluacion);
	}

	@Test
	public void positiveDoubleInvalid3() {
		String input = "0 ";
		boolean evaluacion = Valida.esDecimalPositivo(input);
		assertFalse(evaluacion);
	}

	@Test
	public void lengthValid0() {
		String input = "12345";
		int largoMaximo = 5;
		boolean evaluacion = Valida.largoValido(input, largoMaximo);
		assertTrue(evaluacion);
	}

	@Test
	public void lengthValid1() {
		String input = "1234";
		int largoMaximo = 5;
		boolean evaluacion = Valida.largoValido(input, largoMaximo);
		assertTrue(evaluacion);
	}

	@Test
	public void lengthInvalid1() {
		String input = "soy un input de mas de 5 caracteres";
		int largoMaximo = 5;
		boolean evaluacion = Valida.largoValido(input, largoMaximo);
		assertFalse(evaluacion);
	}

	// isNullOrEmpty
	@Test
	public void lengthInvalid2() {
		String input = "123456";
		int largoMaximo = 5;
		boolean evaluacion = Valida.largoValido(input, largoMaximo);
		assertFalse(evaluacion);
	}

	@Test
	public void isNullOrEmptyValid0() {
		String input = null;
		boolean evaluacion = Valida.esNullOVacio(input);
		assertTrue(evaluacion);
	}

	@Test
	public void isNullOrEmptyValid1() {
		String input = "";
		boolean evaluacion = Valida.esNullOVacio(input);
		assertTrue(evaluacion);
	}

	@Test
	public void isNullOrEmptyInvalid2() {
		String input = "        ";
		boolean evaluacion = Valida.esNullOVacio(input);
		assertTrue(evaluacion);
	}

	@Test
	public void isNullOrEmptyInvalid0() {
		String input = "  123456  ";
		boolean evaluacion = Valida.esNullOVacio(input);
		System.out.println(input);
		assertFalse(evaluacion);
	}

	@Test
	public void isNullOrEmptyInvalid1() {
		String input = "    - ";
		boolean evaluacion = Valida.esNullOVacio(input);
		System.out.println(input);
		assertFalse(evaluacion);
	}
}
