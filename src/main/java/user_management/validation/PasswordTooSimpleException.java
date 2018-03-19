package user_management.validation;

public class PasswordTooSimpleException extends Exception {

    public PasswordTooSimpleException() {
        this("Password did not meet the password requirements - too simple");
    }

    public PasswordTooSimpleException(String message) {
        super(message);
    }

    public PasswordTooSimpleException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordTooSimpleException(Throwable cause) {
        super(cause);
    }

    public PasswordTooSimpleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
