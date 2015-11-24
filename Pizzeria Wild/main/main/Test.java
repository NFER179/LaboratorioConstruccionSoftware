package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import utilidades.Fecha;
import daoImplementacion.ClienteImp;
import dto.ClienteDTO;

public class Test {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
//		Map m = System.getenv();
//		Set k = m.keySet();
//		Iterator i = k.iterator();
//		while (i.hasNext()) {
//			String key = (String) i.next();
//			String value = (String) m.get(key);
//			System.out.println(key + " - " + value);
//		}
		System.out.println(System.getenv().get("ProgramFiles"));
		// Process p = Runtime.getRuntime().exec("cmd.exe/C echo %windir%");
		// BufferedReader br = new BufferedReader(new
		// InputStreamReader(p.getInputStream()));
		// String jaja = br.readLine();
		// System.out.println(jaja);
	}
}