package designpattern.abstractfactory.demo.抽象工廠;

public abstract class 抽象連結 extends 抽象元件 {

	protected String 網址;

	public 抽象連結(String 標題, String 網址) {
		super(標題);
		this.網址 = 網址;
	}

}