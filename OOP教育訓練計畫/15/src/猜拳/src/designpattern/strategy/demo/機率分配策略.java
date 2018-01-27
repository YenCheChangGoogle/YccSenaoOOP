package designpattern.strategy.demo;

import java.util.Random;

public class 機率分配策略 implements 策略介面 {

	private 招式列舉 目前招式值 = 招式列舉.石頭;
	private 招式列舉 前一次招式值 = 招式列舉.石頭;
	private int[][] 歷史紀錄 = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
	private Random random;

	public 機率分配策略(int 亂數種子) {
		random = new Random(亂數種子);
	}

	@Override
	public 招式 取得下一次的招式() {
		int 機率 = random.nextInt(計算獲勝次數(目前招式值));
		招式列舉 下一次的招式;
		if (機率 < 歷史紀錄[目前招式值.getValue()][0]) {
			下一次的招式 = 招式列舉.石頭;
		} else if (機率 < 歷史紀錄[目前招式值.getValue()][0] + 歷史紀錄[目前招式值.getValue()][1]) {
			下一次的招式 = 招式列舉.剪刀;
		} else {
			下一次的招式 = 招式列舉.布;
		}
		前一次招式值 = 目前招式值;
		目前招式值 = 下一次的招式;
		return 招式.取得招式(下一次的招式);
	}

	@Override
	public void 學習(boolean 前一次的輸贏) {
		if (前一次的輸贏) {
			歷史紀錄[前一次招式值.getValue()][目前招式值.getValue()]++;
		} else {
			歷史紀錄[前一次招式值.getValue()][(目前招式值.getValue() + 1) % 3]++;
			歷史紀錄[前一次招式值.getValue()][(目前招式值.getValue() + 2) % 3]++;
		}
	}

	private int 計算獲勝次數(招式列舉 招式值) {
		int 總和 = 0;
		for (int i = 0; i < 3; i++) {
			總和 += 歷史紀錄[招式值.getValue()][i];
		}
		return 總和;
	}
}