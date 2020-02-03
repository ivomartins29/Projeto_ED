/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_t;

import Interface.ListADT;
import Exceptions.NotFoundException;

import Exceptions.EmptyElementException;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 *
 * @author fabio
 * @param <T>
 */
public class ArrayList<T> implements ListADT<T>, Iterable<T> {

    private static final int DEFAULT_CAPACITY = 20;
    private int modCount;

    protected T[] list;
    protected int rear;

    public ArrayList() {
        this.rear = 0;
        list = (T[]) new Object[DEFAULT_CAPACITY];
        modCount = 0;
    }

    public ArrayList(int capacity) {
        this.rear = 0;
        list = (T[]) new Object[capacity];
        modCount = 0;
    }

    @Override
    public T removeFirst() throws EmptyElementException {
        if (isEmpty()) {
            throw new EmptyElementException("Nao ha nada para remover");
        }
        T removido = list[0];
        for (int i = 0; i < rear - 1; i++) {
            list[i] = list[i + 1];
        }
        rear--;
        list[rear] = null;
        modCount++;
        return removido;
    }

    @Override
    public T removeLast() throws EmptyElementException {
        if (isEmpty()) {
            throw new EmptyElementException("Nao ha nada para remover");
        }
        rear--;
        T removido = list[rear];
        list[rear] = null;
        modCount++;
        return removido;

    }

    @Override
    public T remove(T element) throws EmptyElementException, NotFoundException {
        if (isEmpty()) {
            throw new EmptyElementException("Nao ha nada para remover");
        }
        int posicao = -1;
        int i = 0;
        boolean found = false;
        while (i < rear && found == false) {
            if (element.equals(list[i])) {
                posicao = i;
                found = true;
            }
            i++;
        }
        if (found == false) {
            throw new NotFoundException();
        }
        T removido = list[posicao];
        for (int j = posicao; j < rear - 1; j++) {
            list[j] = list[j + 1];

        }
        rear--;

        list[rear] = null;
        modCount++;
        return removido;
    }

    @Override
    public T first() {
        return list[0];
    }

    @Override
    public T last() {
        return list[rear - 1];
    }

    @Override
    public boolean contains(T target) {
        int i = 0;
        boolean found = false;
        while (i < rear && found == false) {
            if (target.equals(list[i])) {

                found = true;
            }
            i++;
        }
        return found;
    }

    @Override
    public boolean isEmpty() {
        return (rear == 0);
    }

    @Override
    public int size() {
        return rear;
    }

    @Override
    public Iterator iterator() {
        return new myItr();
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < rear; i++) {
            s += list[i];
            s += "\n";
        }
        return s;
    }

    protected void expandCapacity() {
        int novoTamanho = (list.length) * 2;
        T[] novoVetor = (T[]) (new Object[novoTamanho]);
        System.out.println("Tamanho amumentado");
        System.out.println("Novo tamanho=" + novoVetor.length);
        this.list = novoVetor;

    }

    private class myItr<T> implements Iterator<T> {

        private int current;
        private int expectedModCount;

        public myItr() {
            this.current = 0;
            this.expectedModCount = modCount;

        }

        @Override
        public boolean hasNext() {
            if(expectedModCount!=modCount){
                throw new ConcurrentModificationException();
            }
            return current != size();

        }

        @Override
        public T next() {
            if (!this.hasNext()) {
                throw new ArrayIndexOutOfBoundsException("Nao ha proximo elemento");

            }

            return (T) list[current++];

        }

    }

}
