package by.overone.demo.exceptions;

public class DishNoFoundException extends RuntimeException{

    public DishNoFoundException() {
    }

    public DishNoFoundException(String message) {
        super(message);
    }

    public DishNoFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DishNoFoundException(Throwable cause) {
        super(cause);
    }

    public DishNoFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
