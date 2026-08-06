package Day3.Abstraction;

abstract class Payment {

    void transactionSuccess() {
        System.out.println("Transaction Successfull");
    }

    abstract void pay();
}
