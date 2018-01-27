package designpattern.strategy.demo;

public class 猜拳遊戲 {

	private 玩家 波賽頓;
	private 玩家 蛤蛤蛤;

	public 猜拳遊戲(int 亂數種子1, int 亂數種子2) {
		初始化(亂數種子1, 亂數種子2);
	}

	public void 開始對戰() {
		for (int i = 0; i < 1000; i++) {
			招式 波賽頓下一招 = 波賽頓.下一招();
			招式 蛤蛤蛤下一招 = 蛤蛤蛤.下一招();
			if (波賽頓下一招.比較強(蛤蛤蛤下一招)) {
				System.out.println("贏家:" + 波賽頓);
				波賽頓.猜贏();
				蛤蛤蛤.猜輸();
			} else if (蛤蛤蛤下一招.比較強(波賽頓下一招)) {
				System.out.println("贏家:" + 蛤蛤蛤);
				波賽頓.猜輸();
				蛤蛤蛤.猜贏();
			} else {
				System.out.println("平手");
				波賽頓.平手();
				蛤蛤蛤.平手();
			}
		}
	}

	private void 初始化(int 亂數種子1, int 亂數種子2) {
		波賽頓 = new 玩家("波賽頓", new 猜贏繼續出同一招的策略(亂數種子1));
		蛤蛤蛤 = new 玩家("蛤蛤蛤", new 機率分配策略(亂數種子2));
	}

}