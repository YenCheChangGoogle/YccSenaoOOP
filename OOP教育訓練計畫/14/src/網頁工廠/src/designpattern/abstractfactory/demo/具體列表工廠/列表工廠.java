package designpattern.abstractfactory.demo.具體列表工廠;

import designpattern.abstractfactory.demo.具體列表工廠.列表容器;
import designpattern.abstractfactory.demo.具體列表工廠.列表連結;
import designpattern.abstractfactory.demo.具體列表工廠.列表頁面;
import designpattern.abstractfactory.demo.抽象工廠.抽象容器;
import designpattern.abstractfactory.demo.抽象工廠.抽象工廠;
import designpattern.abstractfactory.demo.抽象工廠.抽象連結;
import designpattern.abstractfactory.demo.抽象工廠.抽象頁面;

public class 列表工廠 extends 抽象工廠 {

	@Override
	public 抽象連結 建立連結(String 標題, String 網址) {
		return new 列表連結(標題, 網址);
	}

	@Override
	public 抽象容器 建立容器(String 標題) {
		return new 列表容器(標題);
	}

	@Override
	public 抽象頁面 建立頁面(String 標題, String 作者) {
		return new 列表頁面(標題, 作者);
	}

}
