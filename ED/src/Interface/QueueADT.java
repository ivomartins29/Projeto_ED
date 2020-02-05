/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Exception.EmptyCollectionException;

/**
 *
<<<<<<< HEAD
 * @author 8150121 e 8150133
=======
 * @author Hugo Ferreira
>>>>>>> 026de2582b704c9fc3ac69cc75b8d5b641e0a441
 * @param <T>
 */
public interface QueueADT<T extends Object> {

    /**
     * Adds one element to the rear of this queue.
     *
     * @param element the element to be added to the rear of this queue
     */
    public void enqueue(T element);

    /**
     * Removes and returns the element at the front of this queue.
     *
     * @return the element at the front of this queue
     * @throws Exception.EmptyCollectionException
     */
    public T dequeue() throws EmptyCollectionException;

    /**
     * Returns without removing the element at the front of this queue.
     *
     *
     * @return the first element in this queue
     * @throws Exception.EmptyCollectionException
     */
    public T first() throws EmptyCollectionException;

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
    public int size();

    /**
     * Returns a string representation of this queue.
     *
     * @return the string representation of this queue
     */
    @Override
    public String toString();
}
