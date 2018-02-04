package designpattern.bridge.drawingv3;

public abstract class 繪圖程式庫 {
	abstract public void 畫線(double x1, double y1, double x2, double y2);

	abstract public void 畫圓(double x, double y, double radius);
}