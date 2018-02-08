package designpattern.adaptor.classadaptor;

public class PrintBanner extends Banner implements Print {
	public PrintBanner(String data) {
		super(data);
	}

	public void printString() {
		showWithAster();
	}

	public void printWeak() {
		showWithParen();
	}

}