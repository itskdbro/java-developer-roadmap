package Day3.Abstraction;

public class Main {
    public static void main(String[] args) {
        Payment upi = new UPIPayment();
        upi.pay();
        upi.transactionSuccess();
        Payment card = new CardPayment();
        card.pay();
        card.transactionSuccess();
        Payment wallet = new WalletPayment();
        wallet.pay();
        wallet.transactionSuccess();
    }
}
