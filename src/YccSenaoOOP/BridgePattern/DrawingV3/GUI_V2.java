package YccSenaoOOP.BridgePattern.DrawingV3;

public class GUI_V2 extends GUI {
	public void paintCircle(double x, double y, double radius) {
		Win32API.paintCircle(x, y, radius);
	}

	public void line(double x1, double y1, double x2, double y2) {
		Win32API.line(x1, y1, x2, y2);
	}
}