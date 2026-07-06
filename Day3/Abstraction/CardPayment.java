package Day3.Abstraction;

public class CardPayment extends Payment {
    @Override
    public void pay() {
        System.out.println("Payment via Card");
    }
}
