package utilidades;

import java.util.Calendar;

public class Fecha {

	public static String CurrentDate() {
		Calendar c = Calendar.getInstance();
		String Date = "";
		
		/*Obtener año*/
		String año = Integer.toString(c.get(Calendar.YEAR));
		
		/* Obtener mes, se agrega un mes mas porque esta un mes menos. */
		int m = c.get(Calendar.MONTH);
		if(m < 12)
			m = m + 1;
		else
			m = 1;
		
		String mes = Integer.toString(m);
		if(mes.length() == 1)
			mes = "0" + mes;
		
		/* Obener dia */
		String dia = Integer.toString(c.get(Calendar.DATE));
		if(dia.length() == 1)
			dia = "0" + dia;
		
		Date = año + "-" + mes + "-" + dia;
		
		return Date;
	}

	public static String CurrentTime() {
		Calendar c = Calendar.getInstance();
		String time = "";

		String hora = Integer.toString(c.get(Calendar.HOUR));
		if(hora.length() == 1)
			hora = "0" + hora;
		
		String min = Integer.toString(c.get(Calendar.MINUTE));
		if(min.length() == 1)
			min = "0" + min;
		
		String seg = Integer.toString(c.get(Calendar.SECOND));
		if(seg.length() == 1)
			seg = "0" + seg;
		
		time = hora + ":" + min + ":" + seg;
		
		return time;
	}
}