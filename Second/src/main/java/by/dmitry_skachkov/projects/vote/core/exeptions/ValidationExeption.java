package by.dmitry_skachkov.projects.vote.core.exeptions;

public class ValidationExeption extends RuntimeException{

    public ValidationExeption() {
    }

    public ValidationExeption(String message) {
        super(message);
    }

    public ValidationExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidationExeption(Throwable cause) {
        super(cause);
    }

    public ValidationExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
