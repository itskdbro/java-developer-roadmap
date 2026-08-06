package Day7_Exception_Handling;

public class Main {
    public static void main(String[] args) {
//        int a = 10;
//        int b = 0;
////        System.out.println(a / b);  // Arithmetic exception
//
//        try {
//            System.out.println(a / b);
//        } catch (ArithmeticException e) {
//            System.out.println(e.getMessage());
////            System.out.println("cannot divide by zero");
//        }

        // throw and throws example
        try {
            AgeChecker.ageCheck(16);
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
    }
}
