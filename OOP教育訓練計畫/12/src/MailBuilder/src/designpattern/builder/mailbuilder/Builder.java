package designpattern.builder.mailbuilder;

import java.util.Date;

public abstract class Builder {

	protected AutoMessage message;

	public Builder() {
	}

	public abstract Builder builderBody();

	public Builder buildFrom(String from) {
		message.setFrom(from);
		return this;
	};

	public Builder buildSendDate() {
		message.setSendDate(new Date());
		return this;
	}

	public abstract Builder buildSubject();

	public Builder buildTo(String to) {
		System.out.println(to);
		message.setTo(to);
		return this;
	}

	public Builder sendMessage() {
		message.send();
		return this;
	}
}
