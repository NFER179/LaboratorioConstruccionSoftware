package backUp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
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
			backUp("ninaas");
			restoreDB();
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void backUp(String fileName) {
		try {
			String comando = mysqldumpPath + getCredentials()
					+ " > db_backup.sql";
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
	
	public static void restoreDB() throws IOException, SQLException {
		String sql = getSql();
		ejecutarSql(sql);
	}

	private static void ejecutarSql(String sql) throws SQLException {
		String[] sentenciasSql = sql.split(";");
		Statement stm = ConectorDB.GetInstancia().GetStatement();
		for (String sentencia : sentenciasSql) {
			sentencia = sentencia + ";";
			System.out.println(sentencia);
			stm.executeUpdate(sentencia);
		}
	}

	private static String getSql() throws FileNotFoundException, IOException {
		String document = getDocument();
		String sql = getSqlPuro(document);
		return sql;
	}

	private static String getDocument() throws FileNotFoundException,
			IOException {
		String objString = new String();
		StringBuffer objSB = new StringBuffer();
		FileReader objFR = new FileReader(new File("C:/ninaas.sql"));
		BufferedReader objBR = new BufferedReader(objFR);
		while ((objString = objBR.readLine()) != null) {
			objSB.append(objString);
		}
		objBR.close();
		return objSB.toString();
	}

	private static String getSqlPuro(String allDocument) {
		allDocument = allDocument.replace("DROP", "\nDROP");
		allDocument = allDocument.replace("UNLOCK TABLES;",
				"\nUNLOCK TABLES;\n");
		allDocument = allDocument.replace("--LOCK", "--\nLOCK");
		allDocument = allDocument.replace("*/;", "*/;\n");
		allDocument = allDocument.replace("/*", "\n/*");

		String[] inst1 = allDocument.split("\n");
		System.out.println(allDocument);
		String sql = "";
		boolean esSql = true;
		for (String linea : inst1) {
			linea = linea.trim();
			esSql = linea != "" && !linea.contains("--")
					&& !linea.contains("/*");
			if (esSql)
				sql += linea;
		}
		sql = sql.replace("﻿", "");
		return sql;
	}

	private static String getCredentials() {
		String mask = "-u%s -p%s %s";
		return String.format(mask, user, pass, dbName);
	}
}
