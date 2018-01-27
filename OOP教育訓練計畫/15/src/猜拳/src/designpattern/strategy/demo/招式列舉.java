package designpattern.strategy.demo;

public enum 招式列舉 {

	石頭(0), 剪刀(1), 布(2);

	private int value;

	private 招式列舉(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

}
