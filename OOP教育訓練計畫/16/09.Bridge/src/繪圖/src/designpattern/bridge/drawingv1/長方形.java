package designpattern.bridge.drawingv1;

public abstract class 長方形 {
	private double x1;
	private double x2;
	private double y1;
	private double y2;

	abstract protected void 畫線(double x1, double y1, double x2, double y2);

	public void 顯示() {
		畫線(x1, y1, x2, y1);
		畫線(x2, y1, x2, y2);
		畫線(x2, y2, x1, y2);
		畫線(x1, y2, x1, y1);
	}
}