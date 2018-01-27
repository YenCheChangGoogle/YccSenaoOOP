package YccSenaoOOP.StrategyPattern;

//折購 全部8折 (相當於全部折20%)
public class MomenyDiscount20Percentage implements Discountable {
	
	public long discount(long price) {		
		return 80*price/100;
	}		
}
