package YccSenaoOOP.StrategyPattern;

public class CCustomer extends Customer {
	  public CCustomer(String name){
          super("客戶名稱:"+name+" [VIP客戶優惠等級:擁有一次1000折100]", new MomenyDiscount100_1000Only());
      }
}
