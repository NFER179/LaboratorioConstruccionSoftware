package archivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class ManejoArchivos {

	public static String getTextoArchivo(String ruta) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		String ret = "";
		try {
			archivo = new File(ruta);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine()) != null)
				ret += linea;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return ret;
	}

	public static void modificarTextoArchivo(String ruta, String contenido) {
		FileWriter fichero = null;
		try {
			fichero = new FileWriter(ruta);
			fichero.write("");
			fichero.append(contenido);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
