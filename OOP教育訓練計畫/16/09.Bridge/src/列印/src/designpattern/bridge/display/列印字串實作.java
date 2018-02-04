package designpattern.bridge.display;

public class 列印字串實作 extends 列印文件實作 {
	private String 字串;
	private int 寬度;

	public 列印字串實作(String 字串) {
		this.字串 = 字串;
		this.寬度 = 字串.getBytes().length;
	}

	@Override
	public void 列印() {
		System.out.println("|" + this.字串 + "|");
	}

	private void 列印分隔線() {
		System.out.print("+");
		for (int i = 0; i < this.寬度; i++) {
			System.out.print("-");
		}
		System.out.println("+");
	}

	@Override
	public void 開啟() {
		列印分隔線();
	}

	@Override
	public void 關閉() {
		列印分隔線();
	}
}