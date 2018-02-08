package designpattern.adaptor.objectadaptor;

public class PrintBanner extends Print {
	private Banner banner;

	public PrintBanner(String data) {
		this.banner = new Banner(data);
	}

	public void printString() {
		this.banner.showWithAster();
	}

	public void printWeak() {
		this.banner.showWithParen();
	}
}
