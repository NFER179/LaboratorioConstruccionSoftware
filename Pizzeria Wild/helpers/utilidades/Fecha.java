package utilidades;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import modelo.VentaModelo;

public class Fecha {
	private static DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

	public static String CurrentDate() {
		Calendar c = Calendar.getInstance();
		String Date = "";

		/* Obtener año */
		String año = Integer.toString(c.get(Calendar.YEAR));

		/* Obtener mes, se agrega un mes mas porque esta un mes menos. */
		int m = c.get(Calendar.MONTH);
		if (m < 12)
			m = m + 1;
		else
			m = 1;

		String mes = Integer.toString(m);
		if (mes.length() == 1)
			mes = "0" + mes;

		/* Obener dia */
		String dia = Integer.toString(c.get(Calendar.DATE));
		if (dia.length() == 1)
			dia = "0" + dia;

		Date = año + "-" + mes + "-" + dia;

		return Date;
	}

	public static String CurrentDateNicov() {
		Calendar cal = Calendar.getInstance();
		return formato.format(cal.getTime());
	}

	public static String CurrentDateFormato() {
		Calendar cal = Calendar.getInstance();
		DateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		return formato.format(cal.getTime());
	}

	public static String CurrentTime() {
		Calendar c = Calendar.getInstance();
		String time = "";

		String hora = Integer.toString(c.get(Calendar.HOUR));
		if (hora.length() == 1)
			hora = "0" + hora;

		String min = Integer.toString(c.get(Calendar.MINUTE));
		if (min.length() == 1)
			min = "0" + min;

		String seg = Integer.toString(c.get(Calendar.SECOND));
		if (seg.length() == 1)
			seg = "0" + seg;

		time = hora + ":" + min + ":" + seg;

		return time;
	}

	public static String[] rangosPorSemana(int anio, int numeroSemana) {
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(Calendar.YEAR, anio);
		cal.set(Calendar.WEEK_OF_YEAR, numeroSemana);
		String fechaInicio = formato.format(cal.getTime());
		cal.add(Calendar.WEEK_OF_MONTH, 1); // Agrego una semana
		String fechaFin = formato.format(cal.getTime());
		return new String[] { fechaInicio, fechaFin };
	}

	public static String[] rangosPorMes(int anio, int numeroMes) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, anio);
		cal.set(Calendar.MONTH, numeroMes - 1);
		cal.set(Calendar.DATE, 1);
		String fechaInicio = formato.format(cal.getTime());
		cal.add(Calendar.MONTH, 1); // Agrego un mes
		String fechaFin = formato.format(cal.getTime());
		return new String[] { fechaInicio, fechaFin };
	}

	public static int ObtenerDia(String fecha) {
		String[] s = fecha.split("-");
		return Integer.parseInt(s[2]);
	}

	public static int ObtenerMes(String fecha) {
		String[] s = fecha.split("-");
		return Integer.parseInt(s[1]);
	}

	public static int ObtenerAño(String fecha) {
		String[] s = fecha.split("-");
		return Integer.parseInt(s[0]);
	}

	public static List<String> Fechas() {
		List<String> fechas = new ArrayList<String>();
		String FechaInicio = VentaModelo.ObtenerFechaInicioVentas();

		Calendar c = Calendar.getInstance();
		int year = Fecha.ObtenerAño(FechaInicio);
		int month = Fecha.ObtenerMes(FechaInicio);
		int date = Fecha.ObtenerDia(FechaInicio);
		c.set(year, month - 1, date);

		boolean NotCurrentDate = true;
		while (NotCurrentDate) {
			String fecha = formato.format(c.getTime());
			fechas.add(fecha);
			if (Fecha.ObtenerAño(Fecha.CurrentDate()) == c.get(Calendar.YEAR)
					&& Fecha.ObtenerMes(Fecha.CurrentDate()) == c
							.get(Calendar.MONTH)
					&& Fecha.ObtenerDia(Fecha.CurrentDate()) == c
							.get(Calendar.DATE)) {
				NotCurrentDate = false;
			}
			c.add(Calendar.DATE, 1);
		}

		return fechas;
	}

	public static String format(Date fecha) {
		String ret = "";
		ret = formato.format(fecha);
		return ret;
	}

	@SuppressWarnings("deprecation")
	public static int numSemana(Date fecha) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, fecha.getYear());
		c.set(Calendar.MONTH, fecha.getMonth());
		c.set(Calendar.DATE, fecha.getDate());
		return c.get(Calendar.WEEK_OF_YEAR) + 1;
	}

	public static String format(String date) {
		String ret = "";
		String[] datos = date.split("-");
		ret = datos[2] + "/" + datos[1] + "/" + datos[0];
		return ret;
	}
}