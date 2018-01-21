package designpattern.abstractfactory.demo.抽象工廠;

import java.util.Vector;

public abstract class 抽象容器 extends 抽象元件 {
	protected Vector<抽象元件> 容器 = new Vector<抽象元件>();

	public 抽象容器(String 標題) {
		super(標題);
	}

	public void 加入(抽象元件 零件) {
		this.容器.add(零件);
	}
}
