package designpattern.abstractfactory.demo.抽象工廠;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Vector;

public abstract class 抽象頁面 {
	protected String 標題;
	protected String 作者;
	protected Vector<抽象元件> 內容 = new Vector<抽象元件>();

	public 抽象頁面(String 標題, String 作者) {
		this.標題 = 標題;
		this.作者 = 作者;
	}

	public void 加入(抽象元件 零件) {
		this.內容.add(零件);
	}

	public void 輸出() {
		try {
			String 檔案名稱 = 標題 + ".html";
			Writer writer = new FileWriter(檔案名稱);
			writer.write(this.產生HTML());
			writer.close();
			System.out.println("已產生 " + 檔案名稱);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public abstract String 產生HTML();
}