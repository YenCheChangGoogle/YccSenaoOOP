package designpattern.abstractfactory.demo.具體表格工廠;

import java.util.Iterator;

import designpattern.abstractfactory.demo.抽象工廠.抽象容器;
import designpattern.abstractfactory.demo.抽象工廠.抽象元件;

public class 表格容器 extends 抽象容器 {

	public 表格容器(String 標題) {
		super(標題);
	}

	@Override
	public String 產生HTML() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<td>\n");
		buffer.append("<table =\"100%\" border=\"1\"><tr>");
		buffer.append("<td bgcolor=\"#cccccc\" align=\"center\" colspan=\"" + 容器.size() + "\"><b>" + 標題 + "<b></td>");
		buffer.append("</tr>\n");

		Iterator<抽象元件> i = 容器.iterator();
		while (i.hasNext()) {
			抽象元件 零件 = (抽象元件) i.next();
			buffer.append(零件.產生HTML());
		}
		buffer.append("</tr></table>\n");
		buffer.append("</li>\n");

		return buffer.toString();
	}

}