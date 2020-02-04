/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection;

import Exception.EmptyCollectionException;
import Interface.QueueADT;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author 8180546 && 8180159
 * @param <T>
 */
public class LinkedQueue<T> implements QueueADT<T>, Iterable<T> {

    private LinearNode<T> first;
    private LinearNode<T> last;
    private int count;

    /**
     *
     */
    public LinkedQueue() {
        this.first = null;
        this.last = null;
        this.count = 0;
    }

    private void initialize(T element) {
        LinearNode<T> aux = new LinearNode<>(element);
        this.last = aux;
        this.first = aux;
        this.count++;
    }

    @Override
    public void enqueue(T element) {
        if (this.count == 0) {
            initialize(element);
        } else {
            LinearNode<T> aux = new LinearNode<>(element);
            this.first.setNext(aux);
            this.first = aux;
            count++;
        }
    }

    @Override
    public T dequeue() throws EmptyCollectionException {
        if (this.count == 0) {
            throw new EmptyCollectionException("Lista Vazia.");
        }
        if (this.count == 1) {
            T temp = this.last.getElement();
            this.last = this.first = null;
            this.count--;
            return temp;
        } else {
            T temp = this.last.getElement();
            this.last = this.last.getNext();
            this.count--;
            return temp;
        }
    }

    @Override
    public T first() throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException("Lista Vazia.");
        }

        return this.last.getElement();

    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public String toString() {
        String string = "";

        if (this.last != null) {
            boolean value = true;
            LinearNode aux = this.last;

            while (value) {
                string += aux.getElement().toString() + "\n";
                if (aux.getNext() != null) {
                    aux = aux.getNext();
                } else {
                    value = false;
                }
            }
        } else {
            return "Lista Vazia";
        }

        return string;
    }

    @Override
    public Iterator<T> iterator() {
        QueueIterador it = new QueueIterador();
        return it;
    }

    /**
     *
     */
    public class QueueIterador implements Iterator<T> {

        private LinearNode<T> current = last;

        @Override
        public boolean hasNext() {
            return this.current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            T item = this.current.getElement();
            this.current = current.getNext();
            return item;
        }
    }
}
