package designpattern.abstractfactory.demo.具體表格工廠;

import designpattern.abstractfactory.demo.抽象工廠.抽象連結;

public class 表格連結 extends 抽象連結 {

	public 表格連結(String 標題, String 網址) {
		super(標題, 網址);
	}

	@Override
	public String 產生HTML() {
		return "<td><a href=\"" + 網址 + "\">" + 標題 + "</a></td>\n";
	}

}