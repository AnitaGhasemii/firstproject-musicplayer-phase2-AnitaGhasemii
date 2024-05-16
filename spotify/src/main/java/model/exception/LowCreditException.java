package model.exception;

public class LowCreditException extends Exception {
    public LowCreditException() {
        super("LowCreditException");
    }

    public LowCreditException(String message) {
        super(message);
    }
}
