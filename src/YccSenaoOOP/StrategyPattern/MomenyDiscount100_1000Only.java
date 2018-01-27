package YccSenaoOOP.StrategyPattern;

//折購 滿1000折100 僅有一次 (例如: 若是金額為2100元, 滿1000, 也滿2000, 但僅可折100一次)
public class MomenyDiscount100_1000Only implements Discountable {

	public long discount(long price) {		
		
		if(price>=1000) {
			price-=100;
		}
		
		return price;
	}

}
