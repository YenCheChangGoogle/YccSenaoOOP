package YccSenaoOOP.StrategyPattern;

public class BCustomer extends Customer {
	  public BCustomer(String name){
          super("客戶名稱:"+name+" [VIP優惠等級:商品全部打8折]", new MomenyDiscount20Percentage());
      }
}
