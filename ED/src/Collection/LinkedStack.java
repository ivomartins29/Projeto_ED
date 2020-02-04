/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection;

import Exception.EmptyCollectionException;
import Interface.StackADT;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author 8180546 && 8180159
 * @param <T>
 */
public class LinkedStack<T> implements StackADT<T>, Iterable<T> {

    private LinearNode<T> top;
    private int size;

    /**
     *
     */
    public LinkedStack() {
        this.size = 0;
        this.top = null;
    }

    @Override
    public void push(T t) {
        LinearNode<T> tempNode = new LinearNode<>(t);

        tempNode.setNext(this.top);
        this.top = tempNode;
        this.size++;
    }

    @Override
    public T pop() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Lista Vazia.");
        }
        T tempNode = this.top.getElement();
        this.top = this.top.getNext();
        this.size--;
        return tempNode;
    }

    @Override
    public T peek() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Lista Vazia");
        }
        return this.top.getElement();
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        String result = "";
        LinearNode current = this.top;

        while (current != null) {
            result = result + (current.getElement()).toString() + "\n";
            current = current.getNext();
        }

        return result;
    }

    @Override
    public Iterator<T> iterator() {
        StackIterador it = new StackIterador();
        return it;
    }

    /**
     *
     */
    public class StackIterador implements Iterator<T> {

        private LinearNode<T> current = top;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            T item = current.getElement();
            current = current.getNext();
            return item;
        }
    }
}
