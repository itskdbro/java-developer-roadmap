package Day7_Exception_Handling;

public class AgeChecker {
    public static void ageCheck(int age) throws InvalidAgeException {

        if (age < 18) {

            throw new InvalidAgeException("Not eligible to vote ");

        }

        System.out.println("Eligible to vote");
    }
}
