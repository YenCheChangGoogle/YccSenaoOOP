package designpattern.builder.mailbuilder;

public class WelcomeBuilder extends Builder {

	private static final String subject = "歡迎加入 Design Pattern 課程!";

	public WelcomeBuilder() {
		message = new WelcomeMessage();
	}

	@Override
	public Builder builderBody() {
		String body = "恭喜你做了正確的決定!";
		message.setBody(body);
		return this;
	}

	@Override
	public Builder buildSubject() {
		message.setSubject(subject);
		return this;
	}
}
