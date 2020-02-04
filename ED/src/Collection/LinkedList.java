/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection;

import Exception.ElementNotFoundException;
import Exception.EmptyCollectionException;
import Interface.ListADT;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 8180546 && 8180159
 * @param <T>
 */
public class LinkedList<T> implements ListADT<T> {

    /**
     *
     */
    protected LinearNode<T> head;

    /**
     *
     */
    protected LinearNode<T> tail;

    /**
     *
     */
    protected int count;

    /**
     *
     */
    public LinkedList() {
        this.head = this.tail = null;
        this.count = 0;
    }

    @Override
    public T removeFirst() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Lista Vazia.");
        }

        LinearNode<T> result = this.head;
        this.head = this.head.getNext();

        if (this.head == null) {
            this.tail = null;
        }

        this.count--;
        return result.getElement();
    }

    @Override
    public T removeLast() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Lista Vazia");
        }
        LinearNode<T> previous = null;
        LinearNode<T> current = this.head;

        while (current.getNext() != null) {
            previous = current;
            current = current.getNext();
        }

        LinearNode<T> result = this.tail;
        this.tail = previous;

        if (this.tail == null) {
            this.head = null;
        } else {
            this.tail.setNext(null);
        }

        this.count--;

        return result.getElement();
    }

    @Override
    public T remove(T t) throws ElementNotFoundException {

        if (isEmpty()) {
            try {
                throw new Exception("Lista Vazia");
            } catch (Exception ex) {
                Logger.getLogger(LinkedList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        boolean found = false;

        LinearNode<T> previous = null;
        LinearNode<T> current = head;

        while (current != null && !found) {
            if (t.equals(current.getElement())) {
                found = true;
            } else {
                previous = current;
                current = current.getNext();
            }
        }

        if (!found) {
            try {
                throw new Exception("Elemento não encontrado na lista");
            } catch (Exception ex) {
                Logger.getLogger(LinkedList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (size() == 1) {
            this.head = this.tail = null;
        } else if (current.equals(this.head)) {
            this.head = current.getNext();
        } else if (current.equals(this.tail)) {
            this.tail = previous;
            this.tail.setNext(null);
        } else {
            previous.setNext(current.getNext());
        }

        this.count--;
        return current.getElement();
    }

    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Lista Vazia");
        }

        return this.head.getElement();
    }

    @Override
    public T last() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Lista Vazia");
        }

        return this.tail.getElement();
    }

    @Override
    public boolean contains(T t) {
        if (isEmpty()) {
            try {
                throw new Exception("Lista Vazia");
            } catch (Exception ex) {
                Logger.getLogger(LinkedList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        boolean found = false;

        LinearNode<T> current = this.head;

        while (current != null && !found) {
            if (t.equals(current.getElement())) {
                found = true;
            } else {
                current = current.getNext();
            }
        }

        return found;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public String toString() {
        LinearNode<T> current = head;
        String result = "";

        while (current != null) {
            result = result + (current.getElement()).toString() + "\n";
            current = current.getNext();
        }

        return result;
    }

    @Override
    public Iterator<T> iterator() {
        LinkedListIterador<T> it = new LinkedListIterador<>(head, count);
        return it;
    }

    /**
     *
     * @param <T>
     */
    public class LinkedListIterador<T> implements Iterator<T> {

        private LinearNode<T> current;

        /**
         *
         * @param collection
         * @param size
         */
        public LinkedListIterador(LinearNode<T> collection, int size) {
            current = collection;
            count = size;
        }

        @Override
        public boolean hasNext() {
            return (current != null);
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            T result = current.getElement();
            current = current.getNext();
            return result;
        }
    }
}
