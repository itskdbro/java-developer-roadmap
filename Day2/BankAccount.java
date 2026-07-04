package Day2;

public class BankAccount {
    private double balance;
    private int pin;

    public BankAccount(double balance, int pin) {
        this.balance = balance;
        this.pin = pin;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
//        if (amount > 0) {
//            balance += amount;
//            System.out.println(("Deposit successfully"));
//        } else {
//            System.out.println("Deposit Amount is invalid");
//        }
        if (amount < 0) {
            System.out.println("Invalid amount");
            return;
        }
        balance += amount;
        System.out.println("Deposit Successfully");

    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdraw amount");
            return;
        }
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal Successfully");
        } else System.out.println("Insufficient Balance");
    }

    public void changePin(int oldPin, int newPin) {
        if (oldPin != pin) {
            System.out.println("Incorrect old pin ");
            return;
        }
        if (newPin < 1000 || newPin > 9999) {
            System.out.println("Pin must be 4 digits");
            return;
        }
        if (newPin == pin) {
            System.out.println("New pin cannot be same as old pin");
            return;
        }

        pin = newPin;
        System.out.println("Pin updated Successfully");
    }
}
