package designpattern.adaptor.classadaptor;

public class Banner {
	private String data;

	public Banner(String data) {
		this.data = data;
	}

	public void showWithAster() {
		System.out.println("*" + data + "*");
	}

	public void showWithParen() {
		System.out.println("(" + data + ")");
	}
}
