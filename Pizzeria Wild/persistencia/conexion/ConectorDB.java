package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import utilidades.Msj;

import archivos.ManejoArchivos;

public class ConectorDB {

	private static String rutaUsuario = "configs/conf/usuario.txt";
	private static ConectorDB instancia = null;
	private Connection conexion = null;
	private Statement statement = null;

	protected ConectorDB() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new Exception("Error al conectarse a la base de datos");
		}
		String url = "jdbc:mysql://localhost";
		String texto = ManejoArchivos.getTextoArchivo(rutaUsuario);
		String[] partes = texto.split(";");
		String dbUser = partes[0].split(":")[1].trim();
		String dbPass = partes[1].split(":")[1].trim();
		String dbName = partes[2].split(":")[1].trim();

		if (!dbName.equals(""))
			url += "/" + dbName;
		if (dbUser.equals("") && dbPass.equals(""))
			dbPass = dbUser = "root";

		try {
			this.conexion = DriverManager.getConnection(url, dbUser, dbPass);
		} catch (SQLException e1) {
			throw new Exception(
					"El usuario no esta registrado o no tiene los permisos necesarios");
		}
		try {
			this.statement = this.conexion.createStatement();
		} catch (SQLException e) {
			throw new Exception(
					"Error inesperado al conectarse a la base de datos");

		}
	}

	public static ConectorDB GetInstancia() {
		if (instancia == null) {
			try {
				instancia = new ConectorDB();
			} catch (Exception e) {
				Msj.error("Error de conexion",
						"Ocurrio un error al conectarse a la base de datos: "
								+ e.toString());
			}
		}
		return instancia;
	}

	public Statement GetStatement() {
		if (this.conexion == null || this.statement == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost";
				String texto = ManejoArchivos.getTextoArchivo(rutaUsuario);
				String[] partes = texto.split(";");
				String dbUser = partes[0].split(":")[1].trim();
				String dbPass = partes[1].split(":")[1].trim();
				String dbName = partes[2].split(":")[1].trim();

				if (!dbName.equals(""))
					url += "/" + dbName;
				if (dbUser.equals("") && dbPass.equals(""))
					dbPass = dbUser = "root";
				this.conexion = DriverManager
						.getConnection(url, dbUser, dbPass);
				this.statement = this.conexion.createStatement();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return this.statement;
	}

	public void CloseConnection() {
		if (this.conexion != null)
			this.conexion = null;
		if (this.statement != null)
			this.statement = null;
	}
}