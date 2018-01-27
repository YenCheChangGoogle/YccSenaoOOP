package YccSenaoOOP.StrategyPattern;

//折購 每滿1000折100 (例如: 若是金額為2100元, 因為滿2000, 則可折100X2=200)
public class MomenyDiscount100_1000 implements Discountable {

	public long discount(long price) {		
		
		long i=price/1000;
		long discount=100*i;
		price=price-discount;
		
		return price;
	}

}
