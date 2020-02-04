/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection;

import java.util.Iterator;
import Exception.EmptyCollectionException;
import Interface.ListADT;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author 8150121 e 8150133
 * @param <T>
 */
public class ArrayList<T> implements ListADT<T> {

    protected final int DEFAULT_CAPACITY = 100;
    private final int NOT_FOUND = -1;
    protected int rear;
    protected T[] list;

    /**
     * Método Construtor vazio
     */
    public ArrayList() {
        this.rear = 0;
        this.list = (T[]) (new Object[this.DEFAULT_CAPACITY]);
    }

    /**
     * Método Construtor com tamanho definido
     *
     * @param initialCapacity tamanho inicial
     */
    public ArrayList(int initialCapacity) {
        this.rear = 0;
        this.list = (T[]) (new Object[initialCapacity]);
    }

    @Override
    public T removeFirst() throws EmptyCollectionException {
        T result;

        if (isEmpty()) {
            throw new EmptyCollectionException("List");
        }

        this.rear--;
        result = this.list[this.rear];
        this.list[this.rear] = null;
        return result;
    }

    @Override
    public T removeLast() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("List");
        }

        T result = this.list[0];
        this.rear--;

        for (int i = 0; i < this.rear; i++) {
            this.list[i] = this.list[i + 1];
        }

        this.list[this.rear] = null;
        return result;
    }

    @Override
    public T remove(T element) {
        T result;
        int index = find(element);

        if (index == this.NOT_FOUND) {
            try {
                throw new EmptyCollectionException("List");
            } catch (EmptyCollectionException ex) {
                Logger.getLogger(ArrayList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        result = this.list[index];

        this.rear--;

        for (int i = index; i < this.rear; i++) {
            this.list[i] = this.list[i + 1];
        }

        this.list[this.rear] = null;

        return result;
    }

    @Override
    public T first() {
        if (isEmpty()) {
            try {
                throw new EmptyCollectionException("List");
            } catch (EmptyCollectionException ex) {
                Logger.getLogger(ArrayList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return list[0];
    }

    @Override
    public T last() {
        if (isEmpty()) {
            try {
                throw new EmptyCollectionException("List");
            } catch (EmptyCollectionException ex) {
                Logger.getLogger(ArrayList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return this.list[this.rear - 1];
    }

    @Override
    public boolean contains(T target) {
        return (find(target) != this.NOT_FOUND);
    }

    private int find(T target) {
        int counter = 0;
        int result = this.NOT_FOUND;
        boolean found = false;

        if (!isEmpty()) {
            while (!found && counter < this.rear) {
                if (target.equals(this.list[counter])) {
                    found = true;
                } else {
                    counter++;
                }
            }
        }

        if (found) {
            result = counter;
        }

        return result;
    }

    @Override
    public boolean isEmpty() {
        return (this.rear == 0);
    }

    @Override
    public int size() {
        return this.rear;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator<>(this.list, this.rear);
    }

    protected void expandCapacity() {
        T[] larger = (T[]) (new Object[this.list.length * 2]);

        System.arraycopy(this.list, 0, larger, 0, this.list.length);

        this.list = larger;
    }

    @Override
    public String toString() {
        String result = "";

        for (int i = 0; i < this.rear; i++) {
            result = result + this.list[i].toString() + "\n";
        }

        return result;
    }
}
