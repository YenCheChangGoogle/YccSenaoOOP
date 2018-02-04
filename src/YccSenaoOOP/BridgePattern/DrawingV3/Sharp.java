package YccSenaoOOP.BridgePattern.DrawingV3;

public abstract class Sharp {
	protected GUI g;

	public Sharp(GUI g) {
		this.g = g;
	}

	public void paintCircle(double x, double y, double radius) {
		g.paintCircle(x, y, radius);
	}

	public void line(double x1, double y1, double x2, double y2) {
		g.line(x1, y1, x2, y2);
	}

	abstract public void show();
}