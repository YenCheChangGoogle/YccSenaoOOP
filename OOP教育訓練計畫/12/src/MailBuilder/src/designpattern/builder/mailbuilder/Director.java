package designpattern.builder.mailbuilder;

public class Director {
	private Builder builder;

	public Director(Builder builder) {
		this.builder = builder;
	}

	public void construct(String toAddress, String fromAddress) {
		this.builder.buildSubject()
			.builderBody()
			.buildTo(toAddress)
			.buildFrom(fromAddress)
			.buildSendDate()
			.sendMessage();
	}
}
