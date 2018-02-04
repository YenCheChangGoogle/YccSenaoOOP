package designpattern.bridge.drawingv3;

public abstract class 形狀 {
	protected 繪圖程式庫 繪圖程式庫;

	public 形狀(繪圖程式庫 程式庫) {
		this.繪圖程式庫 = 程式庫;
	}

	public void 畫圓(double x, double y, double radius) {
		繪圖程式庫.畫圓(x, y, radius);
	}

	public void 畫線(double x1, double y1, double x2, double y2) {
		繪圖程式庫.畫線(x1, y1, x2, y2);
	}

	abstract public void 顯示();
}