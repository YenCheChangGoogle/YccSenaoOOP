package designpattern.strategy.demo;

import java.util.Random;

public class 猜贏繼續出同一招的策略 implements 策略介面 {

	private 招式 上一次出的招式;
	private boolean 上一次猜贏;
	private Random random;

	public 猜贏繼續出同一招的策略(int 亂數種子) {
		random = new Random(亂數種子);
	}

	@Override
	public 招式 取得下一次的招式() {
		if (!上一次猜贏) {
			上一次出的招式 = 招式.取得招式(招式列舉.values()[random.nextInt(3)]);
		}
		return 上一次出的招式;
	}

	@Override
	public void 學習(boolean 前一次的輸贏) {
		上一次猜贏 = 前一次的輸贏;
	}

}
