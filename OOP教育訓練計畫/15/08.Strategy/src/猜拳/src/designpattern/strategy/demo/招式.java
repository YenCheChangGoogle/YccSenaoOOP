package designpattern.strategy.demo;

public class 招式 {

	public static final 招式[] 招式物件個體 = { 
			new 招式(招式列舉.石頭), 
			new 招式(招式列舉.剪刀), 
			new 招式(招式列舉.布) };

	public static 招式 取得招式(招式列舉 招式) {
		return 招式物件個體[招式.getValue()];
	}

	private 招式列舉 招式值;

	private 招式(招式列舉 招式種類) {
		this.招式值 = 招式種類;
	}

	public boolean 比較弱(招式 h) {
		return 判斷勝負(h) == 勝負結果.猜輸;
	}

	public boolean 比較強(招式 h) {
		return 判斷勝負(h) == 勝負結果.猜贏;
	}

	public String toString() {
		return 招式值.name();
	}

	private 勝負結果 判斷勝負(招式 h) {
		if (this == h) {
			return 勝負結果.平手;
		} else if ((this.招式值.getValue() + 1) % 3 == h.招式值.getValue()) {
			return 勝負結果.猜贏;
		} else {
			return 勝負結果.猜輸;
		}
	}

}