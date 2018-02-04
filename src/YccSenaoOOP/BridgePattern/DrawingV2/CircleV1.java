package YccSenaoOOP.BridgePattern.DrawingV2;

public abstract class CircleV1 extends Circle {

	protected void paintCircle(double XCoordinate, double YCoordinate, double radius) {
		GDIPlus.paintCircle(XCoordinate, XCoordinate, radius);
	}

}