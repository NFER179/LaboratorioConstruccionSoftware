package clasesImpresiones;

import archivos.ManejoArchivos;

public class ObjDatosPizzeria {
	private String direccion;
	private String telefono;
	private static String rutaUsuario = "configs/conf/usuario.txt";
	private static int numDir = 3;
	private static int numTel = 4;
	private static int parteValor = 1;

	/**
	 * Se compromete a funcionar correctamente si en la inicializacion de la
	 * aplicacion se cargan correctamente los datos del usuario
	 * */
	public ObjDatosPizzeria() {
		String texto = ManejoArchivos.getTextoArchivo(rutaUsuario);
		String[] partes = texto.split(";");
		String dir = partes[numDir].split(":")[parteValor].trim();
		String tel = partes[numTel].split(":")[parteValor].trim();
		this.setDireccion(dir);
		this.setTelefono(tel);
	}

	public ObjDatosPizzeria(String direccion, String telefono) {
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
}
