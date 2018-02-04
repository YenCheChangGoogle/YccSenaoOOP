package YccSenaoOOP.BridgePattern.DrawingV3;

public abstract class Circle extends Sharp {
	private double radius;
	private double XCoordinate;
	private double YCoordinate;

	public Circle(GUI g, double XCoordinate, double YCoordinate, double radius) {
		super(g);
		this.XCoordinate = XCoordinate;
		this.YCoordinate = YCoordinate;
		this.radius = radius;
	}

	public void show() {
		this.paintCircle(XCoordinate, YCoordinate, radius);
	}
}