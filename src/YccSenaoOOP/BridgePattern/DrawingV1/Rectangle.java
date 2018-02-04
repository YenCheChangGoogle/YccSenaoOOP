package YccSenaoOOP.BridgePattern.DrawingV1;

public abstract class Rectangle {
	private double x1;
	private double x2;
	private double y1;
	private double y2;

	abstract protected void draw(double x1, double y1, double x2, double y2);

	public void show() {
		draw(x1, y1, x2, y1);
		draw(x2, y1, x2, y2);
		draw(x2, y2, x1, y2);
		draw(x1, y2, x1, y1);
	}
}