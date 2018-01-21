package YccSenaoOOP.AbstractFactoryPattern;

public abstract class Boots {
	protected int speed; // 行動速度

	// 展示行動速度
	public void display() {
		System.out.println(this.getClass().getSimpleName() + " 行動速度 = " + speed);
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

}
