package model.exception.FailedLogInException;

public class UserNotFoundException  extends FailedLogInException {
    public UserNotFoundException(String message) {
        super(message);

    }
    public UserNotFoundException() {
        super("UserNotFoundException");

    }
}
