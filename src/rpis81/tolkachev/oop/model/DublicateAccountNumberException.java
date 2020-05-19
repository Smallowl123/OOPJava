package rpis81.tolkachev.oop.model;

public class DublicateAccountNumberException extends Exception {
    public DublicateAccountNumberException() {
    }

    public DublicateAccountNumberException(String message) {
        super(message);
    }

    public DublicateAccountNumberException(String message, Throwable cause) {
        super(message, cause);
    }
}
