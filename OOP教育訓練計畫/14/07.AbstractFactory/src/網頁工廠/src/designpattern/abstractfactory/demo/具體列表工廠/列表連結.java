package designpattern.abstractfactory.demo.具體列表工廠;

import designpattern.abstractfactory.demo.抽象工廠.抽象連結;

public class 列表連結 extends 抽象連結 {

	public 列表連結(String 標題, String 網址) {
		super(標題, 網址);
	}

	@Override
	public String 產生HTML() {
		return "  <li><a href=\"" + 網址 + "\">" + 標題 + "</a></li>\n";
	}

}