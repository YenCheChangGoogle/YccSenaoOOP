package YccSenaoOOP.FactoryPattern;

public class CITICBankPaymentCreditCardFactory implements IPaymentCreditCardFactory {

	public IPaymentCreditCard getPaymentCreditCard() {
		return new CITICBankPaymentCreditCard();
	}

}
