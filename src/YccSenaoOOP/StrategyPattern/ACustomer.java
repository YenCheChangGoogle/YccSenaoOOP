package YccSenaoOOP.StrategyPattern;

public class ACustomer extends Customer {
	  public ACustomer(String name){
          super("客戶名稱:"+name+" [VIP客戶優惠等級:擁有滿1000折100]", new MomenyDiscount100_1000());
      }
}
