package YccSenaoOOP.FactoryPattern;

//國泰
public class CathayBankPaymentCreditCard implements IPaymentCreditCard {

	public boolean verify(String creditCardNo, String validYYYYMMDD, String last3DigitCode) {		
		boolean valid=false;
		
		//呼叫國泰世華銀行的 API去驗證信用卡
		valid=true; //模擬呼叫完畢取到的結果
		
		return valid;
	}

}
