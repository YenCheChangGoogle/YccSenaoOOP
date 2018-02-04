package designpattern.bridge.drawingv2;

public abstract class 圓形 extends 形狀 {
	private double 半徑;
	private double X座標;
	private double Y座標;

	abstract protected void 畫圓(double x, double y, double radius);

	public void 顯示() {
		畫圓(X座標, Y座標, 半徑);
	}
}