package designpattern.bridge.display;

public class 主程式 {

	public static void main(String[] args) {
		列印文件 列印內容1 = new 列印文件(new 列印字串實作(" Hello World!"));
		列印內容1.顯示();

		列印文件 列印內容2 = new 列印指定次數(new 列印字串實作(" Hello Taiwan!"));
		列印內容2.顯示();

		列印指定次數 列印內容3 = new 列印指定次數(new 列印字串實作(" Hello Taiwan!"));
		列印內容3.反覆列印(10);
	}

}