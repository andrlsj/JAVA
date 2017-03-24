package mail;

public class Mail {
	private String host="";
	private String port="";
	private String mailFrom="";
	private String password="";
	private String mailTo="";
	private String cc="";
	private String subject="";
	private String message="";
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getMailFrom() {
		return mailFrom;
	}
	public void setMailFrom(String mailFrom) {
		this.mailFrom = mailFrom;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMailTo() {
		return mailTo;
	}
	public void setMailTo(String mailTo) {
		this.mailTo = mailTo;
	}	
	public String getCc() {
		return cc;
	}
	public void setCc(String ccAddresses) {
		this.cc = ccAddresses;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Mail [host=" + host + ", port=" + port + ", mailFrom="
				+ mailFrom + ", password=" + password + ", mailTo=" + mailTo
				+ ", cc=" + cc + ", subject=" + subject + ", message="
				+ message + "]";
	}
	
}
