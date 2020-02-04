/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author 8180546 && 8180159
 * @param <T>
 */
public class ArrayIterator<T> implements Iterator<T> {

    private final int count;
    private int current;
    private final T[] items;

    /**
     *
     * @param items
     * @param count
     */
    public ArrayIterator(T[] items, int count) {
        this.items = items;
        this.count = count;
        this.current = 0;
    }

    @Override
    public boolean hasNext() {
        return (this.current < this.count);
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        this.current++;

        return this.items[this.current - 1];
    }
}
