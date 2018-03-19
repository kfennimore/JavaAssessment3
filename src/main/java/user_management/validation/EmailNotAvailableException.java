package user_management.validation;

public class EmailNotAvailableException extends Exception {

    public EmailNotAvailableException() {
        this("Provided Email is not available");
    }

    public EmailNotAvailableException(String message) {
        super(message);
    }

    public EmailNotAvailableException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmailNotAvailableException(Throwable cause) {
        super(cause);
    }

    public EmailNotAvailableException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
