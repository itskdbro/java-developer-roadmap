package Day2;

import java.lang.*;

public class Test {
    public static void main(String[] args) {
//        Student student = new Student("keshav", 23, "Java Full stack");
//        student.displayDetails();

        BankAccount atm = new BankAccount(5000, 1234);

//        System.out.println(atm.getBalance());
//
//        atm.deposit(1000);
//
//        System.out.println(atm.getBalance());
//
//        atm.withdraw(3000);
//
//        System.out.println(atm.getBalance());
//
//        atm.withdraw(10000);

        atm.changePin(1234,1567);
    }
}
