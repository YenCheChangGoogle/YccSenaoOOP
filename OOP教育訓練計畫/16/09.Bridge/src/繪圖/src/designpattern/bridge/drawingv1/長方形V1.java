package designpattern.bridge.drawingv1;

public class 長方形V1 extends 長方形 {

	protected void 畫線(double x1, double y1, double x2, double y2) {
		GDIPlus.畫線(x1, y1, x2, y2);
	}

}