package designpattern.strategy.demo;

import java.util.Random;

public class 主程式 {

	public static void main(String[] args) {
		Random random = new Random();
		int 亂數種子1 = random.nextInt(1000);
		int 亂數種子2 = random.nextInt(1000);
		猜拳遊戲 遊戲 = new 猜拳遊戲(亂數種子1, 亂數種子2);
		遊戲.開始對戰();
	}

}