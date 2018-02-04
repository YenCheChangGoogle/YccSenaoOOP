package designpattern.strategy.demo;

public class 玩家 {
	
	private String 名稱;
	private int 猜輸次數;
	private int 猜贏次數;
	private 策略介面 策略;
	private int 對戰回合數;
	
	public 玩家(String 名稱, 策略介面 策略) {
		this.名稱 = 名稱;
		this.策略 = 策略;
	}
	
	public 招式 下一招() {
		return 策略.取得下一次的招式();
	}
	
	public void 平手() {
		對戰回合數++;	
	}
	
	public void 猜輸() {
		策略.學習(false);
		猜輸次數++;
		對戰回合數++;	
	}
	
	public void 猜贏() {
		策略.學習(true);
		猜贏次數++;
		對戰回合數++;
	}
	
	public String toString() {
		return "[" + 名稱 + ": 對戰 " + 對戰回合數 + " 回合,  " + "贏了 " +  猜贏次數 + ", 輸了 " + 猜輸次數 + "]";
	}
}
