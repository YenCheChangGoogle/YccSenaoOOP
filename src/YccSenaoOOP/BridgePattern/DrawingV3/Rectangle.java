package YccSenaoOOP.BridgePattern.DrawingV3;

public abstract class Rectangle extends Sharp {
	private double x1, x2, y1, y2;

	public Rectangle(GUI g, double x1, double y1, double x2, double y2) {
		super(g);
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	public void show() {
		line(this.x1, this.y1, this.x2, this.y1);
		line(this.x2, this.y1, this.x2, this.y2);
		line(this.x2, this.y2, this.x1, this.y2);
		line(this.x1, this.y2, this.x1, this.y1);
	}
}