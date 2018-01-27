package YccSenaoOOP.StrategyPattern;

public class Customer {
    private String name ;
    private Discountable discountable;

    public Customer(String name, Discountable discountable){
        this.name = name;
        this.discountable = discountable;
    }

    public void setDiscountable(Discountable discountable) {
        this.discountable = discountable;
    }
    
    public long discount(long price) {
        return discountable.discount(price);
    }
}
