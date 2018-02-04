package designpattern.bridge.drawingv2;

public abstract class 圓形V2 extends 圓形 {

	protected void 畫圓(double X座標, double Y座標, double 半徑) {
		Win32API.畫圓形(X座標, Y座標, 半徑);
	}

}