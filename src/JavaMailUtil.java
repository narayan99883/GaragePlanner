import java.util.Properties;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
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
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class JavaMailUtil {

	// general send mail
	public static void sendMail(String recipient) {
		System.out.println("Preparing to send message");
		Properties properties = new Properties();

		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		String myAccountEmail = "garageplanner99883@gmail.com";
		String password = "IAmGaragePlanning";

		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(myAccountEmail, password);
			}
		});

		Message message = prepareMessage(session, myAccountEmail, recipient);
		try {
			Transport.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("message sent successfully!");
	}

	// general email with file
	public static Message prepareMessage(Session session, String myAccountEmail, String recipient) {

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(myAccountEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
			message.setSubject("EMAIL FROM JAVA");
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText("I am sorry");
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			messageBodyPart = new MimeBodyPart();
			String filename = "images/garageLayout.jpg";
			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(filename);
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
			return message;
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// send mail for layout
	public static void sendDisplayMail(String recipient) {
		System.out.println("Preparing to send message");
		Properties properties = new Properties();

		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		String myAccountEmail = "garageplanner99883@gmail.com";
		String password = "IAmGaragePlanning";

		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(myAccountEmail, password);
			}
		});

		Message message = prepareDisplayMessage(session, myAccountEmail, recipient);
		try {
			Transport.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("message sent successfully!");
	}

	// prepare mail for layout
	public static Message prepareDisplayMessage(Session session, String myAccountEmail, String recipient) {

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(myAccountEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
			message.setSubject("From Java: Garage Layout");
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText(
					"Linked you will find a jpg file with the layout of your garage as understood by your Garage Manager");
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			messageBodyPart = new MimeBodyPart();
			String filename = "images/garageLayout.jpg";
			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(filename);
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
			return message;
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// send mail for list
	public static void sendListMail(String recipient) {
		System.out.println("Preparing to send message");
		Properties properties = new Properties();

		properties.put("mail.smtp.auth", "true"); 
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		String myAccountEmail = "garageplanner99883@gmail.com";
		String password = "IAmGaragePlanning";

		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(myAccountEmail, password);
			}
		});

		Message message = prepareListMessage(session, myAccountEmail, recipient);
		try {
			Transport.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("message sent successfully!");

	}

	// prepare mail for list
	public static Message prepareListMessage(Session session, String myAccountEmail, String recipient) {

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(myAccountEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
			message.setSubject("From Java: Garage Object List");
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText(
					"Linked you will find a txt file with all the objects in your garage in the order they were entered in.");
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			messageBodyPart = new MimeBodyPart();

			String filename = "txtfiles/textdoc.txt";
			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(filename);
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
			return message;
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	} 
	
	// send mail for user guide
		public static void sendGuideMail(String recipient) {
			System.out.println("Preparing to send message");
			Properties properties = new Properties();

			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls.enable", "true");
			properties.put("mail.smtp.host", "smtp.gmail.com");
			properties.put("mail.smtp.port", "587");

			String myAccountEmail = "garageplanner99883@gmail.com";
			String password = "IAmGaragePlanning";

			Session session = Session.getInstance(properties, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(myAccountEmail, password);
				}
			});

			Message message = prepareGuideMessage(session, myAccountEmail, recipient);
			try {
				Transport.send(message);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("message sent successfully!");

		}

		// prepare mail for list
		public static Message prepareGuideMessage(Session session, String myAccountEmail, String recipient) {

			try {
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(myAccountEmail));
				message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
				message.setSubject("From Java: Garage Manager User Guide");
				BodyPart messageBodyPart = new MimeBodyPart();
				messageBodyPart.setText(
						"Linked you will find a pdf file with the user guide and instructions on how to use this program.");
				Multipart multipart = new MimeMultipart();
				multipart.addBodyPart(messageBodyPart);
				messageBodyPart = new MimeBodyPart();

				String filename = "txtfiles/UserGuide.pdf";
				DataSource source = new FileDataSource(filename);
				messageBodyPart.setDataHandler(new DataHandler(source));
				messageBodyPart.setFileName(filename);
				multipart.addBodyPart(messageBodyPart);
				message.setContent(multipart);
				return message;
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

}