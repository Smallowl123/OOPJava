package rpis81.tolkachev.oop.model;

public class IllegalAccountNumberException extends RuntimeException {
    public IllegalAccountNumberException() {
    }

    public IllegalAccountNumberException(String message) {
        super(message);
    }

    public IllegalAccountNumberException(String message, Throwable cause) {
        super(message, cause);
    }
}
