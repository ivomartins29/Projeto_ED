/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Exception.ElementNotFoundException;
import Exception.EmptyCollectionException;
import java.util.Iterator;

/**
 *
<<<<<<< HEAD
 * @author 8150121 e 8150133
=======
 * @author Hugo Ferreira
>>>>>>> 026de2582b704c9fc3ac69cc75b8d5b641e0a441
 * @param <T>
 */
public interface ListADT<T extends Object> extends Iterable<T> {

    /**
     * Removes and returns the first element from this list.
     *
     * @return the first element from this list
     * @throws Exception.EmptyCollectionException
     */
    public T removeFirst() throws EmptyCollectionException;

    /**
     * Removes and returns the last element from this list.
     *
     * @return the last element from this list
     * @throws Exception.EmptyCollectionException
     */
    public T removeLast() throws EmptyCollectionException;

    /**
     * Removes and returns the specified element from this list.
     *
     * @param element the element to be removed from the list
     * @return
     * @throws Exception.ElementNotFoundException
     */
    public T remove(T element) throws ElementNotFoundException;

    /**
     * Returns a reference to the first element in this list.
     *
     * @return a reference to the first element in this list
     * @throws Exception.EmptyCollectionException
     */
    public T first() throws EmptyCollectionException;

    /**
     * Returns a reference to the last element in this list.
     *
     * @return a reference to the last element in this list
     * @throws Exception.EmptyCollectionException
     */
    public T last() throws EmptyCollectionException;

    /**
     * Returns true if this list contains the specified target element.
     *
     * @param target the target that is being sought in the list
     * @return true if the list contains this element
     */
    public boolean contains(T target);

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
    public boolean isEmpty();

    /**
     * Returns the number of elements in this list.
     *
     * @return the integer representation of number of elements in this list
     */
    public int size();

    /**
     * Returns an iterator for the elements in this list.
     *
     * @return an iterator over the elements in this list
     */
    @Override
    public Iterator<T> iterator();

    /**
     * Returns a string representation of this list.
     *
     * @return a string representation of this list
     */
    @Override
    public String toString();
}
