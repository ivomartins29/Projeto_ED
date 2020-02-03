/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
import Exceptions.NotFoundException;
import Exceptions.EmptyElementException;
import java.util.Iterator;

public interface ListADT <T> extends Iterable<T>{
    /**
 * Removes and returns the first element from this list.
 *
 * @return the first element from this list
     * @throws Exceptions.EmptyElementException
 */
 public T removeFirst ()throws EmptyElementException;
 /**
 * Removes and returns the last element from this list.
 *
 * @return the last element from this list
     * @throws Exceptions.EmptyElementException
 */
 public T removeLast () throws EmptyElementException;
 /**
 * Removes and returns the specified element from this list.
 *
 * @param element the element to be removed from the list
     * @return 
     * @throws Exceptions.EmptyElementException
     * @throws Exceptions.NotFoundException
 */
 public T remove (T element) throws EmptyElementException,NotFoundException;
 /**
 * Returns a reference to the first element in this list.
 * @return a reference to the first element in this list
 */
 public T first ();
 /**
 * Returns a reference to the last element in this list.
 * @return a reference to the last element in this list
 */
 public T last ();
 /**
 * Returns true if this list contains the specified target
 * element.
 * @param target the target that is being sought in the list
 * @return true if the list contains this element
 */
 public boolean contains (T target);
 /**
 * Returns true if this list contains no elements.
 * @return true if this list contains no elements
 */
 public boolean isEmpty();
 /**
 * Returns the number of elements in this list.
 *
 * @return the integer representation of number of
 * elements in this list
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
    

