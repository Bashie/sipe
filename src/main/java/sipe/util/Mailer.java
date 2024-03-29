package sipe.util;

import java.io.File;
import java.io.IOException;
import java.security.Security;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Component;

import sipe.model.Archivo;
import sipe.model.Sesion;
import sipe.model.Turno;

@Component
public class Mailer {
	private Properties props;
    final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	
	@PostConstruct
	private void init() {
		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		props = new Properties();
		 props.put("mail.smtp.auth", "true");
		 props.put("mail.smtp.starttls.enable", "true"); 
		 props.put("mail.smtp.host", "smtp.gmail.com");
		 props.put("mail.smtp.port", "587");
	}
	
	public void sendMail(String para, String Subject, String cuerpo, Archivo archivo) {
		Session session = Session.getInstance(props, new Authenticator() {
		    @Override
		    protected PasswordAuthentication getPasswordAuthentication() {
		        return new PasswordAuthentication("cecilia.gabelloni@gmail.com", Cryptor.decryptWithCipher("ZBJggskdiHU9L6cJj9GBsA=="));
		    }
		});
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress("sipe@cilsa.org"));
			message.setRecipients(
			Message.RecipientType.TO, InternetAddress.parse(para));
			message.setSubject(Subject);

			MimeBodyPart mimeBodyPart = new MimeBodyPart();
			mimeBodyPart.setContent(cuerpo, "text/html");

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(mimeBodyPart);
			if(!Objects.isNull(archivo)) {
				MimeBodyPart attachmentPart = new MimeBodyPart();
				attachmentPart.attachFile(new File(archivo.getPath() + archivo.getNombre()));
				multipart.addBodyPart(attachmentPart);
			}
			message.setContent(multipart);
			Transport.send(message);
		} catch (MessagingException|IOException e) {
			e.printStackTrace();
		}		
	}
	
	public String getTurnoMessageBody(Turno turno, Boolean status) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<h1>Su turno ha sido" + (status ? "confirmado" : "Cancelado") + "</h1><br>");
		buffer.append("Pr&aacute;ctica: " + turno.getPracticaProfesional().getProfesional().getAreaDesarrollo() + "<br>");
		buffer.append("Fecha: " + turno.getInicio().format(DateTimeFormatter.ISO_LOCAL_DATE));
		buffer.append(" a las " + turno.getInicio().format(DateTimeFormatter.ISO_LOCAL_TIME) + "<br>");
		buffer.append("Profesional: " + turno.getPracticaProfesional().getProfesional().getNombreCompleto() + "<br>");
		buffer.append("Padre/Tutor: " + turno.getPracticaProfesional().getTutor().getNombreCompleto()+ "<br>");
		return buffer.toString();
	}
	
	public String getSesionMessageBody(Sesion sesion, Boolean status, String comentario) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<h1>Se le ha compartido la siguiente sesi&oacute;n</h1><br>");
		buffer.append("Pr&aacute;ctica: " + sesion.getPracticaProfesional().getProfesional().getAreaDesarrollo() + "<br>");
		buffer.append("Fecha: " + sesion.getInicio().format(DateTimeFormatter.ISO_LOCAL_DATE));
		buffer.append(" a las " + sesion.getInicio().format(DateTimeFormatter.ISO_LOCAL_TIME) + "<br>");
		buffer.append("Profesional: " + sesion.getPracticaProfesional().getProfesional().getNombreCompleto() + "<br>");
		buffer.append("Padre/Tutor: " + sesion.getPracticaProfesional().getTutor().getNombreCompleto()+ "<br>");
		if (!Objects.isNull(sesion.getNotas())) {
			buffer.append("Notas: " + sesion.getNotas()+ "<br>");
		}
		if (!Objects.isNull(comentario)) {
			buffer.append("Mensaje: " + comentario + "<br>");
		}
		return buffer.toString();
	}
}
