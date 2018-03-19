package user_management.security;

public class UserAuthenticationFailedException extends Exception {
    String error = "User has failed Authentication - please check Username & Password";


    public UserAuthenticationFailedException() {
        this("User has failed Authentication - please check Username & Password");
    }


    public UserAuthenticationFailedException(String message) {
        super(message);
    }

    public UserAuthenticationFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserAuthenticationFailedException(Throwable cause) {
        super(cause);
    }

    public UserAuthenticationFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
