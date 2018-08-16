package bo;

public class Email {
		
	private String recipient;
	private String subject;
	private String textBody;
	
	public Email(EmailBuilder builder){
			this.recipient = builder.recipient;
			this.subject = builder.subject;
			this.textBody = builder.textBody;
		}

	public String getRecipient() {
		return recipient;
	}
	
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTextBody() {
		return textBody;
	}

	public void setTextBody(String textBody) {
		this.textBody = textBody;
	}
	
	public static class EmailBuilder{
		private String recipient;
		private String subject;
		private String textBody;
		
		public EmailBuilder(String recipient){
			this.recipient = recipient;
		}
		
		public EmailBuilder withSubject(String subject){
			this.subject = subject;
			return this;
		}
		
		public EmailBuilder withBody(String textBody){
			this.textBody = textBody;
			return this;
		}
		
		public Email build(){
			Email email = new Email(this);
			return email;
		}
		
		
	}

	@Override
	public String toString() {
		return "Email [recipient=" + recipient + ", subject=" + subject
				+ ", textBody=" + textBody + "]";
	}
}
