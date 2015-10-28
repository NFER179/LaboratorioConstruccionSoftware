package utilidades;

import java.util.Calendar;

public class Fecha {

	public static String CurrentDate() {
		Calendar c = Calendar.getInstance();
		String Date = "";
		
		/*Obtener a�o*/
		String a�o = Integer.toString(c.get(Calendar.YEAR));
		
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
		
		Date = a�o + "-" + mes + "-" + dia;
		
		return Date;
	}
}