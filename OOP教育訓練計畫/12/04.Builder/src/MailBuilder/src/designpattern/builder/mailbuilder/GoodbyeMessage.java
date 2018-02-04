package designpattern.builder.mailbuilder;

public class GoodbyeMessage extends AutoMessage {
	public GoodbyeMessage() {
		System.out.println("Entering Goodbye Message");
	}

	public void sayGoodbye() {
		System.out.println("Goodbye.");
	}
}
