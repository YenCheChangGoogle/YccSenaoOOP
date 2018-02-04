package designpattern.abstractfactory.demo.具體表格工廠;

import java.util.Iterator;

import designpattern.abstractfactory.demo.抽象工廠.抽象元件;
import designpattern.abstractfactory.demo.抽象工廠.抽象頁面;

public class 表格頁面 extends 抽象頁面 {

	public 表格頁面(String 標題, String 作者) {
		super(標題, 作者);
	}

	@Override
	public String 產生HTML() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<html><head><meta charset='UTF-8'><title>" + 標題 + "</title></head>\n");
		buffer.append("<body>\n");
		buffer.append("<h1>" + 標題 + "</h1>\n");
		buffer.append("<table width=\"80%\" border=\"3\">\n");

		Iterator<抽象元件> i = 內容.iterator();
		while (i.hasNext()) {
			抽象元件 零件 = (抽象元件) i.next();
			buffer.append("<tr>" + 零件.產生HTML() + "</tr>");
		}

		buffer.append("</table>\n");
		buffer.append("<hr><address>" + 作者 + "</address>");
		buffer.append("</body></html>\n");

		return buffer.toString();
	}

}