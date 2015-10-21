package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConectorDB {

	private static ConectorDB instancia = null;
	private Connection  conexion = null;
	private Statement statement = null;
	
	protected ConectorDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/PizzeriaWild";
			this.conexion = DriverManager.getConnection(url, "root", "root");
			this.statement = this.conexion.createStatement();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ConectorDB GetInstancia() {
		if (instancia == null)
			instancia = new ConectorDB();
		
		return instancia;
	}
	
	public Statement GetStatement() {
		if (this.conexion == null || this.statement == null){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost/PizzeriaWild";
				this.conexion = DriverManager.getConnection(url, "root", "root");
				this.statement = this.conexion.createStatement();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return this.statement;
	}
	
	public void CloseConnection() {
		if ( this.conexion != null )
			this.conexion = null;
		if ( this.statement != null )
			this.statement = null;
	}
}