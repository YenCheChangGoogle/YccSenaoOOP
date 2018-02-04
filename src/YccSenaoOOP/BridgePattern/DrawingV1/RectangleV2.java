package YccSenaoOOP.BridgePattern.DrawingV1;

public class RectangleV2 extends Rectangle {

	protected void draw(double x1, double y1, double x2, double y2) {
		Win32API.paint(x1, y1, x2, y2);
	}

}