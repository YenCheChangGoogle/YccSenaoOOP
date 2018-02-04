package designpattern.bridge.drawingv2;

public abstract class 圓形V1 extends 圓形 {

	protected void 畫圓(double X座標, double Y座標, double 半徑) {
		GDIPlus.畫圓(X座標, Y座標, 半徑);
	}

}