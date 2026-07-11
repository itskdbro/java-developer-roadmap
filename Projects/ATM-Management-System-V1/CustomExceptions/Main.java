package Day8.ATMManagementSystem.CustomExceptions;

import Day8.ATMManagementSystem.ATM;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ATM atm = new ATM("Keshav", 10000, 1234);
        int choice;
        double amount;
        int pin;
        do {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Change PIN");
            System.out.println("5. Account Details");
            System.out.println("6. Exit");


            System.out.println("Enter your choice : ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter amount for deposit : ");
                    amount = sc.nextDouble();
                    atm.deposit(amount);
                    break;
                case 3:
                    System.out.print("Enter amount for Withdraw : ");
                    amount = sc.nextDouble();
                    System.out.print("Enter your pin : ");
                    pin = sc.nextInt();

                    boolean success = false;
                    while (!success) {
                        try {
                            atm.withdraw(amount, pin);
                            success = true;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            System.out.println("Try Again");
                        }
                    }
                    break;
                case 4:
                    System.out.print("Enter your old pin : ");
                    int oldPin = sc.nextInt();
                    System.out.print("Enter your new pin : ");
                    int newPin = sc.nextInt();
                    try {
                        atm.changePin(oldPin, newPin);
                    } catch (Day8.ATMManagementSystem.CustomExceptions.InvalidPinException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    atm.accountDetails();
                    break;
                case 6:
                    System.out.println("Thank you for using ATM");
                    break;
                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 6);


    }
}
