package model.exception;

public class FreeAccountLimitException extends Exception{
    public FreeAccountLimitException() {
        super("FreeAccountLimitException");
    }

    public FreeAccountLimitException(String message) {
        super(message);
    }
}
