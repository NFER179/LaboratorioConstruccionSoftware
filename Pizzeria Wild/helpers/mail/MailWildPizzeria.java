package mail;

import java.util.Properties;

import javax.mail.AuthenticationFailedException;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import archivos.ManejoArchivos;

import validacionesCampos.Valida;

public class MailWildPizzeria extends Mail {

	private static String rutaArchivo = "configs/conf/email.txt";
	private String host = "smtp.gmail.com";

	public MailWildPizzeria(String pReceptor, String pAsunto, String pMensaje) {
		super("", "", pReceptor, pAsunto, pMensaje);
		String[] datos = ManejoArchivos.getTextoArchivo(rutaArchivo).split(";");
		String emisor = datos[0];
		String contrasenia = datos[1];
		this.setEmisor(emisor);
		this.setContrasenia(contrasenia);
	}

	public String getHost() {
		return host;
	}

	public void mandarMail() throws Exception {
		if (isValidMail()) {
			try {
				Session session = construirSession(this);
				MimeMessage mensaje = construirMensaje(this, session);
				enviarMail(this, session, mensaje);
			} catch (AuthenticationFailedException ex) {
				throw new Exception(
						"El usuario y la contrase�a son incorrectos: "
								+ ex.toString());
			} catch (AddressException ex) {
				throw new Exception("La direccion de correo es incorrecta: "
						+ ex.toString());
			} catch (MessagingException ex) {
				throw new Exception("Error en el cuerpo del mensaje: "
						+ ex.toString());
			} catch (Exception ex) {
				throw new Exception("Ocurrio una excepcion al enviar un mail: "
						+ ex.toString());
			}
		} else {
			throw new Exception("EL CONTENIDO DEL MAIL ES VACIO");
		}
	}

	private boolean isValidMail() {
		boolean ret = true;
		ret &= !Valida.esNullOVacio(this.para);
		ret &= !Valida.esNullOVacio(this.asunto);
		ret &= !Valida.esNullOVacio(this.mensaje);
		return ret;
	}

	private static MimeMessage construirMensaje(MailWildPizzeria mail,
			Session session) throws MessagingException, AddressException {
		MimeMessage message = new MimeMessage(session);

		message.setFrom(new InternetAddress(mail.getEmisor()));
		InternetAddress direccionActual = new InternetAddress(mail.para);
		message.addRecipient(Message.RecipientType.TO, direccionActual);

		message.setSubject(mail.asunto);
		message.setText(mail.mensaje);
		return message;
	}

	private static void enviarMail(MailWildPizzeria mail, Session session,
			MimeMessage message) throws NoSuchProviderException,
			MessagingException {
		Transport transport = session.getTransport("smtp");
		transport.connect(mail.getHost(), mail.getEmisor(),
				mail.getContrasenia());
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
	}

	private static Session construirSession(MailWildPizzeria mail) {
		Properties props = construirPropiedades(mail);
		Session session = Session.getDefaultInstance(props);
		return session;
	}

	private static Properties construirPropiedades(MailWildPizzeria mail) {
		Properties props = System.getProperties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", mail.getHost());
		props.put("mail.smtp.user", mail.getEmisor());
		props.put("mail.smtp.password", mail.getContrasenia());
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		return props;
	}

}
