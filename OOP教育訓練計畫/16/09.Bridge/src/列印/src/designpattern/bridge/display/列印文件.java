package designpattern.bridge.display;

public class 列印文件 {
	private 列印文件實作 實作;

	public 列印文件(列印文件實作 實作) {
		this.實作 = 實作;
	}

	public void 列印() {
		實作.列印();
	}

	public void 開啟() {
		實作.開啟();
	}

	public void 關閉() {
		實作.關閉();
	}

	public final void 顯示() {
		開啟();
		列印();
		關閉();
	}
}