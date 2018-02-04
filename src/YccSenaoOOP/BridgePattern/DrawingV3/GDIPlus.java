package YccSenaoOOP.BridgePattern.DrawingV3;

public class GDIPlus {
	public static void paintCircle(double x, double y, double radius) {
		Win32API.paintCircle(x, y, radius);
	}

	public static void line(double x1, double y1, double x2, double y2) {
		Win32API.line(x1, y1, x2, y2);
	}

}