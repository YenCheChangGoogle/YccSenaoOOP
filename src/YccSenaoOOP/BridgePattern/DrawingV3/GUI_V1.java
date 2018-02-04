package YccSenaoOOP.BridgePattern.DrawingV3;

public class GUI_V1 extends GUI {
	public void paintCircle(double x, double y, double radius) {
		GDIPlus.paintCircle(x, y, radius);
	}

	public void line(double x1, double y1, double x2, double y2) {
		GDIPlus.line(x1, y1, x2, y2);
	}
}