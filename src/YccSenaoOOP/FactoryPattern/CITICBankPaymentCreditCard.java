package YccSenaoOOP.FactoryPattern;

//中國信託
public class CITICBankPaymentCreditCard implements IPaymentCreditCard {

	public boolean verify(String creditCardNo, String validYYYYMMDD, String last3DigitCode) {
		boolean valid=false;
		
		//呼叫中國信託的 API去驗證信用卡
		valid=true; //模擬呼叫完畢取到的結果
		
		return valid;
	}

}
