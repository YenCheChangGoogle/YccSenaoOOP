package designpattern.builder.mailbuilder;

public class WelcomeMessage extends AutoMessage {
	public WelcomeMessage() {
		System.out.println("Entering Welcome Message");
	}

	public void sayWelcome() {
		System.out.println("Welcome.");
	}
}
