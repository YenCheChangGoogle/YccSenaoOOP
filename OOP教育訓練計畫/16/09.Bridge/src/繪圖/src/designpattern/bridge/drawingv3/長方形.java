package designpattern.bridge.drawingv3;

public abstract class 長方形 extends 形狀 {
	private double x1, x2, y1, y2;

	public 長方形(繪圖程式庫 繪圖程式庫, double x1, double y1, double x2, double y2) {
		super(繪圖程式庫);
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	public void 顯示() {
		畫線(this.x1, this.y1, this.x2, this.y1);
		畫線(this.x2, this.y1, this.x2, this.y2);
		畫線(this.x2, this.y2, this.x1, this.y2);
		畫線(this.x1, this.y2, this.x1, this.y1);
	}
}