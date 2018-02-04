package designpattern.strategy.demo;

public interface 策略介面 {
	public abstract 招式 取得下一次的招式();

	public abstract void 學習(boolean 前一次的輸贏);
}