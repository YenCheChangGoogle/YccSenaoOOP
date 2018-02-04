package designpattern.bridge.drawingv3;

public class 繪圖程式庫V1 extends 繪圖程式庫 {
	public void 畫圓(double x, double y, double radius) {
		GDIPlus.畫圓(x, y, radius);
	}

	public void 畫線(double x1, double y1, double x2, double y2) {
		GDIPlus.畫線(x1, y1, x2, y2);
	}
}