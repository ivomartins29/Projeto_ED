/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Exception.ElementNotFoundException;

/**
 *
 * @author 8180546 && 8180159
 * @param <T>
 */
public interface UnorderedListADT<T extends Object> extends ListADT<T> {

    /**
     * Adds an element to the front of the list
     *
     * @param element the element to be added to the list
     */
    public void addToFront(T element);

    /**
     * Adds an element to the rear of the list
     *
     * @param element the element to be added to the list
     */
    public void addToRear(T element);

    /**
     * Adds an element after a certain other element
     *
     * @param element the element to be added to the list
     * @param target the reference element, which the other element is added
     * after
     * @throws Exception.ElementNotFoundException
     */
    public void addAfter(T element, T target) throws ElementNotFoundException;
}
