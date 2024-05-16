package model.exception.FailedLogInException;

public abstract class FailedLogInException extends Exception{

    public FailedLogInException(String message) {
        super(message);
    }
    public FailedLogInException() {
        super("FailedLogInException");
    }
}
