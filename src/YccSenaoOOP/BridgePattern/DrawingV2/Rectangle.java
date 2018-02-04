package YccSenaoOOP.BridgePattern.DrawingV2;

public abstract class Rectangle extends Sharp {
	private double x1;
	private double x2;
	private double y1;
	private double y2;

	abstract protected void line(double x1, double y1, double x2, double y2);

	public void show() {
		line(x1, y1, x2, y1);
		line(x2, y1, x2, y2);
		line(x2, y2, x1, y2);
		line(x1, y2, x1, y1);
	}
}