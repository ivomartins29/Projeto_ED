/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection;

import java.util.Iterator;

/**
 *
 * @author 8180546 && 8180159
 * @param <T>
 */
public class ArrayOrderedList<T> extends ArrayList<T> {

    /**
     *
     */
    protected int count;

    /**
     *
     */
    protected T[] array;
    private final int TAM_MAX = 20;

    /**
     *
     */
    public ArrayOrderedList() {
        this.array = (T[]) new Object[this.TAM_MAX];
        this.count = 0;
    }

    /**
     *
     * @param size
     */
    public ArrayOrderedList(int size) {
        this.array = (T[]) new Object[size];
        this.count = 0;
    }

    @Override
    protected synchronized void expandCapacity() {
        T[] larger = (T[]) (new Object[this.array.length * 2]);

        System.arraycopy(this.array, 0, larger, 0, this.array.length);

        this.array = larger;
    }

    /**
     *
     * @param element
     */
    public synchronized void add(T element) {
        if (!contains(element)) {
            if (size() == this.array.length) {
                expandCapacity();
            }

            Comparable<T> var = (Comparable<T>) element;

            int i = 0;

            while (i < size() && var.compareTo(this.array[i]) > 0) {
                i++;
            }

            for (int j = this.count; j > i; j--) {
                this.array[j] = this.array[j - 1];

            }

            this.array[i] = element;
            this.count++;
        }

    }

    /**
     *
     */
    public synchronized void printAll() {
        String result = "";

        for (int i = 0; i < this.count; i++) {
            result = result + this.array[i].toString() + "\n";
        }

        System.out.println(result);
    }

    @Override
    public T removeFirst() {
        T tmp;
        tmp = this.array[0];
        this.array[0] = null;

        for (int i = 0; i < this.count; i++) {
            this.array[i] = this.array[i + 1];
        }

        this.count--;
        return tmp;
    }

    @Override
    public T removeLast() {
        T tmp;
        this.count--;
        tmp = this.array[this.count];
        this.array[this.count] = null;
        return tmp;
    }

    @Override
    public T remove(T element) {
        T tmp = null;
        int i;

        for (i = 0; i < this.count; i++) {
            if (element.equals(array[i])) {
                tmp = this.array[i];
                this.count--;
                break;
            }
        }

        for (; i < this.count + 1; i++) {
            this.array[i] = this.array[i + 1];
        }

        return tmp;
    }

    @Override
    public T first() {
        return this.array[0];
    }

    @Override
    public T last() {
        return this.array[this.count - 1];
    }

    @Override
    public synchronized boolean contains(T target) {
        return (find(target) != -1);
    }

    private synchronized int find(T target) {
        int i = 0;
        int result = -1;
        boolean found = false;

        if (!isEmpty()) {
            while (i < this.count) {
                if (target.equals(this.array[i])) {
                    found = true;
                    break;
                } else {
                    i++;
                }
            }
        }

        if (found) {
            result = i;
        }

        return result;
    }

    /**
     *
     * @param target
     * @return
     */
    public synchronized T findObject(T target) {
        int i = 0;

        if (!isEmpty()) {
            while (i < this.count) {
                if (target.equals(this.array[i])) {
                    return this.array[i];
                } else {
                    i++;
                }
            }
        }

        return null;
    }

    /**
     *
     */
    public synchronized void clear() {

        for (int i = 0; i < this.count; i++) {
            this.array[i] = null;
        }

        this.count = 0;
    }

    /**
     *
     * @param index
     * @return
     */
    public synchronized T get(int index) {
        return this.array[index];
    }

    @Override
    public synchronized boolean isEmpty() {
        return (this.count == 0);
    }

    @Override
    public synchronized int size() {
        return this.count;
    }

    @Override
    public synchronized Iterator<T> iterator() {
        return new ArrayIterator<>(this.array, this.count);
    }

    /**
     *
     * @param <T>
     */
    public class ArrayIterator<T> implements Iterator<T> {

        private int modCount;
        private final int size;
        private final T[] array;

        /**
         *
         * @param array
         * @param tamanho
         */
        public ArrayIterator(T[] array, int tamanho) {
            this.modCount = 0;
            this.array = array;
            this.size = tamanho;
        }

        @Override
        public boolean hasNext() {
            return (this.modCount < count);
        }

        @Override
        public T next() {
            this.modCount++;
            return this.array[this.modCount - 1];
        }

    }

    @Override
    public String toString() {
        String str = "OrderedArray = {";

        for (int i = 0; i < this.count; i++) {
            str += "" + i + "," + this.array[i].toString();
        }

        str += "}";
        return str;
    }
}
