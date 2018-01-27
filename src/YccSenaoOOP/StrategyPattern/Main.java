package YccSenaoOOP.StrategyPattern;

public class Main {

	public static void main(String args[]) {
				
		Customer A=new ACustomer("老王"); //擁有滿1000折100 優惠等級的客戶
		Customer B=new BCustomer("小張"); //全部打8折 優惠等級的客戶
		Customer C=new CCustomer("阿陳"); //擁有1000折100一次 優惠等級的客戶
		
		long orderPrice=3600; //此次購買金額
		System.out.println("老王 [擁有滿1000折100 優惠等級的客戶]");
		System.out.println("此次購買金額為"+orderPrice+"元, 需付款金額為"+A.discount(orderPrice)+"元");
		System.out.println();
		
		System.out.println("小張 [全部打8折 優惠等級的客戶]");
		System.out.println("此次購買金額為"+orderPrice+"元, 需付款金額為"+B.discount(orderPrice)+"元");
		System.out.println();
		
		System.out.println("阿陳 [擁有1000折100一次 優惠等級的客戶]");
		System.out.println("此次購買金額為"+orderPrice+"元, 需付款金額為"+C.discount(orderPrice)+"元");
		System.out.println();
		
	}
}
