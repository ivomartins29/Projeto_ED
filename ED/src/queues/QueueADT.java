package queues;

public interface QueueADT<T> {
	/**
	 * Adds one element to the rear of this queue.
	 *
	 * @param element
	 *            the element to be added to the rear of this queue
	 */
	public void enqueue(T element);

	/**
	 * Removes and returns the element at the front of this queue.
	 *
	 * @return the element at the front of this queue
	 * @throws EmptyQueuedColletion 
	 */
	public T dequeue() throws EmptyQueuedException;

	/**
	 * Returns without removing the element at the front of this queue.
	 *
	 * @return the first element in this queue
	 */
	public T first() throws EmptyQueuedException;
	
	/**
	 * Returns true if this queue contains no elements.
	 *
	 * @return true if this queue is empty
	 */
	public boolean isEmpty();

	/**
	 * Returns the number of elements in this queue.
	 *
	 * @return the integer representation of the size of this queue
	 */
	public int size() throws EmptyQueuedException;

	/**
	 * Returns a string representation of this queue.
	 *
	 * @return the string representation of this queue
	 */
	public String toString();
}
