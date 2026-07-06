package Day3.Abstraction;

public class WalletPayment extends Payment {
    @Override
    public void pay() {
        System.out.println("Payment via WalletPayment");
    }
}
