package Day3.Abstraction;

public class UPIPayment extends Payment {
    @Override
    public void pay() {
        System.out.println("Payment via UPI");
    }
}
