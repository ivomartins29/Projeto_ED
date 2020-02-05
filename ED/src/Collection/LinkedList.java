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
 * @author 8150121 e 8150133
 * @param <T>
 */
public class LinkedList<T> implements ListADT<T> {

    protected LinearNode<T> head;
    protected LinearNode<T> tail;
    protected int count;

    /**
     * Cria uma nova LinkedList
     */
    public LinkedList() {
        this.head = this.tail = null;
        this.count = 0;
    }

    /**
     * Remove e retorna o primeiro elemento da lista
     *
     * @return o primeiro elemento da lista
     * @throws EmptyCollectionException quando a lista está vazia
     */
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

    /**
     * Remove e retorna o utlimo elemento da lista
     *
     * @return o utlimo elemento da lista
     * @throws EmptyCollectionException quando a lista está vazia
     */
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

    /**
     * Remove e retorna um elemento especifico da lista
     *
     * @param t o elemento a ser removido da lista
     * @return o elemento removido da lista
     * @throws ElementNotFoundException quando a lista esta vazia
     */
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

    /**
     * Retorna uma referencia para o primeiro elemento da lista
     *
     * @return uma referencia para o primeiro elemento da lista
     * @throws EmptyCollectionException quando a lista esta vazia
     */
    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Lista Vazia");
        }

        return this.head.getElement();
    }

    /**
     * Retorna uma referencia para o ultimo elemento da lista
     *
     * @return uma referencia para o ultimo elemento da lista
     * @throws EmptyCollectionException quando a lista esta vazia
     */
    @Override
    public T last() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Lista Vazia");
        }

        return this.tail.getElement();
    }

    /**
     * Permite descobrir se um elemento especifico existe na lista
     *
     * @param t elemento a quem vai ser verificada a sua existencia na lista
     * @return true se o elemento existir na lista, false caso contrário
     */
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

    /**
     * Permite descobrir se a lista contém algum elemento
     *
     * @return true se a tiver elementos, false caso contrario
     */
    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    /**
     * Retorna o numero de elementos da lista
     *
     * @return o numero de elementos da lista
     */
    @Override
    public int size() {
        return count;
    }

    /**
     * Retorna uma representação em string da lista
     *
     * @return uma representação em string da lista
     */
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

    /**
     * Retorna um iterator para os elementos da lista
     *
     * @return um iterator para os elementos da lista
     */
    @Override
    public Iterator<T> iterator() {
        LinkedListIterador<T> it = new LinkedListIterador<>(head, count);
        return it;
    }

    /**
     * Classe auxiliar do iterator (inner class)
     *
     * @param <T>
     */
    public class LinkedListIterador<T> implements Iterator<T> {

        private final int count;
        private LinearNode<T> current;

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
