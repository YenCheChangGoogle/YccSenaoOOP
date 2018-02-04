package designpattern.bridge.drawingv3;

public class 繪圖程式庫V2 extends 繪圖程式庫 {
	public void 畫圓(double x, double y, double radius) {
		Win32API.畫圓形(x, y, radius);
	}

	public void 畫線(double x1, double y1, double x2, double y2) {
		Win32API.畫直線(x1, y1, x2, y2);
	}
}