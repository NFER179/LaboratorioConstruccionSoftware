package backUp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import archivos.ManejoArchivos;

import conexion.ConectorDB;

public class BackUp {

	private static String rutaUsuario = "configs/usuario.txt";

	private static String rutaDB = "configs/db.sql";

	private static String mysqldumpPath = System.getenv().get("ProgramFiles")
			.replace("\\", "/")
			+ "/MySQL/MySQL Server 5.7/bin/mysqldump ";
	private static String mysqldumpPath2 = System.getenv().get("ProgramFiles")
			.replace("\\", "/")
			+ "/MySQL/MySQL Server 5.7/bin/mysqldump ";

	public static void backUp(String path) throws Exception {
		try {
			String comando = mysqldumpPath + getCredentials();
			Runtime objRT = Runtime.getRuntime();

			Process objProcess = objRT.exec(comando);

			InputStream is = objProcess.getInputStream();
			FileOutputStream fos = new FileOutputStream(path);
			byte[] buffer = new byte[1000];

			int esLeido = is.read(buffer);
			while (esLeido > 0) {
				fos.write(buffer, 0, esLeido);
				esLeido = is.read(buffer);
			}
			fos.close();
		} catch (Exception e) {
			try {
				backUp2(path);
			} catch (Exception e2) {
				throw new Exception(e.toString());
			}
		}
	}

	public static void backUp2(String path) throws Exception {
		try {
			String comando = mysqldumpPath2 + getCredentials();
			Runtime objRT = Runtime.getRuntime();

			Process objProcess = objRT.exec(comando);

			InputStream is = objProcess.getInputStream();
			// String path = String.format(backUpPath, path);
			FileOutputStream fos = new FileOutputStream(path);
			byte[] buffer = new byte[1000];

			int esLeido = is.read(buffer);
			while (esLeido > 0) {
				fos.write(buffer, 0, esLeido);
				esLeido = is.read(buffer);
			}
			fos.close();
		} catch (Exception e) {
			throw new Exception(e.toString());
		}
	}

	public static void restore(String nombreArchivo) throws IOException,
			SQLException {
		String sql = getSql(nombreArchivo);
		ejecutarSql(sql);
	}

	public static void inicializarBD() throws IOException, SQLException {
		File file = new File(rutaDB);
		String path = file.getAbsolutePath();
		ejecutarSql(ManejoArchivos.getTextoArchivo(path));
	}

	public static void crearUsuario(String user, String pass)
			throws SQLException {
		Statement stm = ConectorDB.GetInstancia().GetStatement();
		String sentencia = "GRANT ALL ON PizzeriaWild.* TO '%s'@'localhost' IDENTIFIED BY '%s'";
		sentencia = String.format(sentencia, user, pass);
		stm.executeUpdate(sentencia);

	}

	private static void ejecutarSql(String sql) throws SQLException {
		String[] sentenciasSql = sql.split(";");
		Statement stm = ConectorDB.GetInstancia().GetStatement();
		for (String sentencia : sentenciasSql) {
			sentencia = sentencia + ";";
			stm.executeUpdate(sentencia);
		}
	}

	private static String getSql(String path) throws FileNotFoundException,
			IOException {
		String document = getDocument(path);
		String sql = getSentencesSQL(document);
		return sql;
	}

	private static String getDocument(String path)
			throws FileNotFoundException, IOException {
		String objString = new String();
		StringBuffer objSB = new StringBuffer();
		FileReader objFR = new FileReader(new File(path));
		BufferedReader objBR = new BufferedReader(objFR);
		while ((objString = objBR.readLine()) != null) {
			objSB.append(objString);
		}
		objBR.close();
		return objSB.toString();
	}

	private static String getSentencesSQL(String allDocument) {
		String ret = "drop database if exists PizzeriaWild;"
				+ "create database PizzeriaWild;" + "use PizzeriaWild;";
		List<String> allSQL = getSqlList(allDocument);
		List<String> orden = ordenTablas();
		for (String tabla : orden) {
			for (int i = 0; i < allSQL.size(); i++) {
				String lineaSql = allSQL.get(i);
				if (lineaSql.contains(tabla)) {
					ret += lineaSql;
					allSQL.set(i, "");
				}
			}
		}
		return ret;
	}

	private static List<String> getSqlList(String allDocument) {
		List<String> ret = new ArrayList<String>();
		allDocument = allDocument.replace("DROP", "\nDROP");
		allDocument = allDocument.replace("UNLOCK TABLES;",
				"\nUNLOCK TABLES;\n");
		allDocument = allDocument.replace("--LOCK", "--\nLOCK");
		allDocument = allDocument.replace("*/;", "*/;\n");
		allDocument = allDocument.replace("/*", "\n/*");
		allDocument = allDocument.replace("﻿", "");

		String[] lista = allDocument.split("\n");
		boolean esSql = true;
		for (String linea : lista) {
			linea = linea.trim();
			esSql = linea != "" && !linea.contains("--")
					&& !linea.contains("/*") && !linea.contains("UNLOCK")
					&& !linea.contains("LOCK");
			if (esSql)
				ret.add(linea);
		}
		return ret;
	}

