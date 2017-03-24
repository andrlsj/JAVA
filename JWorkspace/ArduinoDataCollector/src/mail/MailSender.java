package mail;

import java.util.Properties;
import java.util.StringTokenizer;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MailSender implements Sender {

	public static void main(String[] args) {
		MailSender sender = new MailSender();
		try {
			sender.sendHtmlEmail("mail.chq.cymmetrik.com", "25", "ArduinoDataCollector@cymmetrik.com", "", "",
					"shihwen.wei@cymmetrik.com,shihwen.wei@cymmetrik.com", "", "環控平台測試", "<font color='red'>日</font>");
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void Send(Mail mail) {
		sendHtmlEmail(mail);
	}

	public void sendHtmlEmail(Mail mail) {
		if (mail.getMailFrom().equals(""))
			return;
		try {
			if (mail.getPassword().equals(""))
				sendHtmlEmail(mail.getHost(), mail.getPort(), mail.getMailFrom(), mail.getMailTo(), mail.getCc(),
						mail.getSubject(), mail.getMessage());
			else
				sendHtmlEmail(mail.getHost(), mail.getPort(), mail.getMailFrom(), mail.getPassword(), mail.getMailTo(),
						mail.getSubject(), mail.getMessage());
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sendHtmlEmail(String host, String port, String mailFrom, String toAddress, String ccAddress,
			String subject, String message) throws AddressException, MessagingException {
		sendHtmlEmail(host, port, mailFrom, "", "", toAddress, ccAddress, subject, message);
	}

	public void sendHtmlEmail(String host, String port, String mailFrom, final String userName, final String password,
			String toAddress, String ccAddress, String subject, String message)
			throws AddressException, MessagingException {

		// sets SMTP server properties
		Properties properties = new Properties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.auth", "false");
		properties.put("mail.smtp.starttls.enable", "false");

		// creates a new session with an authenticator
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		};

		Session session = Session.getInstance(properties, auth);
		// creates a new e-mail message
		MimeMessage msg = new MimeMessage(session);

		InternetAddress[] toAddresses = parseAddress(toAddress);
		// InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
		/*
		 * msg.setFrom(new InternetAddress(userName));
		 * msg.setRecipients(Message.RecipientType.TO, toAddresses);
		 * if(!ccAddress.equals("")) { InternetAddress[] ccAddresses = {new
		 * InternetAddress(ccAddress)};
		 * msg.setRecipients(Message.RecipientType.CC, ccAddresses); }
		 * 
		 * msg.setSubject(subject); msg.setSentDate(new Date());
		 * msg.setHeader("Content-Transfer-Encoding", "base64");
		 * msg.setContent(message, "text/html; charset=utf-8");
		 */

		// try {
		MimeMessageHelper helper = new MimeMessageHelper(msg, true, "utf-8");
		helper.setFrom(mailFrom);

		helper.setTo(toAddresses);
		if (!ccAddress.equals("")) {
			InternetAddress[] ccAddresses = parseAddress(ccAddress);
			helper.setCc(ccAddresses);
		}
		helper.setSubject(subject);
		helper.setText(message, true);
		// }catch (MessagingException e) {
		// throw new MessagingException(e);
		// }
		// sends the e-mail
		Transport.send(msg);
	}

	public InternetAddress[] parseAddress(String addr) {
		StringTokenizer token = null;
		if (addr.contains(";"))
			token = new StringTokenizer(addr, ";");
		if (addr.contains(","))
			token = new StringTokenizer(addr, ",");
		InternetAddress[] addrArr =null;
		if (token != null) {
			addrArr = new InternetAddress[token.countTokens()];
			int i = 0;
			while (token.hasMoreTokens()) {
				try {
					addrArr[i] = new InternetAddress(token.nextToken().toString());
				} catch (AddressException e1) {
					return null;
				}
				i++;
			}
		}else{
			addrArr = new InternetAddress[1];
			try {
				addrArr[0] = new InternetAddress(addr);
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		return addrArr;
	}
}