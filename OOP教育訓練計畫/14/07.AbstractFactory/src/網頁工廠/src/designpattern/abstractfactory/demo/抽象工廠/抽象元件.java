package designpattern.abstractfactory.demo.抽象工廠;

public abstract class 抽象元件 {
	protected String 標題;

	public 抽象元件(String 標題) {
		this.標題 = 標題;
	}

	public abstract String 產生HTML();
}