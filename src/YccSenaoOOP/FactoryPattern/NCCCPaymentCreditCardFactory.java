package YccSenaoOOP.FactoryPattern;

public class NCCCPaymentCreditCardFactory implements IPaymentCreditCardFactory {

	public IPaymentCreditCard getPaymentCreditCard() {
		return new NCCCPaymentCreditCard();
	}

}
