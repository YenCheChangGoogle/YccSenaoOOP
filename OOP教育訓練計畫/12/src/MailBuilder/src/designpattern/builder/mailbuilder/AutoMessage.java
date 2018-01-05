package designpattern.builder.mailbuilder;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public abstract class AutoMessage {
	protected String body = "";
	protected String from = "";
	protected Date sendDate = null;
	protected String subject = "";
	protected String to = "";

	public AutoMessage() {
	}

	public String getBody() {
		return this.body;
	}

	public String getFrom() {
		return this.from;
	}

	public String getSubject() {
		return subject;
	}

	public String getTo() {
		return to;
	}

	public void send() {
		String smtpHost = "smtp.anet.net.tw";
		String from = "leoshiang@gmail.com";
		String to = "leoshiang@hotmail.com";

		Properties properties = new Properties();
		properties.put("mail.smtp.host", smtpHost);
		Session session = Session.getDefaultInstance(properties, null);
		try {
			// InternetAddress[] address = { new InternetAddress(to)};
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO, to);
			message.setSubject("Hello from Design Pattern");
			message.setSentDate(sendDate);
			message.setText("Hi,\n事情進行得如何?");
			Transport.send(message);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void setBody(String body) {
		this.body = body;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setTo(String to) {
		this.to = to;
	}
}
