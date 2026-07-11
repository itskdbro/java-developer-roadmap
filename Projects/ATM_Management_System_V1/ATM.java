package Projects.ATM_Management_System_V1;

import Day8.ATMManagementSystem.CustomExceptions.InsufficientBalanceException;
import Day8.ATMManagementSystem.CustomExceptions.InvalidPinException;

public class ATM {

    private String accountHolder;
    private double balance;
    private int pin;

    public ATM(String accountHolder, double balance, int pin) {
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.pin = pin;
    }

    public void checkBalance() {
        System.out.println("Current Balance : " + balance);
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Enter valid amount");
            return;
        }
        balance += amount;
        System.out.println("-----------------------");
        System.out.println("Transaction Successfull");
        System.out.println("-----------------------");
        System.out.println(amount + " deposited successfully");
    }

    public void withdraw(double amount, int enteredPin) throws InvalidPinException, InsufficientBalanceException {
        if (enteredPin != pin) {
            throw new InvalidPinException("Incorrect Pin");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
        balance -= amount;
        System.out.println("-----------------------");
        System.out.println("Transaction Successfull");
        System.out.println("-----------------------");
        System.out.println(amount + " withdraw successfully");
    }

    public void changePin(int oldPin, int newPin) throws InvalidPinException {
        if (oldPin != pin) {
            throw new InvalidPinException("Incorrect PIN");
        }
        if (newPin < 1000 || newPin > 9999) {
            throw new IllegalArgumentException("PIN must pe 4 digits");
        }
        pin = newPin;
        System.out.println("PIN changed Successfully");
    }

    public void accountDetails() {

        System.out.println("Account Details");
        System.out.println("------------------");
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Current Balance : " + balance);
    }
}
