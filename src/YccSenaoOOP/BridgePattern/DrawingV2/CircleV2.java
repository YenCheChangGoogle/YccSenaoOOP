package YccSenaoOOP.BridgePattern.DrawingV2;

public abstract class CircleV2 extends Circle {

	protected void paintCircle(double XCoordinate, double YCoordinate, double radius) {
		Win32API.paintCircle(XCoordinate, YCoordinate, radius);
	}

}