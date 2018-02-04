package designpattern.builder.mailbuilder;

public class GoodbyeBuilder extends Builder {

	private static final String subject = "感謝您和我們一起!";

	public GoodbyeBuilder() {
		message = new WelcomeMessage();
	}

	@Override
	public Builder builderBody() {
		String body = "真可惜! 您選擇離開.";
		message.setBody(body);
		return this;
	}

	@Override
	public Builder buildSubject() {
		message.setSubject(subject);
		return this;
	}
}
