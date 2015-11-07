package backUp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.SQLException;
import java.sql.Statement;

import conexion.ConectorDB;

import dto.CategoriaDTO;

public class BackUp {
	private static String user = "root";
	private static String pass = "root";
	private static String dbName = "pizzeriawild";
	private static String mysqldumpPath = "C:/Archivos de programa/MySQL/MySQL Server 5.5/bin/mysqldump ";
	private static String backUpPath = "persistencia/backUp/%s.sql";

	public static void main(String[] args) {
		try {
			resetDB_gtbio();
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void backUp(String fileName) {
		try {
			String comando = mysqldumpPath + getCredentials();
			Runtime objRT = Runtime.getRuntime();
			Process objProcess = objRT.exec(comando);

			InputStream is = objProcess.getInputStream();
			String path = String.format(backUpPath, fileName);
			FileOutputStream fos = new FileOutputStream(path);
			byte[] buffer = new byte[1000];

			int esLeido = is.read(buffer);
			while (esLeido > 0) {
				fos.write(buffer, 0, esLeido);
				esLeido = is.read(buffer);
			}
			fos.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void restore(String fileName) {
		try {
			// mysql -u root -p*** pandurito_bd <C:\ejemplo.sql
			String comando = "mysql " + mysqldumpPath + getCredentials();
			String path = String.format(backUpPath, fileName);
			// comando += " <" + path;
			comando += " < C:\\nina.sql";
			// comando = "pizzeriawild < C:\nina.sql";
			// Statement stm = ConectorDB.GetInstancia().GetStatement();
			// stm.executeQuery(comando);
			System.out.println(comando);
			Runtime objRT = Runtime.getRuntime();
			Process objProcess = objRT.exec(comando);
			InputStream is = objProcess.getInputStream();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void ejecutar(String archivo) {
		try {
			String comando;
			Process proceso = Runtime.getRuntime().exec(archivo);
			BufferedReader lector = new BufferedReader(new InputStreamReader(
					proceso.getInputStream()));
			while ((comando = lector.readLine()) != null) {
				System.out.println(comando);
			}
			lector.close();
		} catch (Exception err) {
			err.printStackTrace();
		}
	}

	public static void restaurar(String fileName) {
		ConectorDB conector = ConectorDB.GetInstancia();
		Statement stm = conector.GetStatement();
		String path = "C:\\Documents and Settings\\nicolas\\Escritorio\\Wild\\trunk\\Pizzeria Wild\\"
				+ String.format(backUpPath, fileName) + ";";
		String sql = "source C:\\nina.sql";

		try {
			stm.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			conector.CloseConnection();
		}
	}

	// public static void restaurar2(String fileName) {
	// try {
	// // Initialize object for ScripRunner
	// ScriptRunner sr = new ScriptRunner(ConectorDB.GetInstancia(),
	// false, false);
	//
	// // Give the input file to Reader
	// Reader reader = new BufferedReader(new FileReader(fileName));
	//
	// // Exctute script
	// sr.runScript(reader);
	//
	// } catch (Exception e) {
	// System.err.println("Failed to Execute" + fileName
	// + " The error is " + e.getMessage());
	// }
	// }

	public static void resetDB_gtbio() throws IOException, SQLException {
		String s = new String();
		StringBuffer sb = new StringBuffer();
		FileReader fr = new FileReader(new File("C:/nina.sql"));
		BufferedReader br = new BufferedReader(fr);
		while ((s = br.readLine()) != null) {
			sb.append(s);
		}
		br.close();
		Statement stm = ConectorDB.GetInstancia().GetStatement();
		String[] inst = sb.toString().split(";");
		String[] inst1 = sb.toString().split("\n");
		for (String linea : inst1) {
			if (linea.contains("--")) {
				linea = "";
			}
		}
		// be sure to not have line starting with "--" or "/*" or any
		// other non aplhabetical character
		for (int i = 0; i < inst.length; i++) {
			// we ensure that there is no spaces before or after the request
			// string in order to not execute empty statements
			if (!inst[i].trim().equals("")) {
				String q = inst[i].replace("﻿", "");
				System.out.println(q);
				stm.executeUpdate(q + ";");
			}
		}
	}

	private static String getCredentials() {
		String mask = "-u%s -p%s %s";
		return String.format(mask, user, pass, dbName);
	}
}
