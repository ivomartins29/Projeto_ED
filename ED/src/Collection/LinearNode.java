/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection;

/**
 *
 * @author 8180546 && 8180159
 * @param <T>
 */
public class LinearNode<T> {

    private LinearNode<T> next;
    private T element;

    /**
     *
     */
    public LinearNode() {
        this.element = null;
        this.next = null;
    }

    /**
     *
     * @param element
     */
    public LinearNode(T element) {
        this.next = null;
        this.element = element;
    }

    /**
     *
     * @return
     */
    public LinearNode<T> getNext() {
        return next;
    }

    /**
     *
     * @param node
     */
    public void setNext(LinearNode<T> node) {
        this.next = node;
    }

    /**
     *
     * @return
     */
    public T getElement() {
        return element;
    }

    /**
     *
     * @param elemento
     */
    public void getElement(T elemento) {
        this.element = elemento;
    }
}
