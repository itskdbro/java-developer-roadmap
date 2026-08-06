package Day1;

import java.util.*;
import java.lang.*;

public class Day1 {
    public static void main(String[] args) {
//        // Challenge 1
//        String name ="keshav";
//        System.out.println("Hello "+name );
//
//        int age = 23;
//        System.out.println("age : "+age);
//
//        int salary = 25000;
//        System.out.println("salary : "+salary);

//        // Challenge 2
//            Scanner sc = new Scanner(System.in);
//
//            int a = sc.nextInt();
//            int b = sc.nextInt();
//            System.out.println("Sum : " + (a + b));
//            System.out.println("Difference : " + (a - b));
//            System.out.println("Multiplication  : " + (a * b));
//            System.out.println("Division :" + (double)a / b);

//        // Challenge 3
//        Scanner sc = new Scanner(System.in);
//
//        System.out.println("Enter your name : ");
//        String name = sc.nextLine();
//
//        System.out.println("Enter your age :");
//        int age = sc.nextInt();
//
//        System.out.println("Hello " + name);
//        System.out.println("You are " + age+ " years old.");
//        if(age>=18){
//
//        System.out.println("You are eligible for voting.");
//        }
//        else {
//
//        System.out.println("You are not eligible for voting.");
//        }

////    Challenge 4 - Odd even program
//
//            Scanner sc = new Scanner(System.in);
//
//            System.out.println("Enter your number : ");
//            int num = sc.nextInt();
//
//            if(num%2==0){
//                System.out.println(num + " is even number");
//            }
//            else {
//                System.out.println(num + " is odd number");
//
//            }

//        // Challenge  5 - largest of 3 numbers
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter your number  : ");
//        int num1 = sc.nextInt();
//        System.out.print("Enter your number  : ");
//        int num2 = sc.nextInt();
//        System.out.print("Enter your number  : ");
//        int num3 = sc.nextInt();
//        int largest = 0;
//
//        if (num1 >= num2 && num1 >= num3) {
//            largest = num1;
//        } else if (num2 >= num3 && num2 >= num1) {
//            largest = num2;
//
//        } else {
//            largest = num3;
//        }
//        System.out.println("Largest number is : " + largest);

////        Challenge 6 - multiplication table
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter your number  : ");
//        int num = sc.nextInt();
//        for (int i = 1; i <= 10; i++) {
//            System.out.println(num + " * " + i + " = " + num * i);
//        }

//      Challenge 7 - complex table
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter starting number  : ");
        int startnum = sc.nextInt();
        System.out.print("Enter ending number  : ");
        int endnum = sc.nextInt();
        for (int i = startnum; i <= endnum; i++) {
            System.out.println("Table of " + i);
            for (int j = 1; j <= 10; j++) {
                System.out.println(i + " * " + j + " = " + i * j);
            }
            System.out.println();


        }


    }
}
