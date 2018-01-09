package YccSenaoOOP.FactoryPattern;

public class CathayBankPaymentCreditCardFactory implements IPaymentCreditCardFactory {
	
	public IPaymentCreditCard getPaymentCreditCard() {
		return new CathayBankPaymentCreditCard();
	}
}
