package exercise;

// BEGIN
public class NegativeRadiusException extends Exception {
    public NegativeRadiusException(String message) {
        super(message);
    }

    public NegativeRadiusException(String message, Throwable cause) {
        super(message, cause);
    }
}
// END
