package mail;

public class Mail {
	private String emisor;
	private String contrasenia;
	public String para;
	public String asunto;
	public String mensaje;

	public Mail(String pEmisor, String pContrasenia) {
		this.emisor = pEmisor;
		this.contrasenia = pContrasenia;
	}

	public Mail(String pEmisor, String pContrasenia, String pReceptor,
			String pAsunto, String pMensaje) {
		this.emisor = pEmisor;
		this.contrasenia = pContrasenia;
		this.para = pReceptor;
		this.asunto = pAsunto;
		this.mensaje = pMensaje;
	}

	public String getEmisor() {
		return emisor;
	}

	public String getContrasenia() {
		return this.contrasenia;
	}

	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
}
