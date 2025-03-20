package CustomExceptions;

public class CancelOrderException extends Exception{
    public CancelOrderException(String message) {
        super(message);
    }
}
