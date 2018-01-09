package YccSenaoOOP.FactoryPattern;

public class Main {

	private static java.util.Map<String, Class> m = new java.util.HashMap<String, Class>();
	static {
		m.put("CathayBank", YccSenaoOOP.FactoryPattern.CathayBankPaymentCreditCardFactory.class);
		m.put("CITIBank", YccSenaoOOP.FactoryPattern.CITICBankPaymentCreditCardFactory.class);
		m.put("NCCC", YccSenaoOOP.FactoryPattern.NCCCPaymentCreditCardFactory.class);
	}

	public static void main(String s[]) {		
		
		//args[0]=s[0];
		//args[1]=s[1];
		//args[2]=s[2];
		//args[3]=s[3];
		
		//範例資料
		//String[]  args={"CathayBank", "卡號", "有效年月日", "信用卡末三碼"};
		//String[]  args={"CITIBank", "卡號", "有效年月日", "信用卡末三碼"};
		String[]  args={"NCCC", "卡號", "有效年月日", "信用卡末三碼"};
		
		String type=args[0];
		String creditCardNo=args[1];
		String validYYYYMMDD=args[2];
		String last3DigitCode=args[3];
		
		try {
			Class c = m.get(type);
			IPaymentCreditCardFactory pcf=(IPaymentCreditCardFactory)c.newInstance();			
			System.out.println(pcf.getPaymentCreditCard().verify(creditCardNo, validYYYYMMDD, last3DigitCode));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
