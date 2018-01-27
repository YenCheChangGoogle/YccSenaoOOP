package designpattern.strategy.demo;

public enum 勝負結果 {

	平手(0), 猜贏(1), 猜輸(2);

	private int value;

	private 勝負結果(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

}
