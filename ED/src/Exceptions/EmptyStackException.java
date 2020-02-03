package Exceptions;

/**
 * @author Luis Pereira
 */
public class EmptyStackException extends Exception {

    public static final String EMPTY_STACK = "Stack is empty!";

    public EmptyStackException(final String MESSAGE) {
        super(MESSAGE);
    }
}
