/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Exception.EmptyException;




public interface HeapADT<T> extends BinaryTreeADT<T> {

    /**
     * Adds the specified object to this heap.
     *
     * @param element the element to added to this head
     */
    public void addElement(T element);

    /**
     * Removes element with the lowest value from this heap.
     *
     * @return the element with the lowest value from this heap
     * @throws Exceptions.EmptyException
     */
    public T removeMin() throws EmptyException;

    /**
     * Returns a reference to the element with the lowest value in this heap.
     *
     * @return a reference to the element with the lowest value in this heap
     */
    public T findMin();

}
