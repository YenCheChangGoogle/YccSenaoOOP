package YccSenaoOOP.BridgePattern.DrawingV2;

public class RectangleV1 extends Rectangle {

	protected void line(double x1, double y1, double x2, double y2) {
		GDIPlus.line(x1, y1, x2, y2);
	}

}