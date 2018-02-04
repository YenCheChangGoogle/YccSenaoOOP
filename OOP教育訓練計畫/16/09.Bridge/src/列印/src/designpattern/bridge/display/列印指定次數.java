package designpattern.bridge.display;

public class 列印指定次數 extends 列印文件 {
	public 列印指定次數(列印文件實作 實作) {
		super(實作);
	}

	public void 反覆列印(int times) {
		開啟();
		for (int i = 0; i < times; i++) {
			列印();
		}
		關閉();
	}
}
