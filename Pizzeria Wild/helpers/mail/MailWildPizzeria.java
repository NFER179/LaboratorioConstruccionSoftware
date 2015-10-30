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

import validacionesCampos.Valida;

public class MailWildPizzeria extends Mail {

	private static String usuario = "wildprizzeria@gmail.com";
	private static String contrasenia = "wildpizzeri";
	public String host = "smtp.gmail.com";

	public MailWildPizzeria() {
		super(usuario, contrasenia);
	}

	public MailWildPizzeria(String[] pReceptor, String pAsunto, String pMensaje) {
		super(usuario, contrasenia, pReceptor, pAsunto, pMensaje);
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
						"El usuario y la contraseña son incorrectos: "
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
		ret &= Valida.esEnteroPositivo(this.para.length+"");
		ret &= Valida.esNullOVacio(this.asunto);
		ret &= Valida.esNullOVacio(this.mensaje);
		return ret;
	}

	private static MimeMessage construirMensaje(MailWildPizzeria mail,
			Session session) throws MessagingException, AddressException {
		MimeMessage message = new MimeMessage(session);

		message.setFrom(new InternetAddress(mail.getEmisor()));
		String[] receptores = mail.para;
		// Agrego los receptores
		for (int i = 0; i < receptores.length; i++) {
			InternetAddress direccionActual = new InternetAddress(receptores[i]);
			message.addRecipient(Message.RecipientType.TO, direccionActual);
		}
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
		return props;
	}

}
