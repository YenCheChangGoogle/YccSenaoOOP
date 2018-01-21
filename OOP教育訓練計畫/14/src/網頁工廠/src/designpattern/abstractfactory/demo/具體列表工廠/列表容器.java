package designpattern.abstractfactory.demo.具體列表工廠;

import java.util.Iterator;

import designpattern.abstractfactory.demo.抽象工廠.抽象容器;
import designpattern.abstractfactory.demo.抽象工廠.抽象元件;

public class 列表容器 extends 抽象容器 {

	public 列表容器(String 標題) {
		super(標題);
	}

	@Override
	public String 產生HTML() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<li>\n");
		buffer.append(this.標題 + "\n");
		buffer.append("<ul>\n");

		Iterator<抽象元件> i = 容器.iterator();
		while (i.hasNext()) {
			抽象元件 零件 = (抽象元件) i.next();
			buffer.append(零件.產生HTML());
		}
		buffer.append("</ul>\n");
		buffer.append("</li>\n");

		return buffer.toString();
	}

}