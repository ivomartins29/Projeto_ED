package LinkedQueue;

/**
 * @author Luis Pereira
 */
public class QueueArrayException extends Exception {

    /**
     * The message to be shown when the list of {@link StackArray StackArray} is
     * empty
     */
    public static final String ERROR_CODE_MESSAGE =
            "Don´t exists a number for each character!";
    /**
     * The message to be shown when the description of the
     * {@link LinkedLitst LisnkedList} is a empty stack
     */
    public static final String ERROR_STACK_IS_EMPTY =
            "This stack is empty";

    /**
     * Creates a new instance of <tt>QueueArrayException</tt>
     *
     * @param MESSAGE The message of this
     *                <tt>QueueArrayException</tt>
     */
    public QueueArrayException(final String MESSAGE) {
        super(MESSAGE);
    }
}
