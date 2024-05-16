package model.exception.FailedLogInException;

public class WrongPasswordException extends FailedLogInException{
    public WrongPasswordException(String message) {
        super(message);

    }
    public WrongPasswordException() {
        super("WrongPasswordException");
    }
}
