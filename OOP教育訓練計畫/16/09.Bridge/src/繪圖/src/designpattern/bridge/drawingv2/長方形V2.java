package designpattern.bridge.drawingv2;

public class 長方形V2 extends 長方形 {

	protected void 畫線(double x1, double y1, double x2, double y2) {
		Win32API.畫直線(x1, y1, x2, y2);
	}

}