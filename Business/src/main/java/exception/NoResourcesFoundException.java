package exception;

/**
 * Exception that is thrown when no resources are returned from themoviedb.org api.
 */
public class NoResourcesFoundException extends RuntimeException {

    /**
     * Generates an exception and prints the reason why it was thrown.
     *
     * @param message the message that needs to be printed.
     */
    public NoResourcesFoundException(String message) {
        super(message);
    }
}