	private static List<String> ordenTablas() {
		List<String> ret = new LinkedList<String>();
		ret.add("DROP TABLE IF EXISTS `preferencias`");
		ret.add("CREATE TABLE `preferencias`");
		ret.add("DROP TABLE IF EXISTS `estilos`");
		ret.add("CREATE TABLE `estilos`");
		ret.add("DROP TABLE IF EXISTS `cliente`");
		ret.add("CREATE TABLE `cliente`");
		ret.add("DROP TABLE IF EXISTS `producto`");
		ret.add("CREATE TABLE `producto`");
		ret.add("DROP TABLE IF EXISTS `sabor_producto`");
		ret.add("CREATE TABLE `sabor_producto`");
		ret.add("DROP TABLE IF EXISTS `venta`");
		ret.add("CREATE TABLE `venta`");
		ret.add("DROP TABLE IF EXISTS `venta_producto`");
		ret.add("CREATE TABLE `venta_producto`");
		ret.add("DROP TABLE IF EXISTS `combo`");
		ret.add("CREATE TABLE `combo`");

		ret.add("DROP TABLE IF EXISTS `combo_activo`");
		ret.add("CREATE TABLE `combo_activo`");

		ret.add("DROP TABLE IF EXISTS `combo_producto`");
		ret.add("CREATE TABLE `combo_producto`");

		ret.add("DROP TABLE IF EXISTS `combo_venta`");
		ret.add("CREATE TABLE `combo_venta`");

		ret.add("DROP TABLE IF EXISTS `repartidor`");
		ret.add("CREATE TABLE `repartidor`");
		ret.add("DROP TABLE IF EXISTS `delivery`");
		ret.add("CREATE TABLE `delivery`");
		ret.add("DROP TABLE IF EXISTS `delivery_venta`");
		ret.add("CREATE TABLE `delivery_venta`");
		ret.add("DROP TABLE IF EXISTS `proveedor`");
		ret.add("CREATE TABLE `proveedor`");
		ret.add("DROP TABLE IF EXISTS `categoria`");
		ret.add("CREATE TABLE `categoria`");
		ret.add("DROP TABLE IF EXISTS `materia_prima`");
		ret.add("CREATE TABLE `materia_prima`");
		ret.add("DROP TABLE IF EXISTS `mp_categoria`");
		ret.add("CREATE TABLE `mp_categoria`");
		ret.add("DROP TABLE IF EXISTS `mp_proveedor`");
		ret.add("CREATE TABLE `mp_proveedor`");
		ret.add("DROP TABLE IF EXISTS `pedido`");
		ret.add("CREATE TABLE `pedido`");
		ret.add("DROP TABLE IF EXISTS `pedido_proveedor`");
		ret.add("CREATE TABLE `pedido_proveedor`");
		ret.add("DROP TABLE IF EXISTS `pedido_mp`");
		ret.add("CREATE TABLE `pedido_mp`");

		ret.add("INSERT INTO `preferencias");
		ret.add("INSERT INTO `estilos");
		ret.add("INSERT INTO `cliente");
		ret.add("INSERT INTO `producto");
		ret.add("INSERT INTO `sabor_producto");
		ret.add("INSERT INTO `venta");
		ret.add("INSERT INTO `venta_producto");
		ret.add("INSERT INTO `combo");

		ret.add("INSERT INTO `combo_activo");
		ret.add("INSERT INTO `combo_producto");
		ret.add("INSERT INTO `combo_venta");

		ret.add("INSERT INTO `repartidor");
		ret.add("INSERT INTO `delivery");
		ret.add("INSERT INTO `delivery_venta");
		ret.add("INSERT INTO `proveedor");
		ret.add("INSERT INTO `categoria");
		ret.add("INSERT INTO `materia_prima");
		ret.add("INSERT INTO `mp_categoria");
		ret.add("INSERT INTO `mp_proveedor");
		ret.add("INSERT INTO `pedido");
		ret.add("INSERT INTO `pedido_proveedor");
		ret.add("INSERT INTO `pedido_mp");
		ret.add("INSERT INTO `estilos");
		return ret;
	}

	private static String getCredentials() {
		String documento = ManejoArchivos.getTextoArchivo(rutaUsuario);
		String[] partes = documento.split(";");
		String user = partes[0].split(":")[1];
		String pass = partes[1].split(":")[1];
		String dbName = partes[2].split(":")[1];
		String mask = "-u%s -p%s %s";
		return String.format(mask, user, pass, dbName);
	}

}
