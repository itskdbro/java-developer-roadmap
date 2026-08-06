package Day8.ATMManagementSystem.CustomExceptions;

public class InvalidPinException extends Exception {
    public InvalidPinException(String message) {
        super(message);
    }
}
