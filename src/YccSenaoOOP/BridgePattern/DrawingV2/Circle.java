package YccSenaoOOP.BridgePattern.DrawingV2;

public abstract class Circle extends Sharp {
	private double radius;
	private double XCoordinate;
	private double YCoordinate;

	abstract protected void paintCircle(double x, double y, double radius);

	public void show() {
		paintCircle(XCoordinate, YCoordinate, radius);
	}
}