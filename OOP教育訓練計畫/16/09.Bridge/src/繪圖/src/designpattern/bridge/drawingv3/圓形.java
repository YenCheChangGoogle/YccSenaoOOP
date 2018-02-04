package designpattern.bridge.drawingv3;

public abstract class 圓形 extends 形狀 {
	private double 半徑;
	private double X座標;
	private double Y座標;

	public 圓形(繪圖程式庫 繪圖程式庫, double X座標, double Y座標, double 半徑) {
		super(繪圖程式庫);
		this.X座標 = X座標;
		this.Y座標 = Y座標;
		this.半徑 = 半徑;
	}

	public void 顯示() {
		this.畫圓(X座標, Y座標, 半徑);
	}
}