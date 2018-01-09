package YccSenaoOOP.FactoryPattern;

public interface IPaymentCreditCard {
	
	//參數 卡號 與 有效年月日 與 信用卡背面的末三碼
	public boolean verify (String creditCardNo, String validYYYYMMDD, String last3DigitCode);

}
