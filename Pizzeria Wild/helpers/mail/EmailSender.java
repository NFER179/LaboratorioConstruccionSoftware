package mail;

public class EmailSender {

	public static void main(String[] args) {
		String[] to = { "videlariveronicolas@gmail.com", "die3389@gmail.com",
				"nicofer179@gmail.com", "Estebanrivera77@gmail.com" };
		String asunto = "YA EXISTE EL MODULO DE MAIL";
		String mensaje = "Estimados, les comunico formalmente que la funcionalidad referida al envio de mail esta completa.\n"
				+ "Saludos coordiales,\n Pizzeria Wild";

		MailWildPizzeria a = new MailWildPizzeria(to, asunto, mensaje);
		try {
			a.mandarMail();
		} catch (Exception e) {
			System.out.println("CAGADAS!: " + e.toString());
		}
	}
}
